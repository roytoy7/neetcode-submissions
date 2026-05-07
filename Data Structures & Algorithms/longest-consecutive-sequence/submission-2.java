class Solution {
    public int longestConsecutive(int[] nums) {
        int longest = 0;
        
        HashSet<Integer> s = new HashSet<>();
        for (int n : nums) s.add(n);

        for (Integer n : s) {
            if (!s.contains(n-1)){
                boolean stillGoing = true;
                int len = 0; 
                while (stillGoing) {
                    if (s.contains(n+len)) len++;
                    else stillGoing=false;
                }
                longest = Math.max(len, longest);
            }
        }
        return longest;
    }
}
