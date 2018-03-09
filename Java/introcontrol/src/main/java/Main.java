import introcontrol.IntroControl;

public class Main {
    public static void main(String[] args) {
        IntroControl i1=new IntroControl();


        System.out.println("Nagyobb mint 10:"+i1.substractTenIfGreaterThanTen(11));
        System.out.println("Kisebb mint 10:"+i1.substractTenIfGreaterThanTen(9));
        System.out.println("Nem zéro:"+i1.describeNumber(9));
        System.out.println("Zéro:"+i1.describeNumber(0));
        System.out.println("Hello Joe:"+i1.greetingToJoe("Joe"));
        System.out.println("Nem Joe:"+i1.greetingToJoe("Jack"));
        System.out.println("Van bónusz:"+i1.calculateBonus(1200000));
        System.out.println("Nincs bónusz:"+i1.calculateBonus(578000));
        System.out.println("villanyóra1:"+i1.calculateMeterReadingsDifference(8911,9000));
        System.out.println("villanyóra2:"+i1.calculateMeterReadingsDifference(9811,111));
        i1.printNumbers(-8);
        i1.printNumbersBetween(1,5);
        i1.printNumbersBetween(-1,5);
        i1.printNumbersBetween(1,-5);
        i1.printNumbersBetweenAnyDirection(1,8);
        i1.printNumbersBetweenAnyDirection(8,1);
        i1.printNumbersBetweenAnyDirection(-8,1);
        i1.printOddNumbers(9);
    }
}
