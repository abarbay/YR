package niofiles;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager {
    public File createFile(String filePath, String fileName) throws IOException {
        if (isEmpty(filePath)) { throw new IllegalArgumentException("Path must not be empty!");}
        Path p= Paths.get(filePath+File.separator+fileName);
        Files.createFile(p);
        return p.toFile();

    }
    public Path createSubDirectory(String pathName, String directory) throws IOException{
        if (isEmpty(pathName)) { throw new IllegalArgumentException("Path or directory name must not be empty!");}
        Path p=Paths.get(pathName+File.separator+directory);
        Files.createDirectory(p);
        return p;
    }
    public void copyFile(String source, String target, CopyOption option) throws IOException{
        if (isEmpty(source)) { throw new IllegalArgumentException("Source name must not be empty!");}
        Files.copy(Paths.get(source),Paths.get(target),option);
    }

    public void copyFile(InputStream source, String targetPath, String targetFileName) throws IOException{
        if(source==null) { throw new NullPointerException("Source must not be null!");}
        Path p=Paths.get(targetPath+File.separator+targetFileName);
        Files.copy(source,p);

    }
    public void moveFile(String source, String target) throws IOException{
        if (isEmpty(source)) { throw new IllegalArgumentException("Source name must not be empty!");}
        Files.move(Paths.get(source),Paths.get(target));
    }

    private boolean isEmpty(String str){
        return (str==null | str.trim().isEmpty());
    }
}
