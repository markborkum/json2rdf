import java.awt.EventQueue;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

import uk.ac.soton.mib104.json2rdf.Version;
import uk.ac.soton.mib104.json2rdf.lang.EvaluationProvider;
import uk.ac.soton.mib104.json2rdf.lang.expression.Block;
import uk.ac.soton.mib104.json2rdf.swing.JSON2RDFDialog;
import uk.ac.soton.mib104.json2rdf.util.BlockFactory;
import uk.ac.soton.mib104.json2rdf.util.JSONUtils;
import uk.ac.soton.mib104.json2rdf.util.StringUtils;

import com.hp.hpl.jena.util.FileUtils;

public final class json2rdf {
	
	private static abstract class CommandLineArgumentException extends Exception {

		private static final long serialVersionUID = -2564311907512934469L;
		
		private String arg0;
		
		@SuppressWarnings("unused")
		public CommandLineArgumentException(final String arg0) {
			this(arg0, null, null);
		}
		
		public CommandLineArgumentException(final String arg0, final String message) {
			this(arg0, message, null);
		}
		
		public CommandLineArgumentException(final String arg0, final String message, final Throwable cause) {
			super(message, cause);
			
			this.setArg0(arg0);
		}
		
		@SuppressWarnings("unused")
		public CommandLineArgumentException(final String arg0, final Throwable cause) {
			this(arg0, null, cause);
		}
		
		@SuppressWarnings("unused")
		public String getArg0() {
			return arg0;
		}

		private void setArg0(final String arg0) {
			this.arg0 = arg0;
		}
		
	}
	
	private static final class CommandLineArguments {
		
		public static final CommandLineArguments parse(final String[] args) throws CommandLineArgumentException {
			final CommandLineArguments commandLineArguments = new CommandLineArguments();
			
			for (int i = 0; i < args.length; i++) {
				final String nextArg = args[i];
				
				if ("--help".equals(nextArg)) {
					usage(null, null);
				} else if ("-F".equals(nextArg) || "--file".equals(nextArg)) {
					commandLineArguments.filename = args[++i];
				} else if ("-L".equals(nextArg) || "--language".equals(nextArg)) {
					commandLineArguments.lang = args[++i];
				} else if ("--gui".equals(nextArg)) {
					commandLineArguments.gui = true;
				} else {
					throw new UnknownCommandLineArgumentException(nextArg);
				}
			}
			
			commandLineArguments.validate();
			
			return commandLineArguments;
		}
		
		public String filename = null;
		
		public boolean gui = false;
		
		public String lang = defaultLang;
		
		private CommandLineArguments() {
			// Do nothing...
		}
		
		public void validate() throws CommandLineArgumentException {
			if (!isValidLang(lang)) {
				throw new InvalidLanguageException(lang);
			}
		}
		
	}
	
	private static final class InvalidLanguageException extends CommandLineArgumentException {

		private static final long serialVersionUID = -8107937042516340263L;
		
		public InvalidLanguageException(final String arg0) {
			super(arg0, String.format("json2rdf: invalid language `%s'", arg0));
		}
		
	}
	
	private static final class UnknownCommandLineArgumentException extends CommandLineArgumentException {

		private static final long serialVersionUID = -8107937042516340263L;
		
		public UnknownCommandLineArgumentException(final String arg0) {
			super(arg0, String.format("json2rdf: unrecognized option `%s'", arg0));
		}
		
	}
	
	public static final String defaultLang = FileUtils.langNTriple;
	
	public static final String title = String.format("%s, version %s", json2rdf.class.getSimpleName(), Version.asString());
	
	public static final String[] validLangs = new String[] {
		FileUtils.langN3,
		FileUtils.langNTriple,
		FileUtils.langTurtle,
		FileUtils.langXML,
		FileUtils.langXMLAbbrev,
	};
	
	public static final boolean isValidLang(final String lang) {
		if (lang != null) {
			for (final String validLang : validLangs) {
				if (validLang.equals(lang)) {
					return true;
				}
			}
		} 

		return false;
	}
	
