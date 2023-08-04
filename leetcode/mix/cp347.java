package leetcode.mix;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;

public class cp347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i : nums) {
            Integer n = hm.get(i);
            if (n == null)
                hm.put(i, 1);
            else
                hm.put(i, n+1);
        }
        int[] result = new int[k];
        ArrayList<Entry<Integer, Integer>> al = new ArrayList<>(hm.entrySet());
        al.sort(new Comparator<Entry<Integer, Integer>> () {
            public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        for (int i = 0; i < k; i++) {
            result[i] = al.get(i).getKey();
        }
        return result;
    }

    public static void main(String[] args) {
        cp347 c = new cp347();
        
        
    }
}
