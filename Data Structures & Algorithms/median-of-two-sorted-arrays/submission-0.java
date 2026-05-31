class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int half = (nums1.length+nums2.length)/2;
        int[] small, big;

        if (nums1.length<nums2.length) {
            small = nums1;
            big = nums2;
        } else {
            small = nums2;
            big = nums1;
        }
        int l = 0, r = small.length;

        while (l<=r) {
            int i = (l+r)/2;
            int j = half-i;

            float lSmall = i-1>=0 ? small[i-1] : Float.NEGATIVE_INFINITY;
            float rSmall = i < small.length ? small[i] : Float.POSITIVE_INFINITY;
            float lBig = j-1>=0 ? big[j-1] : Float.NEGATIVE_INFINITY;
            float rBig = j < big.length ? big[j] : Float.POSITIVE_INFINITY;
            
            System.out.println(lSmall + " " + lBig + " " + rSmall + " " + rBig);
            if (lSmall <= rBig && lBig <= rSmall) {
                if ((nums1.length+nums2.length)%2==1) return Math.min(rSmall, rBig);
                else return (Math.max(lSmall, lBig)+ Math.min(rSmall,rBig))/2.0;
            }
            else if (lSmall > rBig) r = i - 1;
            else l = i + 1;
        }
        return 0.0;
    }
}
