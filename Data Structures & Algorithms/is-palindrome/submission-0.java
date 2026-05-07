class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int e = s.length()-1;
        int st = 0; 
        while (st<e) {
            while (st < e && !Character.isLetterOrDigit(s.charAt(st))) {
                st++;
            }

            while (st < e && !Character.isLetterOrDigit(s.charAt(e))) {
                e--;
            }
            if (s.charAt(st)!=s.charAt(e)) return false;
            st++;
            e--;
        }
        return true;
    }
}
