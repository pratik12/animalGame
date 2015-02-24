package animalGame;

import java.io.File;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *  
 * @author Pratik Bidkar
 * This class starts the process of reading the xml file and get the initial set of questions
 * 
 */
public class ReadXMLFile {
 
	static QuestionXML qmlObj = new QuestionXML();
	
	public static void main(String argv[]){
		
	try {
		 
		File XmlFile = new File("questions.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(XmlFile);
	 
		doc.getDocumentElement().normalize();
		NodeList nList = doc.getElementsByTagName("animal");
	 
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			Node node = null;

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				if (nNode.hasAttributes()) {
					 
					// get attributes names and values
					NamedNodeMap nodeMap = nNode.getAttributes();
		 
					for (int i = 0; i < nodeMap.getLength(); i++) {
		 
						 node = nodeMap.item(i);
					}
				}
				qmlObj.setQuestions(node.getNodeValue(), nNode.getTextContent());
			}
		}
		
		
		Scanner in = new Scanner(System.in);
		System.out.println("Start Press S to start the game and enter Y/N as your answer");
		String input = in.next().trim();
		if(input.equalsIgnoreCase("s")){
			PlayGame pg = new PlayGame();
			pg.game(input, qmlObj);
			
		}else
		{
			System.out.println("Enter a valid character");
			in.close();
		}
		
		
		
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	  
}}
