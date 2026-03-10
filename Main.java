import java.util.ArrayList;
import java.util.List;

public class Main {

    public static boolean existaStudent(List<Student> lista, Student cautat) {

        for (Student s : lista) {

            if (s.getPrenume().equals(cautat.getPrenume()) &&
                    s.getNume().equals(cautat.getNume()) &&
                    s.getFormatieDeStudiu().equals(cautat.getFormatieDeStudiu())) {

                return true;
            }

        }

        return false;
    }

    public static void main(String[] args) {

        Student s1 = new Student(101, "Ion", "Popescu", "TI21/1");
        Student s2 = new Student(112, "Maria", "Popa", "TI21/1");
        Student s3 = new Student(120, "Alis", "Popa", "TI21/2");

        List<Student> listaStudenti = new ArrayList<>();

        listaStudenti.add(s1);
        listaStudenti.add(s2);
        listaStudenti.add(s3);

        System.out.println("Lista studenti:");

        for (Student s : listaStudenti) {

            System.out.println(
                    s.getNumarMatricol() + " " +
                            s.getPrenume() + " " +
                            s.getNume() + " " +
                            s.getFormatieDeStudiu()
            );

        }

        Student cautat1 = new Student(120, "Alis", "Popa", "TI21/2");
        Student cautat2 = new Student(112, "Maria", "Popa", "TI21/1");

        System.out.println("Alis exista: " + existaStudent(listaStudenti, cautat1));
        System.out.println("Maria exista: " + existaStudent(listaStudenti, cautat2));

    }
}