package classstructure;

import java.util.Date;

public class Client {
    private String name;
    private Date dateOfBirth;
    private String address;

    public Client(String name, Date dateOfBirth, String address) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    public void migrate(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAddress() {
        return address;
    }


}
