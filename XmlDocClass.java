package com.accenture.itfactory.base.FilmApplication;
import org.w3c.dom.*;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

//DOM Parser
public class XmlDocClass {
    DocumentBuilderFactory dbFactory;
    DocumentBuilder dBuilder;
    Document doc;
    List<Film> filmList;

    public XmlDocClass(){
        dbFactory = DocumentBuilderFactory.newInstance();
    }
    public void saveSession(String path, List<Film> filmList){

        try{
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.newDocument();

            //root element
            Element rootElement = doc.createElement("FilmDatabase");
            doc.appendChild(rootElement);

            for(Film f :  filmList){
            //elements
            Element filmElement = doc.createElement("Film");
            rootElement.appendChild(filmElement);
            Attr filmAttr = doc.createAttribute("Name");
            filmAttr.setValue(f.name);

            Element id = doc.createElement("Id");
            id.appendChild(doc.createTextNode(f.imdbId));
            filmElement.appendChild(id);

            Element date = doc.createElement("ReleaseDate");
            date.appendChild(doc.createTextNode(f.releaseDate.toString()));
            filmElement.appendChild(date);

            Element fType = doc.createElement("Type");
            fType.appendChild(doc.createTextNode(f.filmType));
            filmElement.appendChild(fType);

            Element rating = doc.createElement("Rating");
            rating.appendChild(doc.createTextNode(Double.toString(f.rating)));
            filmElement.appendChild(rating);

            Element genre = doc.createElement("Genre");
            genre.appendChild(doc.createTextNode(f.genre));
            filmElement.appendChild(genre);

            Element description = doc.createElement("Description");
            description.appendChild(doc.createTextNode(f.description));
            filmElement.appendChild(description);

            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            transformerFactory.setAttribute("indent-number","3");
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT,"yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(path));
            transformer.transform(source,result);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    //Метод не работает. "doc" всегда null и не парсирует файл, который создался в "saveSession" 
    public List<Film> startSession(String path/*File input*/){
        try{
            dBuilder = dbFactory.newDocumentBuilder();
            
            //StringBuilder xmlStringBuilder = new StringBuilder(); //(input);
            //xmlStringBuilder.append(path);
            //ByteArrayInputStream inputStream = new ByteArrayInputStream(xmlStringBuilder.toString().getBytes("UTF-8"));
            //StreamSource inputStream = new StreamSource(path);
            //Document doc = dBuilder.parse(inputStream.getInputStream()); //new File(path));
            //doc.getDocumentElement().normalize();
            //Element root = doc.getElementById();
            /*StringReader sReader = new StringReader(path);
            InputSource inputSource = new InputSource(sReader);
            Document doc = dBuilder.parse(inputSource);*/
            
            Document doc = dBuilder.parse(new File(path));
            NodeList nodeList = doc.getElementsByTagName("FilmDatabase");
            filmList = new ArrayList<Film>(nodeList.getLength());
            for(int i = 0; i<nodeList.getLength();i++){
                Node nNode = nodeList.item(i);
                filmList.add(new Film());
                if(nNode.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) nNode;
                    filmList.get(i).name = String.valueOf(element.getElementsByTagName("Name"));
                    filmList.get(i).imdbId = String.valueOf(element.getElementsByTagName("Id"));
                    filmList.get(i).genre = String.valueOf(element.getElementsByTagName("Genre"));
                    filmList.get(i).filmType = String.valueOf(element.getElementsByTagName("Type"));
                    filmList.get(i).rating = Double.parseDouble(String.valueOf(element.getElementsByTagName("Rating")));
                    filmList.get(i).description = String.valueOf(element.getElementsByTagName("Description"));
                    filmList.get(i).releaseDate = new SimpleDateFormat("yyyy-mm-dd").parse(String.valueOf(element.getElementsByTagName("Release Date")));
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return filmList;
    }
}
