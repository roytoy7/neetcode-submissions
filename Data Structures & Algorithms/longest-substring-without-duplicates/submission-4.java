class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = 0;
        int l = 0;
        HashSet<Character> h = new HashSet<>();
        for (int r = 0; r < s.length();r++){
            while (h.contains(s.charAt(r))) {
                h.remove(s.charAt(l));
                l++;
            }
            h.add(s.charAt(r));
            len = Math.max(len, r-l+1);
        }
        return len;
    }
}
