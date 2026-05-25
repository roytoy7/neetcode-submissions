class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int numC = matrix[0].length;
        int high = matrix.length*numC-1;
        while (low<=high) {
            int mid = (high+low)/2;
            int num = matrix[(mid)/numC][(mid)%numC];
            if (num < target) low = mid+1;
            else if (num > target) high = mid-1;
            else return true;
        }
        return false;
    }
}
