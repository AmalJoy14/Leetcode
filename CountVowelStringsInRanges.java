class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] arr = new int[words.length];
        int count = 0;
        for(int i = 0 ; i < words.length ; i++){
            char ch1 = words[i].charAt(0);
            char ch2 = words[i].charAt(words[i].length() - 1);
            if((ch1 == 'a' || ch1 == 'e' || ch1 == 'i' || ch1 == 'o' || ch1 == 'u') &&
            (ch2 == 'a' || ch2 == 'e' || ch2 == 'i' || ch2 == 'o' || ch2 == 'u')){
                count++;
            }
            arr[i] = count;
        }
        int[] res = new int[queries.length];
        for(int i = 0 ; i < queries.length ; i++){
            if( queries[i][0] - 1 == -1){
                res[i] = arr[queries[i][1]];
                continue;
            }
            res[i] = arr[queries[i][1]] - arr[queries[i][0] - 1];
        }
        
        return res;
    }
}
