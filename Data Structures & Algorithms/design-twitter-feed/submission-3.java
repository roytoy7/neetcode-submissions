class Twitter {
    HashMap<Integer, HashSet<Integer>> fm;
    HashMap<Integer, LinkedList<Tweet>> tm;
    int count;
    class Node {
        Tweet tweet;
        int userId;
        int index;

        Node(Tweet tweet, int userId, int index) {
            this.tweet = tweet;
            this.userId = userId;
            this.index = index;
        }
    }
    class Tweet{
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
        follow(userId, userId);

        tm.putIfAbsent(userId, new LinkedList<>());

        tm.get(userId).addFirst(new Tweet(count++, tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        
        LinkedList<Integer> l = new LinkedList<>();
        if (fm.containsKey(userId)) {
            PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> b.tweet.c-a.tweet.c);

            for (int followee : fm.get(userId)) {
                if (tm.containsKey(followee)) {
                    pq.offer(new Node(tm.get(followee).get(0),followee,0));
                }
            }

            while (!pq.isEmpty() && l.size() < 10) {

                Node curr = pq.poll();

                l.add(curr.tweet.id);

                int nextIndex = curr.index + 1;

                List<Tweet> tweets = tm.get(curr.userId);

                if (nextIndex < tweets.size()) {
                    pq.offer(new Node(
                            tweets.get(nextIndex),
                            curr.userId,
                            nextIndex));
                }
        }
            
        }
        return l;
    }
    
    public void follow(int followerId, int followeeId) {
        fm.putIfAbsent(followerId, new HashSet<>());
        fm.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followerId!=followeeId && fm.containsKey(followerId)) fm.get(followerId).remove(followeeId);
    }
}
