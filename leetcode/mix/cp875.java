public class cp875 {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 0;
        int r = 1_000_000_001;
        while (l < r) {
            int m = (l + r - 1) / 2;
            if (isOk(piles, m, h)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;

    }

    private boolean isOk(int[] a, int n, int h) {
        for (int i : a) {
            h -= Math.ceil((double)i / n);
        }
        return h >= 0;
    }
}
