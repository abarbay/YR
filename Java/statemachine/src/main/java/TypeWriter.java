public enum TypeWriter {
    UPPERCASE{TypeWriter next(){return TypeWriter.NORMAL;}},
    NORMAL{TypeWriter next(){return TypeWriter.UPPERCASE;}};

    abstract TypeWriter next();
}
