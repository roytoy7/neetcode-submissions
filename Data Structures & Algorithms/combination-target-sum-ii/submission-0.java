class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombos(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }
    private void findCombos(int[] arr, int tar, int ind, ArrayList<Integer> res, List<List<Integer>> ans) {
        if (tar==0) {
            ans.add(new ArrayList<>(res));
            return;
        }

        if (ind>=arr.length||tar<0) return;

        for (int i = ind; i < arr.length; i++) {
            if (i>ind&&arr[i]==arr[i-1]) continue;
            res.add(arr[i]);
            findCombos(arr, tar-arr[i], i+1, res, ans);
            res.remove(res.size()-1);
        }
    }
}
