package Lab1.Strategy;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;

/**
 * Created by Андрей on 28.04.2020.
 */
public class Dom implements Strategy {

    private String inputXml = "";
    private String resultXml = "";

    public Dom(String args0, String args1) {
        inputXml = args0;
        resultXml = args1;
    }


    private void getDomAverage() {


        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = builder.parse(inputXml);

            NodeList nodeList = document.getElementsByTagName("student");
            Node node = nodeList.item(0);
            NodeList children = node.getChildNodes();
            // System.out.println(children + " << НОДЫ");

            double sum = 0.0;
            double count = 0.0;
            double real = 0.0;
            double defaultAverage = 0.0;
            NamedNodeMap map;
            Node cur;

            for (int i = 0; i < children.getLength(); i++) {
                cur = children.item(i);
                map = cur.getAttributes();
                if (map != null && cur.getNodeName().equals("subject")) {
                    sum += Integer.parseInt(map.getNamedItem("mark").getNodeValue());
                    System.out.println(map.getNamedItem("mark").getNodeValue() + " << Отметки | " +
                            map.getNamedItem("title").getNodeValue() + " << Предмет |");
                    count++;
                }
                if (cur.getNodeName().equals("average")) {
                    Node n = cur.getFirstChild();
                    defaultAverage = Double.parseDouble(n.getNodeValue());
                }
            }
            System.out.println("Doc: " + defaultAverage);
            real = sum / count;
            System.out.println("Real: " + real);


            DOMSource source = new DOMSource(document);
            if (real != defaultAverage) {
                nodeList = document.getElementsByTagName("average");
                Node average = nodeList.item(0).getFirstChild();
                average.setNodeValue(String.valueOf(real));
                System.out.println("result изменен");
            } else
                System.out.println("всё норм");

            StreamResult result = new StreamResult(resultXml);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.transform(source, result);

            System.out.println("XML готов");
        } catch (SAXException | TransformerException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void analyze() {
        getDomAverage();
    }
}

