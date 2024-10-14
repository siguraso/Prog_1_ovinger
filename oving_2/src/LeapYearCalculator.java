import java.util.Scanner;

public class LeapYearCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Skriv inn året: ");
        int year = input.nextInt();

        if (year%4 == 0 | year%400 == 0){
            if (year == 0){
                System.out.println("År " + year + " finnes faktisk ikke :)");
            }
            else {
                System.out.println("Dette er et skuddår. :):)");
            }
        }

        else {
            System.out.println("Dette er IKKE et skuddår. :(:(:(");
        }
    }
}
