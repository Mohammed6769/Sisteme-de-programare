package lab3;

import java.io.*;
import java.util.*;

class Student {
    int id;
    String prenume;
    String nume;
    String grupa;

    public Student(int id, String prenume, String nume, String grupa) {
        this.id = id;
        this.prenume = prenume;
        this.nume = nume;
        this.grupa = grupa;
    }

    public String toString() {
        return id + "," + prenume + "," + nume + "," + grupa;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("in.txt"));
        String linie;

        System.out.println("Cerinta cu in.txt:");
        while ((linie = br.readLine()) != null) {
            System.out.println(linie);

            String[] bucati = linie.split("\\.");
            for (String b : bucati) {
                if (!b.trim().isEmpty()) {
                    System.out.println(b.trim() + ".");
                }
            }
        }
        br.close();

        List<Student> lista = new ArrayList<>();

        br = new BufferedReader(new FileReader("studenti.txt"));

        while ((linie = br.readLine()) != null) {
            String[] p = linie.split(",");

            lista.add(new Student(
                    Integer.parseInt(p[0]),
                    p[1],
                    p[2],
                    p[3]
            ));
        }
        br.close();

        Collections.sort(lista, (a, b) -> {
            int cmp = a.grupa.compareTo(b.grupa);
            if (cmp == 0) {
                return a.nume.compareTo(b.nume);
            }
            return cmp;
        });

        BufferedWriter bw = new BufferedWriter(new FileWriter("studenti_out_sorted.txt"));

        for (Student s : lista) {
            bw.write(s.toString());
            bw.newLine();
        }

        bw.close();

        System.out.println("Lista studentilor a fost sortata si salvata in studenti_out_sorted.txt");
    }
}