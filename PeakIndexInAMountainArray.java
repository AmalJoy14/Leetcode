class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int len = arr.length;
        if (len == 1) return 0;
        if (arr[0] > arr[1]) return 0;
        if (arr[len - 1] > arr[len - 2]) return len -1;

        int left = 0, right = len - 1;
        while (left < right){
            int mid = (left + right) / 2;
            if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]){
                return mid;
            }
            else if(arr[mid] > arr[mid - 1]){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return -1;
    }
}
