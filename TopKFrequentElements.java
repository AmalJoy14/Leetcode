class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap <Integer,Integer> map = new HashMap<>();
        for (int i = 0 ; i < nums.length ; i++){
            if (!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }
            else{
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        int[] res = new int[k];

        List<Integer>[] arr = new ArrayList[nums.length + 1];    //IMP NOTE IT
        
        for (int key : map.keySet()){
            int count = map.get(key); //Value of count
            if (arr[count] == null){
                arr[count] = new ArrayList<>();
            }
            arr[count].add(key);
        }

        int j = 0;
        for (int i = arr.length - 1 ; i >= 0 && k > j; i--){
            if (arr[i] == null) continue;
            for (int e : arr[i]){
                res[j] = e;
                j++;
            } 
        }
        return res;
    }
}
