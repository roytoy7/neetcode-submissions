class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        Deque<Integer> dq = new ArrayDeque<>(); // indices
        int[] res = new int[nums.length-k+1];

        for (int r=0, l=0; r < nums.length; r++){
            if (!dq.isEmpty()&&l>dq.getFirst()) dq.removeFirst();
            while (!dq.isEmpty()&&nums[r]>=nums[dq.getLast()]) {
                System.out.println(nums[dq.getFirst()]);
                dq.removeLast();
            }
            dq.addLast(r);
            
            if (r+1>=k) {
                res[l] = nums[dq.getFirst()];
                l++;
            }
        }
        return res;

    }
}
