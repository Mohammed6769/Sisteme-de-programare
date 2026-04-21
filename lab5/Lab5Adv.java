package lab5;

public class Lab5Adv {
    public static void main(String[] args) {
        NewIntCalculator intCalc = new NewIntCalculator(10);
        Integer result1 = (Integer) intCalc.add(5).subtract(3).multiply(2).result();
        System.out.println("(10 + 5 - 3) * 2 = " + result1);

        DoubleCalculator doubleCalc = new DoubleCalculator(10.0);
        Double result2 = (Double) doubleCalc.add(5.0).subtract(3.3).multiply(2.2).result();
        System.out.println("(10 + 5 - 3.3) * 2.2 = " + result2);
    }
}