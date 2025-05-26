class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        HashMap<String , Integer> map = new HashMap<>();
        int res = 0;
        for(int k = minSize ; k <= maxSize ; k++){
            int[] arr = new int[26];
            int unique = 0;
            for(int i = 0 ; i < k ; i++){
                char ch = s.charAt(i);
                if(arr[ch - 'a'] == 0) unique++;
                arr[ch - 'a']++;
            }
            
            int left = 0;
            for(int right = k ; right < s.length() ; right++){
                if(unique <= maxLetters){
                    String sub = s.substring(left , right);
                    map.put( sub, map.getOrDefault(sub , 0) + 1);
                    res = Math.max(res , map.get(sub));
                } 

                char ch = s.charAt(right);
                if(arr[ch - 'a'] == 0) unique++;
                arr[ch - 'a']++;
                
                ch = s.charAt(left);
                arr[ch - 'a']--;
                if(arr[ch - 'a'] == 0) unique--;
                left++;

            }
            if(unique <= maxLetters){
                String sub = s.substring(left , s.length());
                map.put( sub, map.getOrDefault(sub , 0) + 1);
                res = Math.max(res , map.get(sub));
            } 
        }
        
        return res;
    }
}
