package lab7;

public class Form {
    private String color;

    private static int instanceCount = 0;

    public Form(String color) {
        this.color = color;
        instanceCount++;
    }

    public String getColor() {
        return color;
    }

    public static int getInstanceCount() {
        return instanceCount;
    }
}