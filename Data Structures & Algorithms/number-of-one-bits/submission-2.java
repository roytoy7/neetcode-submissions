class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n!=0) {
            n &= (n-1);
            count++;
        }
        /*
        for (int i = 0; i < 32; i++) {
            int last = n & 1;
            if (last==1) count++;
            n >>= 1;
        }
        */
        return count;
    }
}
