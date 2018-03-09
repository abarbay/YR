

public class Main {
    public static void main(String[] args) {

        Reverse r = new Reverse();
        Metszet m = new Metszet();
        Lnko l = new Lnko();
        StringConverter s = new StringConverter();
        LetterCounter lc= new LetterCounter();
        Adder a = new Adder();
        Increase inc = new Increase();

        System.out.println(r.reverseString("12345"));

        int[] tomb = new int[]{1, 2, 3};
        int[] tomb = new int[]{1, 2, 4};
        int[] tomb = new int[]{3, 2, 1};

        System.out.println(m.szamol(tomb, 1, 3));

        System.out.println(s.converter("Adam"));

        System.out.println(l.GCD2(28,63));

        System.out.println(l.LCM(4,5));

        System.out.println(lc.cnt("aaabbbbcc"));

        System.out.println(a.add(123));

        System.out.println(inc.incdec(tomb));

    }
}
