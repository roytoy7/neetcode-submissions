class Solution {
    public int longestConsecutive(int[] nums) {
        int longest = 0;
        
        HashSet<Integer> s = new HashSet<>();
        for (int n : nums) s.add(n);

        HashSet<Integer> starts = new HashSet<>();

        for (Integer n : s) {
            if (!s.contains(n-1)) starts.add(n);
        }
        for (Integer n: starts) System.out.println(n);
        
        for (Integer n : starts) {
            boolean stillGoing = true;
            int len = 0; 
            while (stillGoing) {
                if (s.contains(n+len)) len++;
                else stillGoing=false;
            }
            longest = Math.max(len, longest);
        }
        return longest;
    }
}
