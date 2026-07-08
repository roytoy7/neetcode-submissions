class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        sums(nums, 0, target, new ArrayList<>(), ans);
        return ans;
    }
    public void sums(int[] nums, int ind, int target, ArrayList<Integer> res, List<List<Integer>> ans) {
        System.out.println(target);
        if (target<0) return;
        
        if (target==0) {
            ans.add(new ArrayList<>(res));
            return;
        }

        if (ind>=nums.length) return;
        
        int times = target/nums[ind];
        for (int i = 1; i <= times; i++) {
            res.add(nums[ind]);
            sums(nums, ind+1, target-nums[ind]*i, res, ans);     
        }

        for (int i = 0; i < times; i++) res.remove(res.size()-1);
        sums(nums, ind+1, target, res, ans);
        

    }
}
