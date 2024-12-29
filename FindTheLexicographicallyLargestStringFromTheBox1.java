class Solution {
    public String answerString(String word, int numFriends) {
        if (numFriends == 1) return word;
        
        PriorityQueue<String> pq = new PriorityQueue<>((a,b) -> b.compareTo(a));

        if (numFriends == 2){
            for (int i = 1 ; i < word.length() ; i++){
                pq.add(word.substring(0,i));
                pq.add(word.substring(i,word.length()));
            }
        }
        if (numFriends > 2){
            for (int i = 0 ; i < numFriends ; i++){
                String sb = word.substring(i, word.length() - (numFriends - i) + 1);
                pq.add(sb);
            }
            for (int i = numFriends ; i < word.length() ; i++){
                String sb = word.substring(i , word.length());
                pq.add(sb);
            }
        }

        return pq.poll();
    }
}
