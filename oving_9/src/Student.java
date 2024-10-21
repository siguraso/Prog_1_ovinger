public class Student {
    private final String name;
    private int antOppg;

    /**
     * Overview over the amount of tasks that a student has completed and approved.
     * @param name
     * The student's name.
     * @param antOppg
     * The amount of tasks that the student has completed as well as approved.
     */
    Student(String name, int antOppg) {
        this.name = name;
        this.antOppg = antOppg;
    }

    public String getName() {
        return name;
    }

    public int getAntOppg() {
        return antOppg;
    }

    public void okAntOppg(int okning) {
        this.antOppg += okning;
    }

    public String toString() {
        return this.getName() + ", Godkjent: " + this.getAntOppg() + " oppgaver.";
    }

}