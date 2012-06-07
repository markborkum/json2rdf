grammar JSON2RDF;

options {
	language = Java;
}

@lexer::header{
	package uk.ac.soton.mib104.json2rdf;
}

@lexer::members {
	// Empty...
}

@parser::header {
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
}

@parser::members {
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
}

root[] returns [Block parent]
@init {
	$parent = new Block();
}
	:	prelude[$parent] ( expression[$parent] )* EOF
	;
	
prelude[Block parent] returns []
	:	( baseDeclaration[$parent] )? ( prefixDeclaration[$parent] )* ( namedNodeDeclaration[$parent] )*
	;

expression[Block parent] returns []
	:	tripleExpression[$parent]
	|	conditionalBlock[$parent]
	|	foreachBlock[$parent]
	|	matchBlock[$parent]
	|	block[$parent, true]
	;

baseDeclaration[Block parent] returns []
@after {
	new BaseDeclaration($parent, $baseNodeTemplate.template);
}
	:	'BASE' baseNodeTemplate=uriNodeTemplateWithName[$parent]
	;
	
prefixDeclaration[Block parent] returns []
@after {
	new PrefixDeclaration($parent, Template.toTemplate($namespacePrefix.text), $namespaceNodeTemplate.template);
}
	:	'PREFIX' namespacePrefix=PREFIX_NAME namespaceNodeTemplate=uriNodeTemplateWithName[$parent]
	;
	
namedNodeDeclaration[Block parent] returns []
@after {
	new NamedNodeDeclaration($parent, Template.toTemplate($name.text), $namedNodeTemplate.template);
}
	:	'BIND' name=PREFIX_NAME namedNodeTemplate=nodeTemplateWithName[$parent]
	;

tripleExpression[Block parent] returns []
	:	subject=resourceNodeTemplateWithName[$parent] { 
			final Template<Node> subjectTemplate = $subject.template;
		} predicateList[$parent, subjectTemplate] '\.'
	;
	
predicateList[Block parent, Template<Node> subjectTemplate] returns []
	:	headPredicate=predicate[$parent] {
			final Template<Node> headPredicateTemplate = $headPredicate.template;
		} objectList[$parent, $subjectTemplate, headPredicateTemplate] ( ';' tailPredicate=predicate[$parent] {
			final Template<Node> tailPredicateTemplate = $tailPredicate.template;
		} objectList[$parent, $subjectTemplate, tailPredicateTemplate] )*
	;
	
predicate[Block parent] returns [Template<Node> template]
	:	'a' {
			$template = RDF_type;
		}
	|	'=' {
			$template = OWL_sameAs;
		}
	|	uriNode=uriNodeTemplateWithName[$parent] {
			$template = $uriNode.template;
		}
	;
	
objectList[Block parent, Template<Node> subjectTemplate, Template<Node> predicateTemplate] returns []
	:	head=nodeTemplateWithName[$parent] {
			new TripleExpression($parent, $subjectTemplate, $predicateTemplate, $head.template);
		} ( ',' tail=nodeTemplateWithName[$parent] {
			new TripleExpression($parent, $subjectTemplate, $predicateTemplate, $tail.template);
		} )*
	;
	
conditionalBlock[Block parent] returns []
	:	'IF' ifConditionalExpression=conditionalExpression[] { 
			final Block ifTrueBlock = new ConditionalBlock($parent, $ifConditionalExpression.condition);
			final Block ifFalseBlock = new ConditionalBlock($parent, new NotCondition($ifConditionalExpression.condition));
		} block[ifTrueBlock, false] { 
			Block elseBlock = ifFalseBlock;
		} ( 'ELSIF' elsifConditionalExpression=conditionalExpression[] {
			final Block elsifTrueBlock = new ConditionalBlock(elseBlock, $elsifConditionalExpression.condition);
			final Block elsifFalseBlock = new ConditionalBlock(elseBlock, new NotCondition($elsifConditionalExpression.condition));
		} block[elsifTrueBlock, false] {
			elseBlock = elsifFalseBlock;
		} )* ( 'ELSE' block[elseBlock, false] )?
	;
	
conditionalExpression[] returns [Condition condition]
	:	operand=conditionalOrExpression[] {
			$condition = $operand.condition;
		}
	;
	
conditionalOrExpression[] returns [Condition condition]
	:	leftOperand=conditionalAndExpression[] {
			Condition leftCondition = $leftOperand.condition, rightCondition = null;
			
			$condition = leftCondition;
		} ( '||' rightOperand=conditionalAndExpression[] {
			rightCondition = $rightOperand.condition;
		
			$condition = new OrCondition(leftCondition, rightCondition);
			
			leftCondition = $condition;
		} )*
	;
	
