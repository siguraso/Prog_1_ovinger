import java.util.ArrayList;

public class Oppgaveoversikt {
    private ArrayList<Student> studenter;
    private int antStud = 0;

    /**
     * An overview over how many tasks a list of students have completed and approved.
     */
    Oppgaveoversikt() {}

    Oppgaveoversikt(ArrayList<Student> studenter) {
        this.studenter = studenter;
        this.antStud = studenter.size();
    }

    public String toString(int studentIndex) {
        return this.studenter.get(studentIndex + 1).toString();
    }

    public int getAntStud() {
        return antStud;
    }

    public int getSpecificApproved(int studentIndex) {
        return this.studenter.get(studentIndex + 1).getAntOppg();
    }

    public void specificOkAntallOppg(int studentIndex, int toAdd) {
        this.studenter.get(studentIndex + 1).okAntOppg(toAdd);
    }

    public void addStudent(Student student) {
        this.studenter.add(student);
    }
}