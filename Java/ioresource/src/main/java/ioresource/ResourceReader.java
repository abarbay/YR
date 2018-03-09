package ioresource;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ResourceReader {

    public List<Book> readResource(String resource) {
        return readBookData(this.getClass().getClassLoader().getResourceAsStream(resource));

    }

    public List<Book> readBookData(InputStream inputStream) {
        if (inputStream == null) {
            throw new DataException("Resource cannot be found!");
        }

        List<Book> result = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new InputStreamReader(inputStream))) {

            String line = "";
            while ((line = read.readLine()) != null) {
                String currentLine = line;
                String[] content = currentLine.split(":");
                result.add(new Book(Long.valueOf(content[0]), content[1], content[2]));
            }


        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DataException("Data corrupted at:");
        } catch (Exception e) {
            throw new DataException("Data cannot be read or data corrupted at line:");
        }

        return result;


    }

}
