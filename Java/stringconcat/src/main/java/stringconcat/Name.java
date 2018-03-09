package stringconcat;

public class Name {
    private String familyName;
    private String middleName;
    private String givenName;
    private Title title;

    public Name(String familyName, String middleName, String givenName, Title title) {
        if(!isEmpty(familyName) && !isEmpty(givenName) ){
            this.familyName = familyName;
            this.givenName = givenName;
        }
        else {throw new IllegalArgumentException("Family name and given name must not be empty!");}
        if(middleName==null){
            this.middleName="";
        }
        else{this.middleName = middleName;}

        this.title = title;
    }

    public Name(String familyName, String middleName, String givenName) {
        if(!isEmpty(familyName) && !isEmpty(givenName)){
            this.familyName = familyName;
            this.givenName = givenName;
        }
        else{throw new IllegalArgumentException("Family name and given name must not be empty!");}
        if(middleName==null){
            this.middleName="";
        }
        else{this.middleName = middleName;}

        this.title=Title.EMPTY;
    }

    public boolean isEmpty(String str){
        boolean result=false;
        if(str=="" || str==null){result=true;}
        return result;
    }

    public String concatNameWesternStyle(){
        String result="";
        result+=title.getTitle()+" ";
        result+=givenName+" ";
        result+=middleName+" ";
        result+=familyName;
        return result.replace("  "," ").trim();
    };
    public String concatNameHungarianStyle(){
        String result="";
        result=title.getTitle().concat(" ").concat(familyName).concat(" ").concat(middleName).concat(" ").concat(givenName);
        return result.replace("  "," ").trim();
    };
}

