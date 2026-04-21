package lab7;

import java.util.Random;

public class PasswordMaker {
    private static PasswordMaker instance = null;
    private static int callingCount = 0;

    private Random random = new Random();

    private PasswordMaker() {
    }

    public static PasswordMaker getInstance() {
        callingCount++;

        if (instance == null) {
            instance = new PasswordMaker();
        }

        return instance;
    }

    public String getPassword() {
        return "pass" + random.nextInt(1000);
    }

    public static int getCallingCounts() {
        return callingCount;
    }
}