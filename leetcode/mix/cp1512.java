public class cp1512 {
    public int numIdenticalPairs(int[] nums) {
        int ans = 0;
        int[] c = new int[100];
        for (int i : nums) {
            c[i-1]++;
        }  
        for (int i : c) {
            if (i >= 2) {
                ans += ((double)i / 2) * (i-1);
            }
        } 
        return ans;
    }
}
