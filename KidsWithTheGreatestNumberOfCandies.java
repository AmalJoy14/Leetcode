class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean>  result= new ArrayList<>();
        int max = 0;

        //find max
        for (int i = 0 ; i< candies.length ; i++){
            if (max< candies[i]){
                max = candies[i];
            }
        } 

        for (int i = 0 ; i< candies.length ; i++){
            if (candies[i] + extraCandies >= max){
                result.add(i,true);
            }
            else{
                result.add(i,false);
            }
        }
        return result;
    }
}
