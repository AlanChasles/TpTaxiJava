package mainV32;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Tp {


	public static void retour(){
		System.out.print("\n");

	}

	public static void main(String[] args) throws ParserConfigurationException, SAXException {
		
		
		
		String ligne;
		
		double res;
		List<Tarifs> maListe = new ArrayList<Tarifs>();
		
		try{
			DocumentBuilderFactory DBF = DocumentBuilderFactory.newInstance();
			DocumentBuilder DB = DBF.newDocumentBuilder();
			Document document= DB.parse(new File("P:/SLAM4 TP 04092015/tpTaxi/src/mainV32/tarifs.xml"));
			Element racine = document.getDocumentElement();
			NodeList racineNoeuds = racine.getChildNodes();
			
			for (int i = 0; i<racineNoeuds.getLength(); i++) {
				if(racineNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE) {
					Element departement = (Element) racineNoeuds.item(i);
					Element dept = (Element) departement.getElementsByTagName("dept").item(0);
					Element pec = (Element) departement.getElementsByTagName("pec").item(0);
					Element tarifKmSemaine = (Element) departement.getElementsByTagName("tarifKmSemaine").item(0);
					Element tarifHoraireSemaine = (Element) departement.getElementsByTagName("tarifHoraireSemaine").item(0);
					Element tarifKmDimanche = (Element) departement.getElementsByTagName("tarifKmDimanche").item(0);
					Element tarifHoraireDimanche = (Element) departement.getElementsByTagName("tarifHoraireDimanche").item(0);
					maListe.add(new Tarifs(Double.parseDouble(dept.getTextContent()),Double.parseDouble(pec.getTextContent()),Double.parseDouble(tarifKmSemaine.getTextContent()),Double.parseDouble(tarifHoraireSemaine.getTextContent()),Double.parseDouble(tarifKmDimanche.getTextContent()),Double.parseDouble(tarifHoraireDimanche.getTextContent())));
				}
				
			}
			
				
				
				
			
			}
		
		catch(IOException e){
			
			System.out.println(e.getMessage());
			
		}
		
		
		
		
		Saisie var = new Saisie(Calcul.saisieDept(maListe),Calcul.saisieNbKm(),Calcul.saisieJour(),Calcul.saisiehoraire());
		
		

		res = Calcul.calcul(maListe, var);
		System.out.print("Le prix à payer est : ");
		System.out.printf("%.2f",res);
		

	}

}
