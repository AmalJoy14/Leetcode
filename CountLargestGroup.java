class Solution {
    public int countLargestGroup(int n) {
        int[] arr = new int[37];
        int max = 0;
        for(int i = 1 ; i <= n ; i++){
            int val = digitSum(i);
            arr[val]++;
            max = Math.max(max , arr[val]);
        }
        int res = 0;
        for(int num : arr){
            if(num == max) res++;
        }
        return res;
    }
    public int digitSum(int num){
        int sum = 0;
        while(num != 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
