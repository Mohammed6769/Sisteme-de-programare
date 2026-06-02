package lab11;

public abstract class ExportDecorator
        implements StudentExporter {

    protected StudentExporter exporter;

    public ExportDecorator(StudentExporter exporter) {
        this.exporter = exporter;
    }

    @Override
    public void export() {
        exporter.export();
    }
}