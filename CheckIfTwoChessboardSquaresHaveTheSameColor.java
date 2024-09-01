class Solution {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        HashMap<Character ,Integer> map = new HashMap<>();
        int index = 1;
        for (char i = 'a'; i <='h' ;i++){
            map.put(i,index);
            index++;
        }
        //0 for black , 1 for white
        int col1,col2;
        if ((map.get(coordinate1.charAt(0)) + Integer.valueOf(coordinate1.charAt(1))) % 2 == 0){
            col1 = 0;
        } else{
            col1 = 1;
        }
        if ((map.get(coordinate2.charAt(0)) + Integer.valueOf(coordinate2.charAt(1))) % 2 == 0){
            col2 = 0;
        } else{
            col2 = 1;
        }
        return col1 == col2;
    }
}
