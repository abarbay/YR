package xml.rss;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class RssReader {


    public Channel readRss(InputStream in) {

        try {
            List<Item> items = new ArrayList<>();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document document = documentBuilder.parse(in);

            NodeList rssFeed = document.getElementsByTagName("channel");
            String title=((Element)rssFeed.item(0)).getElementsByTagName("title").item(0).getTextContent();
            String link=((Element)rssFeed.item(0)).getElementsByTagName("link").item(0).getTextContent();
            String description=((Element)rssFeed.item(0)).getElementsByTagName("description").item(0).getTextContent();
            System.out.println(title+" "+link+" "+description);


            NodeList itemFeed = document.getElementsByTagName("item");
            for (int i = 0; i < itemFeed.getLength(); i++) {
            String itemTitle=((Element)itemFeed.item(i)).getElementsByTagName("title").item(0).getTextContent();
            String itemLink=((Element)itemFeed.item(i)).getElementsByTagName("link").item(0).getTextContent();
            String itemDescription=((Element)itemFeed.item(i)).getElementsByTagName("description").item(0).getTextContent();
                items.add(new Item(itemTitle, itemLink, itemDescription));
           }
           return new Channel(title,link,description,items);


        } catch (IOException | ParserConfigurationException | org.xml.sax.SAXException e) {
            e.printStackTrace();
            return null;
        }
    }
}
