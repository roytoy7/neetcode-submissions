class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        sums(nums, 0, target, new ArrayList<>(), ans);
        return ans;
    }
    public void sums(int[] nums, int ind, int target, ArrayList<Integer> res, List<List<Integer>> ans) {
        if (target<0 || ind>=nums.length) return;
        if (target==0) {
            ans.add(new ArrayList<>(res));
            return;
        }
        res.add(nums[ind]);
        sums(nums, ind, target-nums[ind], res, ans);     
    
        res.remove(res.size()-1);
        sums(nums, ind+1, target, res, ans);
    }
}
