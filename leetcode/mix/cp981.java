import java.util.ArrayList;
import java.util.HashMap;

public class cp981 {
    class TimeMap {
        
        class Pair {
            String value;
            int timestamp;
            public Pair(int t, String v) {
                timestamp = t;
                value = v;
            }
        }

        HashMap<String, ArrayList<Pair>> hm;
    
        public TimeMap() {
            hm = new HashMap<>();
        }
        
        public void set(String key, String value, int timestamp) {
            ArrayList<Pair> values = hm.get(key);
            if (values == null) {
                values = new ArrayList<>();
            }
            values.add(new Pair(timestamp, value));
            hm.put(key, values);
        }
        
        public String get(String key, int timestamp) {
            ArrayList<Pair> values = hm.get(key);
            if (values == null) return "";
            
            int l = 0;
            int r = values.size()-1;
            while (l < r) {
                int m = (l + r) / 2;
                Pair mPair = values.get(m);
                if (mPair.timestamp == timestamp) {
                    return values.get(m).value;
                } else if (mPair.timestamp > timestamp) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            return values.get(l).value;
        }
    }
}
