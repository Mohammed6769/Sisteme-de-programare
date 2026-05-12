package lab9;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        System.out.println("===== PROBLEMA 9.3.1 =====");
        problema931();

        System.out.println("\n===== PROBLEMA 9.3.2 =====");
        problema932();

        System.out.println("\n===== PROBLEMA 9.3.3 =====");
        problema933();
    }

    // 9.3.1
    // Creati o lista de 10 numere intregi aleatoare in intervalul [5..25]
    public static void problema931() {

        Random random = new Random();

        // creez lista cu 10 numere random intre 5 si 25
        List<Integer> numere = IntStream.range(0, 10)
                .map(i -> 5 + random.nextInt(21))
                .boxed()
                .collect(Collectors.toList());

        System.out.println("Lista initiala: " + numere);

        // a) Calculati suma elementelor folosind java streams si afisati.
        int suma = numere.stream()
                .reduce(0, (a, b) -> a + b);

        System.out.println("Suma elementelor: " + suma);

        // b) Calculati valoarea maxima si minima in lista. Afisati.
        int maxim = numere.stream()
                .max(Comparator.naturalOrder())
                .get();

        int minim = numere.stream()
                .min(Comparator.naturalOrder())
                .get();

        System.out.println("Maxim: " + maxim);
        System.out.println("Minim: " + minim);

        // c) Pastrati doar elementele in intervalul [10..20]. Afisati.
        List<Integer> intre10si20 = numere.stream()
                .filter(n -> n >= 10 && n <= 20)
                .collect(Collectors.toList());

        System.out.println("Numere intre 10 si 20: " + intre10si20);

        // d) Transformati lista de intregi in lista de Double. Afisati.
        List<Double> numereDouble = numere.stream()
                .map(n -> Double.valueOf(n))
                .collect(Collectors.toList());

        System.out.println("Lista Double: " + numereDouble);

        // e) Afisati daca in lista se gaseste valoarea 12.
        boolean exista12 = numere.stream()
                .anyMatch(n -> n == 12);

        System.out.println("Exista valoarea 12? " + exista12);
    }

    // 9.3.2
    // Avand textul "Acesta este un program scris in java pentru expresii lambda"
    public static void problema932() {

        String text = "Acesta este un program scris in java pentru expresii lambda";

        // creez lista de cuvinte
        List<String> cuvinte = Arrays.asList(text.split(" "));

        System.out.println("Lista initiala: " + cuvinte);

        // a) parcurgeti si numarati cuvintele ale caror lungime este mai mare sau egala de 5 caractere.
        List<String> cuvinteFiltrate = cuvinte.stream()
                .filter(cuvant -> cuvant.length() >= 5)
                .collect(Collectors.toList());

        long numarCuvinte = cuvinte.stream()
                .filter(cuvant -> cuvant.length() >= 5)
                .count();

        System.out.println("Cuvinte cu lungime >= 5: " + cuvinteFiltrate);
        System.out.println("Numar cuvinte cu lungime >= 5: " + numarCuvinte);

        // b) ordonati lista noua si apoi afisati
        List<String> cuvinteOrdonate = cuvinteFiltrate.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Lista ordonata: " + cuvinteOrdonate);

        // c) afisati un element care incepe cu litera 'p'
        Optional<String> cuvantCuP = cuvinte.stream()
                .filter(cuvant -> cuvant.startsWith("p"))
                .findFirst();

        if (cuvantCuP.isPresent()) {
            System.out.println("Primul cuvant care incepe cu p: " + cuvantCuP.get());
        } else {
            System.out.println("Nu exista cuvant care incepe cu p");
        }
    }

    // 9.3.3
    public static void problema933() {

        List<Student> studentiCuNote = Arrays.asList(
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

        System.out.println("Lista initiala studenti:");
        studentiCuNote.forEach(student -> System.out.println(student));

        // a) Afisati studentii cu nota 10.
        List<Student> studentiNota10 = studentiCuNote.stream()
                .filter(student -> student.getNota() == 10)
                .collect(Collectors.toList());

        System.out.println("\nStudenti cu nota 10:");
        studentiNota10.forEach(student -> System.out.println(student));

        // b) Afisati studentii cu nota sub 5.
        List<Student> studentiSub5 = studentiCuNote.stream()
                .filter(student -> student.getNota() < 5)
                .collect(Collectors.toList());

        System.out.println("\nStudenti cu nota sub 5:");
        studentiSub5.forEach(student -> System.out.println(student));

        // c) Studentii cu nota < 4 devin studenti cu nota 4.
        List<Student> studentiModificati = studentiCuNote.stream()
                .map(student -> {
                    if (student.getNota() < 4) {
                        return new Student(
                                student.getId(),
                                student.getPrenume(),
                                student.getNume(),
                                student.getFormatie(),
                                4
                        );
                    } else {
                        return student;
                    }
                })
                .collect(Collectors.toList());

        System.out.println("\nLista dupa modificare, notele sub 4 devin 4:");
        studentiModificati.forEach(student -> System.out.println(student));

        // d) Calculati suma notelor tuturor studentilor.
        double sumaNote = studentiCuNote.stream()
                .map(student -> student.getNota())
                .reduce(0.0, (a, b) -> a + b);

        System.out.println("\nSuma notelor: " + sumaNote);

        // e) Calculati media.
        double media = sumaNote / studentiCuNote.size();

        System.out.println("Media notelor: " + media);
    }
}