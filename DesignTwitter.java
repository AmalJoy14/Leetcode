class Twitter {
    LinkedList<List<Integer>> pq;
    HashMap<Integer, HashSet<Integer>> map;
    int time = 0;

    public Twitter() {
        map = new HashMap<>();
        pq = new LinkedList<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        isPresent(userId);
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(userId);
        arr.add(tweetId);
        pq.add(arr);

    }
    
    public List<Integer> getNewsFeed(int userId) {
        isPresent(userId);
        int count = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = pq.size() - 1 ; i >= 0 && count < 10; i--){
            List<Integer> latest = pq.get(i);
            if (map.get(userId).contains(latest.get(0))){
                res.add(latest.get(1));
                count++;
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        isPresent(followerId);
        map.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        isPresent(followerId);
        map.get(followerId).remove(followeeId);
    }
    public void isPresent(int userid){
        if (!map.containsKey(userid)){
            map.put(userid, new HashSet<Integer>());
            map.get(userid).add(userid);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
