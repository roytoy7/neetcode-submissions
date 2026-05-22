class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> ind = new Stack<>();
        int[] arr = new int[temperatures.length];
        
        for (int i=0; i < temperatures.length;i++) {
            arr[i] = 0; 
            if (ind.isEmpty()||temperatures[ind.peek()]>temperatures[i])
                ind.push(i);
            else {
                while (!ind.isEmpty()&&temperatures[i] > temperatures[ind.peek()]) {
                    arr[ind.peek()] = i-ind.pop();
                }
                ind.push(i);
            }
        }
        return arr;
    }
}
