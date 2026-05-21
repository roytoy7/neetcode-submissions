class Solution {
    public boolean isValid(String s) {
        if (s.length()%2!=0||s.length()==0) return false;
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c=='('||c=='{'||c=='[') st.push(c);
            else {
                if (st.isEmpty()) return false;
                char top = st.pop();
                if ((c==')'&&top!='(')||(c==']'&&top!='[')||(c=='}'&&top!='{')) return false;
            }
        }
        if (!st.isEmpty()) return false;
        return true;
        
    }
}
