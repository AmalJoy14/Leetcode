class Solution {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int n = price.length;
        int left = 0 , right = price[n - 1];
        int res = 0;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(isPossible(price , k - 1, mid)){
                res = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return res;
    }

    public boolean isPossible(int[] price , int count , int currVal){
        int prev = price[0];
        for(int i = 1 ; i < price.length && count > 0; i++){
            if(price[i] - prev >= currVal){
                count--;
                prev = price[i];
            }
        }
        return count == 0;
    }
}
