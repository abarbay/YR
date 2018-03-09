package introexception.patient;

public class Patient {
    String name;
    String socialSecurityNumber;
    Integer yearOfBirth;

    public Patient(String name, String socialSecurityNumber, Integer yearOfBirth) {
        this.name = name;
        if(yearOfBirth<1900){
            throw new IllegalArgumentException("Invalid Year Of Birth:" +yearOfBirth);
        }

        if(!new SsnValidator().isValidSsn(socialSecurityNumber)){
            throw new IllegalArgumentException("Invalid Social Security Number:"+ socialSecurityNumber);
        }
        this.yearOfBirth=yearOfBirth;
        this.socialSecurityNumber = socialSecurityNumber;

    }

    public String getName() {
        return name;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public Integer getYearOfBirth() {
        return yearOfBirth;
    }





}
