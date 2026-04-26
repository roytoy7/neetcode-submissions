class Solution {
    public int[] twoSum(int[] nums, int target) {
        // first is the int second is its index
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int diff = target-nums[i];
            if (m.containsKey(diff)) {
                return new int[] {m.get(diff), i};
            }
            m.put(nums[i], i);
        }
        return null;
    }
}
