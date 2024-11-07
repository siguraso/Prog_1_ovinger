import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class InNotEvenPastTheMenu {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    ArrayList<Arrangement> arrangements = new ArrayList<>();
    ArrangementRegister ar = new ArrangementRegister(arrangements);

    choiceWindow mainMenu = new choiceWindow();
    mainMenu.addChoice("add a new arrangement");
    mainMenu.addChoice("search by date");
    mainMenu.addChoice("search by timeframe (between to dates)");
    mainMenu.addChoice("sort list");
    mainMenu.addChoice("exit");

    while (true) {
      clearScreen();
      for (Arrangement arrangement : ar.getArrangements()) {
        System.out.println(arrangement.getName() + ", " + arrangement.getLocation() +
            ", " + arrangement.getTypeOfArrangement() + ", " + arrangement.getTime());
      }

      int mainmenuchoice = mainMenu.choiceSequnce("What would you like yo do?", sc);

      switch (mainmenuchoice) {
        case 1:
          addNewArrangement(sc, ar);
          break;
        case 2:
          searchByDate(sc, ar);
          break;
        case 3:
          searchBetweenDate(sc, ar);
          break;
        case 4:
          ar.sortArrangements();
          break;
        case 5:
          sc.close();
          System.exit(0);
      }
    }
  }

  public static void clearScreen() {
    System.out.println("\033[H\033[2J");
    System.out.flush();
  }

  public static void addNewArrangement(Scanner sc, ArrangementRegister ar) {
    clearScreen();
    System.out.println("what is the name of the arrangement?");
    String name = sc.nextLine();

    System.out.println("what is the time of the arrangement? (YYYYMMDDHHMM)");
    long date = sc.nextLong();

    System.out.println("where is the arrangement?");
    String location = sc.nextLine();

    System.out.println("what type of arrangement is it?");
    String type = sc.nextLine();

    System.out.println("what is the ID of the arrangement?");
    int id = sc.nextInt();

    System.out.println("who is arranging?");
    String arranger = sc.nextLine();

    ar.addArrangement(new Arrangement(id, date, name, arranger, location, type));
  }

  public static void searchByDate(Scanner sc, ArrangementRegister ar) {
    clearScreen();
    System.out.println("enter the date you want to search by (YYYYMMDD)");
    String date = sc.nextLine();

    ArrayList<Arrangement> searchResults = ar.searchByDate(date);

    for (Arrangement arrangement : searchResults) {
      System.out.println(arrangement.getName() + ", " + arrangement.getLocation() +
          ", " + arrangement.getTypeOfArrangement() + ", " + arrangement.getTime());
    }
    System.out.println("press ENTER to continue.");
    sc.nextLine();

    clearScreen();
  }

  public static void searchBetweenDate(Scanner sc, ArrangementRegister ar) {
    clearScreen();
    System.out.println("enter the starting date. (YYYYMMDD)");
    long start = sc.nextLong();

    System.out.println("enter the ending date. (YYYYMMDD)");
    long end = sc.nextLong();

    ArrayList<Arrangement> searchResults = ar.searchBetweenDates(start, end);

    for (Arrangement arrangement : searchResults) {
      System.out.println(arrangement.getName() + ", " + arrangement.getLocation() +
          ", " + arrangement.getTypeOfArrangement() + ", " + arrangement.getTime());
      }

    System.out.println("press ENTER to continue.");
    sc.nextLine();

  }
}
