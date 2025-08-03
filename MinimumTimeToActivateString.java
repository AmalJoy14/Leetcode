class Solution {
    public int minTime(String s, int[] order, int k) {
        int right = order.length - 1 , left = 0 , res = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(isPossible(order , k , mid)){
                res = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return res;
    }
    public boolean isPossible(int[] order , int k , int time){
        long n = order.length;
        int[] arr = new int[(int)n];
        
        for(int i = 0 ; i <= time; i++){
            arr[order[i]] = 1;
        }
        //System.out.println(Arrays.toString(arr));
        long total = n * (n + 1) / 2;
        long count = 0 , noStar = 0;
        for(int num : arr){
            if(num == 1){
                count = 0;
            }
            else{
                count++;
                noStar += count;
            }
        }
        //System.out.println(count);
        if(total - noStar >= k) return true;
        return false;
    }
}
