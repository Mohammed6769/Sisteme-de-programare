package lab10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentiDinFisierText implements IStudentiImport {

    private String fileName;

    public StudentiDinFisierText(String fileName) {
        this.fileName = fileName;
    }

    public List<Student> doImport() {
        List<Student> studenti = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            String linie;

            while ((linie = reader.readLine()) != null) {
                String[] parti = linie.split(";");

                int id = Integer.parseInt(parti[0]);
                String prenume = parti[1];
                String nume = parti[2];
                String formatie = parti[3];
                double nota = Double.parseDouble(parti[4]);

                Student student = new Student(id, prenume, nume, formatie, nota);
                studenti.add(student);
            }

            reader.close();

            System.out.println("Studentii au fost cititi din fisierul text: " + fileName);

        } catch (IOException e) {
            System.out.println("Eroare la citirea din fisier text.");
        }

        return studenti;
    }
}