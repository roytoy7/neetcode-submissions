class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        addSets(nums, ans, new ArrayList<>(), 0);
        return ans;
    }
    private void addSets(int[] nums, List<List<Integer>> ans, List<Integer> res, int ind) {
        ans.addLast(new ArrayList<>(res));

        if (ind>=nums.length) {
            return;
        }

        for (int i = ind; i < nums.length; i++) {
            if (i>ind&&nums[i]==nums[i-1]) continue;
            res.addLast(nums[i]);
            addSets(nums, ans, res, i+1);
            res.remove(res.size()-1);
        }
    }
}