conditionalAndExpression[] returns [Condition condition]
	:	leftOperand=conditionalNotExpression[] {
			Condition leftCondition = $leftOperand.condition, rightCondition = null;
			
			$condition = leftCondition;
		} ( '&&' rightOperand=conditionalNotExpression[] {
			rightCondition = $rightOperand.condition;
			
			$condition = new AndCondition(leftCondition, rightCondition);
			
			leftCondition = $condition;
		} )*
	;
	
conditionalNotExpression[] returns [Condition condition]
	:	'!' operand=conditionalAtom[] {
			$condition = new NotCondition($operand.condition);
		}	
	|	operand=conditionalAtom[] {
			$condition = $operand.condition;
		}
	;
	
conditionalAtom[] returns [Condition condition]
	:	variable=interpolatedVariable[] {
			$condition = new IsDefinedCondition($variable.template);
		}
	|	'false' {
			$condition = Condition.FALSE;
		}
	|	'true' {
			$condition = Condition.TRUE;
		}
	|	'(' operand=conditionalExpression[] ')' {
			$condition = $operand.condition;
		}
	;
	
foreachBlock[Block parent] returns []
	:	'FOREACH' variable=interpolatedVariable[] {
			final Block foreachBlock = new ForeachBlock($parent, $variable.template);
		} block[foreachBlock, false]
	;
	
matchBlock[Block parent] returns []
	:	'MATCH' pattern=interpolatedVariableOrString[] 'IN' target=interpolatedVariableOrString[] {
			final Block matchBlock = new MatchBlock($parent, $pattern.template, $target.template);
		} block[matchBlock, false]
	;

block[Block parent, boolean createNewBlock] returns []
@init {
	final Block newBlock = createNewBlock ? new Block($parent) : $parent;
}
	:	'{' prelude[newBlock] ( expression[newBlock] )* '}'
	;

nodeTemplateWithName[Block parent] returns [Template<Node> template]
	:	node=nodeTemplate[$parent] {
			$template = $node.template;
		} ( 'AS' nodeName=NODE_NAME {
			new NamedNodeDeclaration($parent, Template.toTemplate($nodeName.text), $template);
		} )?
	;

nodeTemplate[Block parent] returns [Template<Node> template]
	:	resourceNode=resourceNodeTemplate[$parent] {
			$template = $resourceNode.template;
		}
	|	literalNode=literalNodeTemplate[$parent] {
			$template = $literalNode.template;
		}
	;
	
resourceNodeTemplateWithName[Block parent] returns [Template<Node> template]
	:	resourceNode=resourceNodeTemplate[$parent] {
			$template = $resourceNode.template;
		} ( 'AS' nodeName=NODE_NAME {
			new NamedNodeDeclaration($parent, Template.toTemplate($nodeName.text), $template);
		} )?
	;

resourceNodeTemplate[Block parent] returns [Template<Node> template]
	:	uriNode=uriNodeTemplate[$parent] {
			$template = $uriNode.template;
		}
	|	anonNode=anonNodeTemplate[$parent] {
			$template = $anonNode.template;
		}
	;
	
uriNodeTemplateWithName[Block parent] returns [Template<Node> template]
	:	uriNode=uriNodeTemplate[$parent] {
			$template = $uriNode.template;
		} ( 'AS' nodeName=NODE_NAME {
			new NamedNodeDeclaration($parent, Template.toTemplate($nodeName.text), $template);
		} )?
	;
	
uriNodeTemplate[Block parent] returns [Template<Node> template]
	:	uri=URI {
			$template = new URINodeTemplate(new InterpolatedStringTemplate(Template.toTemplate($uri.text)));
		}
	|	namespacePrefix=PREFIX_NAME ( localName=ID {
			$template = new PrefixedNameNodeTemplate(Template.toTemplate($namespacePrefix.text), Template.toTemplate($localName.text));
		} | localNameTemplate=interpolatedVariableOrString[] {
			$template = new PrefixedNameNodeTemplate(Template.toTemplate($namespacePrefix.text), $localNameTemplate.template);
		} )
	|	nodeName=NODE_NAME {
			$template = new NamedNodeTemplate(Template.toTemplate($nodeName.text));
		}
	;
	
