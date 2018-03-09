package introexception.patient;

public class SsnValidator {

    public boolean isValidSsn(String socialSecurityNumber){
        Boolean result=false;

        if (socialSecurityNumber.length()==9) {
            int sum = 0;
            for (int i = 0; i < 8; i++) {
                char c = socialSecurityNumber.charAt(i);
                if (i % 2!= 0) {
                    sum += Character.getNumericValue(c) * 7;
                } else if (i % 2 == 0 ) {
                    sum += Character.getNumericValue(c) * 3;
                }
            }
            if (sum % 10 == Character.getNumericValue(socialSecurityNumber.charAt(8))) {
                result = true;
            }

        }
        return result;
    }
}
