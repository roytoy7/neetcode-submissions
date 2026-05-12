class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int maxFreq = 0;
        int l = 0; 
        int ans = 0;
        for (int r = 0; r < s.length();r++){
            char ch = s.charAt(r);
            hm.put(ch, hm.getOrDefault(ch, 0)+1);
            
            maxFreq = Math.max(maxFreq, hm.get(ch));

            while ((r-l+1)-maxFreq>k){
                char left = s.charAt(l);
                hm.put(left, hm.get(left)-1);
                l++;
            }
            ans = Math.max(ans, r-l+1);
        }

       
        return ans;



    }
}
