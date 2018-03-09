package builder.robot;

public class Frame {
    private byte[] bytes;


    public Frame(byte[] bytes) {
        this.bytes = bytes;
    }

    public byte[] getBytes() {
        return bytes;
    }
+
    public String toHexString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(String.format("%02X", bytes[i]));
            if (i < bytes.length - 1) {
                sb.append("-");
            }
        }
        return sb.toString();
    }
}
