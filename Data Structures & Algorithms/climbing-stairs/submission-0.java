class Solution {
    public int climbStairs(int n) {
        int one = 1, two = 1;
        for (int i = 0; i < n - 1; i++) {
            int temp = two;
            two += one;
            one = temp;
        }
        return two;
    }
}