	public static final void main(final String[] args) {
		try {
			final CommandLineArguments commandLineArguments = CommandLineArguments.parse(args);
			
			try {
				if (commandLineArguments.gui) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								writeAfterGUI(commandLineArguments, System.out);
							} catch (final Exception e) {
								usage(commandLineArguments, e);
							}
						}
					});
				} else {
					write(commandLineArguments, System.in, System.out);
				}
			} catch (final Exception e) {
				usage(commandLineArguments, e);
			}
		} catch (final Exception e) {
			usage(null, e);
		}
	}
	
	private static final void usage(final CommandLineArguments commandLineArguments, final Throwable cause) {
		final StringBuilder sb = new StringBuilder();
		
		if (cause != null) {
			sb.append(cause.getMessage());
			sb.append('\n');
		}
		
		sb.append(title);
		sb.append("\n\n");
		
		sb.append("usage: java -jar json2rdf-");
		sb.append(Version.asString());
		sb.append(".jar [-F file] [-L language] [--gui] [--help]\n\n");
		
		sb.append("  F file     : use `file' as JSON2RDF expression\n");
		sb.append("  L language : `language' specifies which RDF serialisation to use (default: \"");
		sb.append(defaultLang);
		sb.append("\")\n");
		sb.append("                 ");
		for (int i = 0; i < validLangs.length; i++) {
			final String nextLang = validLangs[i];
			
			if (i > 0) {
				if (i + 1 == validLangs.length) {
					sb.append(" and");
				} else {
					sb.append(',');
				}
				
				sb.append(' ');
			} 
			
			sb.append('"');
			sb.append(nextLang);
			sb.append('"');
		}
		sb.append('\n');
		sb.append("    gui      : show graphical user interface (on exit, model is written to the standard output)\n");
		sb.append("    help     : show usage information\n");
		
		System.err.println(sb);
		
		System.exit(1);
	}
	
	public static final void write(final CommandLineArguments commandLineArguments, final InputStream inputStream, final OutputStream outputStream) throws Exception {
		final Block block = StringUtils.isNotBlank(commandLineArguments.filename) ? BlockFactory.createBlock(commandLineArguments.filename, "UTF-8") : new Block();
		
		final EvaluationProvider<?> context = JSONUtils.parseJSON(inputStream);
		
		block.write(context, outputStream, commandLineArguments.lang);
		
		return;
	}
	
	public static final void writeAfterGUI(final CommandLineArguments commandLineArguments, final OutputStream outputStream) throws FileNotFoundException {
		final JSON2RDFDialog dialog = new JSON2RDFDialog();
		
		dialog.addWindowListener(new WindowListener() {

			@Override
			public void windowActivated(final WindowEvent e) {
				// Do nothing...
			}

			@Override
			public void windowClosed(final WindowEvent e) {
				// Do nothing...
			}

			@Override
			public void windowClosing(final WindowEvent e) {
				try {
					final EvaluationProvider<?> context = JSONUtils.parseJSON(dialog.getJSONText());

					final Block block = BlockFactory.createBlock(dialog.getBlockText());

					block.write(context, outputStream, dialog.getSelectedLang());
				} catch (final Exception exception) {
					usage(commandLineArguments, exception);
				}
			}

			@Override
			public void windowDeactivated(final WindowEvent e) {
				// Do nothing...	
			}

			@Override
			public void windowDeiconified(final WindowEvent e) {
				// Do nothing...
			}

			@Override
			public void windowIconified(final WindowEvent e) {
				// Do nothing...
			}

			@Override
			public void windowOpened(final WindowEvent e) {
				// Do nothing...
			}
			
		});
		
		if (commandLineArguments.filename != null) {
			final StringBuilder blockStringBuilder = new StringBuilder();
			
			final Scanner blockScanner = new Scanner(new FileInputStream(commandLineArguments.filename), "UTF-8");
			
			try {
				while (blockScanner.hasNextLine()) {
					blockStringBuilder.append(blockScanner.nextLine());
					blockStringBuilder.append(System.getProperty("line.separator"));
				}
			} finally {
				blockScanner.close();
			}
			
			dialog.setBlockText(blockStringBuilder.toString());
		}
		
		{
			final StringBuilder jsonStringBuilder = new StringBuilder();
			
			final Scanner jsonScanner = new Scanner(System.in, "UTF-8");
			
			try {
				while (jsonScanner.hasNextLine()) {
					jsonStringBuilder.append(jsonScanner.nextLine());
					jsonStringBuilder.append(System.getProperty("line.separator"));
				}
			} finally {
				jsonScanner.close();
			}
			
			dialog.setJSONText(jsonStringBuilder.toString());
		}
		
		dialog.setSelectedLang(commandLineArguments.lang);
		
		dialog.evaluateButtonClicked();
		
		dialog.setVisible(true);
		
		return;
	}
	
	private json2rdf() {
		// Do nothing...
	}
	
}
