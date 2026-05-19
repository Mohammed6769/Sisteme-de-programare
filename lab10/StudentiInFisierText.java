package lab10;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class StudentiInFisierText implements IStudentiExport {

    private String fileName;

    public StudentiInFisierText(String fileName) {
        this.fileName = fileName;
    }

    public void doExport(List<Student> studenti) {
        try {
            FileWriter writer = new FileWriter(fileName);

            for (Student student : studenti) {
                writer.write(
                        student.getId() + ";" +
                                student.getPrenume() + ";" +
                                student.getNume() + ";" +
                                student.getFormatie() + ";" +
                                student.getNota() + "\n"
                );
            }

            writer.close();

            System.out.println("Studentii au fost exportati in fisierul text: " + fileName);

        } catch (IOException e) {
            System.out.println("Eroare la scrierea in fisier text.");
        }
    }
}