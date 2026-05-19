package lab10;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentiDinFisierXlsx implements IStudentiImport {

    private String fileName;

    public StudentiDinFisierXlsx(String fileName) {
        this.fileName = fileName;
    }

    public List<Student> doImport() {
        List<Student> studenti = new ArrayList<>();

        try {
            FileInputStream inputStream = new FileInputStream(fileName);

            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);

                int id = (int) row.getCell(0).getNumericCellValue();
                String prenume = row.getCell(1).getStringCellValue();
                String nume = row.getCell(2).getStringCellValue();
                String formatie = row.getCell(3).getStringCellValue();
                double nota = row.getCell(4).getNumericCellValue();

                Student student = new Student(id, prenume, nume, formatie, nota);
                studenti.add(student);
            }

            workbook.close();
            inputStream.close();

            System.out.println("Studentii au fost cititi din fisierul Excel: " + fileName);

        } catch (Exception e) {
            System.out.println("Eroare la citirea din fisier Excel.");
        }

        return studenti;
    }
}