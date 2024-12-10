class Solution {
    public int maximumLength(String s) {
        PriorityQueue<Integer>[] arr = new PriorityQueue[26];
        int[] ch = new int[26];
        for (int i = 0 ; i < arr.length ; i++){
            arr[i] = new PriorityQueue<>();
        }
        ch[s.charAt(0) - 'a']++;
        if(s.charAt(0) != s.charAt(1)){
            arr[s.charAt(0) - 'a'].add(1);
        }
        for(int i = 1 ; i < s.length() ; i++){
            ch[s.charAt(i) - 'a']++;
            int size = 1;
            int j = i;
            arr[s.charAt(j) - 'a'].add(1);
            while(j < s.length() && s.charAt(j) == s.charAt(j - 1)){
                size++;
                j++;
            }
            arr[s.charAt(j- 1) - 'a'].add(size);
            if(arr[s.charAt(j - 1) - 'a'].size() > 3){
                arr[s.charAt(j - 1) - 'a'].poll();
            }
        }
        int res = -1;
        for(int i = 0 ; i < arr.length ; i++){
            while(arr[i].size() > 3){
                arr[i].poll();
            }
            if (arr[i].size() == 3 && ch[i] >= 3){
                res =Math.max(res , arr[i].poll());
            }
        }
        return res;
    }
}
