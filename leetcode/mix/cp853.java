import java.util.Arrays;
import java.util.Comparator;

public class cp853 {
    public int carFleet(int target, int[] position, int[] speed) {
        int ans = 0;
        class entry { 
            int pos;
            int speed;
            public entry(int p, int s) {
                pos = p;
                speed = s;
            }
        }
        entry[] entries = new entry[position.length];
        for (int i = 0; i < entries.length; i++) {
            entries[i] = new entry(position[i], speed[i]);
        }
        Arrays.sort(entries, new Comparator<entry>() {
            public int compare(entry o1, entry o2) {
                return Integer.compare(o2.pos, o1.pos);
            };
        });

        double time = -1;
        for (int i = 0; i < entries.length; i++) {
            if ((double)(target - entries[i].pos) / entries[i].speed > time) {
                ans++;
                time = (double)(target - entries[i].pos) / entries[i].speed;
            }
        }
        return ans;
    }
}
