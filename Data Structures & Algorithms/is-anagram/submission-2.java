class Solution {
    public boolean isAnagram(String s, String t) {
        /*
        if (s.length()!=t.length()) return false;
        Map<Character,Integer> sM = new HashMap<>();
        Map<Character,Integer> tM = new HashMap<>();
        for (int i = 0; i < s.length();i++) {
            if (sM.containsKey(s.charAt(i))) sM.put(s.charAt(i), sM.get(s.charAt(i))+1);
            else sM.put(s.charAt(i), 1);
            
            if (tM.containsKey(t.charAt(i))) tM.put(t.charAt(i), tM.get(t.charAt(i))+1);
            else tM.put(t.charAt(i), 1);
        }
       
        return sM.equals(tM);
        */

         if (s.length() != t.length()) {
            return false;
        }

        char[] sSort = s.toCharArray();
        char[] tSort = t.toCharArray();
        Arrays.sort(sSort);
        Arrays.sort(tSort);
        return Arrays.equals(sSort, tSort);
        
        
    }
}
