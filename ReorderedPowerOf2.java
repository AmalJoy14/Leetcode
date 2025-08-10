class Solution {
    int digCount;
    public boolean reorderedPowerOf2(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        while(n != 0){
            list.add(n % 10);
            n /= 10;
        }
        digCount = list.size();
        return isPossible(list , list.size() , 0);
    }
    public boolean isPossible(List<Integer> list , int size , int num){
        if(size == 0 && num != 0 && num >= Math.pow(10 , digCount - 1) ){
            if((num & ( num - 1)) == 0) return true;
            return false;
        }
        for(int i = 0 ; i < list.size() ; i++){
            int val = list.remove(i);
            if(isPossible(list , size - 1 , num * 10 + val)){
                return true;
            }
            list.add(i , val);
        }
        return false;
    }
}
