package xml.gpx;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;


public class GpxReader {

    public List<TrackPoint> readTrack(InputStream in){

        try{
            List<TrackPoint> catalog = new ArrayList<>();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document document = documentBuilder.parse(in);

            NodeList trackList = document.getElementsByTagName("trkpt");

            for(int i=0;i<trackList.getLength();i++){
                double lat=Double.parseDouble(trackList.item(i).getAttributes().item(0).getNodeValue());
                double lon=Double.parseDouble(trackList.item(i).getAttributes().item(1).getNodeValue());
                int ele=Integer.parseInt(trackList.item(i).getChildNodes().item(0).getTextContent());
                ZonedDateTime time=ZonedDateTime.parse(trackList.item(i).getChildNodes().item(1).getTextContent());
                time=time.toLocalDateTime().atZone(ZoneId.of("UTC"));
                catalog.add(new TrackPoint(lat,lon,ele,time));
            }


        return catalog;

        }catch (IOException  | ParserConfigurationException | org.xml.sax.SAXException e ){
            e.printStackTrace();
            return null;
        }




    }

}
