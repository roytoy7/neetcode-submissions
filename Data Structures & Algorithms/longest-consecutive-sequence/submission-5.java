class Solution {
    public int longestConsecutive(int[] nums) {
        int longest = 0;
        
        HashSet<Integer> s = new HashSet<>();
        for (int n : nums) s.add(n);

        for (int n : s) {
            if (!s.contains(n-1)){
                int len = 0; 
                while (s.contains(n+len)) {
                    len++;
                }
                longest = Math.max(len, longest);
            }
        }
        return longest;
    }
}
