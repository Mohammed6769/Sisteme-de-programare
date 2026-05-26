package lab11;

public class CsvExporter implements StudentExporter {

    @Override
    public void export() {

        System.out.println("Exporting students to CSV...");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Export finished.");
    }
}