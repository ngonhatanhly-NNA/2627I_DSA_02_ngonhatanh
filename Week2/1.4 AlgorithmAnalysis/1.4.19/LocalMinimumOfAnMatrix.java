public class LocalMinimumOfAnMatrix {
    public static void main(String[] args) {
       int[][] matrix = {
            {10, 17, 13, 28, 23},
            {17, 22, 16, 29, 23},
            {24, 28, 22, 34, 24},
            {11, 13, 6, 17, 7},
            {45, 44, 32, 37, 23}
        };

        int localMinimum = findLocalMinimumOfAnMatrix(matrix);
        System.out.println("Local Minimum: " + localMinimum);   
    }

    public static int findLocalMinimumOfAnMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (rows == 0 || cols == 0) {
            return -1; // No elements in the matrix
        }

        int n = matrix.length;
        return helper (matrix, n, 0, cols - 1);
    
    }

    private static int helper(int[][] matrix, int n, int col_start, int col_end){
        if (col_start > col_end) {
            return -1; // No local minimum found
        }

        int mid_col = (col_start + col_end) / 2;

        int min_row = 0;
        for (int i = 0; i < n; i++){
            if (matrix[i][mid_col] < matrix[min_row][mid_col]){
                min_row = i;
            }
        }

        int val = matrix[min_row][mid_col];
        int left_val = mid_col > 0 ? matrix[min_row][mid_col - 1] : Integer.MAX_VALUE;
        int right_val = mid_col < n - 1 ? matrix[min_row][mid_col + 1] : Integer.MAX_VALUE;
        
        if (val <= left_val && val <= right_val) {
            return val;
        }

        if (left_val < right_val) {
            return helper(matrix, n, col_start, mid_col - 1);
        } else {
            return helper(matrix, n, mid_col + 1, col_end);
        }
    }

}
