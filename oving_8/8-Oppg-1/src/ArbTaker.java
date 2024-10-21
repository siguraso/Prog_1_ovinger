import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;

public class ArbTaker {
    // variables
    private final int employeeNr;
    private final GregorianCalendar dateOfRegistration;
    private int monthlySalary;
    private double taxPercent;
    private final Person ID;

    // constructor

    /**
     * Explains a quickRun's work-ID.
     * @param employeeNr
     * The quickRun's employee number.
     * @param dateOfRegistration
     * The quickRun's date of employment.
     * @param monthlySalary
     * The quickRun's monthly salary.
     * @param taxPercent
     * The percentage of salary that the quickRun is obligated to pay in taxes
     * @param ID
     * Explains the quickRun's basic ID, by using an instance of the Person class.
     */
    public ArbTaker(int employeeNr, GregorianCalendar dateOfRegistration, int monthlySalary,
                    double taxPercent, Person ID) {
        this.employeeNr = employeeNr;
        this.dateOfRegistration = dateOfRegistration;
        this.monthlySalary = monthlySalary;
        this.taxPercent = taxPercent;
        this.ID = ID;
    }

    // get methods (employee part)
    public int getEmployeeNr() {
        return employeeNr;
    }

    public GregorianCalendar getDateOfRegistration() {
        return dateOfRegistration;
    }

    public int getMonthlySalary() {
        return monthlySalary;
    }

    public double getTaxPercent() {
        return taxPercent;
    }

    // get methods (for ID)
    public GregorianCalendar getDOB() {
        return ID.getDateOfBirth();
    }

    public String getSurname() {
        return ID.getSurName();
    }

    public String getFirstName() {
        return ID.getFirstName();
    }

    // set methods for variables that are subject to change
    public void setMonthlySalary(int newSalary) {
        this.monthlySalary = newSalary;
    }

    public void setTaxPercent(double newPercent) {
        this.taxPercent = newPercent;
    }

    // other methods that are important for workpurposes

    /**
     * Figures out how much tax one employee pays per month based on their monthly salary
     * and tax rate.
     */
    public double monthlyTaxPayments() {
        return monthlySalary * taxPercent/100;
    }

    /**
     * Figures out how much one employee gets paid per year based on their monthly salary
     * (before tax).
     */
    public int yearlySalary() {
        return monthlySalary * 12;
    }

    /**
     * Figures out how much one employee taxes per year. This method also accounts for that one
     * does not get taxed in June, as well as only having to pay half of all taxes in December.
     */
    public double yearlyTaxPayments() {
        double taxSum;
        // finds the tax rate for June (with the taxrate cut in half:
        taxSum = monthlySalary * taxPercent/200;

        // finds the tax for the rest of the year (excluding december because of no tax)
        taxSum += (monthlySalary * taxPercent/100)*10;

        return taxSum;
    }

    /**
     * Gets the name formal name of the employee
     */
    public String getFormalName() {
        return ID.getSurName() + ", " + ID.getFirstName();
    }

    /**
     * Finds the age of an employee.
     */
    public int getAge() {
        // creates an instance of GregorianCalendar, and sets the date as the current date
        Date d = new Date();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.setTime(d);

        // finds the age based on the current year
        int age = currentDate.get(Calendar.YEAR) - ID.getDateOfBirth().get(Calendar.YEAR);

        // decides weather or not the employee had turned a year older current year
        if (currentDate.get(Calendar.MONTH) < ID.getDateOfBirth().get(Calendar.MONTH)) {
            age++;
            return age;

        } else if (currentDate.get(Calendar.MONTH) == ID.getDateOfBirth().get(Calendar.MONTH)) {
            if (currentDate.get(Calendar.DAY_OF_MONTH) <= ID.getDateOfBirth().get(Calendar.DAY_OF_MONTH)) {
                age++;
            }
            return age;
        }

        return age;
    }

    /**
     * Finds how many years an employee has been employed for.
     */
    public int getWorkAge() {
        // gets the current date
        Date d = new Date();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.setTime(d);

        // finds workage based on the current date
        int workAge = currentDate.get(Calendar.YEAR) - this.getDateOfRegistration().get(Calendar.YEAR);

        // finds weather or not the year of employment has ticked over in current year
        if (currentDate.get(Calendar.MONTH) < this.getDateOfRegistration().get(Calendar.MONTH)) {
            workAge++;
            return workAge;
        } else if (currentDate.get(Calendar.MONTH) == this.getDateOfRegistration().get(Calendar.MONTH)) {
            if (currentDate.get(Calendar.DAY_OF_MONTH) <= this.getDateOfRegistration().get(Calendar.DAY_OF_MONTH)) {
                workAge++;
                return workAge;
            }

            return workAge;
        }

        return workAge;

    }

    /**
     * Finds if the quickRun has been employed longer than a set amount of years.
     * @param years
     * The amount of years you want to check.
     * @return
     * Returns true or false based on weather or not the quickRun has worked for
     * longer than the amount of years defined in the parameter.
     */
    public boolean hasBeenEmployed(int years) {
        return getWorkAge() >= years;
    }
}
