public class Fraction {
    private int numerator;
    private int denominator;

    // Constructor:
    public Fraction(int numer, int denom) {
        if (denom == 0) {
            throw new IllegalArgumentException("Nevneren kan ikke være 0!");
        }

        this.numerator = numer;
        this.denominator = denom;
    }

    public Fraction(int numer) {
        this(numer, 1);
    }

    // Get methods:
    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    // Common denom and shorting Mathods:
    // finds the common denominator
    private void commonDenominator(Fraction A) {
        if (this.getDenominator() != A.getDenominator()) {
            int commonDenom = this.getDenominator() * A.getDenominator();

            this.numerator = this.getNumerator() * A.getDenominator();
            A.numerator = A.getNumerator() * this.getDenominator();

            A.denominator = commonDenom;
            this.denominator = A.getDenominator();

        }
    }

    // shorts the current fraction
    private void shortFraction() {
        for (int i = this.getDenominator(); i > 1; i--) {
            int checkRest = (this.getDenominator() % i) + (this.getNumerator() % i);

            if (checkRest == 0) {
                this.denominator = this.getDenominator() / i;
                this.numerator = this.getNumerator() / i;
                break;
            }

        }
    }

    // Actual math-equation methods:
    // Fraction Addition:
    public void fractionAddition(Fraction A) {
        int initialDenomThis = this.getDenominator();
        int initialNumerThis = this.getNumerator();

        int initialDenomA = A.getDenominator();
        int initialNumerA = A.getNumerator();

        commonDenominator(A);

        this.numerator = this.getNumerator() + A.numerator;

        shortFraction();

        if (this.getDenominator() == 1) {
            System.out.println(initialNumerThis + "     " + initialNumerA + "\n"
                               + "—  +  —  =  " + this.getNumerator()
                               + "\n" + initialDenomThis + "     " + initialDenomA + "\n");
        }

        else {
            System.out.println(initialNumerThis + "     " + initialNumerA + "     " + this.getNumerator() + "\n"
                               + "—  +  —  =  —\n" + initialDenomThis + "     " + initialDenomA + "     "
                               + this.getDenominator() + "\n");
        }
    }

    //Fraction subtraction:
    public void fractionSubtraction(Fraction A) {
        int initialDenomThis = this.getDenominator();
        int initialNumerThis = this.getNumerator();

        int initialDenomA = A.getDenominator();
        int initialNumerA = A.getNumerator();

        commonDenominator(A);

        this.numerator = this.getNumerator() - A.numerator;

        shortFraction();

        if (this.getDenominator() == 1) {
            System.out.println(initialNumerThis + "     " + initialNumerA + "\n"
                               + "—  -  —  =  " + this.getNumerator()
                               + "\n" + initialDenomThis + "     " + initialDenomA + "\n");
        }

        else {
            System.out.println(initialNumerThis + "     " + initialNumerA + "     " + this.getNumerator() + "\n"
                               + "—  -  —  =  —\n" + initialDenomThis + "     " + initialDenomA + "     "
                               + this.getDenominator() + "\n");
        }
    }

    // Fraction multiplication
    public void fractionMultiplication(Fraction A) {
        int initialDenomThis = this.getDenominator();
        int initialNumerThis = this.getNumerator();

        int initialDenomA = A.getDenominator();
        int initialNumerA = A.getNumerator();

        this.numerator = this.getNumerator() * A.getNumerator();
        this.denominator = this.getDenominator() * A.getDenominator();

        shortFraction();

        if (this.getDenominator() == 1) {
            System.out.println(initialNumerThis + "     " + initialNumerA + "\n"
                               + "—  *  —  =  " + this.getNumerator()
                               + "\n" + initialDenomThis + "     " + initialDenomA + "\n");
        } else {
            System.out.println(initialNumerThis + "     " + initialNumerA + "     " + this.getNumerator() + "\n"
                               + "—  *  —  =  —\n" + initialDenomThis + "     " + initialDenomA + "     "
                               + this.getDenominator() + "\n");
        }

    }

    // Fraction Division:
    public void fractionDivision(Fraction A) {
        int initialDenomThis = this.getDenominator();
        int initialNumerThis = this.getNumerator();

        int initialDenomA = A.getDenominator();
        int initialNumerA = A.getNumerator();

        this.numerator = this.getNumerator() * A.getDenominator();
        this.denominator = this.getDenominator() * A.getNumerator();

        shortFraction();

        if (this.getDenominator() == 1) {
            System.out.println(initialNumerThis + "     " + initialNumerA + "\n"
                               + "—  ÷  —  =  " + this.getNumerator()
                               + "\n" + initialDenomThis + "     " + initialDenomA + "\n");
        } else {
            System.out.println(initialNumerThis + "     " + initialNumerA + "     " + this.getNumerator() + "\n"
                               + "—  ÷  —  =  —\n" + initialDenomThis + "     " + initialDenomA + "     "
                               + this.getDenominator() + "\n");

        }
    }


}