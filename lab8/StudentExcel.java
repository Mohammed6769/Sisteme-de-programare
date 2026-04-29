package lab8;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentExcel {

    public static void main(String[] args) {
        List<Student> studenti = new ArrayList<>();

        studenti.add(new Student(120, "Alis", "Popa", "TI21/2"));
        studenti.add(new Student(112, "Maria", "Popa", "TI21/1"));
        studenti.add(new Student(101, "Ion", "Ionescu", "TI21/3"));

        String fisier = "laborator8_students.xlsx";

        writeToXls(studenti, fisier);

        List<Student> studentiCititi = readFromXls(fisier);

        System.out.println("Studenti cititi din fisier:");
        for (Student st : studentiCititi) {
            System.out.println(st);
        }
    }

    public static void writeToXls(List<Student> studenti, String fileName) {
        try (Workbook workbook = new XSSFWorkbook()) {

            Sheet sheet = workbook.createSheet("Studenti");

            int rowNum = 0;

            for (Student st : studenti) {
                Row row = sheet.createRow(rowNum++);

                row.createCell(0).setCellValue(st.getId());
                row.createCell(1).setCellValue(st.getPrenume());
                row.createCell(2).setCellValue(st.getNume());
                row.createCell(3).setCellValue(st.getGrupa());
            }

            try (FileOutputStream fos = new FileOutputStream(fileName)) {
                workbook.write(fos);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Student> readFromXls(String fileName) {
        List<Student> studenti = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(fileName);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                int id = (int) row.getCell(0).getNumericCellValue();
                String prenume = row.getCell(1).getStringCellValue();
                String nume = row.getCell(2).getStringCellValue();
                String grupa = row.getCell(3).getStringCellValue();

                studenti.add(new Student(id, prenume, nume, grupa));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return studenti;
    }
}