anonNodeTemplate[Block parent] returns [Template<Node> template]
	:	'_:' anonId=ID {
			$template = new AnonNodeTemplate(Template.toTemplate($anonId.text));
		}
	|	'[' {
			$template = new AnonNodeTemplate();
		} ( predicateList[$parent, $template] )? ']'
	|	'(' {
			final List<Template<Node>> templates = new LinkedList<Template<Node>>();
		} ( nextTemplate=nodeTemplateWithName[$parent] {
			templates.add($nextTemplate.template);
		} )* ')' {
			if (templates.isEmpty()) {
				$template = RDF_nil;
			} else {
				Template<Node> firstListTemplate = null, currentListTemplate = null;
				
				for (final Iterator<Template<Node>> iterator = templates.iterator(); iterator.hasNext(); ) {
					final Template<Node> nextIteratorTemplate = iterator.next(), nextListTemplate = new AnonNodeTemplate();
					
					if (firstListTemplate == null) {
						firstListTemplate = nextListTemplate;
					}
					
					new TripleExpression($parent, nextListTemplate, RDF_type, RDF_List);
					
					new TripleExpression($parent, nextListTemplate, RDF_first, nextIteratorTemplate);
					
					if (!iterator.hasNext()) {
						new TripleExpression($parent, nextListTemplate, RDF_rest, RDF_nil);
					}
					
					if (currentListTemplate != null) {
						new TripleExpression($parent, currentListTemplate, RDF_rest, nextListTemplate);
					}
					
					currentListTemplate = nextListTemplate;
				}
				
				$template = firstListTemplate;
			}
		}
	;
	
literalNodeTemplate[Block parent] returns [Template<Node> template]
	:	{ 
			Template<?> valueTemplate = null, languageTemplate = null; 
			Template<Node> datatypeTemplate = null;
		} value=interpolatedVariableOrString[] {
			valueTemplate = $value.template;
		} ( ( languageAsString=LANG_TAG {
			languageTemplate = Template.toTemplate($languageAsString.text);
		} | '@' languageAsTemplate=interpolatedVariableOrString[] {
			languageTemplate = $languageAsTemplate.template;
		} ) | '^^' datatype=resourceNodeTemplate[$parent] {
			datatypeTemplate = $datatype.template;
		} )? {
			if (languageTemplate != null) {
				$template = new PlainLiteralNodeTemplate(valueTemplate, languageTemplate);
			} else if (datatypeTemplate != null) {
				$template = new TypedLiteralNodeTemplate(valueTemplate, datatypeTemplate);
			} else {
				$template = new TypedLiteralNodeTemplate(valueTemplate);
			}
		}
	|	sign=positiveOrNegative[] INT {
			try {
				$template = new TypedLiteralNodeTemplate(Template.toTemplate(Integer.parseInt(StringUtils.concat($sign.value, $INT.text))));
			} catch (final Exception e) { 
				// Do nothing...
			}
		}
	|	sign=positiveOrNegative[] FLOAT {
			try {
				$template = new TypedLiteralNodeTemplate(Template.toTemplate(Float.parseFloat(StringUtils.concat($sign.value, $FLOAT.text))));
			} catch (final Exception e) { 
				// Do nothing...
			}
		}
	|	'false' {
			$template = new TypedLiteralNodeTemplate(Template.toTemplate(Boolean.FALSE));
		}
	|	'true' {
			$template = new TypedLiteralNodeTemplate(Template.toTemplate(Boolean.TRUE));
		}
	|	'now' {
			$template = new CurrentTimeNodeTemplate();
		}
	;
	
interpolatedVariableOrString[] returns [Template<?> template]
	:	variable=interpolatedVariable[] { 
			$template = $variable.template;
		}
	|	STRING { 
			$template = new InterpolatedStringTemplate(Template.toTemplate($STRING.text)); 
		}
	;
	
interpolatedVariable[] returns [MethodCallList template]
@init {
	$template = new MethodCallList();
}
	:	'${' ( head=methodCall[] {
			$template.add($head.template);
		} ( '/' tail=methodCall[] {
			$template.add($tail.template);
		} )* )? '}'
	;
	
methodCall[] returns [MethodCall template]
	:	methodName=methodCallName[] {
			$template = new MethodCall(ChildMethod.getMethodName(), new Object[] { $methodName.string }); 
		} ( '(' {
			final List<Object> arguments = new LinkedList<Object>();
		} ( head=methodCallArgument[] { 
			arguments.add($head.argument);
		} ( ',' tail=methodCallArgument[] { 
			arguments.add($tail.argument);
		} )* )? ')' {
			$template = new MethodCall($methodName.string, arguments.toArray(new Object[arguments.size()]));
		} )?
	|	STRING { 
			$template = new MethodCall(ChildMethod.getMethodName(), new Object[] { $STRING.text }); 
		}
	|	sign=positiveOrNegative[] INT { 
			try {
				$template = new MethodCall(ChildMethod.getMethodName(), new Object[] { Integer.parseInt(StringUtils.concat($sign.value, $INT.text)) }); 
			} catch (final Exception e) {
				// Do nothing...
			}
		}
	;
	
