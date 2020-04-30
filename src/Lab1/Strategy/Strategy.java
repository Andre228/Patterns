package Lab1.Strategy;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;

/**
 * Created by Андрей on 28.04.2020.
 */
public interface Strategy {
     void analyze() throws ParserConfigurationException, XMLStreamException, SAXException, IOException;
}
