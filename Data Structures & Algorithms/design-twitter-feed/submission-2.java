class Twitter {
    HashMap<Integer, HashSet<Integer>> fm;
    HashMap<Integer, LinkedList<Tweet>> tm;
    int count;
    public class Tweet{
        int c;
        int id;
        public Tweet(int c, int id) {
            this.c=c;
            this.id=id;
        }
    }
    public Twitter() {
        fm = new HashMap<>();
        tm = new HashMap<>();
        count = 1;
    }
   
    public void postTweet(int userId, int tweetId) {
        if (tm.containsKey(userId)) {
            tm.get(userId).addFirst(new Tweet(count, tweetId));
        }
        else {
            LinkedList<Tweet> l = new LinkedList<>();
            l.addFirst(new Tweet(count, tweetId));
            tm.put(userId, l);
            follow(userId, userId);
        }
        count++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> a.c-b.c);
        LinkedList<Integer> l = new LinkedList<>();
        if (fm.containsKey(userId)) {
            HashSet<Integer> fs = fm.get(userId);
            for (Integer i: fs) {
                LinkedList<Tweet> followerTweets = tm.get(i);
                if (followerTweets == null) continue;
                for (int m = 0; m < followerTweets.size(); m++) {
                    if (pq.size()<10) pq.offer(followerTweets.get(m));
                    else if (followerTweets.get(m).c>pq.peek().c){
                        pq.poll();
                        pq.offer(followerTweets.get(m));
                    }
                    else break;
                }
            }
            int s = pq.size();
            for (int i = 0; i < s; i++) {
                l.addFirst(pq.poll().id);
            }
        }
        return l;
    }
    
    public void follow(int followerId, int followeeId) {
        if (fm.containsKey(followerId)) fm.get(followerId).add(followeeId);
        else {
            HashSet<Integer> hs = new HashSet<>();
            hs.add(followeeId);
            fm.put(followerId, hs);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followerId!=followeeId && fm.containsKey(followerId)) fm.get(followerId).remove(followeeId);
    }
}