methodCallName[] returns [String string]
	:	ID {
			$string = $ID.text;
		}
	|	'a' {
			$string = "a";
		}
	|	'false' {
			$string = "false";
		}
	|	'true' {
			$string = "true";
		}
	|	'now' {
			$string = "now";
		}
	;
	
methodCallArgument[] returns [Object argument]
	:	STRING { 
			$argument = $STRING.text; 
		}
	|	sign=positiveOrNegative[] INT { 
			try {
				$argument = Integer.parseInt(StringUtils.concat($sign.value, $INT.text));
			} catch (final Exception e) {
				// Do nothing...
			}
		}
	|	sign=positiveOrNegative[] FLOAT {
			try {
				$argument = Float.parseFloat(StringUtils.concat($sign.value, $FLOAT.text));
			} catch (final Exception e) {
				// Do nothing...
			}
		}
	|	'false' { 
			$argument = Boolean.FALSE; 
		}
	|	'true' { 
			$argument = Boolean.TRUE; 
		}
	;

positiveOrNegative[] returns [String value]
@init {
	final StringBuilder sb = new StringBuilder();
}
@after {
	$value = getSignFor(sb.toString());
}
	:	( '+' { sb.append(POSITIVE_TERMINAL); } | '-' { sb.append(NEGATIVE_TERMINAL); } )*
	;
	
ID
	:	('a'..'z'|'A'..'Z') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
	;

NODE_NAME
	:	'?' ID { setText(getText().substring(1, getText().length())); }
	;
	
PREFIX_NAME
	:	ID ':' { setText(getText().substring(0, getText().length() - 1)); }
	;
	
LANG_TAG
	:	'@' ('a'..'z'|'A'..'Z')+ ( '-' ('a'..'z'|'A'..'Z'|'0'..'9')+ )? { setText(getText().substring(1, getText().length())); }
	;

INT
	:	'0' 
	|	'1'..'9' ('0'..'9')*
	;

FLOAT
	:	('0'..'9')+ '.' ('0'..'9')* EXPONENT?
	|	'.' ('0'..'9')+ EXPONENT?
	|	('0'..'9')+ EXPONENT
	;
	
fragment
EXPONENT
	:	('e'|'E') ('+'|'-')? ('0'..'9')+
	;

fragment
HEX_DIGIT
	:	('0'..'9'|'a'..'f'|'A'..'F')
	;
  
fragment
UNICODE_ESC
	:	'\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
	;

fragment
OCTAL_ESC
	:	'\\' ('0'..'3') ('0'..'7') ('0'..'7')
	|	'\\' ('0'..'7') ('0'..'7')
	|	'\\' ('0'..'7')
	;

fragment
ESC_SEQ
	:	'\\' ('a'..'z'|'A'..'Z'|'$'|'^'|'?'|'\.'|','|'+'|'-'|'*'|':'|'='|'!'|'<'|'>'|'('|')'|'{'|'}'|'['|']'|'\"'|'\''|'\\')
	|	UNICODE_ESC
	|	OCTAL_ESC
	;

STRING
	:	'"' ( ESC_SEQ | ~('\\'|'"') )* '"' { setText(getText().substring(1, getText().length() - 1)); }
	|	'\'' ( ESC_SEQ | ~('\\'|'\'') )* '\'' { setText(getText().substring(1, getText().length() - 1)); }
	|	'"""' ( options { greedy=false; } : . )* '"""' { setText(getText().substring(3, getText().length() - 3)); }
	|	'\'\'\'' ( options { greedy=false; } : . )* '\'\'\'' { 	setText(getText().substring(3, getText().length() - 3)); }
	;

URI
	:	'<' ( ESC_SEQ | ~('\\'|'>') )* '>' { 
			// As with Turtle and N3, the surrounding whitespace for a URI reference is ignored.
			setText(getText().substring(1, getText().length() - 1).trim()); 
		}
	;

COMMENT
	:	'//' ~('\n'|'\r')* '\r'? '\n' { $channel=HIDDEN; }
	|	'/*' ( options { greedy=false; } : . )* '*/' { $channel=HIDDEN; }
	;

WS
	:	(' '|'\t'|'\r'|'\n') { $channel=HIDDEN; }
	;
