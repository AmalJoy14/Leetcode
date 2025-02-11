class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0 , nums.length - 1);
        return nums;
    }
    public void mergeSort(int[] nums ,int start ,int end){
        if(start == end) return;

        int mid = (start + end)/2;
        mergeSort(nums , start , mid);
        mergeSort(nums , mid + 1 , end);
        merge(nums , start , mid , end);
    }
    public void merge(int[] nums , int start , int mid , int end){
        ArrayList<Integer> temp = new ArrayList<>();
        int i = start , j = mid + 1;
        while(i <= mid && j <= end){
            if(nums[i] >= nums[j]){
                temp.add(nums[j]);
                j++;
            }
            else{
                temp.add(nums[i]);
                i++;
            }
        }
        while(i <= mid){
            temp.add(nums[i]);
            i++;
        }
        while(j <= end){
            temp.add(nums[j]);
            j++;
        }
        for(int idx = 0 ; idx < temp.size() ; idx++){
            nums[start + idx] = temp.get(idx);
        }
    }
}
