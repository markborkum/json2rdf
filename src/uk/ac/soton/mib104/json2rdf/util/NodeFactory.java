package uk.ac.soton.mib104.json2rdf.util;

import java.util.Map;
import java.util.TreeMap;

import org.json.JSONArray;
import org.json.JSONObject;

import com.hp.hpl.jena.datatypes.BaseDatatype;
import com.hp.hpl.jena.datatypes.RDFDatatype;
import com.hp.hpl.jena.graph.Node;
import com.hp.hpl.jena.rdf.model.ResourceFactory;

public final class NodeFactory {
	
	private static final Map<String, BaseDatatype> baseDatatypesByURI = new TreeMap<String, BaseDatatype>();
	
	public static final Node createAnon() {
		return Node.createAnon();
	}
	
	public static final BaseDatatype createBaseDatatype(final String uri) {
		if (!baseDatatypesByURI.containsKey(uri)) {
			baseDatatypesByURI.put(uri, new BaseDatatype(uri));
		}
		
		return baseDatatypesByURI.get(uri);
	}
	
	public static final Node createPlainLiteral(final String value, final String language, final boolean isXML) {
		return Node.createLiteral(value, language, isXML);
	}
	
	public static final Node createTypedLiteral(final Object value) {
		if (value == null) {
			throw new IllegalArgumentException("value == null");
		} else if (value instanceof JSONObject) {
			return createTypedLiteral(((JSONObject) value).toString());
		} else if (value instanceof JSONArray) {
			return createTypedLiteral(((JSONArray) value).toString());
		} else {
			return ResourceFactory.createTypedLiteral(value).asNode();
		}
	}
	
	public static final Node createTypedLiteral(final Object value, final Node node) {
		if (node == null) {
			return createTypedLiteral(value);
		} else if (node.isURI()) {
			return createTypedLiteral(value, createBaseDatatype(node.getURI()));
		} else {
			return createTypedLiteral(value);
		}
	}
	
	public static final Node createTypedLiteral(final Object value, final RDFDatatype datatype) {
		if (datatype == null) {
			return createTypedLiteral(value);
		} else {
			return Node.createLiteral((value == null) ? null : value.toString(), null, datatype);
		}
	}
	
	public static final Node createURI(final String uri) {
		return Node.createURI(uri);
	}
	
	private NodeFactory() {
		// Do nothing...
	}
	
}
