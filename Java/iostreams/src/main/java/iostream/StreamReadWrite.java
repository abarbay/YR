package iostream;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StreamReadWrite {

    public String readUtfInput(String fileName, String charset){
        File input=new File(fileName);
        String line="";
        if(!input.exists()){throw new IllegalArgumentException("File with given name cannot be found:");}
        try(BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), charset)))

        {
          line=in.readLine();

        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
        return line;
    }

    public void writeDataToOutputStream(double[] data, String fileName) {


        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName))) {

            for (int i = 0; i < data.length; i++) {
                out.writeDouble(data[i]);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

   public List<Double> readDataFromInputStream(String fileName){
       File outputFile = new File(fileName);
       if (!outputFile.exists()) {
           throw new IllegalArgumentException();
       }

       List<Double> result= new ArrayList<>();

       try(DataInputStream in= new DataInputStream(new FileInputStream(fileName))){

            while(in.available()>0){
                result.add(in.readDouble());
            }



       }catch (IOException ioe){
           ioe.printStackTrace();
       }
    return result;
    }

}
