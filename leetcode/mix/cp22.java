package leetcode.mix;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class cp22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(n, 0, 0, result, "");
        return result;
    }

    private void backtrack(int n, int i, int j, List<String> result, String temp) {
        if (temp.length() == 2*n) {
            result.add(temp);
            return;
        } 
        if (i < n) backtrack(n, i + 1, j, result, temp + "(");
        if (j < i) backtrack(n, i, j + 1, result, temp + ")");
    }

    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == ')') {
                if (stack.isEmpty()) 
                    return false;
                else
                    stack.pop();
            }
            else
                stack.push(c);
        }
        return stack.isEmpty() ? true : false;
    }

    public static void main(String[] args) {
        cp22 c = new cp22();
        System.out.println(c.generateParenthesis(3));

    }
}
