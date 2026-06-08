class Solution {
    public int findDuplicate(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[Math.abs(nums[i])-1]);
            if (nums[Math.abs(nums[i])-1] < 0) return Math.abs(nums[i]);
            else {
                nums[Math.abs(nums[i])-1] *= -1;
            }
        }
        return nums[nums.length-1];
    }
}
