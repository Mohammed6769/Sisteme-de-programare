package lab5;

public class DoubleCalculator extends lab5.ACalculator {

    public DoubleCalculator(Double value) {
        init(value);
    }

    @Override
    public void init(Object value) {
        state = (Double) value;
    }

    public DoubleCalculator add(Double value) {
        state = (Double) state + value;
        return this;
    }

    public DoubleCalculator subtract(Double value) {
        state = (Double) state - value;
        return this;
    }

    public DoubleCalculator multiply(Double value) {
        state = (Double) state * value;
        return this;
    }
}