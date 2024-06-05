class Solution {
    public int maxArea(int[] height) {
        int max = 0 , left = 0 , right = height.length-1;
        
        while (left < right){
            //Find min height
            int minHeight = (height[left] < height[right])? height[left] :height[right];
            int area = (right-left)*minHeight;
            if (area > max){
                max =area;
            }       
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
