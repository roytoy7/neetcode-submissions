class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //Arrays.sort(numbers);
        int l = 0; 
        int r = numbers.length-1;
        while(numbers[l]+numbers[r]!=target){
            if (numbers[l]+numbers[r]>target) r--;
            else if (numbers[l]+numbers[r]<target) l++;
            System.out.println(l + " " + r);
        }
        
        return new int[] {l+1, r+1};
    }
}
