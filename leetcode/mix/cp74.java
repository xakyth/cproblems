package leetcode.mix;

public class cp74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int r = rows * cols - 1;
        while (l <= r) {
            int mid = (l+r) / 2;
            int i = mid / cols;
            int j = mid % cols;
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }
}
