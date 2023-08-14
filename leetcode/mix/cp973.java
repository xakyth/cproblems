package leetcode.mix;

import java.util.Comparator;
import java.util.PriorityQueue;

public class cp973 {
    public int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Double.compare(Math.sqrt(o1[0]*o1[0] + o1[1]*o1[1]), Math.sqrt(o2[0]*o2[0] + o2[1]*o2[1]));
            }
        });
        for (int[] p : points) {
            heap.offer(p);
        }   
        while (k > 0) {
            int[] temp = heap.poll();
            ans[k-1] = temp;
            k--;
        }
        return ans;
    }

}
