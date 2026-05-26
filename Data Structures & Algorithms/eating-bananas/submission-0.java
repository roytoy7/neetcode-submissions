class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int high = piles[0];
        for (int i = 0; i < piles.length; i++) {
            if (piles[i]>high) high = piles[i];
        }
        int low = 1;
        int k = high;
        while (low<=high) {
            int mid = (low+high)/2;

            int hrs = 0; 
            for (int i = 0; i < piles.length;i++) {
                hrs += (int)Math.ceil(1.0*piles[i]/mid);
            }
            System.out.println(mid + " " + hrs);
            if (hrs<=h) {
                k = mid;
                high = mid - 1;
            }
            else low = mid+1;
        }

        return k;
    }
}
