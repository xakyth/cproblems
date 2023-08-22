import java.util.Stack;

public class cp739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty() || temperatures[stack.peek()] >= temperatures[i]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty()) {
                    if (temperatures[i] > temperatures[stack.peek()]) {
                        ans[stack.peek()] = i - stack.peek();
                        stack.pop();
                    } else {
                        break;
                    }
                }
                stack.push(i);
            }
        }

        return ans;
    }
}
