package leetcode.mix;

class cp1351 {
    public int countNegatives(int[][] grid) {
        int cnt = 0, m = grid.length, n = grid[0].length;

        boolean found = false;
        int x = n, y = - 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] >= 0 ) {
                    y = i - 1;
                    x = j + 1;
                    cnt += n - j - 1;
                    found = true;
                    break;
                }
            }
            if (found)
                break;
            cnt += n;
        } 
        
        for (int i = y; i >= 0; i--) {
            found = false;
            for (int j = x; j < n; j++) {
                if (grid[i][j] < 0) {
                    cnt += n - j;
                    x = j;
                    found = true;
                    break;
                }
            }
            if (!found)
                break;
        }

        return cnt;
    }
}