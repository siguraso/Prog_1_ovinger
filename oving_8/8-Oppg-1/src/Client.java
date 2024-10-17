import java.util.Calendar;
import java.util.GregorianCalendar;

// showcase for the functions not used in the interface class
public class Client {
    public static void main(String[] args) {
        ArbTaker donTommy = new ArbTaker(69,
                new GregorianCalendar(2022, Calendar.MARCH, 3),
                500000, 5, new Person("Don", "Tommy",
                new GregorianCalendar(2008, Calendar.JANUARY, 12)));

        System.out.println("Arbeidstaker: " + donTommy.getFormalName() +
                "\nFornavn: " + donTommy.getFirstName() +
                "\nEtternavn: " + donTommy.getSurname() +
                "\nFødselsdag: " + + donTommy.getDOB().get(Calendar.DAY_OF_MONTH) + "." + donTommy.getDOB().get(Calendar.MONTH) +
                "." + donTommy.getDOB().get(Calendar.YEAR) +
                "\nAlder: " + donTommy.getAge() +
                "\nAntall år i bedriften: " + donTommy.getWorkAge() +
                "\nSkatteprosent: " + donTommy.getTaxPercent() + "%" +
                "\nSkattetrekk pr. måned: " + donTommy.monthlyTaxPayments() +
                "\nSkattetrekk pr. år: " + donTommy.yearlyTaxPayments() +
                "\nBruttolønn pr. år: " + donTommy.yearlySalary() +
                "\nHar klienten vært ansatt i mer enn 1 år? " + donTommy.hasBeenEmployed(1) +
                "\nHar klienten vært ansatt i mer enn 3 år? " + donTommy.hasBeenEmployed(3));

    }
}
