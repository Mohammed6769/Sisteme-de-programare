package lab5;

public class NewIntCalculator extends lab5.ACalculator {

    public NewIntCalculator(Integer value) {
        init(value);
    }

    @Override
    public void init(Object value) {
        state = (Integer) value;
    }

    public NewIntCalculator add(Integer value) {
        state = (Integer) state + value;
        return this;
    }

    public NewIntCalculator subtract(Integer value) {
        state = (Integer) state - value;
        return this;
    }

    public NewIntCalculator multiply(Integer value) {
        state = (Integer) state * value;
        return this;
    }
}