class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (String c : tokens) {
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
