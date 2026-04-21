package lab6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NewIntCalculatorTest {

    @Test
    void testAddPositive() {
        NewIntCalculator calc = new NewIntCalculator();

        Integer result = calc.init().add(10).add(5).result();

        assertEquals(15, result);
    }

    @Test
    void testAddNegatives() {
        NewIntCalculator calc = new NewIntCalculator();

        Integer result = calc.init().add(-10).add(-5).result();

        assertEquals(-15, result);
    }

    @Test
    void testSubtractPositives() {
        NewIntCalculator calc = new NewIntCalculator();

        Integer result = calc.init().add(10).subtract(3).result();

        assertEquals(7, result);
    }

    @Test
    void testSubtractNegatives() {
        NewIntCalculator calc = new NewIntCalculator();

        Integer result = calc.init().add(-10).subtract(-5).result();

        assertEquals(-5, result);
    }

    @Test
    void testMultiplyPositives() {
        NewIntCalculator calc = new NewIntCalculator();

        Integer result = calc.init().add(10).multiply(2).result();

        assertEquals(20, result);
    }

    @Test
    void testMultiplyNegatives() {
        NewIntCalculator calc = new NewIntCalculator();

        Integer result = calc.init().add(-10).multiply(-2).result();

        assertEquals(20, result);
    }

    @Test
    void testMultiplyBy0() {
        NewIntCalculator calc = new NewIntCalculator();

        Integer result = calc.init().add(10).multiply(0).result();

        assertEquals(0, result);
    }

    @Test
    void testDividePositives() {
        NewIntCalculator calc = new NewIntCalculator();

        Integer result = calc.init().add(10).divide(2).result();

        assertEquals(5, result);
    }

    @Test
    void testDivideNegatives() {
        NewIntCalculator calc = new NewIntCalculator();

        Integer result = calc.init().add(-10).divide(-2).result();

        assertEquals(5, result);
    }

    @Test
    void testDivideBy0() {
        NewIntCalculator calc = new NewIntCalculator();

        assertThrows(ArithmeticException.class, () -> {
            calc.init().add(10).divide(0);
        });
    }

    @Test
    void testResult() {
        NewIntCalculator calc = new NewIntCalculator();

        Integer result = calc.init().add(7).result();

        assertEquals(7, result);
    }

    @Test
    void testClear() {
        NewIntCalculator calc = new NewIntCalculator();
        calc.init().add(10);
        calc.clear();

        assertNull(calc.result());
    }

    @Test
    void testInit() {
        NewIntCalculator calc = new NewIntCalculator();

        Integer result = calc.init().result();

        assertEquals(0, result);
    }
}