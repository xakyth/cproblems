package leetcode.mix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class cp49 {
    
    public List<List<String>> groupAnagrams(String[] strs) {
        boolean[] used = new boolean[strs.length];
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < strs.length - 1; i++) {
            if (used[i])
                continue;
            List<String> temp = new ArrayList<>();
            temp.add(strs[i]);
            for (int j = i + 1; j < strs.length; j++) {
                if (isAnagram(strs[i], strs[j])) {
                    used[j] = true;
                    temp.add(strs[j]);
                }
            }
            result.add(temp);
        }
        return result;
    }
    private boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        char[] a1 = s1.toCharArray();
        char[] a2 = s2.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i])
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        cp49 c = new cp49();
        

    }
}
