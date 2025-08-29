class Solution {
    public int minCharacters(String a, String b) {
        long res = Integer.MAX_VALUE;
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        int total1 = 0 , total2 = 0;
        for(int i = 0 ; i < a.length() ; i++){
            arr1[a.charAt(i) - 'a']++;
        }
        for(int i = 0 ; i < b.length() ; i++){
            arr2[b.charAt(i) - 'a']++;
        }
        for(int i = 0 ; i < 26 ; i++){
            total1 += arr1[i];
            total2 += arr2[i];
        }
        for(int minEle = 0 ; minEle < 25 ; minEle++){
            long count1 = 0;
            long count2 = 0;
            long count = total1 + total2 - (arr1[minEle] + arr2[minEle]);
            for(int j = minEle + 1 ; j < 26 ; j++){
                count1 += arr1[j];
                count2 += arr2[j];
            }
            for(int j = 0 ; j <= minEle ; j++){
                count1 += arr2[j];
                count2 += arr1[j];
            }
            res = Math.min(res , Math.min(count , Math.min(count1 , count2) ) );
        }
        res = Math.min(res , total1 + total2 - (arr1[25] + arr2[25]));
        return (int)res;
    }
}
