class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        combos(ans, nums, new ArrayList<>(), new boolean[nums.length]);
        return ans;
    }
    
    private void combos(List<List<Integer>> ans, int[] nums, List<Integer> res, boolean[] visited) {
            if (res.size()==nums.length) {
                ans.add(new ArrayList<>(res));
            }
            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) continue;
                
                res.add(nums[i]);
                visited[i] = true;

                combos(ans, nums, res, visited);

                res.remove(res.size()-1);
                visited[i] = false;
            }
        };   

}
