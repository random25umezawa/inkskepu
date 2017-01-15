import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

class XmlUtil{
	static Document doc;
	static Transformer transformer;
	static{
		try{
			doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
			transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty("indent","yes");
			transformer.setOutputProperty("encoding","UTF-8");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	static DrawObject read(String fileName) {
		try{
			doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("fileName"));

			return null;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	static void write(String fileName, DrawObject _do) {
		try{
			doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
			Element base = doc.createElement("svg");
			base.setAttribute("viewBox","0,0,300,400");
			Element circle = doc.createElement("circle");
			circle.setAttribute("cx","100");
			circle.setAttribute("cy","100");
			circle.setAttribute("r","25");
			circle.setAttribute("stroke-width","7");
			circle.setAttribute("stroke","green");
			circle.setAttribute("fill","yellow");
			base.appendChild(circle);
			doc.appendChild(base);
			transformer.transform(new DOMSource(doc),new StreamResult(new File(fileName)));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
