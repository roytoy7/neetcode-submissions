class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int numZ = 0;
        for (int n : nums) {
            if (n==0) numZ+=1;
            else prod *= n;
        }
        int[] arr = new int[nums.length];
        for (int i = 0; i < arr.length;i++) {
            if (numZ>1) arr[i] = 0;
            else if (numZ==1) {
                if (nums[i]==0) arr[i] = prod;
                else arr[i] = 0;
            }
            else arr[i] = prod/nums[i];
        }
        return arr;
    }
}  
