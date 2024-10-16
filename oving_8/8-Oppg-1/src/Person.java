import java.util.GregorianCalendar;


public class Person {
    // variables
    private final String firstName;
    private final String surName;
    GregorianCalendar dateOfBirth;

    // constructor

    /**
     * A client's basic ID.
     * @param firstName
     * The first name of client
     * @param surName
     * The surname of client
     * @param dateOfBirth
     * the date of birth of client
     */
    public Person(String firstName, String surName, GregorianCalendar dateOfBirth) {
        this.firstName = firstName;
        this.surName = surName;
        this.dateOfBirth = dateOfBirth;
    }

    // get-methods
    public String getFirstName() {
        return firstName;
    }

    public String getSurName() {
        return surName;
    }

    public GregorianCalendar getDateOfBirth() {
        return dateOfBirth;
    }
}
