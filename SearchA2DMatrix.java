class Solution {
    public boolean binarySearch(int[] matrix, int target){
        int left = 0, right = matrix.length - 1;
        while(left <= right){
            int mid = (left + right)/2;
            if (matrix[mid] == target){
                return true;
            }
            else if (matrix[mid] > target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return false;
    }


    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0, right = matrix.length - 1;
        while(left <= right){
            int mid = (left + right)/2;
            if (matrix[mid][0] <= target && matrix[mid][matrix[mid].length - 1] >= target){
                return binarySearch(matrix[mid] , target );
            }
            else if (matrix[mid][0] > target){
                right = mid-1;
            }
            else if (matrix[mid][matrix[mid].length - 1] < target){
                left = mid + 1;
            }
        }
        return false;
    }
}
