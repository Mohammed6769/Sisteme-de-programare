package lab5;

public class AdvancedCalculator extends IntCalculator {

    public AdvancedCalculator(int state) {
        super(state);
    }

    @Override
    public AdvancedCalculator add(int value) {
        super.add(value);
        return this;
    }

    @Override
    public AdvancedCalculator subtract(int value) {
        super.subtract(value);
        return this;
    }

    @Override
    public AdvancedCalculator multiply(int value) {
        super.multiply(value);
        return this;
    }

    public AdvancedCalculator divide(int value) {
        state /= value;
        return this;
    }

    public AdvancedCalculator power(int exponent) {
        state = (int) Math.pow(state, exponent);
        return this;
    }

    public AdvancedCalculator root(int n) {
        state = (int) Math.pow(state, 1.0 / n);
        return this;
    }
}