class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        String[] arr = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        combos(res, new StringBuilder(), arr, digits, 0);

        return res;
    }
    private void combos(List<String> res, StringBuilder sb, String[] arr, String digits, int i) {
        if (digits.length()==0) return;
        
        if (sb.length()==digits.length()) {
            res.add(sb.toString());
            return;
        }
        
        int dig = (int)digits.charAt(i)-50;

        for (int n = 0; n < arr[dig].length(); n++) {
            sb.append(arr[dig].charAt(n));
            combos(res, sb, arr, digits, i+1);
            sb.deleteCharAt(sb.length()-1);
        }
        
    }
}
