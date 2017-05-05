package com.ccnu.jh.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.*;
import org.xml.sax.*;

import com.ccnu.jh.model.Dict;

public class FileFunc {
	public static ArrayList<Dict> readDictXml(String path) {
		ArrayList<Dict> res = new ArrayList<>();
		try {
			File file = new File(path);
			if (file.exists()) {
				System.out.println("found file");
				Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
				NodeList nl = doc.getElementsByTagName("item");
				
				for (int i = 0; i < nl.getLength(); i++) {
					Dict d = new Dict();
					ArrayList<String> valuelist = new ArrayList<>();
					Node fa = nl.item(i);
					for (Node n = fa.getFirstChild(); n != null; n = n.getNextSibling()) {
						if (n.getNodeType() == Node.ELEMENT_NODE) {
							valuelist.add(n.getFirstChild().getNodeValue());
						}
					}
					d.setDicttypeid(new Integer(valuelist.get(0)));
					d.setName(valuelist.get(1));
					d.setDescription(valuelist.get(2));
					res.add(d);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		return res;
	}
}
