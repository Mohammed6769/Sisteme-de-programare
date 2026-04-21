package lab6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DoubleCalculatorTest {

    @Test
    void testAddPositive() {
        DoubleCalculator calc = new DoubleCalculator();

        Double result = calc.init().add(10.0).add(5.0).result();

        assertEquals(15.0, result, 0.0001);
    }

    @Test
    void testAddNegatives() {
        DoubleCalculator calc = new DoubleCalculator();

        Double result = calc.init().add(-10.0).add(-5.0).result();

        assertEquals(-15.0, result, 0.0001);
    }

    @Test
    void testSubtractPositives() {
        DoubleCalculator calc = new DoubleCalculator();

        Double result = calc.init().add(10.0).subtract(3.3).result();

        assertEquals(6.7, result, 0.0001);
    }

    @Test
    void testSubtractNegatives() {
        DoubleCalculator calc = new DoubleCalculator();

        Double result = calc.init().add(-10.0).subtract(-5.0).result();

        assertEquals(-5.0, result, 0.0001);
    }

    @Test
    void testMultiplyPositives() {
        DoubleCalculator calc = new DoubleCalculator();

        Double result = calc.init().add(10.0).multiply(2.2).result();

        assertEquals(22.0, result, 0.0001);
    }

    @Test
    void testMultiplyNegatives() {
        DoubleCalculator calc = new DoubleCalculator();

        Double result = calc.init().add(-10.0).multiply(-2.0).result();

        assertEquals(20.0, result, 0.0001);
    }

    @Test
    void testMultiplyBy0() {
        DoubleCalculator calc = new DoubleCalculator();

        Double result = calc.init().add(10.0).multiply(0.0).result();

        assertEquals(0.0, result, 0.0001);
    }

    @Test
    void testDividePositives() {
        DoubleCalculator calc = new DoubleCalculator();

        Double result = calc.init().add(10.0).divide(2.0).result();

        assertEquals(5.0, result, 0.0001);
    }

    @Test
    void testDivideNegatives() {
        DoubleCalculator calc = new DoubleCalculator();

        Double result = calc.init().add(-10.0).divide(-2.0).result();

        assertEquals(5.0, result, 0.0001);
    }

    @Test
    void testDivideBy0() {
        DoubleCalculator calc = new DoubleCalculator();

        Double result = calc.init().add(10.0).divide(0.0).result();

        assertTrue(Double.isInfinite(result));
    }

    @Test
    void testResult() {
        DoubleCalculator calc = new DoubleCalculator();

        Double result = calc.init().add(7.5).result();

        assertEquals(7.5, result, 0.0001);
    }

    @Test
    void testClear() {
        DoubleCalculator calc = new DoubleCalculator();
        calc.init().add(10.0);
        calc.clear();

        assertNull(calc.result());
    }

    @Test
    void testInit() {
        DoubleCalculator calc = new DoubleCalculator();

        Double result = calc.init().result();

        assertEquals(0.0, result, 0.0001);
    }
}