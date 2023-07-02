package leetcode;

public class Main {
    
    public static void main(String[] args) {
        leetcode.cp1601.Solution sol1601 = new leetcode.cp1601.Solution();
        System.out.println(sol1601.maximumRequests(5, new int[][] { {0,1}, {1,0}, {0,1}, {1,2}, {2, 0}, {3, 4}}));
        System.out.println(sol1601.maximumRequests(3, new int[][] { {0,0}, {1,2}, {2,1}}));
        System.out.println(sol1601.maximumRequests(4, new int[][] { {0,3}, {3,1}, {1,2}, {2,0}}));
    }
}
