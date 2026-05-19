package lab10;

import java.util.Arrays;
import java.util.List;

public class AplicatieCuStrategy {

    public static void main(String[] args) {

        List<Student> studenti = Arrays.asList(
                new Student(1025, "Andrei", "Popa", "ISM141/2", 8.70),
                new Student(1024, "Ioan", "Mihalcea", "ISM141/1", 10),
                new Student(1026, "Anamaria", "Prodan", "TI131/1", 8.90),
                new Student(1029, "Bianca", "Popescu", "TI131/1", 10),
                new Student(1029, "Maria", "Pana", "TI131/2", 4.10),
                new Student(1029, "Gabriela", "Mohanu", "TI131/2", 7.33),
                new Student(1029, "Marius", "Nasta", "TI131/2", 3.20),
                new Student(1029, "Marius", "Nasta", "TI131/1", 5.12),
                new Student(1029, "Andrei", "Dobrescu", "TI131/2", 2.22)
        );

        Exporter exporter = new Exporter();

        // a) Strategy pentru afisare in consola
        IStudentiExport strategyConsole = new StudentiInConsola();
        exporter.startExport(strategyConsole, studenti);

        System.out.println();

        // b) Strategy pentru export in fisier txt
        IStudentiExport strategyFisierText = new StudentiInFisierText("studentiStrategyText.txt");
        exporter.startExport(strategyFisierText, studenti);

        System.out.println();

        // c) Strategy pentru export in fisier xlsx
        IStudentiExport strategyFisierExcel = new StudentiInFisierXlsx("studentiStrategyExcel.xlsx");
        exporter.startExport(strategyFisierExcel, studenti);

        System.out.println();

        // d) Strategy pentru citire din fisier txt
        Importer importer = new Importer();

        IStudentiImport strategyCitireText = new StudentiDinFisierText("studentiStrategyText.txt");
        List<Student> studentiCititiDinText = importer.startImport(strategyCitireText);

        System.out.println("Studenti cititi din fisier text:");
        studentiCititiDinText.forEach(student -> System.out.println(student));

        System.out.println();

        // e) Strategy pentru citire din fisier xlsx
        IStudentiImport strategyCitireExcel = new StudentiDinFisierXlsx("studentiStrategyExcel.xlsx");
        List<Student> studentiCititiDinExcel = importer.startImport(strategyCitireExcel);

        System.out.println("Studenti cititi din fisier Excel:");
        studentiCititiDinExcel.forEach(student -> System.out.println(student));
    }
}