package functions;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.awt.Color;

import java.io.File;

import java.util.HashSet;
import java.util.Map;

import objects.*;
import functions.Data;
import variables.ReferenceVariable;

public class XmlUtil{
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

	public static HashSet<BaseObject> read(String fileName) {
		HashSet<BaseObject> _set = new HashSet<>();
		try{
			doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(fileName));
			//svgの中の要素から
			Element root = doc.getDocumentElement();
			readElementsToCollection(root,null,_set);
			/*
			for(BaseObject _bo : _set) {
				System.out.println(_bo.getName());
				if(_bo instanceof GroupObject) {
					for(BaseObject __bo : ((GroupObject)_bo).getChilds()) {
						System.out.println("  "+__bo.getName());
					}
				}
			}
			*/

			for(BaseObject _bo : _set) debug(_bo);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return _set;
	}
	static void debug(BaseObject _bo) {
		System.out.print(_bo.getName());
		if(_bo instanceof GroupObject) {
			System.out.println("{");
			for(BaseObject __bo : ((GroupObject)_bo).getChilds()) debug(__bo);
			System.out.println("}");
		}else {
			for(java.util.Map.Entry<String,ReferenceVariable> entry : _bo.getAttrs().entrySet()) {
				System.out.println(entry.getKey()+","+entry.getValue().get());
			}
			System.out.println();
		}
	}

	public static void write(String fileName, HashSet<BaseObject> _data) {
		try{
			doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
			for(BaseObject first : _data) {
				while(first.getParent()!=null) first = first.getParent();
				doc.appendChild(writeObjectsToElements(first));
				break;
			}
			//doc.appendChild(base);
			transformer.transform(new DOMSource(doc),new StreamResult(new File(fileName)));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static Element writeObjectsToElements(BaseObject _bo) {
		Element element = doc.createElement(_bo.getName());
		for(Map.Entry<String,ReferenceVariable> _attr : _bo.getAttrs().entrySet()) {
			Object obj = _attr.getValue().get();
			String value = obj.toString();
			Class cls = obj.getClass();
			if(cls == Color.class) value = String.format("#%02x%02x%02x",((Color)obj).getRed(),((Color)obj).getGreen(),((Color)obj).getBlue());
			element.setAttribute(_attr.getKey(),""+value);
		}
		if(_bo instanceof GroupObject) {
			GroupObject _go = (GroupObject) _bo;
			for(BaseObject __bo : _go.getChilds()) {
				element.appendChild(writeObjectsToElements(__bo));
			}
		}
		return element;
	}

	public static void readElementsToCollection(Element _e, BaseObject _bo, HashSet<BaseObject> _set) {
		//Element自身を確認
		//	svg要素だったときは親_boの該当オブジェクトとして実体化
		//Elementの子要素を確認
		BaseObject __bo = null;
		switch(_e.getNodeName()) {
			case "svg":
				__bo = new Svg(_bo);
				Data.mother = __bo;
				break;
			case "rect":
				__bo = new Rect(_bo);
				break;
			case "g":
				__bo = new Group(_bo);
				break;
		}
		if(__bo != null) {
			NamedNodeMap nnp = _e.getAttributes();
			for(int i = 0; i < nnp.getLength(); i++) {
				Node _node = nnp.item(i);
				if(_node.getNodeType() == Node.ATTRIBUTE_NODE) {
					Attr _attr = (Attr)_node;
					String name = _attr.getName();
					String value = _attr.getValue();
					if(name.equals("style")) {
						String[] pairs = value.split(";");
						for(String _pairs : pairs) {
							String[] n_v = _pairs.split(":");
							if(n_v.length==2) {
								__bo.setAttr(n_v[0],n_v[1]);
							}
						}
					}
					__bo.setAttr(name,value);
				}
			}
			_set.add(__bo);
			if(_bo instanceof GroupObject) {
				((GroupObject)_bo).addChild(__bo);
			}
		}
		//Elementから子孫があればBaseObjectに追加する。
		if(__bo instanceof GroupObject) {
			NodeList nr = _e.getChildNodes();
			for(int i = 0; i < nr.getLength(); i++) {
				Node node = nr.item(i);
				if(node.getNodeType() == Node.ELEMENT_NODE) {
					Element childE = (Element)node;
					readElementsToCollection(childE,__bo,_set);
				}
			}
		}
	}
}
