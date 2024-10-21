public class quickRun {
    public static void main(String[] args) {
        Oppgaveoversikt oo = new Oppgaveoversikt();

        // Student 1:
        Student smartFella = new Student("Smart Fella", 10);

        // Student 2:
        Student fartSmella = new Student("Fart Smella", 0);

        oo.addStudent(smartFella);
        oo.addStudent(fartSmella);

        System.out.println("Antall studenter: " + oo.getAntStud());

        System.out.println(oo.toString(1));
        System.out.println(oo.toString(2));

        System.out.println("\nFart Smella: " + oo.getSpecificApproved(2));
        System.out.println("\nSmart Fella: " + oo.getSpecificApproved(1));

        oo.specificOkAntallOppg(1, 2);
        System.out.println("\nadded 2 to smart fella.");

        oo.specificOkAntallOppg(2, -2);
        System.out.println("\nremoved 2 from fart smella (because he is that shit). \n");

        System.out.println(oo.toString(1));
        System.out.println(oo.toString(2));


    }
}