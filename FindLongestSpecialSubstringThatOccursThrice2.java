class Solution {
    public int maximumLength(String s) {
        int left = 1 , right = s.length() - 1 , res = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(isPossible(s, mid)){
                res = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return res;
    }
    public boolean isPossible(String s , int mid){
        int[] arr = new int[26];
        int size = 1;
        for(int i = 1; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch == s.charAt(i - 1)){
                size++;
            }
            else{
                if(size >= mid)
                    arr[s.charAt(i - 1) - 'a'] += size - mid + 1;
                size = 1;
            }
        }
        int last = s.length() - 1;
        if(size >= mid)
            arr[s.charAt(last) - 'a'] += size - mid + 1;
        
        for(int num : arr){
            if(num >= 3) return true;
        }
        return false;
        
    }
}
