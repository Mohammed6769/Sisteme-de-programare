package lab9;

public class Student {

    private int id;
    private String prenume;
    private String nume;
    private String formatie;
    private double nota;

    public Student(int id, String prenume, String nume, String formatie, double nota) {
        this.id = id;
        this.prenume = prenume;
        this.nume = nume;
        this.formatie = formatie;
        this.nota = nota;
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

    public String getFormatie() {
        return formatie;
    }

    public double getNota() {
        return nota;
    }

    public String toString() {
        return id + " " + prenume + " " + nume + " " + formatie + " nota: " + nota;
    }
}
