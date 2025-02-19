class Solution {
    int count = 0;
    String res = "";
    public String getHappyString(int n, int k) {
        create(n , k  , 0 , '_' , new StringBuilder() );
        return count == k ? res : "";
    }
    public void create(int n , int k  ,int index , char prev , StringBuilder sb ){
        if(count >= k){
            return;
        }
        if(index == n){
            res = String.valueOf(sb);
            count++;
            return;
        }
        
        for(char i = 'a' ; i < 'd' ; i++){
            if(i != prev){
                sb.append(i);
                create( n , k , index + 1 , i , sb );
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return;
    }
}
