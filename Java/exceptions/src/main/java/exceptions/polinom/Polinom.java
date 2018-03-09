package exceptions.polinom;

public class Polinom {
    private double[] coefficients;

    public Polinom(double[] coefficients) {
        if (coefficients == null) {
            throw new NullPointerException("coefficients is null");
        }
        this.coefficients = coefficients;

    }

    public Polinom(String[] coefficientStrs) {
        if (coefficientStrs == null) {
            throw new NullPointerException("coefficientStrs is null");
        }
        double[] coefficientsTest = new double[coefficientStrs.length];
        try {
            for (int i = 0; i < coefficientStrs.length; i++) {
                coefficientsTest[i] = Double.parseDouble(coefficientStrs[i]);
            }
            coefficients = coefficientsTest;
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Illegal coefficients, not a number", nfe);
        }
    }

    public double[] getCoefficients() {
        return coefficients;
    }

    public double evaluate(double x) {
        double result = 0.0;
        double powNum = coefficients.length - 1;
        for (double coefficient : coefficients) {
            result += coefficient * (Math.pow(x, powNum));
            powNum--;
        }
        return result;
    }
}
