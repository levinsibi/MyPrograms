package rft;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class XMLtest {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		
		
		
		String filepath = "d:\\file.xml";
		DocumentBuilderFactory docFactory =  DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(filepath);
		// TODO Auto-generated method stub
		
		
		
		Node node1=doc.getElementsByTagName("lastname").item(0);
		System.out.println(node1.getTextContent().toString());
		node1.setTextContent("porinju");
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(filepath));
		transformer.transform(source, result);

	}

}
