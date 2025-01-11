class Solution {
    public boolean canConstruct(String s, int k) {
        int n = s.length();
        int countDouble = 0 ,countSingle = 0 , countThree = 0;
        if(n == k) return true;
        if(n < k) return false;

        int[] arr = new int[26];

        for(int i = 0 ; i < n ; i++){
            int ch = s.charAt(i) - 'a';
            arr[ch]++;
        }
        // System.out.println(Arrays.toString(arr));
        for(int i = 0 ; i < 26 ; i++){
            countDouble += arr[i] / 2;
            countSingle += arr[i] % 2;
        }
        int pal = countDouble + countSingle;
        if(pal <= k){
            return true;
        }
        // System.out.println(countDouble + " " + countSingle);
        int flag = 0;
        while(flag == 0){
            flag = 1;
            if(countDouble > 0 && countSingle > 0){
                flag = 0;
                countDouble--;
                countSingle--;
                countThree++;
                pal--;
            }
            else if(countDouble > 0){
                countDouble--;
                pal--;
                flag = 0;
            }
            // System.out.println("Heyy");
            if(pal == k){
                return true;
            }
            
        }
        return false;
    }
}
