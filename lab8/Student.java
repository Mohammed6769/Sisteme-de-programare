package lab8;

public class Student {
    private int id;
    private String prenume;
    private String nume;
    private String grupa;

    public Student(int id, String prenume, String nume, String grupa) {
        this.id = id;
        this.prenume = prenume;
        this.nume = nume;
        this.grupa = grupa;
    }

    public int getId() {
        return id;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getNume() {
        return nume;
    }

    public String getGrupa() {
        return grupa;
    }

    public String toString() {
        return id + " " + prenume + " " + nume + " " + grupa;
    }
}
