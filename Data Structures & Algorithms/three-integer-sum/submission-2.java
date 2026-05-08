class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> li = new ArrayList<>();
        int i = 0; 
        while (i< nums.length-2){ 
            int l = i+1;
            int r = nums.length-1;
            while (l<r){
                int sum = nums[l] + nums[r];
                if (sum<-nums[i]) l++;
                else if (sum>-nums[i]) r--;
                else {
                    List<Integer> list = List.of(nums[i], nums[l], nums[r]);
                    li.add(list);
                    do l++; while(l<nums.length-1&&nums[l]==nums[l-1]);
                    do r--; while (r>0&&nums[r+1]==nums[r]);
                }
            }
            do i++; while (i<nums.length-1&&nums[i]==nums[i-1]);
        }

        return li;
    }
}
