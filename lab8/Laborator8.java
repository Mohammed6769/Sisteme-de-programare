package lab8;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class Laborator8 {

    public static void main(String[] args) {
        String input = "laborator8_input.xlsx";

        citesteFisier(input);
        copiazaCuMedie(input, "laborator8_output2.xlsx");
        copiazaCuFormula(input, "laborator8_output3.xlsx");
    }

    public static void citesteFisier(String fileName) {
        try (FileInputStream fis = new FileInputStream(fileName);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                for (Cell cell : row) {
                    if (cell.getCellType() == CellType.STRING) {
                        System.out.print(cell.getStringCellValue() + " ");
                    } else if (cell.getCellType() == CellType.NUMERIC) {
                        System.out.print(cell.getNumericCellValue() + " ");
                    }
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void copiazaCuMedie(String inputFile, String outputFile) {
        try (FileInputStream fis = new FileInputStream(inputFile);
             Workbook workbook1 = new XSSFWorkbook(fis);
             Workbook workbook2 = new XSSFWorkbook()) {

            Sheet sheet1 = workbook1.getSheetAt(0);
            Sheet sheet2 = workbook2.createSheet("Output");

            for (Row row1 : sheet1) {
                Row row2 = sheet2.createRow(row1.getRowNum());

                for (Cell cell1 : row1) {
                    Cell cell2 = row2.createCell(cell1.getColumnIndex());

                    if (cell1.getCellType() == CellType.STRING) {
                        cell2.setCellValue(cell1.getStringCellValue());
                    } else if (cell1.getCellType() == CellType.NUMERIC) {
                        cell2.setCellValue(cell1.getNumericCellValue());
                    }
                }

                int lastCol = row1.getLastCellNum();

                double suma = 0;
                int count = 0;

                for (int i = lastCol - 3; i < lastCol; i++) {
                    Cell c = row1.getCell(i);
                    if (c != null && c.getCellType() == CellType.NUMERIC) {
                        suma = suma + c.getNumericCellValue();
                        count++;
                    }
                }

                if (count > 0) {
                    row2.createCell(lastCol).setCellValue(suma / count);
                }
            }

            try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                workbook2.write(fos);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void copiazaCuFormula(String inputFile, String outputFile) {
        try (FileInputStream fis = new FileInputStream(inputFile);
             Workbook workbook1 = new XSSFWorkbook(fis);
             Workbook workbook2 = new XSSFWorkbook()) {

            Sheet sheet1 = workbook1.getSheetAt(0);
            Sheet sheet2 = workbook2.createSheet("Output");

            for (Row row1 : sheet1) {
                Row row2 = sheet2.createRow(row1.getRowNum());

                for (Cell cell1 : row1) {
                    Cell cell2 = row2.createCell(cell1.getColumnIndex());

                    if (cell1.getCellType() == CellType.STRING) {
                        cell2.setCellValue(cell1.getStringCellValue());
                    } else if (cell1.getCellType() == CellType.NUMERIC) {
                        cell2.setCellValue(cell1.getNumericCellValue());
                    }
                }

                int excelRow = row1.getRowNum() + 1;
                int lastCol = row1.getLastCellNum();

                row2.createCell(lastCol).setCellFormula("AVERAGE(D" + excelRow + ":F" + excelRow + ")");
            }

            try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                workbook2.write(fos);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}