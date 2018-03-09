package solid.base;

public class AccountValidator implements Validator {

    @Override
    public boolean isValid(String userName) {
        boolean result=false;
        if(userName!=null){
            if(userName.length()>5 && !userName.contains(" ") ){
                result=true;
            }
        }
        return result;
    }
}
