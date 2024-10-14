import java.util.Scanner;
import java.util.ArrayList;

public class NyString {
    // variables
    private final String string;

    // constructor
    public NyString(String string) {
        this.string = string;
    }

    // methods
    public String Acronym() {
        // creates a deep copy of this.string
        String cString = string;

        // puts all characters to lowercase to standardize all elements ascii-codes
        cString = cString.toLowerCase();

        // makes a characterArray of the deep copy of this.string
        char[] chars = cString.toCharArray();
        // creates a stringbuilder for the acornym
        StringBuilder Acronym = new StringBuilder();

        // if the first element of the array is a character from a-z (including æ,ø,å),
        // add them to the stringbuilder.
        if ((int) chars[0] != 32 && (((int) chars[0] <= 122 && (int) chars[0] >= 97) ||
                (int) chars[0] == 248 || chars[0] == 229 || chars[0] == 230)) {
            Acronym.append(String.valueOf(chars[0]).toUpperCase());
        }

        // if the current character is a space, add the next character to the acronym if it is a letter.
        // (a-z, æ, ø, å)
        for (int i = 0; i < chars.length; i++) {
            if ((int) chars[i] == 32 && (((int) chars[i+1] <= 122 && (int) chars[i+1] >= 97) ||
                    (int) chars[i+1] == 248 || chars[i+1] == 229 || chars[i+1] == 230)) {
                Acronym.append(String.valueOf(chars[i+1]).toUpperCase());
            }
        }

        return Acronym.toString();
    }

    public String removeLetter(char antiChar) {
        // creates a deep copy of the string
        String cString = string;

        // creates a list of characters so that we can keep the uppercase characters in final string.
        char[] chars = cString.toCharArray();

        // sets the deep copy to lower case so that we wont have any unnecessary complications with capitalization
        cString = cString.toLowerCase();
        // creates a list of the all lower case string
        char[] charsLowerCase = cString.toCharArray();
        // creates an ArrayList for building the final string
        ArrayList<Character> newChars = new ArrayList<>();

        // creates a stringbuilder for the final letter
        StringBuilder cStringNoLetter = new StringBuilder();

        // if the character is not the character we want to remove, add it to the new list of characters
        for (int i = 0; i < charsLowerCase.length; i++) {
            if (!String.valueOf(charsLowerCase[i]).equals(String.valueOf(antiChar).toLowerCase())) {
                newChars.add(chars[i]);
            }
        }

        // creates a string based on the contents of the newChars list
        for (int i = 0; i < newChars.size(); i++) {
            cStringNoLetter.append(newChars.get(i));
        }

        return cStringNoLetter.toString();
    }



    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        NyString nyString = new NyString(s);


        System.out.println("Forkortelse av strengen: " + nyString.Acronym());
        System.out.println("Strengen uten bokstaven e: " + nyString.removeLetter('e'));
    }
}


