class KthLargest {
    PriorityQueue<Integer> mins = new PriorityQueue<>();
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int i = 0; i < nums.length; i++) {
            if (mins.size()<k) mins.add(nums[i]);
            else if (nums[i]>mins.peek()) {
                mins.poll();
                mins.add(nums[i]);
            }
        }
    }
    
    public int add(int val) {
        if (mins.size()<k) mins.add(val);
        else if (val>mins.peek()) {
            mins.poll();
            mins.add(val);
        }
        return mins.peek();
    }
}
