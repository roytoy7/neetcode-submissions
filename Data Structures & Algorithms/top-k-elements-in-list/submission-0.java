class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        Integer freq = 0; 
        for (int n: nums) {
            if (m.containsKey(n)) m.put(n, m.get(n)+1);
            else m.put(n, 1);
            freq = Math.max(freq, m.get(n));
        }

        int[] o = new int[k];
        while (k!=0) {
            for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
                if (entry.getValue() == freq) {
                    o[k-1] = entry.getKey();
                    k--;
                }
            }
            freq--;
        }
        return o;
    }
}
