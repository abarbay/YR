package records;

public enum MarkType {
    A(5, "excellent"),
    B(4, "very good"),
    C(3, "improvement needed"),
    D(2, "close to fail"),
    F(1, "fail");

    private final int VALUE;
    private final String DESCRIPTION;

    MarkType(int VALUE, String DESCRIPTION) {
        this.VALUE = VALUE;
        this.DESCRIPTION = DESCRIPTION;
    }

    public int getVALUE() {
        return VALUE;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }
}
