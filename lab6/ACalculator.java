package lab6;

public abstract class ACalculator<T> {
    Object state;

    public abstract ACalculator<T> init();

    public T result() {
        return (T) state;
    }

    public void clear() {
        state = null;
    }
}
