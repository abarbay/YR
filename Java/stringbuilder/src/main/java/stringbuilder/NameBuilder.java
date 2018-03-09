package stringbuilder;

public class NameBuilder {

    public boolean isEmpty(String str){
        boolean result=false;
        if(str=="" || str==null){result=true;}
        return result;
    }

    public String concatNameWesternStyle(String familyName, String middleName, String givenName, Title title) {

        if (isEmpty(familyName) || isEmpty(givenName)) {
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }
            StringBuilder sb= new StringBuilder();
            if(title!=null){
                sb.append(title.getTitle());
                sb.append(" ");
            }
            sb.append(givenName);
            sb.append(" ");
            if(!isEmpty(middleName)){
                sb.append(middleName);
                sb.append(" ");
            }
            sb.append(familyName);
            return sb.toString();


    }

    public String concatNameHungarianStyle(String familyName, String middleName, String givenName, Title title){
        if(isEmpty(familyName) || isEmpty(givenName) ){
            throw new IllegalArgumentException("Family name and given name must not be empty!");}
        else{

        }
        StringBuilder sb= new StringBuilder();
        if(title!=null){
            sb.append(title.getTitle());
            sb.append(" ");
        }
        sb.append(familyName);
        sb.append(" ");

        if(!isEmpty(middleName)){
            sb.append(middleName);
            sb.append(" ");
        }
        sb.append(givenName);
        return sb.toString();
    }

    public String insertTitle(String name, Title title, String where){
        StringBuilder sb= new StringBuilder(name);
        sb.insert(sb.indexOf(where)+1,title.getTitle()+" ");
        return sb.toString();
    }

    public String deleteNamePart(String name, String delete){
        StringBuilder sb= new StringBuilder(name);
        sb.delete(sb.indexOf(delete),sb.indexOf(delete)+delete.length());
        return sb.toString();
    }

    public boolean isPalindrome(String word){
        StringBuilder sb= new StringBuilder(word);
        return sb.toString().equals(sb.reverse().toString());
    }




}
