import java.util.ArrayList;

public class Oppgaveoversikt {
    private ArrayList<Student> studenter = new ArrayList<>();
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
        return this.studenter.get(studentIndex - 1).toString();
    }

    public int getAntStud() {
        return antStud;
    }

    public int getSpecificApproved(int studentIndex) {
        return this.studenter.get(studentIndex - 1).getAntOppg();
    }

    public void specificOkAntallOppg(int studentIndex, int toAdd) {
        this.studenter.get(studentIndex - 1).okAntOppg(toAdd);
    }

    /**
     * Adds a student to the list of students.
     * @param student
     * Defines the Student's name as well as how many tasks they have gotten approved.
     */
    public void addStudent(Student student) {
        // adds student to studenter list
        this.studenter.add(student);

        // adds a student to the total amount (the antStud variable)
        this.antStud += 1;
    }
}