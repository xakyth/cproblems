import java.util.ArrayList;
import java.util.Comparator;

public class cp747 {
    public String reorganizeString(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        int[] counts = new int[26];
        for (Character c : s.toCharArray()) {
            counts[c - 'a']++;
        }
        class entry {
            char c;
            int cnt;
            public entry(char c, int cnt) {
                this.c = c;
                this.cnt = cnt;
            }
        }
        ArrayList<entry> a = new ArrayList<>();
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                a.add(new entry((char)(i+'a'), counts[i]));
            }
        }
        a.sort(new Comparator<entry>() {
            public int compare(entry o1, entry o2) {
                return Integer.compare(o2.cnt, o1.cnt);
            }}
        );
        while (!a.isEmpty()) {
            entry e1 = a.get(0);
            if (a.size() == 1) {
                if (e1.cnt > 1) {
                    return "";
                } else if (e1.cnt == 1) {
                    sb.append(e1.c);
                    break;
                } else {
                    break;
                }
            } else {
                entry e2 = a.get(1);
                int diff = e1.cnt - e2.cnt;
                if (diff > 1) {
                    entry eLast = a.get(a.size() - 1);
                    if (diff - eLast.cnt >= 0) {
                        for (int i = 0; i < eLast.cnt; i++) {
                            sb.append(e1.c);
                            sb.append(eLast.c);
                        }
                        e1.cnt -= eLast.cnt;
                        a.set(0, e1);
                        a.remove(a.size() - 1);
                    } else {
                        for (int i = 0; i < diff; i++) {
                            sb.append(e1.c);
                            sb.append(eLast.c);
                        }
                        e1.cnt -= diff;
                        eLast.cnt -= diff;
                        a.set(0, e1);
                        a.set(a.size() - 1, eLast);
                    }
                } else {
                    for (int i = 0; i < a.size(); i++) {
                        entry eTemp = a.get(i);
                        sb.append(eTemp.c);
                        eTemp.cnt -= 1;
                        a.set(i, eTemp);
                    }
                    for (int i = a.size() - 1; i >= 0; i--) {
                        entry eTemp = a.get(i);
                        if (eTemp.cnt <= 0)
                            a.remove(eTemp);
                    }
                }
            }
        }
        
        return sb.toString();
    }
}
