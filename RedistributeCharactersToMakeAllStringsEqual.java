class Solution {
    public boolean makeEqual(String[] words) {
        int[] arr = new int[26];
        for(int i = 0 ; i < words.length  ;i++){
            for(int j = 0 ; j < words[i].length() ; j++){
                arr[words[i].charAt(j) - 'a']++;
            }
        }
        int size = words.length;
        for(int num : arr){
            if(num % size != 0) return false;
        }
        return true;
    }
}
