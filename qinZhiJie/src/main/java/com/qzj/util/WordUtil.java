package com.qzj.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class WordUtil {

	public static void main(String[] args) {


		// readWord2007("doc\\wzg1.docx");

		String content = readWord2003("G:\\工作2019\\01资料馆\\02指法词典\\谱字释义\\03  三画\\擗，擘，劈   ok.doc");
		while(true) {
			if(content.contains("\"_blank\"")) {
				System.out.println(content.substring(content.indexOf(""), content.indexOf("") + 1));
				content = content.replace(content.substring(content.indexOf(""), content.indexOf("") + 1), "").replace("", "");
			}else {
				break;
			}
		}
		System.out.println(content);
	}

	public static String readWord2003(String filePath) {
		FileInputStream fis;
		HWPFDocument doc;
		String text = null;
		try {
			File f = new File(filePath);
			fis = new FileInputStream(f);
			doc = new HWPFDocument(fis);
			Range rang = doc.getRange();     
			text = rang.text();  
			fis.close();     
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return text;
	}

	public static String readWord2007(String filePath) {

		String text = null;
		try {
			OPCPackage oPCPackage = POIXMLDocument.openPackage(filePath);
			XWPFDocument xwpf = new XWPFDocument(oPCPackage);
			POIXMLTextExtractor ex = new XWPFWordExtractor(xwpf);
			text = ex.getText();
			oPCPackage.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return text;
	}
}
