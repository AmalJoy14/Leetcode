class Solution {
    public int longestBalanced(String s) {
        int res = 1;
        List<int[]> list = new ArrayList<>();
        list.add(new int[26]);
        int[] arr = new int[26];
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            arr[ch - 'a']++;
            int[] adder = arr.clone();
            list.add(adder);
        }
        for(int i = 0 ; i < s.length() ; i++){
            for(int j = i + 1 ; j <= s.length() ; j++){
                int[] arr1 = list.get(i);
                int[] arr2 = list.get(j);
                int val = -1 ;
                boolean balanced = true;
                for(int k = 0 ; k < 26 ; k++){
                    int diff = arr2[k] - arr1[k];
                    if(diff == 0) continue;
                    if(val == -1) val = diff;
                    else if(val != diff){
                        balanced = false;
                        break;
                    }
                    
                }
                if(balanced && val != -1) res = Math.max(j - i , res);
            }
        }
        return res;
    }
}
