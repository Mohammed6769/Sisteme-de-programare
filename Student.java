public class Student {

    int numarMatricol;
    String prenume;
    String nume;
    String formatieDeStudiu;

    Student(int numarMatricol, String prenume, String nume, String formatieDeStudiu) {
        this.numarMatricol = numarMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
    }

    String toStringStudent() {
        return numarMatricol + " " + prenume + " " + nume + " " + formatieDeStudiu;
    }
}