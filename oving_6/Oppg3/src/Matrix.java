import java.util.ArrayList;

public class Matrix {
    // variables
    private final ArrayList<ArrayList<Integer>> matrice;

    // constructor
    public Matrix(ArrayList<ArrayList<Integer>> matrix) {
        this.matrice = matrix;

        for (int i = 1; i < matrice.size(); i++) {
            if (matrice.get(i).size() != matrice.get(i-1).size()) {
                throw new IllegalArgumentException("Matrisen har ikke like mange kolonner pr. rad!");
            }
        }
    }

    // methods
    public ArrayList<Integer> getRow(int row) {
        return matrice.get(row);
    }

    public ArrayList<Integer> getCol(int col) {
        ArrayList<Integer> column = new ArrayList<>();

        for (ArrayList<Integer> row : matrice) {
            column.add(row.get(col));
        }

        return column;
    }

    public void printMatrix() {
        for (int i = 0; i < matrice.size(); i++) {
            System.out.println(this.getRow(i));
        }
    }

    public int getValue(int row, int col) {
        return matrice.get(row).get(col);
    }

    // mathematical methods
    public Matrix transpose() {
        ArrayList<ArrayList<Integer>> tMatrix = new ArrayList<>();

        for (int i = 0; i < this.getRow(0).size(); i++) {
            ArrayList<Integer> row = this.getCol(i);
           tMatrix.add(new ArrayList<>(row));
        }

        return new Matrix(tMatrix);
    }

    public Matrix addition(Matrix other) {
        if (this.getRow(0).size() != other.getRow(0).size() ||
                this.getCol(0).size() != other.getCol(0).size()) {
            throw new IllegalArgumentException("Matrisene må være av lik dimmensjon for å kunne adderes!");
        }

        ArrayList<ArrayList<Integer>> aMatrix = new ArrayList<>();

        for (int i = 0; i < this.getRow(0).size(); i++) {
            ArrayList<Integer> row = new ArrayList<>();

            for (int j = 0; j < this.getRow(0).size(); j++) {
                int addValue = this.getRow(i).get(j) + other.getRow(i).get(j);
                row.add(addValue);
            }

            aMatrix.add(row);
        }

        return new Matrix(aMatrix);
    }

    public Matrix multiplication(Matrix other) {
        ArrayList<ArrayList<Integer>> mMatrix = new ArrayList<>();

        // om de ikke deler størrelse, fakk dem...

        if (this.getRow(0).size() != other.getCol(0).size() &&
                (this.getCol(0).size() != other.getRow(0).size())) {
            throw new IllegalArgumentException("Disse matrisene er ikke multipliserbare!");
        }

        // define dimentions of the matrix

        // matrix a * matrix b means that rows(a) (in this case this) is always the amount of rows,
        // whilst rows(b) (this case other) is always the amount of rows

        int rows = this.getCol(0).size();
        int cols = other.getRow(0).size();

        for (int curRow = 0; curRow < rows; curRow++) {
            ArrayList<Integer> row = new ArrayList<>();
            int curValue = 0;

            for (int curCol = 0; curCol < cols; curCol++) {
                for (int i = 0; i < rows; i++) {
                    curValue += this.getValue(curRow, i) * other.getValue(i, curCol);

                }

                row.add(curValue);
                curValue = 0;
            }
            mMatrix.add(row);

        }

        return new Matrix(mMatrix);

    }
}