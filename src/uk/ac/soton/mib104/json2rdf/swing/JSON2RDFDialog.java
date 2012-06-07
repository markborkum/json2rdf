package uk.ac.soton.mib104.json2rdf.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
//import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.BoxView;
import javax.swing.text.ComponentView;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.IconView;
import javax.swing.text.LabelView;
import javax.swing.text.ParagraphView;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.View;
import javax.swing.text.ViewFactory;

import org.antlr.runtime.RecognitionException;
import org.json.JSONException;

import uk.ac.soton.mib104.json2rdf.Version;
import uk.ac.soton.mib104.json2rdf.lang.EvaluationException;
import uk.ac.soton.mib104.json2rdf.lang.EvaluationProvider;
import uk.ac.soton.mib104.json2rdf.lang.expression.Block;
import uk.ac.soton.mib104.json2rdf.util.BlockFactory;
import uk.ac.soton.mib104.json2rdf.util.JSONUtils;
import uk.ac.soton.mib104.json2rdf.util.StringUtils;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.util.FileUtils;

public class JSON2RDFDialog extends JDialog {
	
	private static final class JEditorPaneOutputStream extends OutputStream {
		
		private Document document;
		
		private JEditorPane editorPane;
		
		public JEditorPaneOutputStream(final JEditorPane editorPane) {
			super();
			
			this.editorPane = editorPane;
			this.document = editorPane.getDocument();
		}

		@Override
		public void write(final int b) throws IOException {
			try {
				document.insertString(document.getLength(), Character.toString((char) b), null);
				editorPane.setCaretPosition(document.getLength() - 1);
			} catch (final BadLocationException e) {
				e.printStackTrace();
			}
		}
	
	}

	// http://www.developer.com/java/other/article.php/3318421/Add-Line-Numbering-in-the-JEditorPane.htm
	private static final class NumberedEditorKit extends StyledEditorKit {
		private static final long serialVersionUID = 1624048944587722774L;

		public ViewFactory getViewFactory() {
			return new NumberedViewFactory();
		}
	}

	// http://www.developer.com/java/other/article.php/3318421/Add-Line-Numbering-in-the-JEditorPane.htm
	private static final class NumberedParagraphView extends ParagraphView {
		public static short NUMBERS_WIDTH = 25;

		public NumberedParagraphView(Element e) {
			super(e);
			short top = 0;
			short left = 0;
			short bottom = 0;
			short right = 0;
			this.setInsets(top, left, bottom, right);
		}

		public float getMinimumSpan(int axis) {
			return super.getPreferredSpan(axis);
		}

		public int getPreviousLineCount() {
			int lineCount = 0;
			View parent = this.getParent();
			int count = parent.getViewCount();
			for (int i = 0; i < count; i++) {
				if (parent.getView(i) == this) {
					break;
				} else {
					lineCount += parent.getView(i).getViewCount();
				}
			}
			return lineCount;
		}

		public void layout(int width, int height) {
			super.layout(Short.MAX_VALUE, height);
		}

		public void paintChild(Graphics g, Rectangle r, int n) {
			super.paintChild(g, r, n);
			int previousLineCount = getPreviousLineCount();
			int numberX = r.x - getLeftInset();
			int numberY = r.y + r.height - 5;
			g.drawString(Integer.toString(previousLineCount + n + 1), numberX,
					numberY);
		}

		protected void setInsets(short top, short left, short bottom,
				short right) {
			super.setInsets(top, (short) (left + NUMBERS_WIDTH), bottom, right);
		}

	}

	// http://www.developer.com/java/other/article.php/3318421/Add-Line-Numbering-in-the-JEditorPane.htm
	private static final class NumberedViewFactory implements ViewFactory {
		public View create(Element elem) {
			String kind = elem.getName();
			if (kind != null)
				if (kind.equals(AbstractDocument.ContentElementName)) {
					return new LabelView(elem);
				} else if (kind.equals(AbstractDocument.ParagraphElementName)) {
					// return new ParagraphView(elem);
					return new NumberedParagraphView(elem);
				} else if (kind.equals(AbstractDocument.SectionElementName)) {
					return new BoxView(elem, View.Y_AXIS);
				} else if (kind.equals(StyleConstants.ComponentElementName)) {
					return new ComponentView(elem);
				} else if (kind.equals(StyleConstants.IconElementName)) {
					return new IconView(elem);
				}
			// default to text display
			return new LabelView(elem);
		}
	}

	private static final String buttonText = "Test";
	
////	private static final String closeButtonText = "Close";
//	
//	private static final String closeLabelText = "(hint: to write RDF Graph, close this window)";

