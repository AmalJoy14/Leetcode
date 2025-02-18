class Solution {
    String res = "";
    public String smallestNumber(String pattern) {
        int[] taken = new int[10];
        create( pattern , new StringBuilder() , 1 , 10 , taken, 0);
        return res;
    }
    public boolean create(String pattern , StringBuilder sb , int start , int stop , int[] taken , int index){

        for(int i = start ; i < stop ; i++){
            if(taken[i] == 0){
                sb.append(String.valueOf(i));
                taken[i] = 1;
                if(sb.length() == pattern.length() + 1){
                    res = String.valueOf(sb);    
                    taken[i] = 0;
                    sb.deleteCharAt(sb.length() - 1);
                    return true;
                }
                if(pattern.charAt(index) == 'I'){
                    if(create(pattern , sb , i + 1, 10 , taken , index + 1)){
                        return true;
                    }
                }
                else{
                    if(create(pattern , sb , 1 , i , taken , index + 1)){
                        return true;
                    }
                }
                taken[i] = 0;
                sb.deleteCharAt(sb.length() - 1);
                
            }
        }
        return false;
    }
}
