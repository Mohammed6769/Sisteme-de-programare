package lab10;

import java.util.List;

public class StudentiInConsola implements IStudentiExport {

    public void doExport(List<Student> studenti) {
        System.out.println("Studentii afisati in consola:");

        for (Student student : studenti) {
            System.out.println(student);
        }
    }
}