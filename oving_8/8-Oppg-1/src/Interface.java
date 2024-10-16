import java.util.GregorianCalendar;
import java.util.Calendar;

// simple client program to test the Person and ArbTaker classes
public class Main {
    public static void main(String[] args) {
        ArbTaker jonTommy = new ArbTaker(43,
                new GregorianCalendar(2007, Calendar.FEBRUARY, 22),
                82457, 25, new Person("Jon Tommy", "Aresen",
                new GregorianCalendar(1984, Calendar.MAY, 21)));


        System.out.println("Arbeidstaker: " + jonTommy.getFormalName() +
                "\nAlder: " + jonTommy.getAge() +
                "\nAntall år i bedriften: " + jonTommy.getWorkAge() +
                "\nSkattetrekk pr. måned: " + jonTommy.monthlyTaxPayments() +
                "\nSkattetrekk pr. år: " + jonTommy.yearlyTaxPayments() +
                "\nBruttolønn pr. år: " + jonTommy.yearlySalary() +
                "\nHar klienten jobbet i bedriften lengre enn 8 år? " + jonTommy.hasBeenEmployed(8) +
                "\nHar klienten jobbet i bedriften lengre enn 20 år? " + jonTommy.hasBeenEmployed(20));
    }
}
