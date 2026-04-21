package lab5;



public class IntCalculator {
    protected int state;

    public IntCalculator(int state) {
        this.state = state;
    }

    public IntCalculator add(int value) {
        state += value;
        return this;
    }

    public IntCalculator subtract(int value) {
        state -= value;
        return this;
    }

    public IntCalculator multiply(int value) {
        state *= value;
        return this;
    }

    public int result() {
        return state;
    }

    public void clear() {
        state = 0;
    }
}
