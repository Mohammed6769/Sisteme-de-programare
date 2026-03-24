package lab4;

import java.util.Objects;

public class Student {
    private int nrMatricol;
    private String prenume;
    private String nume;
    private String grupa;
    private float nota;

    public Student(int nrMatricol, String prenume, String nume, String grupa) {
        this.nrMatricol = nrMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.grupa = grupa;
        this.nota = 0.0f;
    }

    public int getNrMatricol() {
        return nrMatricol;
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

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return nrMatricol + "," + prenume + "," + nume + "," + grupa + "," + nota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return nrMatricol == student.nrMatricol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nrMatricol);
    }
}
