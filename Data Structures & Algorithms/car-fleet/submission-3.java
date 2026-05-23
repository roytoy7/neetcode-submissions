class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] posSpeed = new int[position.length][2];

        for (int i = 0; i < position.length; i++){
            posSpeed[i][0] = position[i];
            posSpeed[i][1] = speed[i];
        }
        Arrays.sort(posSpeed, (a, b) -> b[0]-a[0]);

        Stack<Double> st = new Stack<>();
        for (int i = 0; i < position.length; i++) {
            double time = 1.0*(target-posSpeed[i][0])/posSpeed[i][1];
            if (st.isEmpty()||st.peek()<time) st.push(time);
        }
        return st.size();
        
    }
}
