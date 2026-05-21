class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < tokens.length;i++) {
            String c = tokens[i];
            if (!(c.equals("+")||c.equals("-")||c.equals("*")||c.equals("/"))) st.push(Integer.parseInt(c));
            else {
                int numR = st.pop();
                int numL = st.pop();
                if (c.equals("+")) st.push(numL+numR);
                else if (c.equals("*")) st.push(numL*numR);
                else if (c.equals("-")) st.push(numL-numR);
                else if (c.equals("/")) st.push(numL/numR);
            }
        }
        return st.pop();
    }
}
