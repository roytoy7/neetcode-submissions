class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int maxFreq = 0;
        int l = 0; 
        int ans = 0;
        for (int r = 0; r < s.length();r++){
            char ch = s.charAt(r);
            if (hm.containsKey(ch)) hm.put(ch, hm.get(ch)+1);
            else hm.put(ch, 1);

            if (hm.get(ch)>maxFreq) maxFreq = hm.get(ch);

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