	private static final String jsonLabelText = "JSON Document:",
			blockLabelText = "JSON2RDF Expression:",
			modelLabelText = "RDF Graph (readonly):";

	private static final Object mutex = new Object();

	private static final Color okColor = Color.black, errorColor = Color.red;

	private static final long serialVersionUID = 6058126100579516859L;

	public static final String title = String.format("json2rdf, version %s", Version.asString());
	
	public static final String[] validLangs = new String[] {
		FileUtils.langN3,
		FileUtils.langNTriple,
		FileUtils.langTurtle,
		FileUtils.langXML,
		FileUtils.langXMLAbbrev,
	};
	
	public static final String defaultLang = validLangs[1];
	
	private static final PrintStream createPrintStream(final JEditorPane editorPane) {
		return new PrintStream(new JEditorPaneOutputStream(editorPane));
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					final JSON2RDFDialog frame = new JSON2RDFDialog();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JPanel contentPane;

	private JButton evaluateButton;

	private JEditorPane jsonEditorPane, blockEditorPane, modelEditorPane;
	
	private JLabel jsonLabel, blockLabel, modelLabel;
	
	private JComboBox langComboBox;
	
	/**
	 * Create the frame.
	 */
	public JSON2RDFDialog() {
		setTitle(title);

		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		{
			JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
			splitPane.setBorder(new EmptyBorder(0, 0, 0, 0));
			splitPane.setOneTouchExpandable(false);
			splitPane.setContinuousLayout(true);
			contentPane.add(splitPane, BorderLayout.CENTER);

			{
				JSplitPane jsonAndBlockSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
				jsonAndBlockSplitPane.setBorder(new EmptyBorder(0, 0, 0, 0));
				jsonAndBlockSplitPane.setOneTouchExpandable(false);
				jsonAndBlockSplitPane.setContinuousLayout(true);
				splitPane.setLeftComponent(jsonAndBlockSplitPane);

				{
					JPanel jsonPane = new JPanel();
					jsonPane.setLayout(new BorderLayout(0, 0));
					jsonPane.setMinimumSize(new Dimension(320, 240));
					jsonPane.setPreferredSize(new Dimension(320, 240));
					jsonAndBlockSplitPane.setTopComponent(jsonPane);
					{
						jsonLabel = new JLabel(jsonLabelText);
						jsonPane.add(jsonLabel, BorderLayout.NORTH);
					}
					{
						jsonEditorPane = new JEditorPane();
						jsonEditorPane.setEditorKit(new NumberedEditorKit());

						JScrollPane jsonScrollPane = new JScrollPane(
								jsonEditorPane);
						jsonPane.add(jsonScrollPane, BorderLayout.CENTER);
					}
				}

				{
					JPanel blockPane = new JPanel();
					blockPane.setLayout(new BorderLayout(0, 0));
					blockPane.setMinimumSize(new Dimension(320, 240));
					blockPane.setPreferredSize(new Dimension(320, 240));
					jsonAndBlockSplitPane.setBottomComponent(blockPane);
					{
						blockLabel = new JLabel(blockLabelText);
						blockPane.add(blockLabel, BorderLayout.NORTH);
					}
					{
						blockEditorPane = new JEditorPane();
						blockEditorPane.setEditorKit(new NumberedEditorKit());

						JScrollPane blockScrollPane = new JScrollPane(
								blockEditorPane);
						blockPane.add(blockScrollPane, BorderLayout.CENTER);
					}
				}
			}

			{
				JPanel modelPane = new JPanel();
				modelPane.setLayout(new BorderLayout(0, 0));
				modelPane.setMinimumSize(new Dimension(320, 480));
				modelPane.setPreferredSize(new Dimension(320, 480));
				splitPane.setRightComponent(modelPane);
				{
					modelLabel = new JLabel(modelLabelText);
					modelPane.add(modelLabel, BorderLayout.NORTH);
				}
				{
					modelEditorPane = new JEditorPane();
					modelEditorPane.setEditable(false);
					modelEditorPane.setEditorKit(new NumberedEditorKit());

					JScrollPane modelScrollPane = new JScrollPane(
							modelEditorPane);
					modelPane.add(modelScrollPane, BorderLayout.CENTER);
				}
			}
		}
		
		{
			JPanel evaluateAndCloseButtonPane = new JPanel();
			contentPane.add(evaluateAndCloseButtonPane, BorderLayout.SOUTH);
			evaluateAndCloseButtonPane.setLayout(new BorderLayout(0, 0));
			
//			{
//				JPanel closeButtonPane = new JPanel();
//				evaluateAndCloseButtonPane.add(closeButtonPane, BorderLayout.WEST);
//				FlowLayout flowLayout = (FlowLayout) closeButtonPane.getLayout();
//				flowLayout.setAlignment(FlowLayout.LEFT);
//				
//				{
////					JButton closeButton = new JButton(closeButtonText);
////					closeButtonPane.add(closeButton);
////					getRootPane().setDefaultButton(closeButton);
////					
////					closeButton.addActionListener(new ActionListener() {
////
////						@Override
////						public void actionPerformed(ActionEvent event) {
////							forceWindowClosing();
////						}
////						
////					});
//					
//					JLabel closeLabel = new JLabel(closeLabelText);
//					closeLabel.setFont(new Font(null, Font.ITALIC | Font.ROMAN_BASELINE, 11));
//					closeButtonPane.add(closeLabel);
//				}
//			}
			
			{
				JPanel evaluateButtonPane = new JPanel();
				evaluateAndCloseButtonPane.add(evaluateButtonPane, BorderLayout.EAST);
				FlowLayout flowLayout = (FlowLayout) evaluateButtonPane.getLayout();
				flowLayout.setAlignment(FlowLayout.RIGHT);

				{
					langComboBox = new JComboBox();
					langComboBox.setModel(new DefaultComboBoxModel(
							validLangs));
					langComboBox
							.setSelectedItem(defaultLang);
					evaluateButtonPane.add(langComboBox);
					
					langComboBox.addItemListener(new ItemListener() {

						@Override
						public void itemStateChanged(ItemEvent event) {
							evaluateButtonClicked();
						}
						
					});
				}
				
				{
					evaluateButton = new JButton(buttonText);
					evaluateButtonPane.add(evaluateButton);
					getRootPane().setDefaultButton(evaluateButton);

					evaluateButton.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent event) {
							evaluateButtonClicked();
						}

					});
				}
			}
		}
		
		getRootPane().registerKeyboardAction(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				forceWindowClosing();
			}
			
		}, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
		
		pack();

		Dimension size = getSize(), screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenSize.width - size.width) / 2, (screenSize.height - size.height) / 2);
		setMinimumSize(size);
	}
	
	public void evaluateButtonClicked() {
		synchronized (mutex) {
			try {
				EvaluationProvider<?> context = JSONUtils.parseJSON(getJSONText());
				
				Block block = BlockFactory.createBlock(getBlockText());
				
				setModelText(StringUtils.emptyString);
				block.write(context, createPrintStream(modelEditorPane), getSelectedLang());
				modelEditorPane.setCaretPosition(0);

				jsonLabel.setForeground(okColor);
				blockLabel.setForeground(okColor);
				modelLabel.setForeground(okColor);
			} catch (JSONException e) {
				handleException(e);

				jsonLabel.setForeground(errorColor);
				blockLabel.setForeground(okColor);
				modelLabel.setForeground(errorColor);
			} catch (RecognitionException e) {
				handleException(e);

				jsonLabel.setForeground(okColor);
				blockLabel.setForeground(errorColor);
				modelLabel.setForeground(errorColor);
			} catch (EvaluationException e) {
				handleException(e);

				jsonLabel.setForeground(okColor);
				blockLabel.setForeground(errorColor);
				modelLabel.setForeground(errorColor);
			} catch (Exception e) {
				handleException(e);
			}
		}
	}
	
	private void forceWindowClosing() {
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));

		setVisible(false);
		dispose();
	}

	public String getBlockText() {
		return blockEditorPane.getText();
	}

	public String getJSONText() {
		return jsonEditorPane.getText();
	}

	public String getModelText() {
		return modelEditorPane.getText();
	}

	public String getSelectedLang() {
		return langComboBox.getSelectedItem().toString();
	}
	
	private void handleException(Throwable cause) {
		synchronized(mutex) {
			setModelText(StringUtils.emptyString);
			cause.printStackTrace(createPrintStream(modelEditorPane));
			modelEditorPane.setCaretPosition(0);
		}
	}

	public void setBlockText(String text) {
		blockEditorPane.setText(text);
		blockEditorPane.setCaretPosition(0);
	}

	public void setJSONText(String text) {
		jsonEditorPane.setText(text);
		jsonEditorPane.setCaretPosition(0);
	}

	public void setModelText(String text) {
		modelEditorPane.setText(text);
		modelEditorPane.setCaretPosition(0);
	}

	public void setSelectedLang(String lang) {
		langComboBox.setSelectedItem(lang.toString());
	}

	public Model toModel() throws JSONException, RecognitionException, EvaluationException {
		synchronized (mutex) {
			EvaluationProvider<?> context = JSONUtils.parseJSON(getJSONText());

			Block block = BlockFactory.createBlock(getBlockText());
			
			return block.toModel(context);
		}
	}

}
