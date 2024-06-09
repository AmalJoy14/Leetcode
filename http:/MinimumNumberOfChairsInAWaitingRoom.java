class Solution {
    public int minimumChairs(String s) {
        int noOfChairs = 0, peopleInRoom = 0;
        for (int i = 0 ; i< s.length() ; i++){
            if (s.charAt(i) == 'E'){
                peopleInRoom++;
                if(peopleInRoom > noOfChairs) {
                    noOfChairs++;
                }
            } else{
                peopleInRoom--;
            }
        }
        return noOfChairs;
    }
}
