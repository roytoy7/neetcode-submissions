class TimeMap {
    HashMap<String, ArrayList<Pair>> tm;
    
    class Pair {
        String value;
        int timestamp;
        Pair(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
        }
    }

    public TimeMap() {
        tm = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Pair p = new Pair(value, timestamp);
        if (tm.containsKey(key)) {
            tm.get(key).add(p);
        }
        else {
            ArrayList<Pair> al = new ArrayList<>();
            al.add(p);
            tm.put(key, al);
        }
    }
    
    public String get(String key, int timestamp) {
        if (tm.containsKey(key))
        {
            ArrayList<Pair> al = tm.get(key);

            int l = 0, r = al.size()-1;
            while (l<=r) {
                int mid = (l+r)/2;
                Pair p = al.get(mid);
                if (p.timestamp==timestamp) return p.value;
                else if (p.timestamp<timestamp) l = mid+1;
                else r = mid-1;
            }
            if (l-1>=0) return al.get(l-1).value;
        }
        return "";
    }
}
