package lab11;

public class MainDecorator {

    public static void main(String[] args) {

        StudentExporter exporter =
                new CsvExporter();

        StudentExporter decoratedExporter =
                new TimeDecorator(exporter);

        decoratedExporter.export();
    }
}