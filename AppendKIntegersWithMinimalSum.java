class Solution {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for(int i = 1 ; i < nums.length ; i++){
            if(list.get(list.size() - 1) != nums[i]){
                list.add(nums[i]);
            }
        }
        
        //find no. elements before K
        int pivot = -1 , count = 0;
        for(int i = 0 ; i < list.size() ; i++){
            if(list.get(i) <= k){
                count++;
            }
            else{
                pivot = i;
                break;
            }
        }
        if(pivot == -1) pivot = list.size();
        //System.out.println(list + " " + pivot);
        
        k++;
        while(pivot < list.size() && count > 0){
            if(list.get(pivot) == k){
                pivot++;
                count++;
            } 
            count--;
            k++;
        }
        k--;
        k += count;
        //System.out.println(k);
        long red = 0;
        for(int i = 0 ; i < pivot ; i++){
            red += list.get(i);
        }
        return (long) k * (long)(k + 1) / 2 - red;  
    }
}
