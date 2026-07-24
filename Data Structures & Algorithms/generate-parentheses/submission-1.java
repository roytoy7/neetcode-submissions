class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        gen(res, new StringBuilder(2*n), n, n);
        return res;
    }
    private void gen(List<String> res, StringBuilder sb, int l, int r) {
        if (l==0&&r==0) {
            res.addLast(sb.toString()); 
            return;
        }

        if (l>0) {
            sb.append("(");
            gen(res, sb, l-1, r);
            sb.deleteCharAt(sb.length()-1);
        }

        if (r>l) {
            sb.append(")");
            gen(res, sb, l, r-1);
            sb.deleteCharAt(sb.length()-1);
        }
        
    }
}
