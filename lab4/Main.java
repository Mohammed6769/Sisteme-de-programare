package lab4;

import java.io.*;
import java.util.*;

public class Main {

    public static float gasesteNota(String prenume, String nume, HashMap<Integer, Student> tineri) {
        HashMap<String, Student> cautareDupaNume = new HashMap<>();

        for (Student s : tineri.values()) {
            String cheie = s.getPrenume() + "-" + s.getNume();
            cautareDupaNume.put(cheie, s);
        }

        String cheieCautata = prenume + "-" + nume;
        Student studentGasit = cautareDupaNume.get(cheieCautata);

        if (studentGasit != null) {
            return studentGasit.getNota();
        }

        return 0.0f;
    }

    public static void main(String[] args) throws Exception {

        List<Student> listaStudenti = new ArrayList<>();
        HashMap<Integer, Student> tineri = new HashMap<>();

        BufferedReader br = new BufferedReader(new FileReader("src/lab4/studenti.txt"));
        String linie;

        while ((linie = br.readLine()) != null) {
            String[] p = linie.split(",");

            Student s = new Student(
                    Integer.parseInt(p[0]),
                    p[1],
                    p[2],
                    p[3]
            );

            listaStudenti.add(s);
            tineri.put(s.getNrMatricol(), s);
        }

        br.close();

        BufferedReader br2 = new BufferedReader(new FileReader("src/lab4/note_anon.txt"));

        while ((linie = br2.readLine()) != null) {
            String[] p = linie.split(",");

            int nrMatricol = Integer.parseInt(p[0]);
            float nota = Float.parseFloat(p[1]);

            Student s = tineri.get(nrMatricol);
            if (s != null) {
                s.setNota(nota);
            }
        }

        br2.close();

        for (Map.Entry<Integer, Student> entry : tineri.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        float notaM = gasesteNota("Bianca", "Popescu", tineri);
        float notaN = gasesteNota("Ioan", "Popa", tineri);

        System.out.println("Nota Bianca Popescu: " + notaM);
        System.out.println("Nota Ioan Popa: " + notaN);
    }
}
