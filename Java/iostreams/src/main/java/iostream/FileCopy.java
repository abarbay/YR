package iostream;

import java.io.*;

public class FileCopy {
    public void copyFile(String source, String target) {
        if (isEmpty(source) || isEmpty(target)) {
            throw new IllegalArgumentException("Source or target file name must not be empty");
        }
        File src = new File(source);
        File trgt = new File(target);

        if (!src.exists()) {
            throw new IllegalArgumentException("Source file cannot be found!");
        }


        byte[] buffer = new byte[1024];

        try (InputStream in = new BufferedInputStream(new FileInputStream(src));
             OutputStream out = new BufferedOutputStream(new FileOutputStream(trgt))
        ){
            int lengthRead;

            while ((lengthRead = in.read(buffer)) >= 0) {
                out.write(buffer, 0, lengthRead);
                out.flush();
            }
        }
     catch(
    IOException ioe){
        ioe.printStackTrace();
    }

}



    public void copyFile(File source, File target){
        if(source== null|| target==null) {throw new IllegalArgumentException("Source or target file name must not be empty");}

        if (!source.exists()) {
            throw new IllegalArgumentException("Source file cannot be found!");
        }

        byte[] buffer = new byte[1024];

        try (InputStream in = new BufferedInputStream(new FileInputStream(source));
             OutputStream out = new BufferedOutputStream(new FileOutputStream(target));
        ){
            int lengthRead;
            while ((lengthRead = in.read(buffer)) >= 0) {
                out.write(buffer, 0, lengthRead);
                out.flush();
            }
        }
        catch(
                IOException ioe){
            ioe.printStackTrace();
        }
    }




    private boolean isEmpty(String str){
        return (str==null || str.trim().isEmpty());
    }


}
