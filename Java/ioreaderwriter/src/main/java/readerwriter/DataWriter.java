package readerwriter;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class DataWriter {

    public static String CHARSET_UTF8 = "UTF-8";

    public void writeBookData(List<Book> bookList, String fileName, String encoding) {
        if (isEmpty(fileName)) {
            throw new IllegalArgumentException("File name must not be empty!");
        }
        if (isEmpty(encoding)) {
            throw new IllegalArgumentException("Encoding must not be empty!");
        }

        StringBuilder sb = new StringBuilder();
        for (Book book : bookList) {
            sb.append(book.getId() + ":" + book.getAuthor() + ":" + book.getTitle() + "\n");
        }
        String bookString = sb.toString();


        try (BufferedWriter write = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), encoding))) {
            write.write(bookString);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


    }

    public void writeBookData(List<Book> bookList, String fileName) {
        writeBookData(bookList, fileName, CHARSET_UTF8);
    }

    private boolean isEmpty(String str) {
        return (str == null || str.trim().isEmpty());
    }

}
