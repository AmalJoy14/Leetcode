class Solution {
    public int minimizeXor(int num1, int num2) {
        int setCount = 0;
        while(num2 != 0){
            if((num2 & 1) == 1){
                setCount++;
            }
            num2 >>= 1 ;
        }
        System.out.println(setCount);
        String s = Integer.toBinaryString(num1);
        StringBuilder sb = new StringBuilder("0".repeat(s.length()));

        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '1' && setCount > 0){
                sb.setCharAt(i , '1');
                setCount--;
            }
        }
        for(int i = s.length() - 1 ; i >= 0 ; i--){
            if(s.charAt(i) == '0' && setCount > 0){
                sb.setCharAt(i , '1');
                setCount--;
            }
        }
        while(setCount > 0){
            sb.insert(0 , '1');
            setCount--;
        }
        return Integer.parseInt(String.valueOf(sb) , 2);
    }
}
