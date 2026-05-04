class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        /*
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
        */
        Map<Integer,Integer> m = new HashMap<>();
        List<Integer>[] freq = new List[nums.length+1];

        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for (int n: nums) {
            if (m.containsKey(n)) m.put(n, m.get(n)+1);
            else m.put(n, 1);
        }

        for (Map.Entry<Integer, Integer> entry: m.entrySet())
            freq[entry.getValue()].add(entry.getKey());

        int[] o = new int[k];
        for (int i = freq.length-1; i>0&&k>0;i--) {
            for (int n: freq[i]) {
                o[k-1] = n;
                k--;
            }
        }
        return o;

    }
}
