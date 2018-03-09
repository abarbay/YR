package builder.robot;

public class SetMovementCapabilityFrameBuilder {

    byte[] bytes = {4, 96, 10, 98, 8, 0};

    public SetMovementCapabilityFrameBuilder setMaximumSpeed(byte speed) {
        bytes[1] = speed;
        return this;
    }

    public SetMovementCapabilityFrameBuilder setMaximumRotationSpeed(byte speed) {
        bytes[2] = speed;
        return this;
    }

    public SetMovementCapabilityFrameBuilder setMaximumAcceleration(byte acceleration) {
        bytes[3] = acceleration;
        return this;
    }

    public SetMovementCapabilityFrameBuilder setMaximumRotationalAcceleration(byte acceleration) {
        bytes[4] = acceleration;
        return this;
    }

    public Frame build() {
        byte result = 0;
        for (int i = 0; i < bytes.length - 1; i++) {
            result += bytes[i];
        }
        bytes[5] = result;
        return new Frame(bytes);
    }

}
