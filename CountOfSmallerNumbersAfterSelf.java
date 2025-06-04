class Solution {
    ArrayList<Integer> list = new ArrayList<>();

    public List<Integer> countSmaller(int[] nums) {
        int[] idx = new int[nums.length];
        for(int i = 0 ; i < nums.length ; i++)list.add(0);
        for(int i = 0 ; i < nums.length ; i++) idx[i] = i;

        mergeSort(nums , 0 , nums.length - 1 , idx);
        System.out.println(Arrays.toString(nums));
        return list;
    }

    public void mergeSort(int[] arr , int left , int right , int[] idx){
        if(left < right){
            int mid = (left + right) / 2;
            mergeSort(arr , left , mid , idx);
            mergeSort(arr , mid + 1 , right , idx);
            merge(arr, left , mid , right , idx);
        }
    }

    public void merge(int[] arr , int left , int mid , int right, int[] idx){
        int[] temp = new int[right - left + 1];
        int[] tempIdx = new int[right - left + 1];

        //System.out.println(Arrays.toString(arr) + "  " + list);
        int i = left , j = mid + 1 , k = 0;
        while(i <= mid && j <= right){
            if(arr[i] > arr[j]){
                temp[k] = arr[i];
                tempIdx[k] = idx[i];
                list.set(idx[i] , list.get(idx[i]) + right - j + 1 );
                i++;
            }
            else{
                temp[k] = arr[j];
                tempIdx[k] = idx[j];
                j++;
            }
            k++;
        }
        while(i <= mid){
            temp[k] = arr[i];
            tempIdx[k] = idx[i];
            k++;
            i++;
        }
        while(j <= right){
            temp[k] = arr[j];
            tempIdx[k] = idx[j];
            k++;
            j++;
        }
        for(int p = 0 ; p < temp.length ; p++){
            arr[left] = temp[p];
            idx[left] = tempIdx[p];
            left++;
        }
    }
}
