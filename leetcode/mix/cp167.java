package leetcode.mix;

public class cp167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            if (numbers[l] + numbers[r] == target) {
                break;
            } else if (numbers[l] + numbers[r] < target) {
                l++;
            } else {
                r--;
            }
        }
        res[0] = l+1;
        res[1] = r+1;
        return res;
    }
}
