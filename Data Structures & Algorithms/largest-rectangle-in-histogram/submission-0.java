class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int max = heights[0];
        for (int i = 0; i <= n; i++){
            int currHeight = (i==n) ? 0 : heights[i];
            
            while (!st.isEmpty()&&currHeight<heights[st.peek()]) {
                int height = heights[st.pop()];
                int width = st.isEmpty() ? i : i - st.peek() - 1;
                max = Math.max(max, height * width);
            }
            st.push(i);
        }
        return max;
    }
}
