package lab11;

public class TimeDecorator extends ExportDecorator {

    public TimeDecorator(StudentExporter exporter) {
        super(exporter);
    }

    @Override
    public void export() {

        long start = System.currentTimeMillis();

        exporter.export();

        long end = System.currentTimeMillis();

        System.out.println("Execution time: "
                + (end - start) + " ms");
    }
}