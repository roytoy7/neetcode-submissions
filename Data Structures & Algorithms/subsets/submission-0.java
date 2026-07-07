class Solution {
    List<List<Integer>> l;
    public List<List<Integer>> subsets(int[] nums) {
        l = new ArrayList<>();
        add(nums, new ArrayList<>(), 0);
        return l;
    }
    public void add(int[] list, List<Integer> li, int i) {
        if (i == list.length) {
            l.add(new ArrayList<>(li));
            return;
        }
        
        li.add(list[i]);
        add(list, li, i+1);
        
        li.remove(li.size()-1);
        add(list, li, i+1);
    }

}
