class Solution {
    private class Task{
        char c;
        int freq;
        int time;
        public Task(char c, int freq) {
            this.c=c;
            this.freq=freq;
            this.time = 0;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            freq[tasks[i]-65]++;
        }
        PriorityQueue<Task> pq = new PriorityQueue<>((a, b) -> b.freq-a.freq);
        for (int i = 0; i < 26; i++) {
            if (freq[i]!=0) pq.offer(new Task((char)(65+i), freq[i]));
        }
        int time = 0;
        Queue<Task> times = new LinkedList<>();
        while (!pq.isEmpty()||!times.isEmpty()) {
            time++;
            
            while (!times.isEmpty() && times.peek().time <= time) {
                pq.offer(times.poll());
            }

            if (!pq.isEmpty()) {
                Task popped = pq.poll();
                popped.freq--;
                if (popped.freq!=0) {
                    popped.time = time+n+1;
                    times.offer(popped);
                }
            }
        }
        return time;
    }
}
