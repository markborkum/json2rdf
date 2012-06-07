// $ANTLR 3.4 /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g 2012-06-06 10:43:41

	package uk.ac.soton.mib104.json2rdf;
	
	import com.hp.hpl.jena.graph.Node;
	import com.hp.hpl.jena.vocabulary.OWL;
	import com.hp.hpl.jena.vocabulary.RDF;
	
	import java.util.Iterator;
	import java.util.LinkedList;
	import java.util.List;

	import uk.ac.soton.mib104.json2rdf.lang.condition.AndCondition;
	import uk.ac.soton.mib104.json2rdf.lang.condition.Condition;
	import uk.ac.soton.mib104.json2rdf.lang.condition.IsDefinedCondition;
	import uk.ac.soton.mib104.json2rdf.lang.condition.NotCondition;
	import uk.ac.soton.mib104.json2rdf.lang.condition.OrCondition;
	import uk.ac.soton.mib104.json2rdf.lang.expression.BaseDeclaration;
	import uk.ac.soton.mib104.json2rdf.lang.expression.ConditionalBlock;
	import uk.ac.soton.mib104.json2rdf.lang.expression.Block;
	import uk.ac.soton.mib104.json2rdf.lang.expression.ForeachBlock;
	import uk.ac.soton.mib104.json2rdf.lang.expression.MatchBlock;
	import uk.ac.soton.mib104.json2rdf.lang.expression.NamedNodeDeclaration;
	import uk.ac.soton.mib104.json2rdf.lang.expression.PrefixDeclaration;
	import uk.ac.soton.mib104.json2rdf.lang.expression.TripleExpression;
	import uk.ac.soton.mib104.json2rdf.lang.method.ChildMethod;
	import uk.ac.soton.mib104.json2rdf.lang.method.CurrentTimeMethod;
	import uk.ac.soton.mib104.json2rdf.lang.template.AnonNodeTemplate;
	import uk.ac.soton.mib104.json2rdf.lang.template.CurrentTimeNodeTemplate;
	import uk.ac.soton.mib104.json2rdf.lang.template.InterpolatedStringTemplate;
	import uk.ac.soton.mib104.json2rdf.lang.template.MethodCall;
	import uk.ac.soton.mib104.json2rdf.lang.template.MethodCallList;
	import uk.ac.soton.mib104.json2rdf.lang.template.NamedNodeTemplate;
	import uk.ac.soton.mib104.json2rdf.lang.template.PlainLiteralNodeTemplate;
	import uk.ac.soton.mib104.json2rdf.lang.template.PrefixedNameNodeTemplate;
	import uk.ac.soton.mib104.json2rdf.lang.template.Template;
	import uk.ac.soton.mib104.json2rdf.lang.template.TypedLiteralNodeTemplate;
	import uk.ac.soton.mib104.json2rdf.lang.template.URINodeTemplate;
	import uk.ac.soton.mib104.json2rdf.util.StringUtils;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class JSON2RDFParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "ESC_SEQ", "EXPONENT", "FLOAT", "HEX_DIGIT", "ID", "INT", "LANG_TAG", "NODE_NAME", "OCTAL_ESC", "PREFIX_NAME", "STRING", "UNICODE_ESC", "URI", "WS", "'!'", "'${'", "'&&'", "'('", "')'", "'+'", "','", "'-'", "'/'", "';'", "'='", "'@'", "'AS'", "'BASE'", "'BIND'", "'ELSE'", "'ELSIF'", "'FOREACH'", "'IF'", "'IN'", "'MATCH'", "'PREFIX'", "'['", "'\\.'", "']'", "'^^'", "'_:'", "'a'", "'false'", "'now'", "'true'", "'{'", "'||'", "'}'"
    };

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

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public JSON2RDFParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public JSON2RDFParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return JSON2RDFParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g"; }


    	private static final Template<Node> OWL_sameAs = new URINodeTemplate(Template.toTemplate(OWL.sameAs.getURI()));
    	private static final Template<Node> RDF_first  = new URINodeTemplate(Template.toTemplate(RDF.first.getURI()));
    	private static final Template<Node> RDF_nil    = new URINodeTemplate(Template.toTemplate(RDF.nil.getURI()));
    	private static final Template<Node> RDF_rest   = new URINodeTemplate(Template.toTemplate(RDF.rest.getURI()));
    	private static final Template<Node> RDF_type   = new URINodeTemplate(Template.toTemplate(RDF.type.getURI()));
    	private static final Template<Node> RDF_List   = new URINodeTemplate(Template.toTemplate(RDF.List.getURI()));

    	private static final char POSITIVE_TERMINAL = '+', NEGATIVE_TERMINAL = '-';
    	
    	private static final int POSITIVE_SIGN = 1, NEGATIVE_SIGN = -1;
    	
    	private static final String getSignFor(final String string) {
    		int currentSign = POSITIVE_SIGN;
    		
    		final int length = string.length();
    		
    		for (int i = 0; i < length; i++) {
    			final char nextChar = string.charAt(i);
    			
    			switch (nextChar) {
    			case POSITIVE_TERMINAL:
    				currentSign *= POSITIVE_SIGN;
    				break;
    			case NEGATIVE_TERMINAL:
    				currentSign *= NEGATIVE_SIGN;
    				break;
    			default:
    				// TODO Replace with specialized Exception class.
    				throw new IllegalArgumentException("Unknown character: '" + nextChar + "' (should be '" + POSITIVE_TERMINAL + "' or '" + NEGATIVE_TERMINAL + "')");
    			}
    		}
    		
    		switch (currentSign) {
    		case POSITIVE_SIGN:
    			return StringUtils.emptyString;
    		case NEGATIVE_SIGN:
    			return Character.toString(NEGATIVE_TERMINAL);
    		default:
    			// TODO Replace with specialized Exception class.
    			throw new IllegalStateException("Unknown sign: " + currentSign + " (should be " + POSITIVE_SIGN + " or " + NEGATIVE_SIGN + ")");
    		}
    	}



    // $ANTLR start "root"
    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:100:1: root[] returns [Block parent] : prelude[$parent] ( expression[$parent] )* EOF ;
    public final Block root() throws RecognitionException {
        Block parent = null;



        	parent = new Block();

        try {
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:104:2: ( prelude[$parent] ( expression[$parent] )* EOF )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:104:4: prelude[$parent] ( expression[$parent] )* EOF
            {
            pushFollow(FOLLOW_prelude_in_root69);
            prelude(parent);

            state._fsp--;


            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:104:21: ( expression[$parent] )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==NODE_NAME||LA1_0==PREFIX_NAME||LA1_0==URI||LA1_0==22||(LA1_0 >= 36 && LA1_0 <= 37)||LA1_0==39||LA1_0==41||LA1_0==45||LA1_0==50) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:104:23: expression[$parent]
            	    {
            	    pushFollow(FOLLOW_expression_in_root74);
            	    expression(parent);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            match(input,EOF,FOLLOW_EOF_in_root80); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return parent;
    }
    // $ANTLR end "root"



    // $ANTLR start "prelude"
    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:107:1: prelude[Block parent] returns [] : ( baseDeclaration[$parent] )? ( prefixDeclaration[$parent] )* ( namedNodeDeclaration[$parent] )* ;
    public final void prelude(Block parent) throws RecognitionException {
        try {
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:108:2: ( ( baseDeclaration[$parent] )? ( prefixDeclaration[$parent] )* ( namedNodeDeclaration[$parent] )* )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:108:4: ( baseDeclaration[$parent] )? ( prefixDeclaration[$parent] )* ( namedNodeDeclaration[$parent] )*
            {
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:108:4: ( baseDeclaration[$parent] )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==32) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:108:6: baseDeclaration[$parent]
                    {
                    pushFollow(FOLLOW_baseDeclaration_in_prelude99);
                    baseDeclaration(parent);

                    state._fsp--;


                    }
                    break;

            }


            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:108:34: ( prefixDeclaration[$parent] )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==40) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:108:36: prefixDeclaration[$parent]
            	    {
            	    pushFollow(FOLLOW_prefixDeclaration_in_prelude107);
            	    prefixDeclaration(parent);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:108:66: ( namedNodeDeclaration[$parent] )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==33) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:108:68: namedNodeDeclaration[$parent]
            	    {
            	    pushFollow(FOLLOW_namedNodeDeclaration_in_prelude115);
            	    namedNodeDeclaration(parent);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "prelude"



    // $ANTLR start "expression"
    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:111:1: expression[Block parent] returns [] : ( tripleExpression[$parent] | conditionalBlock[$parent] | foreachBlock[$parent] | matchBlock[$parent] | block[$parent, true] );
    public final void expression(Block parent) throws RecognitionException {
        try {
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:112:2: ( tripleExpression[$parent] | conditionalBlock[$parent] | foreachBlock[$parent] | matchBlock[$parent] | block[$parent, true] )
            int alt5=5;
            switch ( input.LA(1) ) {
            case NODE_NAME:
            case PREFIX_NAME:
            case URI:
            case 22:
            case 41:
            case 45:
                {
                alt5=1;
                }
                break;
            case 37:
                {
                alt5=2;
                }
                break;
            case 36:
                {
                alt5=3;
                }
                break;
            case 39:
                {
                alt5=4;
                }
                break;
            case 50:
                {
                alt5=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }

            switch (alt5) {
                case 1 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:112:4: tripleExpression[$parent]
                    {
                    pushFollow(FOLLOW_tripleExpression_in_expression135);
                    tripleExpression(parent);

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:113:4: conditionalBlock[$parent]
                    {
                    pushFollow(FOLLOW_conditionalBlock_in_expression141);
                    conditionalBlock(parent);

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:114:4: foreachBlock[$parent]
                    {
                    pushFollow(FOLLOW_foreachBlock_in_expression147);
                    foreachBlock(parent);

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:115:4: matchBlock[$parent]
                    {
                    pushFollow(FOLLOW_matchBlock_in_expression153);
                    matchBlock(parent);

                    state._fsp--;


                    }
                    break;
                case 5 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:116:4: block[$parent, true]
                    {
                    pushFollow(FOLLOW_block_in_expression159);
                    block(parent, true);

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "expression"



    // $ANTLR start "baseDeclaration"
    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:119:1: baseDeclaration[Block parent] returns [] : 'BASE' baseNodeTemplate= uriNodeTemplateWithName[$parent] ;
    public final void baseDeclaration(Block parent) throws RecognitionException {
        Template<Node> baseNodeTemplate =null;


        try {
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:123:2: ( 'BASE' baseNodeTemplate= uriNodeTemplateWithName[$parent] )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:123:4: 'BASE' baseNodeTemplate= uriNodeTemplateWithName[$parent]
            {
            match(input,32,FOLLOW_32_in_baseDeclaration181); 

            pushFollow(FOLLOW_uriNodeTemplateWithName_in_baseDeclaration185);
            baseNodeTemplate=uriNodeTemplateWithName(parent);

            state._fsp--;


            }


            	new BaseDeclaration(parent, baseNodeTemplate);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "baseDeclaration"



    // $ANTLR start "prefixDeclaration"
    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:126:1: prefixDeclaration[Block parent] returns [] : 'PREFIX' namespacePrefix= PREFIX_NAME namespaceNodeTemplate= uriNodeTemplateWithName[$parent] ;
    public final void prefixDeclaration(Block parent) throws RecognitionException {
        Token namespacePrefix=null;
        Template<Node> namespaceNodeTemplate =null;


        try {
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:130:2: ( 'PREFIX' namespacePrefix= PREFIX_NAME namespaceNodeTemplate= uriNodeTemplateWithName[$parent] )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:130:4: 'PREFIX' namespacePrefix= PREFIX_NAME namespaceNodeTemplate= uriNodeTemplateWithName[$parent]
            {
            match(input,40,FOLLOW_40_in_prefixDeclaration208); 

            namespacePrefix=(Token)match(input,PREFIX_NAME,FOLLOW_PREFIX_NAME_in_prefixDeclaration212); 

            pushFollow(FOLLOW_uriNodeTemplateWithName_in_prefixDeclaration216);
            namespaceNodeTemplate=uriNodeTemplateWithName(parent);

            state._fsp--;


            }


            	new PrefixDeclaration(parent, Template.toTemplate((namespacePrefix!=null?namespacePrefix.getText():null)), namespaceNodeTemplate);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "prefixDeclaration"



    // $ANTLR start "namedNodeDeclaration"
    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:133:1: namedNodeDeclaration[Block parent] returns [] : 'BIND' name= PREFIX_NAME namedNodeTemplate= nodeTemplateWithName[$parent] ;
    public final void namedNodeDeclaration(Block parent) throws RecognitionException {
        Token name=null;
        Template<Node> namedNodeTemplate =null;


        try {
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:137:2: ( 'BIND' name= PREFIX_NAME namedNodeTemplate= nodeTemplateWithName[$parent] )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:137:4: 'BIND' name= PREFIX_NAME namedNodeTemplate= nodeTemplateWithName[$parent]
            {
            match(input,33,FOLLOW_33_in_namedNodeDeclaration239); 

            name=(Token)match(input,PREFIX_NAME,FOLLOW_PREFIX_NAME_in_namedNodeDeclaration243); 

            pushFollow(FOLLOW_nodeTemplateWithName_in_namedNodeDeclaration247);
            namedNodeTemplate=nodeTemplateWithName(parent);

            state._fsp--;


            }


            	new NamedNodeDeclaration(parent, Template.toTemplate((name!=null?name.getText():null)), namedNodeTemplate);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "namedNodeDeclaration"



    // $ANTLR start "tripleExpression"
    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:140:1: tripleExpression[Block parent] returns [] : subject= resourceNodeTemplateWithName[$parent] predicateList[$parent, subjectTemplate] '\\.' ;
    public final void tripleExpression(Block parent) throws RecognitionException {
        Template<Node> subject =null;


        try {
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:141:2: (subject= resourceNodeTemplateWithName[$parent] predicateList[$parent, subjectTemplate] '\\.' )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:141:4: subject= resourceNodeTemplateWithName[$parent] predicateList[$parent, subjectTemplate] '\\.'
            {
            pushFollow(FOLLOW_resourceNodeTemplateWithName_in_tripleExpression266);
            subject=resourceNodeTemplateWithName(parent);

            state._fsp--;


             
            			final Template<Node> subjectTemplate = subject;
            		

            pushFollow(FOLLOW_predicateList_in_tripleExpression271);
            predicateList(parent, subjectTemplate);

            state._fsp--;


            match(input,42,FOLLOW_42_in_tripleExpression274); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "tripleExpression"



    // $ANTLR start "predicateList"
    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:146:1: predicateList[Block parent, Template<Node> subjectTemplate] returns [] : headPredicate= predicate[$parent] objectList[$parent, $subjectTemplate, headPredicateTemplate] ( ';' tailPredicate= predicate[$parent] objectList[$parent, $subjectTemplate, tailPredicateTemplate] )* ;
    public final void predicateList(Block parent, Template<Node> subjectTemplate) throws RecognitionException {
        Template<Node> headPredicate =null;

        Template<Node> tailPredicate =null;


        try {
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:147:2: (headPredicate= predicate[$parent] objectList[$parent, $subjectTemplate, headPredicateTemplate] ( ';' tailPredicate= predicate[$parent] objectList[$parent, $subjectTemplate, tailPredicateTemplate] )* )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:147:4: headPredicate= predicate[$parent] objectList[$parent, $subjectTemplate, headPredicateTemplate] ( ';' tailPredicate= predicate[$parent] objectList[$parent, $subjectTemplate, tailPredicateTemplate] )*
            {
            pushFollow(FOLLOW_predicate_in_predicateList293);
            headPredicate=predicate(parent);

            state._fsp--;



            			final Template<Node> headPredicateTemplate = headPredicate;
            		

            pushFollow(FOLLOW_objectList_in_predicateList298);
            objectList(parent, subjectTemplate, headPredicateTemplate);

            state._fsp--;


            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:149:66: ( ';' tailPredicate= predicate[$parent] objectList[$parent, $subjectTemplate, tailPredicateTemplate] )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==28) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:149:68: ';' tailPredicate= predicate[$parent] objectList[$parent, $subjectTemplate, tailPredicateTemplate]
            	    {
            	    match(input,28,FOLLOW_28_in_predicateList303); 

            	    pushFollow(FOLLOW_predicate_in_predicateList307);
            	    tailPredicate=predicate(parent);

            	    state._fsp--;



            	    			final Template<Node> tailPredicateTemplate = tailPredicate;
            	    		

            	    pushFollow(FOLLOW_objectList_in_predicateList312);
            	    objectList(parent, subjectTemplate, tailPredicateTemplate);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "predicateList"



    // $ANTLR start "predicate"
    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:154:1: predicate[Block parent] returns [Template<Node> template] : ( 'a' | '=' |uriNode= uriNodeTemplateWithName[$parent] );
    public final Template<Node> predicate(Block parent) throws RecognitionException {
        Template<Node> template = null;


        Template<Node> uriNode =null;


        try {
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:155:2: ( 'a' | '=' |uriNode= uriNodeTemplateWithName[$parent] )
            int alt7=3;
            switch ( input.LA(1) ) {
            case 46:
                {
                alt7=1;
                }
                break;
            case 29:
                {
                alt7=2;
                }
                break;
            case NODE_NAME:
            case PREFIX_NAME:
            case URI:
                {
                alt7=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;

            }

            switch (alt7) {
                case 1 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:155:4: 'a'
                    {
                    match(input,46,FOLLOW_46_in_predicate333); 


                    			template = RDF_type;
                    		

                    }
                    break;
                case 2 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:158:4: '='
                    {
                    match(input,29,FOLLOW_29_in_predicate340); 


                    			template = OWL_sameAs;
                    		

                    }
                    break;
                case 3 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:161:4: uriNode= uriNodeTemplateWithName[$parent]
                    {
                    pushFollow(FOLLOW_uriNodeTemplateWithName_in_predicate349);
                    uriNode=uriNodeTemplateWithName(parent);

                    state._fsp--;



                    			template = uriNode;
                    		

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return template;
    }
    // $ANTLR end "predicate"



    // $ANTLR start "objectList"
    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:166:1: objectList[Block parent, Template<Node> subjectTemplate, Template<Node> predicateTemplate] returns [] : head= nodeTemplateWithName[$parent] ( ',' tail= nodeTemplateWithName[$parent] )* ;
    public final void objectList(Block parent, Template<Node> subjectTemplate, Template<Node> predicateTemplate) throws RecognitionException {
        Template<Node> head =null;

        Template<Node> tail =null;


        try {
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:167:2: (head= nodeTemplateWithName[$parent] ( ',' tail= nodeTemplateWithName[$parent] )* )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:167:4: head= nodeTemplateWithName[$parent] ( ',' tail= nodeTemplateWithName[$parent] )*
            {
            pushFollow(FOLLOW_nodeTemplateWithName_in_objectList371);
            head=nodeTemplateWithName(parent);

            state._fsp--;



            			new TripleExpression(parent, subjectTemplate, predicateTemplate, head);
            		

            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:169:5: ( ',' tail= nodeTemplateWithName[$parent] )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==25) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:169:7: ',' tail= nodeTemplateWithName[$parent]
            	    {
            	    match(input,25,FOLLOW_25_in_objectList378); 

            	    pushFollow(FOLLOW_nodeTemplateWithName_in_objectList382);
            	    tail=nodeTemplateWithName(parent);

            	    state._fsp--;



            	    			new TripleExpression(parent, subjectTemplate, predicateTemplate, tail);
            	    		

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "objectList"



    // $ANTLR start "conditionalBlock"
    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:174:1: conditionalBlock[Block parent] returns [] : 'IF' ifConditionalExpression= conditionalExpression[] block[ifTrueBlock, false] ( 'ELSIF' elsifConditionalExpression= conditionalExpression[] block[elsifTrueBlock, false] )* ( 'ELSE' block[elseBlock, false] )? ;
    public final void conditionalBlock(Block parent) throws RecognitionException {
        Condition ifConditionalExpression =null;

        Condition elsifConditionalExpression =null;


        try {
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:175:2: ( 'IF' ifConditionalExpression= conditionalExpression[] block[ifTrueBlock, false] ( 'ELSIF' elsifConditionalExpression= conditionalExpression[] block[elsifTrueBlock, false] )* ( 'ELSE' block[elseBlock, false] )? )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:175:4: 'IF' ifConditionalExpression= conditionalExpression[] block[ifTrueBlock, false] ( 'ELSIF' elsifConditionalExpression= conditionalExpression[] block[elsifTrueBlock, false] )* ( 'ELSE' block[elseBlock, false] )?
            {
            match(input,37,FOLLOW_37_in_conditionalBlock405); 

            pushFollow(FOLLOW_conditionalExpression_in_conditionalBlock409);
            ifConditionalExpression=conditionalExpression();

            state._fsp--;


             
            			final Block ifTrueBlock = new ConditionalBlock(parent, ifConditionalExpression);
            			final Block ifFalseBlock = new ConditionalBlock(parent, new NotCondition(ifConditionalExpression));
            		

            pushFollow(FOLLOW_block_in_conditionalBlock414);
            block(ifTrueBlock, false);

            state._fsp--;


             
            			Block elseBlock = ifFalseBlock;
            		

            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:180:5: ( 'ELSIF' elsifConditionalExpression= conditionalExpression[] block[elsifTrueBlock, false] )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==35) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:180:7: 'ELSIF' elsifConditionalExpression= conditionalExpression[] block[elsifTrueBlock, false]
            	    {
            	    match(input,35,FOLLOW_35_in_conditionalBlock421); 

            	    pushFollow(FOLLOW_conditionalExpression_in_conditionalBlock425);
            	    elsifConditionalExpression=conditionalExpression();

            	    state._fsp--;



            	    			final Block elsifTrueBlock = new ConditionalBlock(elseBlock, elsifConditionalExpression);
            	    			final Block elsifFalseBlock = new ConditionalBlock(elseBlock, new NotCondition(elsifConditionalExpression));
            	    		

            	    pushFollow(FOLLOW_block_in_conditionalBlock430);
            	    block(elsifTrueBlock, false);

            	    state._fsp--;



            	    			elseBlock = elsifFalseBlock;
            	    		

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:185:8: ( 'ELSE' block[elseBlock, false] )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==34) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:185:10: 'ELSE' block[elseBlock, false]
                    {
                    match(input,34,FOLLOW_34_in_conditionalBlock440); 

                    pushFollow(FOLLOW_block_in_conditionalBlock442);
                    block(elseBlock, false);

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "conditionalBlock"



    // $ANTLR start "conditionalExpression"
    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:188:1: conditionalExpression[] returns [Condition condition] : operand= conditionalOrExpression[] ;
    public final Condition conditionalExpression() throws RecognitionException {
        Condition condition = null;


        Condition operand =null;


        try {
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:189:2: (operand= conditionalOrExpression[] )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:189:4: operand= conditionalOrExpression[]
            {
            pushFollow(FOLLOW_conditionalOrExpression_in_conditionalExpression465);
            operand=conditionalOrExpression();

            state._fsp--;



            			condition = operand;
            		

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return condition;
    }
    // $ANTLR end "conditionalExpression"



    // $ANTLR start "conditionalOrExpression"
    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:194:1: conditionalOrExpression[] returns [Condition condition] : leftOperand= conditionalAndExpression[] ( '||' rightOperand= conditionalAndExpression[] )* ;
    public final Condition conditionalOrExpression() throws RecognitionException {
        Condition condition = null;


        Condition leftOperand =null;

        Condition rightOperand =null;


        try {
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:195:2: (leftOperand= conditionalAndExpression[] ( '||' rightOperand= conditionalAndExpression[] )* )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:195:4: leftOperand= conditionalAndExpression[] ( '||' rightOperand= conditionalAndExpression[] )*
            {
            pushFollow(FOLLOW_conditionalAndExpression_in_conditionalOrExpression487);
            leftOperand=conditionalAndExpression();

            state._fsp--;



            			Condition leftCondition = leftOperand, rightCondition = null;
            			
            			condition = leftCondition;
            		

            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:199:5: ( '||' rightOperand= conditionalAndExpression[] )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==51) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:199:7: '||' rightOperand= conditionalAndExpression[]
            	    {
            	    match(input,51,FOLLOW_51_in_conditionalOrExpression494); 

            	    pushFollow(FOLLOW_conditionalAndExpression_in_conditionalOrExpression498);
            	    rightOperand=conditionalAndExpression();

            	    state._fsp--;



            	    			rightCondition = rightOperand;
            	    		
            	    			condition = new OrCondition(leftCondition, rightCondition);
            	    			
            	    			leftCondition = condition;
            	    		

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return condition;
    }
    // $ANTLR end "conditionalOrExpression"



    // $ANTLR start "conditionalAndExpression"
    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:208:1: conditionalAndExpression[] returns [Condition condition] : leftOperand= conditionalNotExpression[] ( '&&' rightOperand= conditionalNotExpression[] )* ;
    public final Condition conditionalAndExpression() throws RecognitionException {
        Condition condition = null;


        Condition leftOperand =null;

        Condition rightOperand =null;


        try {
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:209:2: (leftOperand= conditionalNotExpression[] ( '&&' rightOperand= conditionalNotExpression[] )* )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:209:4: leftOperand= conditionalNotExpression[] ( '&&' rightOperand= conditionalNotExpression[] )*
            {
            pushFollow(FOLLOW_conditionalNotExpression_in_conditionalAndExpression523);
            leftOperand=conditionalNotExpression();

            state._fsp--;



            			Condition leftCondition = leftOperand, rightCondition = null;
            			
            			condition = leftCondition;
            		

            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:213:5: ( '&&' rightOperand= conditionalNotExpression[] )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==21) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:213:7: '&&' rightOperand= conditionalNotExpression[]
            	    {
            	    match(input,21,FOLLOW_21_in_conditionalAndExpression530); 

            	    pushFollow(FOLLOW_conditionalNotExpression_in_conditionalAndExpression534);
            	    rightOperand=conditionalNotExpression();

            	    state._fsp--;



            	    			rightCondition = rightOperand;
            	    			
            	    			condition = new AndCondition(leftCondition, rightCondition);
            	    			
            	    			leftCondition = condition;
            	    		

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return condition;
    }
    // $ANTLR end "conditionalAndExpression"



    // $ANTLR start "conditionalNotExpression"
    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:222:1: conditionalNotExpression[] returns [Condition condition] : ( '!' operand= conditionalAtom[] |operand= conditionalAtom[] );
    public final Condition conditionalNotExpression() throws RecognitionException {
        Condition condition = null;


        Condition operand =null;


        try {
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:223:2: ( '!' operand= conditionalAtom[] |operand= conditionalAtom[] )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==19) ) {
                alt13=1;
            }
            else if ( (LA13_0==20||LA13_0==22||LA13_0==47||LA13_0==49) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;

            }
            switch (alt13) {
                case 1 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:223:4: '!' operand= conditionalAtom[]
                    {
                    match(input,19,FOLLOW_19_in_conditionalNotExpression557); 

                    pushFollow(FOLLOW_conditionalAtom_in_conditionalNotExpression561);
                    operand=conditionalAtom();

                    state._fsp--;



                    			condition = new NotCondition(operand);
                    		

                    }
                    break;
                case 2 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:226:4: operand= conditionalAtom[]
                    {
                    pushFollow(FOLLOW_conditionalAtom_in_conditionalNotExpression572);
                    operand=conditionalAtom();

                    state._fsp--;



                    			condition = operand;
                    		

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return condition;
    }
    // $ANTLR end "conditionalNotExpression"



    // $ANTLR start "conditionalAtom"
    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:231:1: conditionalAtom[] returns [Condition condition] : (variable= interpolatedVariable[] | 'false' | 'true' | '(' operand= conditionalExpression[] ')' );
    public final Condition conditionalAtom() throws RecognitionException {
        Condition condition = null;


        MethodCallList variable =null;

        Condition operand =null;


        try {
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:232:2: (variable= interpolatedVariable[] | 'false' | 'true' | '(' operand= conditionalExpression[] ')' )
            int alt14=4;
            switch ( input.LA(1) ) {
            case 20:
                {
                alt14=1;
                }
                break;
            case 47:
                {
                alt14=2;
                }
                break;
            case 49:
                {
                alt14=3;
                }
                break;
            case 22:
                {
                alt14=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;

            }

            switch (alt14) {
                case 1 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:232:4: variable= interpolatedVariable[]
                    {
                    pushFollow(FOLLOW_interpolatedVariable_in_conditionalAtom594);
                    variable=interpolatedVariable();

                    state._fsp--;



                    			condition = new IsDefinedCondition(variable);
                    		

                    }
                    break;
                case 2 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:235:4: 'false'
                    {
                    match(input,47,FOLLOW_47_in_conditionalAtom602); 


                    			condition = Condition.FALSE;
                    		

                    }
                    break;
                case 3 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:238:4: 'true'
                    {
                    match(input,49,FOLLOW_49_in_conditionalAtom609); 


                    			condition = Condition.TRUE;
                    		

                    }
                    break;
                case 4 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:241:4: '(' operand= conditionalExpression[] ')'
                    {
                    match(input,22,FOLLOW_22_in_conditionalAtom616); 

                    pushFollow(FOLLOW_conditionalExpression_in_conditionalAtom620);
                    operand=conditionalExpression();

                    state._fsp--;


                    match(input,23,FOLLOW_23_in_conditionalAtom623); 


                    			condition = operand;
                    		

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return condition;
    }
    // $ANTLR end "conditionalAtom"



    // $ANTLR start "foreachBlock"
    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:246:1: foreachBlock[Block parent] returns [] : 'FOREACH' variable= interpolatedVariable[] block[foreachBlock, false] ;
    public final void foreachBlock(Block parent) throws RecognitionException {
        MethodCallList variable =null;


        try {
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:247:2: ( 'FOREACH' variable= interpolatedVariable[] block[foreachBlock, false] )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:247:4: 'FOREACH' variable= interpolatedVariable[] block[foreachBlock, false]
            {
            match(input,36,FOLLOW_36_in_foreachBlock642); 

            pushFollow(FOLLOW_interpolatedVariable_in_foreachBlock646);
            variable=interpolatedVariable();

            state._fsp--;



            			final Block foreachBlock = new ForeachBlock(parent, variable);
            		

            pushFollow(FOLLOW_block_in_foreachBlock651);
            block(foreachBlock, false);

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "foreachBlock"



    // $ANTLR start "matchBlock"
    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:252:1: matchBlock[Block parent] returns [] : 'MATCH' pattern= interpolatedVariableOrString[] 'IN' target= interpolatedVariableOrString[] block[matchBlock, false] ;
    public final void matchBlock(Block parent) throws RecognitionException {
        Template<?> pattern =null;

        Template<?> target =null;


        try {
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:253:2: ( 'MATCH' pattern= interpolatedVariableOrString[] 'IN' target= interpolatedVariableOrString[] block[matchBlock, false] )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:253:4: 'MATCH' pattern= interpolatedVariableOrString[] 'IN' target= interpolatedVariableOrString[] block[matchBlock, false]
            {
            match(input,39,FOLLOW_39_in_matchBlock669); 

            pushFollow(FOLLOW_interpolatedVariableOrString_in_matchBlock673);
            pattern=interpolatedVariableOrString();

            state._fsp--;


            match(input,38,FOLLOW_38_in_matchBlock676); 

            pushFollow(FOLLOW_interpolatedVariableOrString_in_matchBlock680);
            target=interpolatedVariableOrString();

            state._fsp--;



            			final Block matchBlock = new MatchBlock(parent, pattern, target);
            		

            pushFollow(FOLLOW_block_in_matchBlock685);
            block(matchBlock, false);

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "matchBlock"



    // $ANTLR start "block"
    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:258:1: block[Block parent, boolean createNewBlock] returns [] : '{' prelude[newBlock] ( expression[newBlock] )* '}' ;
    public final void block(Block parent, boolean createNewBlock) throws RecognitionException {

        	final Block newBlock = createNewBlock ? new Block(parent) : parent;

        try {
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:262:2: ( '{' prelude[newBlock] ( expression[newBlock] )* '}' )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:262:4: '{' prelude[newBlock] ( expression[newBlock] )* '}'
            {
            match(input,50,FOLLOW_50_in_block707); 

            pushFollow(FOLLOW_prelude_in_block709);
            prelude(newBlock);

            state._fsp--;


            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:262:26: ( expression[newBlock] )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==NODE_NAME||LA15_0==PREFIX_NAME||LA15_0==URI||LA15_0==22||(LA15_0 >= 36 && LA15_0 <= 37)||LA15_0==39||LA15_0==41||LA15_0==45||LA15_0==50) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:262:28: expression[newBlock]
            	    {
            	    pushFollow(FOLLOW_expression_in_block714);
            	    expression(newBlock);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            match(input,52,FOLLOW_52_in_block720); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "block"



    // $ANTLR start "nodeTemplateWithName"
    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:265:1: nodeTemplateWithName[Block parent] returns [Template<Node> template] : node= nodeTemplate[$parent] ( 'AS' nodeName= NODE_NAME )? ;
    public final Template<Node> nodeTemplateWithName(Block parent) throws RecognitionException {
        Template<Node> template = null;


        Token nodeName=null;
        Template<Node> node =null;


        try {
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:266:2: (node= nodeTemplate[$parent] ( 'AS' nodeName= NODE_NAME )? )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:266:4: node= nodeTemplate[$parent] ( 'AS' nodeName= NODE_NAME )?
            {
            pushFollow(FOLLOW_nodeTemplate_in_nodeTemplateWithName738);
            node=nodeTemplate(parent);

            state._fsp--;



            			template = node;
            		

            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:268:5: ( 'AS' nodeName= NODE_NAME )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==31) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:268:7: 'AS' nodeName= NODE_NAME
                    {
                    match(input,31,FOLLOW_31_in_nodeTemplateWithName745); 

                    nodeName=(Token)match(input,NODE_NAME,FOLLOW_NODE_NAME_in_nodeTemplateWithName749); 


                    			new NamedNodeDeclaration(parent, Template.toTemplate((nodeName!=null?nodeName.getText():null)), template);
                    		

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return template;
    }
    // $ANTLR end "nodeTemplateWithName"



    // $ANTLR start "nodeTemplate"
    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:273:1: nodeTemplate[Block parent] returns [Template<Node> template] : (resourceNode= resourceNodeTemplate[$parent] |literalNode= literalNodeTemplate[$parent] );
    public final Template<Node> nodeTemplate(Block parent) throws RecognitionException {
        Template<Node> template = null;


        Template<Node> resourceNode =null;

        Template<Node> literalNode =null;


        try {
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:274:2: (resourceNode= resourceNodeTemplate[$parent] |literalNode= literalNodeTemplate[$parent] )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==NODE_NAME||LA17_0==PREFIX_NAME||LA17_0==URI||LA17_0==22||LA17_0==41||LA17_0==45) ) {
                alt17=1;
            }
            else if ( (LA17_0==FLOAT||LA17_0==INT||LA17_0==STRING||LA17_0==20||LA17_0==24||LA17_0==26||(LA17_0 >= 47 && LA17_0 <= 49)) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;

            }
            switch (alt17) {
                case 1 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:274:4: resourceNode= resourceNodeTemplate[$parent]
                    {
                    pushFollow(FOLLOW_resourceNodeTemplate_in_nodeTemplate772);
                    resourceNode=resourceNodeTemplate(parent);

                    state._fsp--;



                    			template = resourceNode;
                    		

                    }
                    break;
                case 2 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:277:4: literalNode= literalNodeTemplate[$parent]
                    {
                    pushFollow(FOLLOW_literalNodeTemplate_in_nodeTemplate782);
                    literalNode=literalNodeTemplate(parent);

                    state._fsp--;



                    			template = literalNode;
                    		

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return template;
    }
    // $ANTLR end "nodeTemplate"



    // $ANTLR start "resourceNodeTemplateWithName"
    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:282:1: resourceNodeTemplateWithName[Block parent] returns [Template<Node> template] : resourceNode= resourceNodeTemplate[$parent] ( 'AS' nodeName= NODE_NAME )? ;
    public final Template<Node> resourceNodeTemplateWithName(Block parent) throws RecognitionException {
        Template<Node> template = null;


        Token nodeName=null;
        Template<Node> resourceNode =null;


        try {
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:283:2: (resourceNode= resourceNodeTemplate[$parent] ( 'AS' nodeName= NODE_NAME )? )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:283:4: resourceNode= resourceNodeTemplate[$parent] ( 'AS' nodeName= NODE_NAME )?
            {
            pushFollow(FOLLOW_resourceNodeTemplate_in_resourceNodeTemplateWithName804);
            resourceNode=resourceNodeTemplate(parent);

            state._fsp--;



            			template = resourceNode;
            		

            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:285:5: ( 'AS' nodeName= NODE_NAME )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==31) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:285:7: 'AS' nodeName= NODE_NAME
                    {
                    match(input,31,FOLLOW_31_in_resourceNodeTemplateWithName811); 

                    nodeName=(Token)match(input,NODE_NAME,FOLLOW_NODE_NAME_in_resourceNodeTemplateWithName815); 


                    			new NamedNodeDeclaration(parent, Template.toTemplate((nodeName!=null?nodeName.getText():null)), template);
                    		

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return template;
    }
    // $ANTLR end "resourceNodeTemplateWithName"



    // $ANTLR start "resourceNodeTemplate"
    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:290:1: resourceNodeTemplate[Block parent] returns [Template<Node> template] : (uriNode= uriNodeTemplate[$parent] |anonNode= anonNodeTemplate[$parent] );
    public final Template<Node> resourceNodeTemplate(Block parent) throws RecognitionException {
        Template<Node> template = null;


        Template<Node> uriNode =null;

        Template<Node> anonNode =null;


        try {
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:291:2: (uriNode= uriNodeTemplate[$parent] |anonNode= anonNodeTemplate[$parent] )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==NODE_NAME||LA19_0==PREFIX_NAME||LA19_0==URI) ) {
                alt19=1;
            }
            else if ( (LA19_0==22||LA19_0==41||LA19_0==45) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;

            }
            switch (alt19) {
                case 1 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:291:4: uriNode= uriNodeTemplate[$parent]
                    {
                    pushFollow(FOLLOW_uriNodeTemplate_in_resourceNodeTemplate838);
                    uriNode=uriNodeTemplate(parent);

                    state._fsp--;



                    			template = uriNode;
                    		

                    }
                    break;
                case 2 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:294:4: anonNode= anonNodeTemplate[$parent]
                    {
                    pushFollow(FOLLOW_anonNodeTemplate_in_resourceNodeTemplate848);
                    anonNode=anonNodeTemplate(parent);

                    state._fsp--;



                    			template = anonNode;
                    		

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return template;
    }
    // $ANTLR end "resourceNodeTemplate"



    // $ANTLR start "uriNodeTemplateWithName"
    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:299:1: uriNodeTemplateWithName[Block parent] returns [Template<Node> template] : uriNode= uriNodeTemplate[$parent] ( 'AS' nodeName= NODE_NAME )? ;
    public final Template<Node> uriNodeTemplateWithName(Block parent) throws RecognitionException {
        Template<Node> template = null;


        Token nodeName=null;
        Template<Node> uriNode =null;


        try {
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:300:2: (uriNode= uriNodeTemplate[$parent] ( 'AS' nodeName= NODE_NAME )? )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:300:4: uriNode= uriNodeTemplate[$parent] ( 'AS' nodeName= NODE_NAME )?
            {
            pushFollow(FOLLOW_uriNodeTemplate_in_uriNodeTemplateWithName870);
            uriNode=uriNodeTemplate(parent);

            state._fsp--;



            			template = uriNode;
            		

            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:302:5: ( 'AS' nodeName= NODE_NAME )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==31) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:302:7: 'AS' nodeName= NODE_NAME
                    {
                    match(input,31,FOLLOW_31_in_uriNodeTemplateWithName877); 

                    nodeName=(Token)match(input,NODE_NAME,FOLLOW_NODE_NAME_in_uriNodeTemplateWithName881); 


                    			new NamedNodeDeclaration(parent, Template.toTemplate((nodeName!=null?nodeName.getText():null)), template);
                    		

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return template;
    }
    // $ANTLR end "uriNodeTemplateWithName"



    // $ANTLR start "uriNodeTemplate"
    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:307:1: uriNodeTemplate[Block parent] returns [Template<Node> template] : (uri= URI |namespacePrefix= PREFIX_NAME (localName= ID |localNameTemplate= interpolatedVariableOrString[] ) |nodeName= NODE_NAME );
    public final Template<Node> uriNodeTemplate(Block parent) throws RecognitionException {
        Template<Node> template = null;


        Token uri=null;
        Token namespacePrefix=null;
        Token localName=null;
        Token nodeName=null;
        Template<?> localNameTemplate =null;


        try {
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:308:2: (uri= URI |namespacePrefix= PREFIX_NAME (localName= ID |localNameTemplate= interpolatedVariableOrString[] ) |nodeName= NODE_NAME )
            int alt22=3;
            switch ( input.LA(1) ) {
            case URI:
                {
                alt22=1;
                }
                break;
            case PREFIX_NAME:
                {
                alt22=2;
                }
                break;
            case NODE_NAME:
                {
                alt22=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;

            }

            switch (alt22) {
                case 1 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:308:4: uri= URI
                    {
                    uri=(Token)match(input,URI,FOLLOW_URI_in_uriNodeTemplate905); 


                    			template = new URINodeTemplate(new InterpolatedStringTemplate(Template.toTemplate((uri!=null?uri.getText():null))));
                    		

                    }
                    break;
                case 2 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:311:4: namespacePrefix= PREFIX_NAME (localName= ID |localNameTemplate= interpolatedVariableOrString[] )
                    {
                    namespacePrefix=(Token)match(input,PREFIX_NAME,FOLLOW_PREFIX_NAME_in_uriNodeTemplate914); 

                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:311:32: (localName= ID |localNameTemplate= interpolatedVariableOrString[] )
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==ID) ) {
                        alt21=1;
                    }
                    else if ( (LA21_0==STRING||LA21_0==20) ) {
                        alt21=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 21, 0, input);

                        throw nvae;

                    }
                    switch (alt21) {
                        case 1 :
                            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:311:34: localName= ID
                            {
                            localName=(Token)match(input,ID,FOLLOW_ID_in_uriNodeTemplate920); 


                            			template = new PrefixedNameNodeTemplate(Template.toTemplate((namespacePrefix!=null?namespacePrefix.getText():null)), Template.toTemplate((localName!=null?localName.getText():null)));
                            		

                            }
                            break;
                        case 2 :
                            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:313:7: localNameTemplate= interpolatedVariableOrString[]
                            {
                            pushFollow(FOLLOW_interpolatedVariableOrString_in_uriNodeTemplate928);
                            localNameTemplate=interpolatedVariableOrString();

                            state._fsp--;



                            			template = new PrefixedNameNodeTemplate(Template.toTemplate((namespacePrefix!=null?namespacePrefix.getText():null)), localNameTemplate);
                            		

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:316:4: nodeName= NODE_NAME
                    {
                    nodeName=(Token)match(input,NODE_NAME,FOLLOW_NODE_NAME_in_uriNodeTemplate940); 


                    			template = new NamedNodeTemplate(Template.toTemplate((nodeName!=null?nodeName.getText():null)));
                    		

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return template;
    }
    // $ANTLR end "uriNodeTemplate"



    // $ANTLR start "anonNodeTemplate"
    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:321:1: anonNodeTemplate[Block parent] returns [Template<Node> template] : ( '_:' anonId= ID | '[' ( predicateList[$parent, $template] )? ']' | '(' (nextTemplate= nodeTemplateWithName[$parent] )* ')' );
    public final Template<Node> anonNodeTemplate(Block parent) throws RecognitionException {
        Template<Node> template = null;


        Token anonId=null;
        Template<Node> nextTemplate =null;


        try {
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:322:2: ( '_:' anonId= ID | '[' ( predicateList[$parent, $template] )? ']' | '(' (nextTemplate= nodeTemplateWithName[$parent] )* ')' )
            int alt25=3;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt25=1;
                }
                break;
            case 41:
                {
                alt25=2;
                }
                break;
            case 22:
                {
                alt25=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;

            }

            switch (alt25) {
                case 1 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:322:4: '_:' anonId= ID
                    {
                    match(input,45,FOLLOW_45_in_anonNodeTemplate959); 

                    anonId=(Token)match(input,ID,FOLLOW_ID_in_anonNodeTemplate963); 


                    			template = new AnonNodeTemplate(Template.toTemplate((anonId!=null?anonId.getText():null)));
                    		

                    }
                    break;
                case 2 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:325:4: '[' ( predicateList[$parent, $template] )? ']'
                    {
                    match(input,41,FOLLOW_41_in_anonNodeTemplate970); 


                    			template = new AnonNodeTemplate();
                    		

                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:327:5: ( predicateList[$parent, $template] )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==NODE_NAME||LA23_0==PREFIX_NAME||LA23_0==URI||LA23_0==29||LA23_0==46) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:327:7: predicateList[$parent, $template]
                            {
                            pushFollow(FOLLOW_predicateList_in_anonNodeTemplate976);
                            predicateList(parent, template);

                            state._fsp--;


                            }
                            break;

                    }


                    match(input,43,FOLLOW_43_in_anonNodeTemplate982); 

                    }
                    break;
                case 3 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:328:4: '(' (nextTemplate= nodeTemplateWithName[$parent] )* ')'
                    {
                    match(input,22,FOLLOW_22_in_anonNodeTemplate987); 


                    			final List<Template<Node>> templates = new LinkedList<Template<Node>>();
                    		

                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:330:5: (nextTemplate= nodeTemplateWithName[$parent] )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==FLOAT||LA24_0==INT||LA24_0==NODE_NAME||(LA24_0 >= PREFIX_NAME && LA24_0 <= STRING)||LA24_0==URI||LA24_0==20||LA24_0==22||LA24_0==24||LA24_0==26||LA24_0==41||LA24_0==45||(LA24_0 >= 47 && LA24_0 <= 49)) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:330:7: nextTemplate= nodeTemplateWithName[$parent]
                    	    {
                    	    pushFollow(FOLLOW_nodeTemplateWithName_in_anonNodeTemplate995);
                    	    nextTemplate=nodeTemplateWithName(parent);

                    	    state._fsp--;



                    	    			templates.add(nextTemplate);
                    	    		

                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);


                    match(input,23,FOLLOW_23_in_anonNodeTemplate1003); 


                    			if (templates.isEmpty()) {
                    				template = RDF_nil;
                    			} else {
                    				Template<Node> firstListTemplate = null, currentListTemplate = null;
                    				
                    				for (final Iterator<Template<Node>> iterator = templates.iterator(); iterator.hasNext(); ) {
                    					final Template<Node> nextIteratorTemplate = iterator.next(), nextListTemplate = new AnonNodeTemplate();
                    					
                    					if (firstListTemplate == null) {
                    						firstListTemplate = nextListTemplate;
                    					}
                    					
                    					new TripleExpression(parent, nextListTemplate, RDF_type, RDF_List);
                    					
                    					new TripleExpression(parent, nextListTemplate, RDF_first, nextIteratorTemplate);
                    					
                    					if (!iterator.hasNext()) {
                    						new TripleExpression(parent, nextListTemplate, RDF_rest, RDF_nil);
                    					}
                    					
                    					if (currentListTemplate != null) {
                    						new TripleExpression(parent, currentListTemplate, RDF_rest, nextListTemplate);
                    					}
                    					
                    					currentListTemplate = nextListTemplate;
                    				}
                    				
                    				template = firstListTemplate;
                    			}
                    		

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return template;
    }
    // $ANTLR end "anonNodeTemplate"



    // $ANTLR start "literalNodeTemplate"
    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:365:1: literalNodeTemplate[Block parent] returns [Template<Node> template] : (value= interpolatedVariableOrString[] ( (languageAsString= LANG_TAG | '@' languageAsTemplate= interpolatedVariableOrString[] ) | '^^' datatype= resourceNodeTemplate[$parent] )? |sign= positiveOrNegative[] INT |sign= positiveOrNegative[] FLOAT | 'false' | 'true' | 'now' );
    public final Template<Node> literalNodeTemplate(Block parent) throws RecognitionException {
        Template<Node> template = null;


        Token languageAsString=null;
        Token INT1=null;
        Token FLOAT2=null;
        Template<?> value =null;

        Template<?> languageAsTemplate =null;

        Template<Node> datatype =null;

        String sign =null;


        try {
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:366:2: (value= interpolatedVariableOrString[] ( (languageAsString= LANG_TAG | '@' languageAsTemplate= interpolatedVariableOrString[] ) | '^^' datatype= resourceNodeTemplate[$parent] )? |sign= positiveOrNegative[] INT |sign= positiveOrNegative[] FLOAT | 'false' | 'true' | 'now' )
            int alt28=6;
            alt28 = dfa28.predict(input);
            switch (alt28) {
                case 1 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:366:4: value= interpolatedVariableOrString[] ( (languageAsString= LANG_TAG | '@' languageAsTemplate= interpolatedVariableOrString[] ) | '^^' datatype= resourceNodeTemplate[$parent] )?
                    {
                     
                    			Template<?> valueTemplate = null, languageTemplate = null; 
                    			Template<Node> datatypeTemplate = null;
                    		

                    pushFollow(FOLLOW_interpolatedVariableOrString_in_literalNodeTemplate1026);
                    value=interpolatedVariableOrString();

                    state._fsp--;



                    			valueTemplate = value;
                    		

                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:371:5: ( (languageAsString= LANG_TAG | '@' languageAsTemplate= interpolatedVariableOrString[] ) | '^^' datatype= resourceNodeTemplate[$parent] )?
                    int alt27=3;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==LANG_TAG||LA27_0==30) ) {
                        alt27=1;
                    }
                    else if ( (LA27_0==44) ) {
                        alt27=2;
                    }
                    switch (alt27) {
                        case 1 :
                            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:371:7: (languageAsString= LANG_TAG | '@' languageAsTemplate= interpolatedVariableOrString[] )
                            {
                            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:371:7: (languageAsString= LANG_TAG | '@' languageAsTemplate= interpolatedVariableOrString[] )
                            int alt26=2;
                            int LA26_0 = input.LA(1);

                            if ( (LA26_0==LANG_TAG) ) {
                                alt26=1;
                            }
                            else if ( (LA26_0==30) ) {
                                alt26=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 26, 0, input);

                                throw nvae;

                            }
                            switch (alt26) {
                                case 1 :
                                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:371:9: languageAsString= LANG_TAG
                                    {
                                    languageAsString=(Token)match(input,LANG_TAG,FOLLOW_LANG_TAG_in_literalNodeTemplate1037); 


                                    			languageTemplate = Template.toTemplate((languageAsString!=null?languageAsString.getText():null));
                                    		

                                    }
                                    break;
                                case 2 :
                                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:373:7: '@' languageAsTemplate= interpolatedVariableOrString[]
                                    {
                                    match(input,30,FOLLOW_30_in_literalNodeTemplate1043); 

                                    pushFollow(FOLLOW_interpolatedVariableOrString_in_literalNodeTemplate1047);
                                    languageAsTemplate=interpolatedVariableOrString();

                                    state._fsp--;



                                    			languageTemplate = languageAsTemplate;
                                    		

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:375:9: '^^' datatype= resourceNodeTemplate[$parent]
                            {
                            match(input,44,FOLLOW_44_in_literalNodeTemplate1056); 

                            pushFollow(FOLLOW_resourceNodeTemplate_in_literalNodeTemplate1060);
                            datatype=resourceNodeTemplate(parent);

                            state._fsp--;



                            			datatypeTemplate = datatype;
                            		

                            }
                            break;

                    }



                    			if (languageTemplate != null) {
                    				template = new PlainLiteralNodeTemplate(valueTemplate, languageTemplate);
                    			} else if (datatypeTemplate != null) {
                    				template = new TypedLiteralNodeTemplate(valueTemplate, datatypeTemplate);
                    			} else {
                    				template = new TypedLiteralNodeTemplate(valueTemplate);
                    			}
                    		

                    }
                    break;
                case 2 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:386:4: sign= positiveOrNegative[] INT
                    {
                    pushFollow(FOLLOW_positiveOrNegative_in_literalNodeTemplate1075);
                    sign=positiveOrNegative();

                    state._fsp--;


                    INT1=(Token)match(input,INT,FOLLOW_INT_in_literalNodeTemplate1078); 


                    			try {
                    				template = new TypedLiteralNodeTemplate(Template.toTemplate(Integer.parseInt(StringUtils.concat(sign, (INT1!=null?INT1.getText():null)))));
                    			} catch (final Exception e) { 
                    				// Do nothing...
                    			}
                    		

                    }
                    break;
                case 3 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:393:4: sign= positiveOrNegative[] FLOAT
                    {
                    pushFollow(FOLLOW_positiveOrNegative_in_literalNodeTemplate1087);
                    sign=positiveOrNegative();

                    state._fsp--;


                    FLOAT2=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_literalNodeTemplate1090); 


                    			try {
                    				template = new TypedLiteralNodeTemplate(Template.toTemplate(Float.parseFloat(StringUtils.concat(sign, (FLOAT2!=null?FLOAT2.getText():null)))));
                    			} catch (final Exception e) { 
                    				// Do nothing...
                    			}
                    		

                    }
                    break;
                case 4 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:400:4: 'false'
                    {
                    match(input,47,FOLLOW_47_in_literalNodeTemplate1097); 


                    			template = new TypedLiteralNodeTemplate(Template.toTemplate(Boolean.FALSE));
                    		

                    }
                    break;
                case 5 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:403:4: 'true'
                    {
                    match(input,49,FOLLOW_49_in_literalNodeTemplate1104); 


                    			template = new TypedLiteralNodeTemplate(Template.toTemplate(Boolean.TRUE));
                    		

                    }
                    break;
                case 6 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:406:4: 'now'
                    {
                    match(input,48,FOLLOW_48_in_literalNodeTemplate1111); 


                    			template = new CurrentTimeNodeTemplate();
                    		

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return template;
    }
    // $ANTLR end "literalNodeTemplate"



    // $ANTLR start "interpolatedVariableOrString"
    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:411:1: interpolatedVariableOrString[] returns [Template<?> template] : (variable= interpolatedVariable[] | STRING );
    public final Template<?> interpolatedVariableOrString() throws RecognitionException {
        Template<?> template = null;


        Token STRING3=null;
        MethodCallList variable =null;


        try {
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:412:2: (variable= interpolatedVariable[] | STRING )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==20) ) {
                alt29=1;
            }
            else if ( (LA29_0==STRING) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;

            }
            switch (alt29) {
                case 1 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:412:4: variable= interpolatedVariable[]
                    {
                    pushFollow(FOLLOW_interpolatedVariable_in_interpolatedVariableOrString1132);
                    variable=interpolatedVariable();

                    state._fsp--;


                     
                    			template = variable;
                    		

                    }
                    break;
                case 2 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:415:4: STRING
                    {
                    STRING3=(Token)match(input,STRING,FOLLOW_STRING_in_interpolatedVariableOrString1140); 

                     
                    			template = new InterpolatedStringTemplate(Template.toTemplate((STRING3!=null?STRING3.getText():null))); 
                    		

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return template;
    }
    // $ANTLR end "interpolatedVariableOrString"



    // $ANTLR start "interpolatedVariable"
    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:420:1: interpolatedVariable[] returns [MethodCallList template] : '${' (head= methodCall[] ( '/' tail= methodCall[] )* )? '}' ;
    public final MethodCallList interpolatedVariable() throws RecognitionException {
        MethodCallList template = null;


        MethodCall head =null;

        MethodCall tail =null;



        	template = new MethodCallList();

        try {
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:424:2: ( '${' (head= methodCall[] ( '/' tail= methodCall[] )* )? '}' )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:424:4: '${' (head= methodCall[] ( '/' tail= methodCall[] )* )? '}'
            {
            match(input,20,FOLLOW_20_in_interpolatedVariable1164); 

            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:424:9: (head= methodCall[] ( '/' tail= methodCall[] )* )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==FLOAT||(LA31_0 >= ID && LA31_0 <= INT)||LA31_0==STRING||LA31_0==24||LA31_0==26||(LA31_0 >= 46 && LA31_0 <= 49)) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:424:11: head= methodCall[] ( '/' tail= methodCall[] )*
                    {
                    pushFollow(FOLLOW_methodCall_in_interpolatedVariable1170);
                    head=methodCall();

                    state._fsp--;



                    			template.add(head);
                    		

                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:426:5: ( '/' tail= methodCall[] )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==27) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:426:7: '/' tail= methodCall[]
                    	    {
                    	    match(input,27,FOLLOW_27_in_interpolatedVariable1177); 

                    	    pushFollow(FOLLOW_methodCall_in_interpolatedVariable1181);
                    	    tail=methodCall();

                    	    state._fsp--;



                    	    			template.add(tail);
                    	    		

                    	    }
                    	    break;

                    	default :
                    	    break loop30;
                        }
                    } while (true);


                    }
                    break;

            }


            match(input,52,FOLLOW_52_in_interpolatedVariable1192); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return template;
    }
    // $ANTLR end "interpolatedVariable"



    // $ANTLR start "methodCall"
    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:431:1: methodCall[] returns [MethodCall template] : (methodName= methodCallName[] ( '(' (head= methodCallArgument[] ( ',' tail= methodCallArgument[] )* )? ')' )? | STRING |sign= positiveOrNegative[] INT );
    public final MethodCall methodCall() throws RecognitionException {
        MethodCall template = null;


        Token STRING4=null;
        Token INT5=null;
        String methodName =null;

        Object head =null;

        Object tail =null;

        String sign =null;


        try {
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:432:2: (methodName= methodCallName[] ( '(' (head= methodCallArgument[] ( ',' tail= methodCallArgument[] )* )? ')' )? | STRING |sign= positiveOrNegative[] INT )
            int alt35=3;
            switch ( input.LA(1) ) {
            case ID:
            case 46:
            case 47:
            case 48:
            case 49:
                {
                alt35=1;
                }
                break;
            case STRING:
                {
                alt35=2;
                }
                break;
            case FLOAT:
            case INT:
            case 24:
            case 26:
                {
                alt35=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;

            }

            switch (alt35) {
                case 1 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:432:4: methodName= methodCallName[] ( '(' (head= methodCallArgument[] ( ',' tail= methodCallArgument[] )* )? ')' )?
                    {
                    pushFollow(FOLLOW_methodCallName_in_methodCall1211);
                    methodName=methodCallName();

                    state._fsp--;



                    			template = new MethodCall(ChildMethod.getMethodName(), new Object[] { methodName }); 
                    		

                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:434:5: ( '(' (head= methodCallArgument[] ( ',' tail= methodCallArgument[] )* )? ')' )?
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==22) ) {
                        alt34=1;
                    }
                    switch (alt34) {
                        case 1 :
                            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:434:7: '(' (head= methodCallArgument[] ( ',' tail= methodCallArgument[] )* )? ')'
                            {
                            match(input,22,FOLLOW_22_in_methodCall1218); 


                            			final List<Object> arguments = new LinkedList<Object>();
                            		

                            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:436:5: (head= methodCallArgument[] ( ',' tail= methodCallArgument[] )* )?
                            int alt33=2;
                            int LA33_0 = input.LA(1);

                            if ( (LA33_0==FLOAT||LA33_0==INT||LA33_0==STRING||LA33_0==24||LA33_0==26||LA33_0==47||LA33_0==49) ) {
                                alt33=1;
                            }
                            switch (alt33) {
                                case 1 :
                                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:436:7: head= methodCallArgument[] ( ',' tail= methodCallArgument[] )*
                                    {
                                    pushFollow(FOLLOW_methodCallArgument_in_methodCall1226);
                                    head=methodCallArgument();

                                    state._fsp--;


                                     
                                    			arguments.add(head);
                                    		

                                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:438:5: ( ',' tail= methodCallArgument[] )*
                                    loop32:
                                    do {
                                        int alt32=2;
                                        int LA32_0 = input.LA(1);

                                        if ( (LA32_0==25) ) {
                                            alt32=1;
                                        }


                                        switch (alt32) {
                                    	case 1 :
                                    	    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:438:7: ',' tail= methodCallArgument[]
                                    	    {
                                    	    match(input,25,FOLLOW_25_in_methodCall1233); 

                                    	    pushFollow(FOLLOW_methodCallArgument_in_methodCall1237);
                                    	    tail=methodCallArgument();

                                    	    state._fsp--;


                                    	     
                                    	    			arguments.add(tail);
                                    	    		

                                    	    }
                                    	    break;

                                    	default :
                                    	    break loop32;
                                        }
                                    } while (true);


                                    }
                                    break;

                            }


                            match(input,23,FOLLOW_23_in_methodCall1248); 


                            			template = new MethodCall(methodName, arguments.toArray(new Object[arguments.size()]));
                            		

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:443:4: STRING
                    {
                    STRING4=(Token)match(input,STRING,FOLLOW_STRING_in_methodCall1258); 

                     
                    			template = new MethodCall(ChildMethod.getMethodName(), new Object[] { (STRING4!=null?STRING4.getText():null) }); 
                    		

                    }
                    break;
                case 3 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:446:4: sign= positiveOrNegative[] INT
                    {
                    pushFollow(FOLLOW_positiveOrNegative_in_methodCall1267);
                    sign=positiveOrNegative();

                    state._fsp--;


                    INT5=(Token)match(input,INT,FOLLOW_INT_in_methodCall1270); 

                     
                    			try {
                    				template = new MethodCall(ChildMethod.getMethodName(), new Object[] { Integer.parseInt(StringUtils.concat(sign, (INT5!=null?INT5.getText():null))) }); 
                    			} catch (final Exception e) {
                    				// Do nothing...
                    			}
                    		

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return template;
    }
    // $ANTLR end "methodCall"



    // $ANTLR start "methodCallName"
    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:455:1: methodCallName[] returns [String string] : ( ID | 'a' | 'false' | 'true' | 'now' );
    public final String methodCallName() throws RecognitionException {
        String string = null;


        Token ID6=null;

        try {
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:456:2: ( ID | 'a' | 'false' | 'true' | 'now' )
            int alt36=5;
            switch ( input.LA(1) ) {
            case ID:
                {
                alt36=1;
                }
                break;
            case 46:
                {
                alt36=2;
                }
                break;
            case 47:
                {
                alt36=3;
                }
                break;
            case 49:
                {
                alt36=4;
                }
                break;
            case 48:
                {
                alt36=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;

            }

            switch (alt36) {
                case 1 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:456:4: ID
                    {
                    ID6=(Token)match(input,ID,FOLLOW_ID_in_methodCallName1289); 


                    			string = (ID6!=null?ID6.getText():null);
                    		

                    }
                    break;
                case 2 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:459:4: 'a'
                    {
                    match(input,46,FOLLOW_46_in_methodCallName1296); 


                    			string = "a";
                    		

                    }
                    break;
                case 3 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:462:4: 'false'
                    {
                    match(input,47,FOLLOW_47_in_methodCallName1303); 


                    			string = "false";
                    		

                    }
                    break;
                case 4 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:465:4: 'true'
                    {
                    match(input,49,FOLLOW_49_in_methodCallName1310); 


                    			string = "true";
                    		

                    }
                    break;
                case 5 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:468:4: 'now'
                    {
                    match(input,48,FOLLOW_48_in_methodCallName1317); 


                    			string = "now";
                    		

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return string;
    }
    // $ANTLR end "methodCallName"



    // $ANTLR start "methodCallArgument"
    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:473:1: methodCallArgument[] returns [Object argument] : ( STRING |sign= positiveOrNegative[] INT |sign= positiveOrNegative[] FLOAT | 'false' | 'true' );
    public final Object methodCallArgument() throws RecognitionException {
        Object argument = null;


        Token STRING7=null;
        Token INT8=null;
        Token FLOAT9=null;
        String sign =null;


        try {
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:474:2: ( STRING |sign= positiveOrNegative[] INT |sign= positiveOrNegative[] FLOAT | 'false' | 'true' )
            int alt37=5;
            alt37 = dfa37.predict(input);
            switch (alt37) {
                case 1 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:474:4: STRING
                    {
                    STRING7=(Token)match(input,STRING,FOLLOW_STRING_in_methodCallArgument1336); 

                     
                    			argument = (STRING7!=null?STRING7.getText():null); 
                    		

                    }
                    break;
                case 2 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:477:4: sign= positiveOrNegative[] INT
                    {
                    pushFollow(FOLLOW_positiveOrNegative_in_methodCallArgument1345);
                    sign=positiveOrNegative();

                    state._fsp--;


                    INT8=(Token)match(input,INT,FOLLOW_INT_in_methodCallArgument1348); 

                     
                    			try {
                    				argument = Integer.parseInt(StringUtils.concat(sign, (INT8!=null?INT8.getText():null)));
                    			} catch (final Exception e) {
                    				// Do nothing...
                    			}
                    		

                    }
                    break;
                case 3 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:484:4: sign= positiveOrNegative[] FLOAT
                    {
                    pushFollow(FOLLOW_positiveOrNegative_in_methodCallArgument1357);
                    sign=positiveOrNegative();

                    state._fsp--;


                    FLOAT9=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_methodCallArgument1360); 


                    			try {
                    				argument = Float.parseFloat(StringUtils.concat(sign, (FLOAT9!=null?FLOAT9.getText():null)));
                    			} catch (final Exception e) {
                    				// Do nothing...
                    			}
                    		

                    }
                    break;
                case 4 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:491:4: 'false'
                    {
                    match(input,47,FOLLOW_47_in_methodCallArgument1367); 

                     
                    			argument = Boolean.FALSE; 
                    		

                    }
                    break;
                case 5 :
                    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:494:4: 'true'
                    {
                    match(input,49,FOLLOW_49_in_methodCallArgument1374); 

                     
                    			argument = Boolean.TRUE; 
                    		

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return argument;
    }
    // $ANTLR end "methodCallArgument"



    // $ANTLR start "positiveOrNegative"
    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:499:1: positiveOrNegative[] returns [String value] : ( '+' | '-' )* ;
    public final String positiveOrNegative() throws RecognitionException {
        String value = null;



        	final StringBuilder sb = new StringBuilder();

        try {
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:506:2: ( ( '+' | '-' )* )
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:506:4: ( '+' | '-' )*
            {
            // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:506:4: ( '+' | '-' )*
            loop38:
            do {
                int alt38=3;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==24) ) {
                    alt38=1;
                }
                else if ( (LA38_0==26) ) {
                    alt38=2;
                }


                switch (alt38) {
            	case 1 :
            	    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:506:6: '+'
            	    {
            	    match(input,24,FOLLOW_24_in_positiveOrNegative1404); 

            	     sb.append(POSITIVE_TERMINAL); 

            	    }
            	    break;
            	case 2 :
            	    // /Users/mib/Documents/workspace/JSON2RDF v5/src/antlr3/JSON2RDF.g:506:46: '-'
            	    {
            	    match(input,26,FOLLOW_26_in_positiveOrNegative1410); 

            	     sb.append(NEGATIVE_TERMINAL); 

            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);


            }


            	value = getSignFor(sb.toString());

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "positiveOrNegative"

    // Delegated rules


    protected DFA28 dfa28 = new DFA28(this);
    protected DFA37 dfa37 = new DFA37(this);
    static final String DFA28_eotS =
        "\11\uffff";
    static final String DFA28_eofS =
        "\11\uffff";
    static final String DFA28_minS =
        "\1\7\1\uffff\2\7\5\uffff";
    static final String DFA28_maxS =
        "\1\61\1\uffff\2\32\5\uffff";
    static final String DFA28_acceptS =
        "\1\uffff\1\1\2\uffff\1\2\1\3\1\4\1\5\1\6";
    static final String DFA28_specialS =
        "\11\uffff}>";
    static final String[] DFA28_transitionS = {
            "\1\5\2\uffff\1\4\4\uffff\1\1\4\uffff\1\1\3\uffff\1\2\1\uffff"+
            "\1\3\24\uffff\1\6\1\10\1\7",
            "",
            "\1\5\2\uffff\1\4\15\uffff\1\2\1\uffff\1\3",
            "\1\5\2\uffff\1\4\15\uffff\1\2\1\uffff\1\3",
            "",
            "",
            "",
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
            return "365:1: literalNodeTemplate[Block parent] returns [Template<Node> template] : (value= interpolatedVariableOrString[] ( (languageAsString= LANG_TAG | '@' languageAsTemplate= interpolatedVariableOrString[] ) | '^^' datatype= resourceNodeTemplate[$parent] )? |sign= positiveOrNegative[] INT |sign= positiveOrNegative[] FLOAT | 'false' | 'true' | 'now' );";
        }
    }
    static final String DFA37_eotS =
        "\10\uffff";
    static final String DFA37_eofS =
        "\10\uffff";
    static final String DFA37_minS =
        "\1\7\1\uffff\2\7\4\uffff";
    static final String DFA37_maxS =
        "\1\61\1\uffff\2\32\4\uffff";
    static final String DFA37_acceptS =
        "\1\uffff\1\1\2\uffff\1\2\1\3\1\4\1\5";
    static final String DFA37_specialS =
        "\10\uffff}>";
    static final String[] DFA37_transitionS = {
            "\1\5\2\uffff\1\4\4\uffff\1\1\10\uffff\1\2\1\uffff\1\3\24\uffff"+
            "\1\6\1\uffff\1\7",
            "",
            "\1\5\2\uffff\1\4\15\uffff\1\2\1\uffff\1\3",
            "\1\5\2\uffff\1\4\15\uffff\1\2\1\uffff\1\3",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA37_eot = DFA.unpackEncodedString(DFA37_eotS);
    static final short[] DFA37_eof = DFA.unpackEncodedString(DFA37_eofS);
    static final char[] DFA37_min = DFA.unpackEncodedStringToUnsignedChars(DFA37_minS);
    static final char[] DFA37_max = DFA.unpackEncodedStringToUnsignedChars(DFA37_maxS);
    static final short[] DFA37_accept = DFA.unpackEncodedString(DFA37_acceptS);
    static final short[] DFA37_special = DFA.unpackEncodedString(DFA37_specialS);
    static final short[][] DFA37_transition;

    static {
        int numStates = DFA37_transitionS.length;
        DFA37_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA37_transition[i] = DFA.unpackEncodedString(DFA37_transitionS[i]);
        }
    }

    class DFA37 extends DFA {

        public DFA37(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 37;
            this.eot = DFA37_eot;
            this.eof = DFA37_eof;
            this.min = DFA37_min;
            this.max = DFA37_max;
            this.accept = DFA37_accept;
            this.special = DFA37_special;
            this.transition = DFA37_transition;
        }
        public String getDescription() {
            return "473:1: methodCallArgument[] returns [Object argument] : ( STRING |sign= positiveOrNegative[] INT |sign= positiveOrNegative[] FLOAT | 'false' | 'true' );";
        }
    }
 

    public static final BitSet FOLLOW_prelude_in_root69 = new BitSet(new long[]{0x000422B000425000L});
    public static final BitSet FOLLOW_expression_in_root74 = new BitSet(new long[]{0x000422B000425000L});
    public static final BitSet FOLLOW_EOF_in_root80 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_baseDeclaration_in_prelude99 = new BitSet(new long[]{0x0000010200000002L});
    public static final BitSet FOLLOW_prefixDeclaration_in_prelude107 = new BitSet(new long[]{0x0000010200000002L});
    public static final BitSet FOLLOW_namedNodeDeclaration_in_prelude115 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_tripleExpression_in_expression135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditionalBlock_in_expression141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_foreachBlock_in_expression147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_matchBlock_in_expression153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_expression159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_baseDeclaration181 = new BitSet(new long[]{0x0000000000025000L});
    public static final BitSet FOLLOW_uriNodeTemplateWithName_in_baseDeclaration185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_prefixDeclaration208 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_PREFIX_NAME_in_prefixDeclaration212 = new BitSet(new long[]{0x0000000000025000L});
    public static final BitSet FOLLOW_uriNodeTemplateWithName_in_prefixDeclaration216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_namedNodeDeclaration239 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_PREFIX_NAME_in_namedNodeDeclaration243 = new BitSet(new long[]{0x0003A2000552D480L});
    public static final BitSet FOLLOW_nodeTemplateWithName_in_namedNodeDeclaration247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_resourceNodeTemplateWithName_in_tripleExpression266 = new BitSet(new long[]{0x0000400020025000L});
    public static final BitSet FOLLOW_predicateList_in_tripleExpression271 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_tripleExpression274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_predicateList293 = new BitSet(new long[]{0x0003A2000552D480L});
    public static final BitSet FOLLOW_objectList_in_predicateList298 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_predicateList303 = new BitSet(new long[]{0x0000400020025000L});
    public static final BitSet FOLLOW_predicate_in_predicateList307 = new BitSet(new long[]{0x0003A2000552D480L});
    public static final BitSet FOLLOW_objectList_in_predicateList312 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_46_in_predicate333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_predicate340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_uriNodeTemplateWithName_in_predicate349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nodeTemplateWithName_in_objectList371 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_objectList378 = new BitSet(new long[]{0x0003A2000552D480L});
    public static final BitSet FOLLOW_nodeTemplateWithName_in_objectList382 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_37_in_conditionalBlock405 = new BitSet(new long[]{0x0002800000580000L});
    public static final BitSet FOLLOW_conditionalExpression_in_conditionalBlock409 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_block_in_conditionalBlock414 = new BitSet(new long[]{0x0000000C00000002L});
    public static final BitSet FOLLOW_35_in_conditionalBlock421 = new BitSet(new long[]{0x0002800000580000L});
    public static final BitSet FOLLOW_conditionalExpression_in_conditionalBlock425 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_block_in_conditionalBlock430 = new BitSet(new long[]{0x0000000C00000002L});
    public static final BitSet FOLLOW_34_in_conditionalBlock440 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_block_in_conditionalBlock442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditionalOrExpression_in_conditionalExpression465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditionalAndExpression_in_conditionalOrExpression487 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_51_in_conditionalOrExpression494 = new BitSet(new long[]{0x0002800000580000L});
    public static final BitSet FOLLOW_conditionalAndExpression_in_conditionalOrExpression498 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_conditionalNotExpression_in_conditionalAndExpression523 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_conditionalAndExpression530 = new BitSet(new long[]{0x0002800000580000L});
    public static final BitSet FOLLOW_conditionalNotExpression_in_conditionalAndExpression534 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_19_in_conditionalNotExpression557 = new BitSet(new long[]{0x0002800000500000L});
    public static final BitSet FOLLOW_conditionalAtom_in_conditionalNotExpression561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditionalAtom_in_conditionalNotExpression572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interpolatedVariable_in_conditionalAtom594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_conditionalAtom602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_conditionalAtom609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_conditionalAtom616 = new BitSet(new long[]{0x0002800000580000L});
    public static final BitSet FOLLOW_conditionalExpression_in_conditionalAtom620 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_conditionalAtom623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_foreachBlock642 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_interpolatedVariable_in_foreachBlock646 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_block_in_foreachBlock651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_matchBlock669 = new BitSet(new long[]{0x0000000000108000L});
    public static final BitSet FOLLOW_interpolatedVariableOrString_in_matchBlock673 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_matchBlock676 = new BitSet(new long[]{0x0000000000108000L});
    public static final BitSet FOLLOW_interpolatedVariableOrString_in_matchBlock680 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_block_in_matchBlock685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_block707 = new BitSet(new long[]{0x001423B300425000L});
    public static final BitSet FOLLOW_prelude_in_block709 = new BitSet(new long[]{0x001422B000425000L});
    public static final BitSet FOLLOW_expression_in_block714 = new BitSet(new long[]{0x001422B000425000L});
    public static final BitSet FOLLOW_52_in_block720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nodeTemplate_in_nodeTemplateWithName738 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_nodeTemplateWithName745 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_NODE_NAME_in_nodeTemplateWithName749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_resourceNodeTemplate_in_nodeTemplate772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literalNodeTemplate_in_nodeTemplate782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_resourceNodeTemplate_in_resourceNodeTemplateWithName804 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_resourceNodeTemplateWithName811 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_NODE_NAME_in_resourceNodeTemplateWithName815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_uriNodeTemplate_in_resourceNodeTemplate838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_anonNodeTemplate_in_resourceNodeTemplate848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_uriNodeTemplate_in_uriNodeTemplateWithName870 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_uriNodeTemplateWithName877 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_NODE_NAME_in_uriNodeTemplateWithName881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_URI_in_uriNodeTemplate905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PREFIX_NAME_in_uriNodeTemplate914 = new BitSet(new long[]{0x0000000000108200L});
    public static final BitSet FOLLOW_ID_in_uriNodeTemplate920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interpolatedVariableOrString_in_uriNodeTemplate928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NODE_NAME_in_uriNodeTemplate940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_anonNodeTemplate959 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_ID_in_anonNodeTemplate963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_anonNodeTemplate970 = new BitSet(new long[]{0x0000480020025000L});
    public static final BitSet FOLLOW_predicateList_in_anonNodeTemplate976 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_anonNodeTemplate982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_anonNodeTemplate987 = new BitSet(new long[]{0x0003A20005D2D480L});
    public static final BitSet FOLLOW_nodeTemplateWithName_in_anonNodeTemplate995 = new BitSet(new long[]{0x0003A20005D2D480L});
    public static final BitSet FOLLOW_23_in_anonNodeTemplate1003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interpolatedVariableOrString_in_literalNodeTemplate1026 = new BitSet(new long[]{0x0000100040000802L});
    public static final BitSet FOLLOW_LANG_TAG_in_literalNodeTemplate1037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_literalNodeTemplate1043 = new BitSet(new long[]{0x0000000000108000L});
    public static final BitSet FOLLOW_interpolatedVariableOrString_in_literalNodeTemplate1047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_literalNodeTemplate1056 = new BitSet(new long[]{0x0000220000425000L});
    public static final BitSet FOLLOW_resourceNodeTemplate_in_literalNodeTemplate1060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_positiveOrNegative_in_literalNodeTemplate1075 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_INT_in_literalNodeTemplate1078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_positiveOrNegative_in_literalNodeTemplate1087 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_FLOAT_in_literalNodeTemplate1090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_literalNodeTemplate1097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_literalNodeTemplate1104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_literalNodeTemplate1111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interpolatedVariable_in_interpolatedVariableOrString1132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_interpolatedVariableOrString1140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_interpolatedVariable1164 = new BitSet(new long[]{0x0013C00005008600L});
    public static final BitSet FOLLOW_methodCall_in_interpolatedVariable1170 = new BitSet(new long[]{0x0010000008000000L});
    public static final BitSet FOLLOW_27_in_interpolatedVariable1177 = new BitSet(new long[]{0x0003C00005008600L});
    public static final BitSet FOLLOW_methodCall_in_interpolatedVariable1181 = new BitSet(new long[]{0x0010000008000000L});
    public static final BitSet FOLLOW_52_in_interpolatedVariable1192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_methodCallName_in_methodCall1211 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_methodCall1218 = new BitSet(new long[]{0x0002800005808480L});
    public static final BitSet FOLLOW_methodCallArgument_in_methodCall1226 = new BitSet(new long[]{0x0000000002800000L});
    public static final BitSet FOLLOW_25_in_methodCall1233 = new BitSet(new long[]{0x0002800005008480L});
    public static final BitSet FOLLOW_methodCallArgument_in_methodCall1237 = new BitSet(new long[]{0x0000000002800000L});
    public static final BitSet FOLLOW_23_in_methodCall1248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_methodCall1258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_positiveOrNegative_in_methodCall1267 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_INT_in_methodCall1270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_methodCallName1289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_methodCallName1296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_methodCallName1303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_methodCallName1310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_methodCallName1317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_methodCallArgument1336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_positiveOrNegative_in_methodCallArgument1345 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_INT_in_methodCallArgument1348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_positiveOrNegative_in_methodCallArgument1357 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_FLOAT_in_methodCallArgument1360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_methodCallArgument1367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_methodCallArgument1374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_positiveOrNegative1404 = new BitSet(new long[]{0x0000000005000002L});
    public static final BitSet FOLLOW_26_in_positiveOrNegative1410 = new BitSet(new long[]{0x0000000005000002L});

}