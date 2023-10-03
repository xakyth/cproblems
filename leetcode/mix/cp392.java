public class cp392 {
    public boolean isSubsequence(String s, String t) {
        for (int i = 0, j = 0; i < s.length(); j++) {
            if (j >= t.length()) {
                return false;
            }
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
        }
        return true;        
    }
}
