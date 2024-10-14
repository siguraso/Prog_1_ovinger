import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // define global values
        int xVal1;
        int yVal1;
        int xVal2;
        int yVal2;

        // define matrix dimensions
        while (true) {
            System.out.println("Hvor mange kolonner i matrise A?");
            xVal1 = sc.nextInt();
            sc.nextLine();

            System.out.println("\nHvor mange rader i matrise A?");
            yVal1 = sc.nextInt();
            sc.nextLine();

            clearScreen();

            System.out.println("\nHvor mange kolonner i matrise B?");
            xVal2 = sc.nextInt();
            sc.nextLine();

            System.out.println("\nHvor mange rader i matrise B?");
            yVal2 = sc.nextInt();
            sc.nextLine();

            clearScreen();

            ArrayList<String> okDiagChoices = new ArrayList<>();
            ChoiceWindow okDiag = new ChoiceWindow(okDiagChoices);
            okDiag.addChoice("Ja");
            okDiag.addChoice("Nei");

            int okChoice = okDiag.choiceSequnce("Matrise A: " + xVal1 + "x" + yVal1 +
                    "\nMatrise B: " + xVal2 + "x" + yVal2 + "\nEr dette OK?", sc);

            if (okChoice == 1) {
                clearScreen();
                break;
            }

            clearScreen();
        }

        // configure matrix values
        System.out.println("Matrise 1:");
        Matrix m1 = matrixBuilder(xVal1, yVal1, sc);

        System.out.println("Matrise 2:");
        Matrix m2 = matrixBuilder(xVal2, yVal2, sc);

        // decide what mathematical operations to do with above defined matrixes
        // set up a dialog window
        ArrayList<String> mathDiagChoices = new ArrayList<>();
        ChoiceWindow mathChoice = new ChoiceWindow(mathDiagChoices);

        mathChoice.addChoice("Addisjon (!Matrisene må være formlike!)");
        mathChoice.addChoice("Transponering av Matrise 1");
        mathChoice.addChoice("Transponering av Matrise 2");
        mathChoice.addChoice("Multiplikasjon AxB (!Matrisene må være multipliserbare!)");
        mathChoice.addChoice("Multiplikasjon BxA (!Matrisene må være multipliserbare!)");
        mathChoice.addChoice("Avslutt Programmet.");

        while (true) {
            int choice = mathChoice.choiceSequnce("Hvilken matematisk operasjon vil du gjøre?",
                    sc);
            clearScreen();
            switch (choice) {
                case 1:
                    m1.printMatrix();
                    System.out.println("\n + \n");
                    m2.printMatrix();

                    Matrix addM = m1.addition(m2);

                    System.out.println("\n = \n");
                    addM.printMatrix();

                    sc.nextLine();
                    sc.nextLine();

                    break;

                case 2:
                    m1.printMatrix();
                    System.out.println("\nTransponert: \n");

                    Matrix tM1 = m1.transpose();

                    tM1.printMatrix();

                    sc.nextLine();
                    sc.nextLine();

                    break;

                case 3:
                    m2.printMatrix();
                    System.out.println("\nTransponert: \n");

                    Matrix tM2 = m2.transpose();

                    tM2.printMatrix();

                    sc.nextLine();
                    sc.nextLine();

                    break;

                case 4:
                    m1.printMatrix();
                    System.out.println("\n * \n");
                    m2.printMatrix();

                    Matrix multiMAB = m1.multiplication(m2);

                    System.out.println("\n = \n");
                    multiMAB.printMatrix();

                    sc.nextLine();
                    sc.nextLine();

                    break;

                case 5:
                    m2.printMatrix();
                    System.out.println("\n * \n");
                    m1.printMatrix();

                    Matrix multiMBA = m2.multiplication(m1);

                    System.out.println("\n = \n");
                    multiMBA.printMatrix();

                    sc.nextLine();
                    sc.nextLine();

                case 6:
                    sc.close();
                    System.exit(0);
            }
        }
    }


    public static void clearScreen() {
        // clear the terminal window
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static Matrix matrixBuilder(int x, int y, Scanner sc) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        // defines all the values within a matrix with a set of predefined dimensions
        while (true) {
            // loop for every row
            for (int i = 0; i < y; i++) {
                ArrayList<Integer> row = new ArrayList<>();

                // loop for every value on each row
                for (int j = 0; j < x; j++) {
                    System.out.println(row);
                    System.out.println("\nHvilken verdi vil du legge inn (verdi nr." + (j + 1) + " i rad "
                            + (i + 1) + ")\n");

                    int val = sc.nextInt();

                    row.add(val);
                }

                // adds rows to a general row arraylist
                matrix.add(row);
                clearScreen();
            }

            // defines a matrix based on the matrix arraylist, and prints it
            Matrix m = new Matrix(matrix);
            m.printMatrix();

            // sets up a dialog window just in case user made a typo, or similar mistake
            ArrayList<String> okDiagChoices = new ArrayList<>();
            ChoiceWindow okDiag = new ChoiceWindow(okDiagChoices);
            okDiag.addChoice("Ja");
            okDiag.addChoice("Nei");

            int okChoice = okDiag.choiceSequnce("Er denne matrisen OK?", sc);

            clearScreen();

            // if user is okay with the defined matrix, continue the program (which breaks the while loop),
            // if not, redo definition of values (the while true loop)
            if (okChoice == 1) {
                return m;
            } else {
                matrix.clear();
            }
        }
    }
}
