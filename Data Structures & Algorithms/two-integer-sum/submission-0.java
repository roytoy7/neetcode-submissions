class Solution {
    public int[] twoSum(int[] nums, int target) {
        // first is the int second is its index
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int diff = target-nums[i];
            if (m.containsKey(diff)) {
                int[] k = {m.get(diff), i};
                return k;
            }
            m.put(nums[i], i);
        }
        return null;
    }
}
