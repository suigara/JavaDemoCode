package newfethers.java5.generic;

public class Matrix<T> {
    private Object[][] matrix;

    public static void main(String[] args) {
         
         Matrix<Object> objMtx = new Matrix<Object>(4, 3);
         Matrix<Integer> intMtx = new Matrix<Integer>(4, 3);
         objMtx.merge(intMtx);
         intMtx.copyHere(objMtx);
    }

    public Matrix(int width, int height) {
        matrix = new Object[width][height];
    }

    public void merge(Matrix<? extends T> other) {
        for (int i = 0; i < getWidth(); i++) {
            for (int j = 0; j < getHeight(); j++) {
                if (matrix[i][j] == null) {
                    matrix[i][j] = other.get(i, j);
                }
            }
        }
    }

    public void copyHere(Matrix<? super T> here) {
        for (int i = 0; i < here.getWidth(); i++) {
            for (int j = 0; j < here.getHeight(); j++) {
                here.set(i, j, get(i, j));
            }
        }
    }

    public void set(int x, int y, T value) {
        matrix[x][y] = value;
    }

    public T get(int x, int y) {
        @SuppressWarnings("unchecked")
        T result = (T) matrix[x][y];
        return result;
    }

    public int getHeight() {
        return matrix.length;
    }

    public int getWidth() {
        if (getHeight() == 0) {
            return 0;
        }
        return matrix[0].length;
    }

}
