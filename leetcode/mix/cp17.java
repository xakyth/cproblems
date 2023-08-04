package leetcode.mix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class cp17 {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, Character[]> hm = new HashMap();
        hm.put('2', new Character[] { 'a', 'b', 'c'});
        hm.put('3', new Character[] { 'd', 'e', 'f'});
        hm.put('4', new Character[] { 'g', 'h', 'i'});
        hm.put('5', new Character[] { 'j', 'k', 'l'});
        hm.put('6', new Character[] { 'm', 'n', 'o'});
        hm.put('7', new Character[] { 'p', 'q', 'r', 's'});
        hm.put('8', new Character[] { 't', 'u', 'v'});
        hm.put('9', new Character[] { 'w', 'x', 'y', 'z'});
        List<String> result = new ArrayList<>();
        f(digits, 0, hm, result, new StringBuilder());
        return result;
    }
    private void f(String digits, int i, HashMap<Character, Character[]> hm, List<String> result, StringBuilder temp) {
        if (i == digits.length()) {
            if (temp.length() > 0) 
                result.add(temp.toString());
        } else {
            Character[] m = hm.get(digits.charAt(i));
            for (int j = 0; j < m.length; j++) {
                temp.append(m[j]);
                f(digits, i+1, hm, result, temp);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        cp17 c = new cp17();
        System.out.println(c.letterCombinations("2"));

    }
}
