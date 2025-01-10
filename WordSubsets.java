class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> list = new ArrayList<>();
        int[] arr = new int[26];
        for(int i = 0 ; i < words2.length ; i++){
            int[] temp = new int[26];
            for(int j = 0 ; j < words2[i].length() ; j++){
                int ch = words2[i].charAt(j) - 'a';
                temp[ch]++;
            }
            for(int j = 0 ; j < 26 ; j++){
                arr[j] = Math.max(arr[j] , temp[j]);
            }
        }

        for(int i = 0 ; i < words1.length ; i++){
            int[] temp = new int[26];
            for(int j = 0 ; j < words1[i].length() ; j++){
                int ch = words1[i].charAt(j) - 'a';
                temp[ch]++;
            }
            int flag = 1;
            for(int j = 0 ; j < 26 ; j++){
                if(arr[j] != 0 && arr[j] > temp[j]){
                    flag = 0;
                }
            }
            if(flag == 1){
                list.add(words1[i]);
            }
        }
        return list;
    }
}
