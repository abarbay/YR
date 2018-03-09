package properties;



import java.io.IOException;
import java.io.InputStream;
import java.util.*;



public class JavaTools {
    private Properties prop= new Properties();




    public Set<String> getToolKeys(){
        InputStream in =
                getClass().getClassLoader().getResourceAsStream("tools.properties");
        try {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Set<String>props=prop.stringPropertyNames();
        Set<String> result= new HashSet<>();
        for(String propNames:props){
            result.add(propNames.substring(0,propNames.indexOf(".")));
        }
        return result;
}

    public Set<String> getTools(){
        InputStream in =
                getClass().getClassLoader().getResourceAsStream("tools.properties");
        try {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Set<String> result= new HashSet<>();
            for(Map.Entry<Object, Object> e : prop.entrySet()) {
              String key = (String) e.getKey();
              String value= (String) e.getValue();
              if(key.contains("name")){
                  result.add(value);
              }
            }
        return result;
    }

    public String getName(String name){
        InputStream in =
                getClass().getClassLoader().getResourceAsStream("tools.properties");
        try {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String result=null;
        for(Map.Entry<Object, Object> e : prop.entrySet()) {
            String key = (String) e.getKey();
            String value= (String) e.getValue();
            if(key.contains(name)){
                result= value;
            }
        }
        return result;


    }

   public String getUrl(String name){
       InputStream in =
               getClass().getClassLoader().getResourceAsStream("tools.properties");
       try {
           prop.load(in);
       } catch (IOException e) {
           e.printStackTrace();
       }
       String result=null;
       for(Map.Entry<Object, Object> e : prop.entrySet()) {
           String key = (String) e.getKey();
           String value= (String) e.getValue();
           if(key.contains(name +".url")){
              result=value;
           }
       }
       return result;
   }






}
