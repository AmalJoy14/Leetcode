class Solution {
    public boolean checkIfExist(int[] arr) {
        int countZero = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0 ; i < arr.length ; i++){
            set.add(arr[i]);
            if (arr[i] == 0) countZero++;
        }
        for (int i = 0 ; i < arr.length ; i++){
            if (arr[i] == 0 && countZero > 1){
                return true;
            }
            else if (arr[i] != 0 && set.contains(arr[i] * 2)){
                return true;
            }
        }
        return false;
    }
}
