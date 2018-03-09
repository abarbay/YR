package niopath;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Library {
    List<Book> books = new ArrayList<>();

    public void loadBooksFromFile(Path path) throws IOException {

        try (BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream(path.toFile())))) {

            String line = "";
            while ((line = read.readLine()) != null) {
                String currentLine = line;
                String[] content = currentLine.split(":");
                books.add(new Book(Long.valueOf(content[0]), content[1], content[2]));
            }


        } catch (NumberFormatException nfe) {
            throw new IOException("Non-parseable book data!");
        } catch (IndexOutOfBoundsException ioobe) {
            throw new IOException("Wrong book data!");
        }


    }

    public void writeBookListToFile(Path path) throws IOException {

        StringBuilder sb = new StringBuilder();
        for (Book book : books) {
            sb.append(book.toString() + "\n");
        }
        String bookString = sb.toString();
        bookString = bookString.trim();


        try (BufferedWriter write = new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(path)))) {
            write.write(bookString);
            write.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    public int bookListSize() {
        return books.size();
    }
}
