class Solution {
    public int trap(int[] height) {
        int length = height.length;
        int[] prefArr = new int[length];
        int[] suffArr = new int[length];

        prefArr[0] = 0; 
        suffArr[length-1] = 0;
        for (int i = 1; i < length;i++){
            prefArr[i] = Math.max(prefArr[i-1], height[i-1]);
        }
        for (int i = length-2;i>=0; i--){
            suffArr[i] = Math.max(suffArr[i+1], height[i+1]);
        }
        int area = 0;
        for (int i = 0; i < length;i++){
            if (suffArr[i]>height[i]&&prefArr[i]>height[i])
                area += Math.min(suffArr[i],prefArr[i])-height[i];
        }
        return area;

    }
}
