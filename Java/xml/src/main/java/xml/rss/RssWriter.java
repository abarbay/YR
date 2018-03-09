package xml.rss;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayOutputStream;

public class RssWriter {

    public String writeRss(Channel channel) {

        Document d = createDocumentByChannel(channel);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();

        try{

        Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(d);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            StreamResult result = new StreamResult(baos);

            transformer.transform(source, result);
            return new String(baos.toByteArray());
    } catch ( TransformerException e) {
            e.printStackTrace();
            return null;
        }

    }

    public Document createDocumentByChannel(Channel channel){
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            Element root=document.createElement("rss");
            document.appendChild(root);
            Element chnl=document.createElement("channel");
            root.appendChild(chnl);

            Element title=document.createElement("title");
            chnl.appendChild(title).setTextContent(channel.getTitle().toString());

            Element link=document.createElement("link");
            chnl.appendChild(link).setTextContent(channel.getLink().toString());
            Element description=document.createElement("description");
            chnl.appendChild(description).setTextContent(channel.getDescription().toString());



            for(Item i:channel.getItems()){
                Element item=document.createElement("item");
                chnl.appendChild(item);
                Element itemTitle=document.createElement("title");
                item.appendChild(itemTitle).setTextContent(i.getTitle().toString());
                Element itemLink=document.createElement("link");
                item.appendChild(itemLink).setTextContent(i.getLink().toString());
                Element itemDescription=document.createElement("description");
                item.appendChild(itemDescription).setTextContent(i.getDescription().toString());
            }


        return document;


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            return null;

        }


    }
}
