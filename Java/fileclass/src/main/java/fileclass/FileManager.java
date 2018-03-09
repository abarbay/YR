package fileclass;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManager implements FilenameFilter {

    public void createFile(String file){
        File newFile=new File(file);

        if(newFile.exists()){throw new IllegalArgumentException("File with this name already exists");}
        try {
            newFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createSubDirectory(String path,String dirName){

        File newDir=new File(path,dirName);
        if(newDir.exists()){throw new IllegalArgumentException("Directory with this name already exists");}
        if(new File(path).exists()){
            newDir.mkdir();
        }
        else{
            newDir.mkdirs();
        }
    }

    public boolean deleteFile(String file){
        Boolean isDeleted=false;
        File deleteFile=new File(file);
        if(deleteFile.exists()){
            deleteFile.delete();
            isDeleted= true;
        }else{
            throw new IllegalArgumentException("File with this name does not exists");
        }
        return isDeleted;
    }

    public List<String> findDirectories(String rootDir,List<String> dirs){
        File root= new File(rootDir);
        //checks all files
        for(File file:root.listFiles()){
        // checks directory
            if(file.isDirectory()){
                dirs.add(file.toString());
                //recursion
                    if (isParentDir(file)) {
                        findDirectories(file.toString(),dirs);
                    }
                }
            }
        return dirs;
    }

    public List<String> listFilesByExtension(String directory,String extension){
        List<String> result=new ArrayList<>();
        File dir=new File(directory);
        if(dir.exists() && dir.isDirectory()){
            for(File file:dir.listFiles()){
                // check both file and extension
                if(file.isFile() && accept(file,extension)){
                    result.add(file.toString());
                }
            }
        }
        if (result.size()==0){
            throw new NullPointerException("No files found with extension");
        }else{return result;}
    }


    /*
    Checks the specified dir has any subdirectories
     */
    private boolean isParentDir(File dir){
        if(dir.isDirectory()){
            for(File file:dir.listFiles()){
                if(file.isDirectory()){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean accept(File file, String extension) {
        String fileString = file.toString();
        int index =  fileString.lastIndexOf(".");
        return fileString.substring(index + 1).equals(extension);
    }
}
