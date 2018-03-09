import builder.robot.Frame;

public class maintest {
    public static void main(String[] args) {
        byte[] bytes = {-1, 0, 1};

        Frame f = new Frame(bytes);

        System.out.println(f.toHexString());
    }
}
