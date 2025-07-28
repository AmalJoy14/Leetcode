class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int res = 1;
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0 ; i < arr.length ; i++){
            if(map.containsKey(arr[i] - difference)){
                map.put(arr[i] , map.get(arr[i] - difference) + 1);
            }
            else{
                map.put(arr[i] , 1);
            }
        }
        for(int key : map.keySet()){
            res = Math.max(res , map.get(key));
        }
        return res;
    }
}
