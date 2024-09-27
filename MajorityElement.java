class Solution {
    public int majorityElement(int[] nums) {
        /*************Moore's Algorithm*************/
        int freq = 0,element = 0;
        for (int i = 0 ; i < nums.length ; i++){
            if (freq == 0){
                element = nums[i];
            }
            if (nums[i] == element){
                freq++;
            }
            else{
                freq--;
            }
            
        }
        return element;
    }
}




// class Solution {
//     public int majorityElement(int[] nums) {
//         HashMap <Integer,Integer> map = new HashMap<>();
//         for (int i = 0 ; i < nums.length ; i++){
//             if (!map.containsKey(nums[i])){
//                 map.put(nums[i],1);
//             } else {
//                 map.put(nums[i],map.get(nums[i])+1);
//             }
//         }
//         for (Map.Entry <Integer,Integer> e : map.entrySet()){
//             if (e.getValue() > nums.length/2){
//                 return e.getKey();
//             }
//         }
//         return -1;
//     }
// }
