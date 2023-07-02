package leetcode.cp1601;

public class Solution {

    private int best = 0;

    public void backtrack(int i, int[] state, int[][] requests, int score) {
        if (i == requests.length) {
            boolean flag = true;
            for (int j = 0; j < state.length; j++) {
                if (state[j] != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag && score > this.best) {
                this.best = score;
            }
        } else {
            state[requests[i][0]]--;
            state[requests[i][1]]++;
            backtrack(i+1, state, requests, score+1);
            state[requests[i][0]]++;
            state[requests[i][1]]--;
            backtrack(i+1, state, requests, score);
        }
        
    }

    public int maximumRequests(int n, int[][] requests) {
        best = 0;
        int[] state = new int[n];
        this.backtrack(0, state, requests, 0);
        return best;
    }
}