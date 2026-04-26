class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> l = new ArrayList<>(); 
        
        Map<Map<Character, Integer>, Integer> h = new HashMap<>();

        for (int i = 0; i < strs.length;i++) {
            String s = strs[i];
            Map<Character, Integer> m = new HashMap<>();
            for (int k = 0; k<s.length();k++) {
                if (m.containsKey(s.charAt(k))) {
                    m.put(s.charAt(k), m.get(s.charAt(k))+1);
                }
                else m.put(s.charAt(k), 1);
            }

            if (!(h.containsKey(m))) {
                h.put(m, l.size());
                l.add(new ArrayList<String>());
            }
            l.get(h.get(m)).add(s);
        }

        return l;
    }
}
