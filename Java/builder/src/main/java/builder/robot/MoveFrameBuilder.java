package builder.robot;

public class MoveFrameBuilder {

    private byte[] bytes = new byte[6];

    public MoveFrameBuilder setXSpeed(byte speed) {
        bytes[1] = speed;
        return this;
    }

    public MoveFrameBuilder setYSpeed(byte speed) {
        bytes[2] = speed;
        return this;
    }

    public MoveFrameBuilder setRotationSpeed(byte speed) {
        bytes[3] = speed;
        return this;
    }

    public MoveFrameBuilder setMaximumSpeed(byte speed) {
        bytes[4] = speed;
        return this;
    }

    public Frame build() {
        bytes[0] = 125;
        byte result = 0;
        for (int i = 0; i < bytes.length - 1; i++) {
            result += bytes[i];
        }
        bytes[5] = result;
        return new Frame(bytes);
    }

}
