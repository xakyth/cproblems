package leetcode.mix;

import java.util.Comparator;
import java.util.PriorityQueue;

public class cp295 {
    class MedianFinder {

        private PriorityQueue<Integer> h1;
        private PriorityQueue<Integer> h2;

        public MedianFinder() {
            h1 = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return Integer.compare(o2, o1);
                }
            });
            h2 = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return Integer.compare(o1, o2);
                }
            });
        }
        
        public void addNum(int num) {
            if (h1.isEmpty()) {
                h1.offer(num);
            } else {
                int i = h1.peek();
                if (i >= num) {
                    h1.offer(num);
                } else {
                    h2.offer(num);
                }
            }
            if (h1.size() - h2.size() > 1) {
                h2.offer(h1.poll());
            } else if (h1.size() - h2.size() < 0) {
                h1.offer(h2.poll());
            }
        }
        
        public double findMedian() {
            if (h1.size() == h2.size()) {
                return (h1.peek() + h2.peek()) / 2;
            } else {
                return h1.peek();
            }
        }
    }

}
