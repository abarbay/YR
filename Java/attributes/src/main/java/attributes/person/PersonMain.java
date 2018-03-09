package attributes.person;



public class PersonMain {
    public static void main(String[] args) {
        Person p1= new Person();
        p1.correctData("Mekk Elek","12345");
        p1.moveTo(new Address("Hungary","Budapest","Fő utca 2.","1085"));
        System.out.println(p1.personToString());
        System.out.println(p1.getAddress().addressToString());


    }
}
