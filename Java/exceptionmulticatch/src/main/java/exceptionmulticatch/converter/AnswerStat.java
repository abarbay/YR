package exceptionmulticatch.converter;

public class AnswerStat {
    BinaryStringConverter bsc = new BinaryStringConverter();

    public AnswerStat(BinaryStringConverter bsc) {
        this.bsc = bsc;
    }

    public boolean[] convert(String str) {

        try {
            return bsc.binaryStringToBooleanArray(str);
        } catch (NullPointerException | IllegalArgumentException ex) {
            throw new InvalidBinaryStringException(ex);
        }

    }

    public int answerTruePercent(String answers) {
        boolean[] answerResult = this.convert(answers);
        double result = 0;
        double sum = 0;
        double trueAnswers = 0;
        for (Boolean item : answerResult) {
            sum++;
            if (item) {
                trueAnswers++;
            }
        }
        result = (trueAnswers / sum) * 100;
        return (int) result;
    }


}
