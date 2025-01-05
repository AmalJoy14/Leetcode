class Solution {
    public long calculateScore(String s) {
        long val = 0;
        HashSet<Integer> marked = new HashSet<>();
        HashMap<Character , Stack<Integer>> map = new HashMap<>();
        for(char i = 'a' ; i <= 'z' ; i++ ){
            map.put(i , new Stack<Integer>());
        }
        
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            char mirror =(char) ('z' - (ch - 'a'));
            if(!map.get(mirror).isEmpty()){
                int j = map.get(mirror).pop();
                val += i - j;
            }
            else{
                map.get(ch).push(i);
            }
        }
        return val;
    }
}
