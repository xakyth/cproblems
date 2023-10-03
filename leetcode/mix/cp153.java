public class cp153 {
    public int findMin(int[] a) {
        int l = 0;
        int r = a.length - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (a[l] > a[m] && a[m] > a[m-1]) {
                r = m - 1;
            } else if (a[m] > a[r]) {
                l = m + 1;
            } else {
                return a[l];
            }
        }
        
        return a[l];
    }
}
