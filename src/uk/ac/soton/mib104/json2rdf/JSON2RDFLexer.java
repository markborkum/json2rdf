// $ANTLR 3.4 /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g 2012-06-09 20:15:36

	package uk.ac.soton.mib104.json2rdf;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class JSON2RDFLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__50=50;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int COMMENT=4;
    public static final int ESC_SEQ=5;
    public static final int EXPONENT=6;
    public static final int FLOAT=7;
    public static final int HEX_DIGIT=8;
    public static final int ID=9;
    public static final int INT=10;
    public static final int LANG_TAG=11;
    public static final int NODE_NAME=12;
    public static final int OCTAL_ESC=13;
    public static final int PREFIX_NAME=14;
    public static final int STRING=15;
    public static final int UNICODE_ESC=16;
    public static final int URI=17;
    public static final int WS=18;

    	// Empty...


    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public JSON2RDFLexer() {} 
    public JSON2RDFLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public JSON2RDFLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "/Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g"; }

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:14:7: ( '!' )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:14:9: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:15:7: ( '${' )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:15:9: '${'
            {
            match("${"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:16:7: ( '&&' )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:16:9: '&&'
            {
            match("&&"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:17:7: ( '(' )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:17:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:18:7: ( ')' )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:18:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:19:7: ( '+' )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:19:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:20:7: ( ',' )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:20:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:21:7: ( '-' )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:21:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:22:7: ( '/' )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:22:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:23:7: ( ';' )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:23:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:24:7: ( '=' )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:24:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:25:7: ( '@' )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:25:9: '@'
            {
            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:26:7: ( 'AS' )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:26:9: 'AS'
            {
            match("AS"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:27:7: ( 'BASE' )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:27:9: 'BASE'
            {
            match("BASE"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:28:7: ( 'BIND' )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:28:9: 'BIND'
            {
            match("BIND"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:29:7: ( 'ELSE' )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:29:9: 'ELSE'
            {
            match("ELSE"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:30:7: ( 'ELSIF' )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:30:9: 'ELSIF'
            {
            match("ELSIF"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:31:7: ( 'FOREACH' )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:31:9: 'FOREACH'
            {
            match("FOREACH"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:32:7: ( 'IF' )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:32:9: 'IF'
            {
            match("IF"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:33:7: ( 'IN' )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:33:9: 'IN'
            {
            match("IN"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:34:7: ( 'MATCH' )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:34:9: 'MATCH'
            {
            match("MATCH"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:35:7: ( 'PREFIX' )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:35:9: 'PREFIX'
            {
            match("PREFIX"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:36:7: ( '[' )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:36:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:37:7: ( '\\.' )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:37:9: '\\.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:38:7: ( ']' )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:38:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:39:7: ( '^^' )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:39:9: '^^'
            {
            match("^^"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:40:7: ( '_:' )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:40:9: '_:'
            {
            match("_:"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:41:7: ( 'a' )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:41:9: 'a'
            {
            match('a'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:42:7: ( 'false' )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:42:9: 'false'
            {
            match("false"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:43:7: ( 'now' )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:43:9: 'now'
            {
            match("now"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:44:7: ( 'true' )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:44:9: 'true'
            {
            match("true"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:45:7: ( '{' )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:45:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:46:7: ( '||' )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:46:9: '||'
            {
            match("||"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:47:7: ( '}' )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:47:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:510:2: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:510:4: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:510:24: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "NODE_NAME"
    public final void mNODE_NAME() throws RecognitionException {
        try {
            int _type = NODE_NAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:514:2: ( '?' ID )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:514:4: '?' ID
            {
            match('?'); 

            mID(); 


             setText(getText().substring(1, getText().length())); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NODE_NAME"

    // $ANTLR start "PREFIX_NAME"
    public final void mPREFIX_NAME() throws RecognitionException {
        try {
            int _type = PREFIX_NAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:518:2: ( ID ':' )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:518:4: ID ':'
            {
            mID(); 


            match(':'); 

             setText(getText().substring(0, getText().length() - 1)); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PREFIX_NAME"

    // $ANTLR start "LANG_TAG"
    public final void mLANG_TAG() throws RecognitionException {
        try {
            int _type = LANG_TAG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:522:2: ( '@' ( 'a' .. 'z' | 'A' .. 'Z' )+ ( '-' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+ )? )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:522:4: '@' ( 'a' .. 'z' | 'A' .. 'Z' )+ ( '-' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+ )?
            {
            match('@'); 

            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:522:8: ( 'a' .. 'z' | 'A' .. 'Z' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= 'A' && LA2_0 <= 'Z')||(LA2_0 >= 'a' && LA2_0 <= 'z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:
            	    {
            	    if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:522:29: ( '-' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+ )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='-') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:522:31: '-' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+
                    {
                    match('-'); 

                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:522:35: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+
                    int cnt3=0;
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0 >= '0' && LA3_0 <= '9')||(LA3_0 >= 'A' && LA3_0 <= 'Z')||(LA3_0 >= 'a' && LA3_0 <= 'z')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt3 >= 1 ) break loop3;
                                EarlyExitException eee =
                                    new EarlyExitException(3, input);
                                throw eee;
                        }
                        cnt3++;
                    } while (true);


                    }
                    break;

            }


             setText(getText().substring(1, getText().length())); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LANG_TAG"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:526:2: ( '0' | '1' .. '9' ( '0' .. '9' )* )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='0') ) {
                alt6=1;
            }
            else if ( ((LA6_0 >= '1' && LA6_0 <= '9')) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }
            switch (alt6) {
                case 1 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:526:4: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 2 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:527:4: '1' .. '9' ( '0' .. '9' )*
                    {
                    matchRange('1','9'); 

                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:527:13: ( '0' .. '9' )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0 >= '0' && LA5_0 <= '9')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:531:2: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )? | '.' ( '0' .. '9' )+ ( EXPONENT )? | ( '0' .. '9' )+ EXPONENT )
            int alt13=3;
            alt13 = dfa13.predict(input);
            switch (alt13) {
                case 1 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:531:4: ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )?
                    {
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:531:4: ( '0' .. '9' )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0 >= '0' && LA7_0 <= '9')) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt7 >= 1 ) break loop7;
                                EarlyExitException eee =
                                    new EarlyExitException(7, input);
                                throw eee;
                        }
                        cnt7++;
                    } while (true);


                    match('.'); 

                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:531:20: ( '0' .. '9' )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( ((LA8_0 >= '0' && LA8_0 <= '9')) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:531:32: ( EXPONENT )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='E'||LA9_0=='e') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:531:32: EXPONENT
                            {
                            mEXPONENT(); 


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:532:4: '.' ( '0' .. '9' )+ ( EXPONENT )?
                    {
                    match('.'); 

                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:532:8: ( '0' .. '9' )+
                    int cnt10=0;
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( ((LA10_0 >= '0' && LA10_0 <= '9')) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt10 >= 1 ) break loop10;
                                EarlyExitException eee =
                                    new EarlyExitException(10, input);
                                throw eee;
                        }
                        cnt10++;
                    } while (true);


                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:532:20: ( EXPONENT )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0=='E'||LA11_0=='e') ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:532:20: EXPONENT
                            {
                            mEXPONENT(); 


                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:533:4: ( '0' .. '9' )+ EXPONENT
                    {
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:533:4: ( '0' .. '9' )+
                    int cnt12=0;
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( ((LA12_0 >= '0' && LA12_0 <= '9')) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt12 >= 1 ) break loop12;
                                EarlyExitException eee =
                                    new EarlyExitException(12, input);
                                throw eee;
                        }
                        cnt12++;
                    } while (true);


                    mEXPONENT(); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FLOAT"

    // $ANTLR start "EXPONENT"
    public final void mEXPONENT() throws RecognitionException {
        try {
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:539:2: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:539:4: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:539:14: ( '+' | '-' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='+'||LA14_0=='-') ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }


            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:539:25: ( '0' .. '9' )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0 >= '0' && LA15_0 <= '9')) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
            } while (true);


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EXPONENT"

    // $ANTLR start "HEX_DIGIT"
    public final void mHEX_DIGIT() throws RecognitionException {
        try {
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:544:2: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "HEX_DIGIT"

    // $ANTLR start "UNICODE_ESC"
    public final void mUNICODE_ESC() throws RecognitionException {
        try {
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:549:2: ( '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:549:4: '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
            {
            match('\\'); 

            match('u'); 

            mHEX_DIGIT(); 


            mHEX_DIGIT(); 


            mHEX_DIGIT(); 


            mHEX_DIGIT(); 


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "UNICODE_ESC"

    // $ANTLR start "OCTAL_ESC"
    public final void mOCTAL_ESC() throws RecognitionException {
        try {
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:554:2: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
            int alt16=3;
            int LA16_0 = input.LA(1);

            if ( (LA16_0=='\\') ) {
                int LA16_1 = input.LA(2);

                if ( ((LA16_1 >= '0' && LA16_1 <= '3')) ) {
                    int LA16_2 = input.LA(3);

                    if ( ((LA16_2 >= '0' && LA16_2 <= '7')) ) {
                        int LA16_4 = input.LA(4);

                        if ( ((LA16_4 >= '0' && LA16_4 <= '7')) ) {
                            alt16=1;
                        }
                        else {
                            alt16=2;
                        }
                    }
                    else {
                        alt16=3;
                    }
                }
                else if ( ((LA16_1 >= '4' && LA16_1 <= '7')) ) {
                    int LA16_3 = input.LA(3);

                    if ( ((LA16_3 >= '0' && LA16_3 <= '7')) ) {
                        alt16=2;
                    }
                    else {
                        alt16=3;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;

            }
            switch (alt16) {
                case 1 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:554:4: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '3') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 2 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:555:4: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 3 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:556:4: '\\\\' ( '0' .. '7' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OCTAL_ESC"

    // $ANTLR start "ESC_SEQ"
    public final void mESC_SEQ() throws RecognitionException {
        try {
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:561:2: ( '\\\\' ( 'a' .. 'z' | 'A' .. 'Z' | '$' | '^' | '?' | '\\.' | ',' | '+' | '-' | '*' | ':' | '=' | '!' | '<' | '>' | '(' | ')' | '{' | '}' | '[' | ']' | '\\\"' | '\\'' | '\\\\' ) | UNICODE_ESC | OCTAL_ESC )
            int alt17=3;
            int LA17_0 = input.LA(1);

            if ( (LA17_0=='\\') ) {
                switch ( input.LA(2) ) {
                case 'u':
                    {
                    int LA17_2 = input.LA(3);

                    if ( ((LA17_2 >= '0' && LA17_2 <= '9')||(LA17_2 >= 'A' && LA17_2 <= 'F')||(LA17_2 >= 'a' && LA17_2 <= 'f')) ) {
                        alt17=2;
                    }
                    else {
                        alt17=1;
                    }
                    }
                    break;
                case '!':
                case '\"':
                case '$':
                case '\'':
                case '(':
                case ')':
                case '*':
                case '+':
                case ',':
                case '-':
                case '.':
                case ':':
                case '<':
                case '=':
                case '>':
                case '?':
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                case 'G':
                case 'H':
                case 'I':
                case 'J':
                case 'K':
                case 'L':
                case 'M':
                case 'N':
                case 'O':
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                case 'T':
                case 'U':
                case 'V':
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                case '[':
                case '\\':
                case ']':
                case '^':
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                case '{':
                case '}':
                    {
                    alt17=1;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                    {
                    alt17=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 1, input);

                    throw nvae;

                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;

            }
            switch (alt17) {
                case 1 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:561:4: '\\\\' ( 'a' .. 'z' | 'A' .. 'Z' | '$' | '^' | '?' | '\\.' | ',' | '+' | '-' | '*' | ':' | '=' | '!' | '<' | '>' | '(' | ')' | '{' | '}' | '[' | ']' | '\\\"' | '\\'' | '\\\\' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '!' && input.LA(1) <= '\"')||input.LA(1)=='$'||(input.LA(1) >= '\'' && input.LA(1) <= '.')||input.LA(1)==':'||(input.LA(1) >= '<' && input.LA(1) <= '?')||(input.LA(1) >= 'A' && input.LA(1) <= '^')||(input.LA(1) >= 'a' && input.LA(1) <= '{')||input.LA(1)=='}' ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 2 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:562:4: UNICODE_ESC
                    {
                    mUNICODE_ESC(); 


                    }
                    break;
                case 3 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:563:4: OCTAL_ESC
                    {
                    mOCTAL_ESC(); 


                    }
                    break;

            }

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ESC_SEQ"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:566:2: ( '\"' ( ESC_SEQ |~ ( '\\\\' | '\"' ) )* '\"' | '\\'' ( ESC_SEQ |~ ( '\\\\' | '\\'' ) )* '\\'' | '\"\"\"' ( options {greedy=false; } : . )* '\"\"\"' | '\\'\\'\\'' ( options {greedy=false; } : . )* '\\'\\'\\'' )
            int alt22=4;
            int LA22_0 = input.LA(1);

            if ( (LA22_0=='\"') ) {
                int LA22_1 = input.LA(2);

                if ( (LA22_1=='\"') ) {
                    int LA22_3 = input.LA(3);

                    if ( (LA22_3=='\"') ) {
                        alt22=3;
                    }
                    else {
                        alt22=1;
                    }
                }
                else if ( ((LA22_1 >= '\u0000' && LA22_1 <= '!')||(LA22_1 >= '#' && LA22_1 <= '\uFFFF')) ) {
                    alt22=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA22_0=='\'') ) {
                int LA22_2 = input.LA(2);

                if ( (LA22_2=='\'') ) {
                    int LA22_5 = input.LA(3);

                    if ( (LA22_5=='\'') ) {
                        alt22=4;
                    }
                    else {
                        alt22=2;
                    }
                }
                else if ( ((LA22_2 >= '\u0000' && LA22_2 <= '&')||(LA22_2 >= '(' && LA22_2 <= '\uFFFF')) ) {
                    alt22=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 2, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;

            }
            switch (alt22) {
                case 1 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:566:4: '\"' ( ESC_SEQ |~ ( '\\\\' | '\"' ) )* '\"'
                    {
                    match('\"'); 

                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:566:8: ( ESC_SEQ |~ ( '\\\\' | '\"' ) )*
                    loop18:
                    do {
                        int alt18=3;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0=='\\') ) {
                            alt18=1;
                        }
                        else if ( ((LA18_0 >= '\u0000' && LA18_0 <= '!')||(LA18_0 >= '#' && LA18_0 <= '[')||(LA18_0 >= ']' && LA18_0 <= '\uFFFF')) ) {
                            alt18=2;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:566:10: ESC_SEQ
                    	    {
                    	    mESC_SEQ(); 


                    	    }
                    	    break;
                    	case 2 :
                    	    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:566:20: ~ ( '\\\\' | '\"' )
                    	    {
                    	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);


                    match('\"'); 

                     setText(getText().substring(1, getText().length() - 1)); 

                    }
                    break;
                case 2 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:567:4: '\\'' ( ESC_SEQ |~ ( '\\\\' | '\\'' ) )* '\\''
                    {
                    match('\''); 

                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:567:9: ( ESC_SEQ |~ ( '\\\\' | '\\'' ) )*
                    loop19:
                    do {
                        int alt19=3;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0=='\\') ) {
                            alt19=1;
                        }
                        else if ( ((LA19_0 >= '\u0000' && LA19_0 <= '&')||(LA19_0 >= '(' && LA19_0 <= '[')||(LA19_0 >= ']' && LA19_0 <= '\uFFFF')) ) {
                            alt19=2;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:567:11: ESC_SEQ
                    	    {
                    	    mESC_SEQ(); 


                    	    }
                    	    break;
                    	case 2 :
                    	    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:567:21: ~ ( '\\\\' | '\\'' )
                    	    {
                    	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);


                    match('\''); 

                     setText(getText().substring(1, getText().length() - 1)); 

                    }
                    break;
                case 3 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:568:4: '\"\"\"' ( options {greedy=false; } : . )* '\"\"\"'
                    {
                    match("\"\"\""); 



                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:568:10: ( options {greedy=false; } : . )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0=='\"') ) {
                            int LA20_1 = input.LA(2);

                            if ( (LA20_1=='\"') ) {
                                int LA20_3 = input.LA(3);

                                if ( (LA20_3=='\"') ) {
                                    alt20=2;
                                }
                                else if ( ((LA20_3 >= '\u0000' && LA20_3 <= '!')||(LA20_3 >= '#' && LA20_3 <= '\uFFFF')) ) {
                                    alt20=1;
                                }


                            }
                            else if ( ((LA20_1 >= '\u0000' && LA20_1 <= '!')||(LA20_1 >= '#' && LA20_1 <= '\uFFFF')) ) {
                                alt20=1;
                            }


                        }
                        else if ( ((LA20_0 >= '\u0000' && LA20_0 <= '!')||(LA20_0 >= '#' && LA20_0 <= '\uFFFF')) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:568:40: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);


                    match("\"\"\""); 



                     setText(getText().substring(3, getText().length() - 3)); 

                    }
                    break;
                case 4 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:569:4: '\\'\\'\\'' ( options {greedy=false; } : . )* '\\'\\'\\''
                    {
                    match("'''"); 



                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:569:13: ( options {greedy=false; } : . )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0=='\'') ) {
                            int LA21_1 = input.LA(2);

                            if ( (LA21_1=='\'') ) {
                                int LA21_3 = input.LA(3);

                                if ( (LA21_3=='\'') ) {
                                    alt21=2;
                                }
                                else if ( ((LA21_3 >= '\u0000' && LA21_3 <= '&')||(LA21_3 >= '(' && LA21_3 <= '\uFFFF')) ) {
                                    alt21=1;
                                }


                            }
                            else if ( ((LA21_1 >= '\u0000' && LA21_1 <= '&')||(LA21_1 >= '(' && LA21_1 <= '\uFFFF')) ) {
                                alt21=1;
                            }


                        }
                        else if ( ((LA21_0 >= '\u0000' && LA21_0 <= '&')||(LA21_0 >= '(' && LA21_0 <= '\uFFFF')) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:569:43: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);


                    match("'''"); 



                     	setText(getText().substring(3, getText().length() - 3)); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "URI"
    public final void mURI() throws RecognitionException {
        try {
            int _type = URI;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:573:2: ( '<' ( ESC_SEQ |~ ( '\\\\' | '>' ) )* '>' )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:573:4: '<' ( ESC_SEQ |~ ( '\\\\' | '>' ) )* '>'
            {
            match('<'); 

            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:573:8: ( ESC_SEQ |~ ( '\\\\' | '>' ) )*
            loop23:
            do {
                int alt23=3;
                int LA23_0 = input.LA(1);

                if ( (LA23_0=='\\') ) {
                    alt23=1;
                }
                else if ( ((LA23_0 >= '\u0000' && LA23_0 <= '=')||(LA23_0 >= '?' && LA23_0 <= '[')||(LA23_0 >= ']' && LA23_0 <= '\uFFFF')) ) {
                    alt23=2;
                }


                switch (alt23) {
            	case 1 :
            	    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:573:10: ESC_SEQ
            	    {
            	    mESC_SEQ(); 


            	    }
            	    break;
            	case 2 :
            	    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:573:20: ~ ( '\\\\' | '>' )
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '=')||(input.LA(1) >= '?' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);


            match('>'); 

             
            			// As with Turtle and N3, the surrounding whitespace for a URI reference is ignored.
            			setText(getText().substring(1, getText().length() - 1).trim()); 
            		

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "URI"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:580:2: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' | '/*' ( options {greedy=false; } : . )* '*/' )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0=='/') ) {
                int LA27_1 = input.LA(2);

                if ( (LA27_1=='/') ) {
                    alt27=1;
                }
                else if ( (LA27_1=='*') ) {
                    alt27=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 27, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;

            }
            switch (alt27) {
                case 1 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:580:4: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
                    {
                    match("//"); 



                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:580:9: (~ ( '\\n' | '\\r' ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( ((LA24_0 >= '\u0000' && LA24_0 <= '\t')||(LA24_0 >= '\u000B' && LA24_0 <= '\f')||(LA24_0 >= '\u000E' && LA24_0 <= '\uFFFF')) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:
                    	    {
                    	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);


                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:580:23: ( '\\r' )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0=='\r') ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:580:23: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }


                    match('\n'); 

                     _channel=HIDDEN; 

                    }
                    break;
                case 2 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:581:4: '/*' ( options {greedy=false; } : . )* '*/'
                    {
                    match("/*"); 



                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:581:9: ( options {greedy=false; } : . )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0=='*') ) {
                            int LA26_1 = input.LA(2);

                            if ( (LA26_1=='/') ) {
                                alt26=2;
                            }
                            else if ( ((LA26_1 >= '\u0000' && LA26_1 <= '.')||(LA26_1 >= '0' && LA26_1 <= '\uFFFF')) ) {
                                alt26=1;
                            }


                        }
                        else if ( ((LA26_0 >= '\u0000' && LA26_0 <= ')')||(LA26_0 >= '+' && LA26_0 <= '\uFFFF')) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:581:39: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop26;
                        }
                    } while (true);


                    match("*/"); 



                     _channel=HIDDEN; 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:585:2: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:585:4: ( ' ' | '\\t' | '\\r' | '\\n' )
            {
            if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


             _channel=HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:1:8: ( T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | ID | NODE_NAME | PREFIX_NAME | LANG_TAG | INT | FLOAT | STRING | URI | COMMENT | WS )
        int alt28=44;
        alt28 = dfa28.predict(input);
        switch (alt28) {
            case 1 :
                // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:1:10: T__19
                {
                mT__19(); 


                }
                break;
            case 2 :
                // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:1:16: T__20
                {
                mT__20(); 


                }
                break;
            case 3 :
                // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:1:22: T__21
                {
                mT__21(); 


                }
                break;
            case 4 :
                // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:1:28: T__22
                {
                mT__22(); 


                }
                break;
            case 5 :
                // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:1:34: T__23
                {
                mT__23(); 


                }
                break;
            case 6 :
                // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:1:40: T__24
                {
                mT__24(); 


                }
                break;
            case 7 :
                // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:1:46: T__25
                {
                mT__25(); 


                }
                break;
            case 8 :
                // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:1:52: T__26
                {
                mT__26(); 


                }
                break;
            case 9 :
                // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:1:58: T__27
                {
                mT__27(); 


                }
                break;
            case 10 :
                // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:1:64: T__28
                {
                mT__28(); 


                }
                break;
            case 11 :
                // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:1:70: T__29
                {
                mT__29(); 


                }
                break;
            case 12 :
                // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:1:76: T__30
                {
                mT__30(); 


                }
                break;
            case 13 :
                // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:1:82: T__31
                {
                mT__31(); 


                }
                break;
            case 14 :
                // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:1:88: T__32
                {
                mT__32(); 


                }
                break;
            case 15 :
                // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:1:94: T__33
                {
                mT__33(); 


                }
                break;
            case 16 :
                // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:1:100: T__34
                {
                mT__34(); 


                }
                break;
            case 17 :
                // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:1:106: T__35
                {
                mT__35(); 


                }
                break;
            case 18 :
                // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:1:112: T__36
                {
                mT__36(); 


                }
                break;
            case 19 :
                // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:1:118: T__37
                {
                mT__37(); 


                }
                break;
            case 20 :
                // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:1:124: T__38
                {
                mT__38(); 


                }
                break;
            case 21 :
                // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:1:130: T__39
                {
                mT__39(); 


                }
                break;
            case 22 :
                // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:1:136: T__40
                {
                mT__40(); 


                }
                break;
            case 23 :
                // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:1:142: T__41
                {
                mT__41(); 


                }
                break;
            case 24 :
                // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:1:148: T__42
                {
                mT__42(); 


                }
                break;
            case 25 :
                // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:1:154: T__43
                {
                mT__43(); 


                }
                break;
            case 26 :
                // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:1:160: T__44
                {
                mT__44(); 


                }
                break;
            case 27 :
                // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:1:166: T__45
                {
                mT__45(); 


                }
                break;
            case 28 :
                // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:1:172: T__46
                {
                mT__46(); 


                }
                break;
            case 29 :
                // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:1:178: T__47
                {
                mT__47(); 


                }
                break;
            case 30 :
                // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:1:184: T__48
                {
                mT__48(); 


                }
                break;
            case 31 :
                // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:1:190: T__49
                {
                mT__49(); 


                }
                break;
            case 32 :
                // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:1:196: T__50
                {
                mT__50(); 


                }
                break;
            case 33 :
                // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:1:202: T__51
                {
                mT__51(); 


                }
                break;
            case 34 :
                // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:1:208: T__52
                {
                mT__52(); 


                }
                break;
            case 35 :
                // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:1:214: ID
                {
                mID(); 


                }
                break;
            case 36 :
                // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:1:217: NODE_NAME
                {
                mNODE_NAME(); 


                }
                break;
            case 37 :
                // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:1:227: PREFIX_NAME
                {
                mPREFIX_NAME(); 


                }
                break;
            case 38 :
                // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:1:239: LANG_TAG
                {
                mLANG_TAG(); 


                }
                break;
            case 39 :
                // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:1:248: INT
                {
                mINT(); 


                }
                break;
            case 40 :
                // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:1:252: FLOAT
                {
                mFLOAT(); 


                }
                break;
            case 41 :
                // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:1:258: STRING
                {
                mSTRING(); 


                }
                break;
            case 42 :
                // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:1:265: URI
                {
                mURI(); 


                }
                break;
            case 43 :
                // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:1:269: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 44 :
                // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:1:277: WS
                {
                mWS(); 


                }
                break;

        }

    }


    protected DFA13 dfa13 = new DFA13(this);
    protected DFA28 dfa28 = new DFA28(this);
    static final String DFA13_eotS =
        "\5\uffff";
    static final String DFA13_eofS =
        "\5\uffff";
    static final String DFA13_minS =
        "\2\56\3\uffff";
    static final String DFA13_maxS =
        "\1\71\1\145\3\uffff";
    static final String DFA13_acceptS =
        "\2\uffff\1\2\1\1\1\3";
    static final String DFA13_specialS =
        "\5\uffff}>";
    static final String[] DFA13_transitionS = {
            "\1\2\1\uffff\12\1",
            "\1\3\1\uffff\12\1\13\uffff\1\4\37\uffff\1\4",
            "",
            "",
            ""
    };

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "530:1: FLOAT : ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )? | '.' ( '0' .. '9' )+ ( EXPONENT )? | ( '0' .. '9' )+ EXPONENT );";
        }
    }
    static final String DFA28_eotS =
        "\11\uffff\1\50\2\uffff\1\51\7\55\1\uffff\1\67\3\uffff\1\71\3\55"+
        "\3\uffff\1\55\1\uffff\2\75\7\uffff\1\77\1\55\2\uffff\4\55\1\104"+
        "\1\105\2\55\3\uffff\3\55\1\uffff\1\75\1\uffff\4\55\2\uffff\3\55"+
        "\1\123\1\55\1\125\1\126\1\127\5\55\1\uffff\1\135\3\uffff\1\136\1"+
        "\55\1\140\1\55\1\142\2\uffff\1\55\1\uffff\1\144\1\uffff\1\145\2"+
        "\uffff";
    static final String DFA28_eofS =
        "\146\uffff";
    static final String DFA28_minS =
        "\1\11\10\uffff\1\52\2\uffff\1\101\7\60\1\uffff\1\60\3\uffff\4\60"+
        "\3\uffff\1\60\1\uffff\2\56\7\uffff\2\60\2\uffff\10\60\3\uffff\3"+
        "\60\1\uffff\1\56\1\uffff\4\60\2\uffff\15\60\1\uffff\1\60\3\uffff"+
        "\5\60\2\uffff\1\60\1\uffff\1\60\1\uffff\1\60\2\uffff";
    static final String DFA28_maxS =
        "\1\175\10\uffff\1\57\2\uffff\10\172\1\uffff\1\71\3\uffff\4\172\3"+
        "\uffff\1\172\1\uffff\2\145\7\uffff\2\172\2\uffff\10\172\3\uffff"+
        "\3\172\1\uffff\1\145\1\uffff\4\172\2\uffff\15\172\1\uffff\1\172"+
        "\3\uffff\5\172\2\uffff\1\172\1\uffff\1\172\1\uffff\1\172\2\uffff";
    static final String DFA28_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\12\1\13\10\uffff"+
        "\1\27\1\uffff\1\31\1\32\1\33\4\uffff\1\40\1\41\1\42\1\uffff\1\44"+
        "\2\uffff\1\51\1\52\1\54\1\53\1\11\1\14\1\46\2\uffff\1\43\1\45\10"+
        "\uffff\1\30\1\50\1\34\3\uffff\1\47\1\uffff\1\15\4\uffff\1\23\1\24"+
        "\15\uffff\1\36\1\uffff\1\16\1\17\1\20\5\uffff\1\37\1\21\1\uffff"+
        "\1\25\1\uffff\1\35\1\uffff\1\26\1\22";
    static final String DFA28_specialS =
        "\146\uffff}>";
    static final String[] DFA28_transitionS = {
            "\2\46\2\uffff\1\46\22\uffff\1\46\1\1\1\44\1\uffff\1\2\1\uffff"+
            "\1\3\1\44\1\4\1\5\1\uffff\1\6\1\7\1\10\1\25\1\11\1\42\11\43"+
            "\1\uffff\1\12\1\45\1\13\1\uffff\1\41\1\14\1\15\1\16\2\40\1\17"+
            "\1\20\2\40\1\21\3\40\1\22\2\40\1\23\12\40\1\24\1\uffff\1\26"+
            "\1\27\1\30\1\uffff\1\31\4\40\1\32\7\40\1\33\5\40\1\34\6\40\1"+
            "\35\1\36\1\37",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\47\4\uffff\1\47",
            "",
            "",
            "\32\52\6\uffff\32\52",
            "\12\54\1\56\6\uffff\22\54\1\53\7\54\4\uffff\1\54\1\uffff\32"+
            "\54",
            "\12\54\1\56\6\uffff\1\57\7\54\1\60\21\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\12\54\1\56\6\uffff\13\54\1\61\16\54\4\uffff\1\54\1\uffff\32"+
            "\54",
            "\12\54\1\56\6\uffff\16\54\1\62\13\54\4\uffff\1\54\1\uffff\32"+
            "\54",
            "\12\54\1\56\6\uffff\5\54\1\63\7\54\1\64\14\54\4\uffff\1\54"+
            "\1\uffff\32\54",
            "\12\54\1\56\6\uffff\1\65\31\54\4\uffff\1\54\1\uffff\32\54",
            "\12\54\1\56\6\uffff\21\54\1\66\10\54\4\uffff\1\54\1\uffff\32"+
            "\54",
            "",
            "\12\70",
            "",
            "",
            "",
            "\12\54\1\56\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\12\54\1\56\6\uffff\32\54\4\uffff\1\54\1\uffff\1\72\31\54",
            "\12\54\1\56\6\uffff\32\54\4\uffff\1\54\1\uffff\16\54\1\73\13"+
            "\54",
            "\12\54\1\56\6\uffff\32\54\4\uffff\1\54\1\uffff\21\54\1\74\10"+
            "\54",
            "",
            "",
            "",
            "\12\54\1\56\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "",
            "\1\70\1\uffff\12\70\13\uffff\1\70\37\uffff\1\70",
            "\1\70\1\uffff\12\76\13\uffff\1\70\37\uffff\1\70",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\54\1\56\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\12\54\1\56\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "",
            "",
            "\12\54\1\56\6\uffff\22\54\1\100\7\54\4\uffff\1\54\1\uffff\32"+
            "\54",
            "\12\54\1\56\6\uffff\15\54\1\101\14\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\12\54\1\56\6\uffff\22\54\1\102\7\54\4\uffff\1\54\1\uffff\32"+
            "\54",
            "\12\54\1\56\6\uffff\21\54\1\103\10\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\12\54\1\56\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\12\54\1\56\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\12\54\1\56\6\uffff\23\54\1\106\6\54\4\uffff\1\54\1\uffff\32"+
            "\54",
            "\12\54\1\56\6\uffff\4\54\1\107\25\54\4\uffff\1\54\1\uffff\32"+
            "\54",
            "",
            "",
            "",
            "\12\54\1\56\6\uffff\32\54\4\uffff\1\54\1\uffff\13\54\1\110"+
            "\16\54",
            "\12\54\1\56\6\uffff\32\54\4\uffff\1\54\1\uffff\26\54\1\111"+
            "\3\54",
            "\12\54\1\56\6\uffff\32\54\4\uffff\1\54\1\uffff\24\54\1\112"+
            "\5\54",
            "",
            "\1\70\1\uffff\12\76\13\uffff\1\70\37\uffff\1\70",
            "",
            "\12\54\1\56\6\uffff\4\54\1\113\25\54\4\uffff\1\54\1\uffff\32"+
            "\54",
            "\12\54\1\56\6\uffff\3\54\1\114\26\54\4\uffff\1\54\1\uffff\32"+
            "\54",
            "\12\54\1\56\6\uffff\4\54\1\115\3\54\1\116\21\54\4\uffff\1\54"+
            "\1\uffff\32\54",
            "\12\54\1\56\6\uffff\4\54\1\117\25\54\4\uffff\1\54\1\uffff\32"+
            "\54",
            "",
            "",
            "\12\54\1\56\6\uffff\2\54\1\120\27\54\4\uffff\1\54\1\uffff\32"+
            "\54",
            "\12\54\1\56\6\uffff\5\54\1\121\24\54\4\uffff\1\54\1\uffff\32"+
            "\54",
            "\12\54\1\56\6\uffff\32\54\4\uffff\1\54\1\uffff\22\54\1\122"+
            "\7\54",
            "\12\54\1\56\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\12\54\1\56\6\uffff\32\54\4\uffff\1\54\1\uffff\4\54\1\124\25"+
            "\54",
            "\12\54\1\56\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\12\54\1\56\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\12\54\1\56\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\12\54\1\56\6\uffff\5\54\1\130\24\54\4\uffff\1\54\1\uffff\32"+
            "\54",
            "\12\54\1\56\6\uffff\1\131\31\54\4\uffff\1\54\1\uffff\32\54",
            "\12\54\1\56\6\uffff\7\54\1\132\22\54\4\uffff\1\54\1\uffff\32"+
            "\54",
            "\12\54\1\56\6\uffff\10\54\1\133\21\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\12\54\1\56\6\uffff\32\54\4\uffff\1\54\1\uffff\4\54\1\134\25"+
            "\54",
            "",
            "\12\54\1\56\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "",
            "",
            "",
            "\12\54\1\56\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\12\54\1\56\6\uffff\2\54\1\137\27\54\4\uffff\1\54\1\uffff\32"+
            "\54",
            "\12\54\1\56\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\12\54\1\56\6\uffff\27\54\1\141\2\54\4\uffff\1\54\1\uffff\32"+
            "\54",
            "\12\54\1\56\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "",
            "",
            "\12\54\1\56\6\uffff\7\54\1\143\22\54\4\uffff\1\54\1\uffff\32"+
            "\54",
            "",
            "\12\54\1\56\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "",
            "\12\54\1\56\6\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "",
            ""
    };

    static final short[] DFA28_eot = DFA.unpackEncodedString(DFA28_eotS);
    static final short[] DFA28_eof = DFA.unpackEncodedString(DFA28_eofS);
    static final char[] DFA28_min = DFA.unpackEncodedStringToUnsignedChars(DFA28_minS);
    static final char[] DFA28_max = DFA.unpackEncodedStringToUnsignedChars(DFA28_maxS);
    static final short[] DFA28_accept = DFA.unpackEncodedString(DFA28_acceptS);
    static final short[] DFA28_special = DFA.unpackEncodedString(DFA28_specialS);
    static final short[][] DFA28_transition;

    static {
        int numStates = DFA28_transitionS.length;
        DFA28_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA28_transition[i] = DFA.unpackEncodedString(DFA28_transitionS[i]);
        }
    }

    class DFA28 extends DFA {

        public DFA28(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 28;
            this.eot = DFA28_eot;
            this.eof = DFA28_eof;
            this.min = DFA28_min;
            this.max = DFA28_max;
            this.accept = DFA28_accept;
            this.special = DFA28_special;
            this.transition = DFA28_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | ID | NODE_NAME | PREFIX_NAME | LANG_TAG | INT | FLOAT | STRING | URI | COMMENT | WS );";
        }
    }
 

}