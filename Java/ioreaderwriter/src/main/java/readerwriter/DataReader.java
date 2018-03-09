package readerwriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

    public static String CHARSET_UTF8 = "UTF-8";


    public List<Book> readBookData(String fileName, String encoding) {
        if (isEmpty(fileName)) {
            throw new IllegalArgumentException("File name must not be empty!");
        }
        if (isEmpty(encoding)) {
            throw new IllegalArgumentException("Encoding must not be empty!");
        }
        File file = new File(fileName);
        if (!file.exists()) {
            throw new IllegalArgumentException("File not found:");
        }

        List<Book> result = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream(file), encoding))) {

            String line = "";
            while ((line = read.readLine()) != null) {
                String currentLine = line;
                String[] content = currentLine.split(":");
                result.add(new Book(Long.valueOf(content[0]), content[1], content[2]));
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return result;
    }

    public List<Book> readBookData(String fileName) {
        return readBookData(fileName, CHARSET_UTF8);
    }

    private boolean isEmpty(String str) {
        return (str == null || str.trim().isEmpty());
    }
}
