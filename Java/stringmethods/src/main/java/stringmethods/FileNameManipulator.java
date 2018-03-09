package stringmethods;

public class FileNameManipulator {

    public char findLastCharacter(String str){
        if(isEmpty(str)){
            throw new IllegalArgumentException("Empty string!");
        }else{
            str=str.trim();
            return str.charAt(str.length()-1);
        }
    }

    public String findFileExtension(String fileName){
        if(isEmpty(fileName.substring(0,fileName.indexOf('.'))) || isEmpty(fileName.substring(fileName.indexOf('.')+1))){
            throw new IllegalArgumentException("Invalid file name!");
        }
        else{
            return fileName.substring(fileName.indexOf("."));
        }
    }

    public boolean identifyFilesByExtension(String ext, String fileName){
        if(isEmpty(fileName.substring(0,fileName.indexOf("."))) || isEmpty(fileName.substring(fileName.indexOf(".")+1))){
            throw new IllegalArgumentException("Invalid argument!");
        }
        else{
            return fileName.substring(fileName.indexOf('.')+1).equals(ext);
        }
    }

   public boolean compareFilesByName(String searchedFileName, String actualFileName) {
       if (isEmpty(searchedFileName.trim()) || isEmpty(actualFileName.trim())) {
           throw new IllegalArgumentException("Invalid file name!");
       } else {
           return searchedFileName.toLowerCase().equals(actualFileName.toLowerCase());
       }
   }

    public String changeExtensionToLowerCase(String fileName){
        if (isEmpty(fileName.trim())) {
            throw  new IllegalArgumentException("Empty string!");
        } else {
            return fileName.substring(0, fileName.indexOf('.')+1) + fileName.substring(fileName.indexOf('.')+1).toLowerCase();
        }

    }
    public String replaceStringPart(String fileName, String present, String target){
        if (isEmpty(fileName) || isEmpty(present)|| isEmpty(target)) {
            throw  new IllegalArgumentException();
        } else if (!fileName.contains(present)) {
            return fileName;
        } else {
            return fileName.replace(present, target);
        }
    }



    private boolean isEmpty(String inputString) {
        return (inputString == null || inputString.isEmpty());
    }
}
