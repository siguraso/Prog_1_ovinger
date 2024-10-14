import java.util.ArrayList;
import java.util.List;

public class MinceMeatGrader {
    public static void main(String[] args) {
        // Definer kjøttdeig med en liste: [gram, pris]
        // Liste for kjøttA
        List<Double> kjottA = new ArrayList<>(); //definerer lista for kjøttA
        kjottA.add(0, 450.0); //legg til gram i lista i index nr. 0.
        kjottA.add(1, 35.9); //legg til pris i lista i index nr. 1.

        // Liste for kjøttB
        List<Double> kjottB = new ArrayList<>(); //definerer lista for kjøttB
        kjottB.add(0, 500.0); //legg til gram i lista i index 0.
        kjottB.add(1, 39.5); //legg til pris i lista i index 1.

        // finn pris pr gram:
        double gramPriceKjottA = kjottA.get(1)/kjottA.get(0);
        double gramPriceKjottB = kjottB.get(1)/kjottB.get(0);

        // Print ut resultatene:
        System.out.println("Pr. gram koster kjøttdeig A: " +
                String.format("%.4f", gramPriceKjottA) + ", mens kjøttdeig B koster: " +
                String.format("%.4f", gramPriceKjottB) +
                ". \n\nPr. kilogram koster kjøttdeig A: " +
                String.format("%.2f", gramPriceKjottA*1000) +
                ", mens kjøttdeig B koster: " +
                String.format("%.2f", gramPriceKjottB *1000) + ".");
    }
}
