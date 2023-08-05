package leetcode.mix;

public class cp1870 {
    public int minSpeedOnTime(int[] dist, double hour) {
        int l = 0;
        int r = 10_000_000;
        int mid = -1;
        int best = -1;
        while (l <= r) {
            mid = (l + r) / 2;
            if (enoughSpeed(dist, hour, mid)) {
                best = mid;
                r = mid - 1;
            } else {
                l = mid + 1;    
            }
        }
        return best;      
    }
    public static boolean enoughSpeed(int[] dist, double hour, int speed) {
        for (int i = 0; i < dist.length - 1; i++) {
            hour -= Math.ceil((double)dist[i] / (double)speed);
        }
        hour -= (double)dist[dist.length - 1] / (double)speed;
        if (hour >= -0.0000000001)
            return true;
        return false;
    }
} 