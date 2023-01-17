package cz.mendelu.ja.leteckaposta.planes.flight;

import lombok.val;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class XMLgenerator {
    private final String path = "./output.xml";

    public static void xmlInit() {
        try {
            File xmlFile = new File("./output.xml");
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            // Create root element
            Element rootElement = doc.createElement("root");
            doc.appendChild(rootElement);

            // Write the content into XML file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(xmlFile);
            transformer.transform(source, result);

            System.out.println("XML file created successfully!");
        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
            System.out.println("Error creating XML file: " + e.getMessage());
        }
    }

    public static String updateXML(String from, String to, String packageId, LocalDateTime when) {
        try {
            File xmlFile = new File("./output.xml");
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(xmlFile);

            // Get root element
            Element rootElement = doc.getDocumentElement();

            // Create package element
            Element packageElement = doc.createElement("package");
            packageElement.setAttribute("from", from);
            packageElement.setAttribute("to", to);
            packageElement.setAttribute("when", when.format(DateTimeFormatter.ISO_DATE_TIME));
            packageElement.setAttribute("id", packageId);
            rootElement.appendChild(packageElement);
            // Write the content into XML file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(xmlFile);
            transformer.transform(source, result);

            return "Package added successfully!";
        } catch (ParserConfigurationException | TransformerException | SAXException | IOException e) {
            e.printStackTrace();
            return "Error adding package: " + e.getMessage();
        }
    }
    public static void main(String[] args) {

    }
}

