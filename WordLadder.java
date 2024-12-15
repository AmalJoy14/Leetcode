
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        Queue<String> que = new LinkedList<>();
        for (String s : wordList) {
            set.add(s);
        }
        if (!set.contains(endWord)) {
            return 0;
        }
        int count = 1;
        que.add(beginWord);
        que.add(null);
        while (!que.isEmpty()) {
            
            String ss = que.remove();
            if(ss.equals(endWord)){
                return count;
            }
            StringBuilder sb = new StringBuilder(ss);
            for (int i = 0; i < endWord.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    sb.setCharAt(i,ch);
                    if(set.contains(String.valueOf(sb))){
                        que.add(String.valueOf(sb));
                        set.remove(String.valueOf(sb));
                    }
                }
                sb = new StringBuilder(ss);
            }
            // System.out.println(que);
            if(que.peek() == null){
                count++;
                que.remove();
                if(!que.isEmpty()){
                    que.add(null);
                }
            }
        }
        return 0;
    }
}
