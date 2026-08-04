class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> part = new ArrayList<>();

        dfs(res, part, s, 0);

        return res;
    }

    private void dfs(List<List<String>> res, List<String> part, String s, int i) {
        if (i>=s.length()) {
            res.add(new ArrayList(part));
            return;
        }
        
        for (int m = i; m < s.length();m++) {
            if (isPali(s.substring(i, m+1))) {
                part.add(new String(s.substring(i, m+1)));
                dfs(res, part, s, m+1);
                part.remove(part.size()-1);
            }

        }
    }

    private boolean isPali(String s) {
        for (int l = 0, r = s.length()-1; l < r; l++, r--) {
            if (s.charAt(l)!=s.charAt(r)) return false;
        }
        return true;
    }
}
