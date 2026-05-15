class Solution {
    public String minWindow(String s, String t) {
        int len = 0; 
        int l = 0; 
        int finalL = 0, finalR = 0;

        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            hm.put(t.charAt(i), hm.getOrDefault(t.charAt(i),0)+1);
        }
        int have = 0, need = hm.size();
        HashMap<Character, Integer> temp = new HashMap<>();
        for (int r = 0; r < s.length(); r++){
            
            if (hm.containsKey(s.charAt(r))){
                temp.put(s.charAt(r), temp.getOrDefault(s.charAt(r),0)+1);
                if (temp.get(s.charAt(r))==hm.get(s.charAt(r))) have++;
                while (need==have) {
                    if (len==0||len>(r-l+1)) {
                        len = r-l+1;
                        finalL = l; 
                        finalR = r;
                    }
                    if (hm.containsKey(s.charAt(l))) {
                        temp.put(s.charAt(l), temp.get(s.charAt(l))-1);
                        if (temp.get(s.charAt(l))<hm.get(s.charAt(l))) have--;
                    }
                    l++;
                }
            } 
        }
        if (len==0) return "";
        return s.substring(finalL, finalR+1);

        
    }
}
