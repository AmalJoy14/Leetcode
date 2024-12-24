class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int len = Math.max(num1.length(), num2.length());
        int carry = 0;
        for(int i = 0 ; i < len ; i++){
            char ch1;
            if(num1.length() - i - 1>= 0){
                 ch1 = num1.charAt(num1.length() - i - 1);
            }
            else{
                ch1 = '0';
            }
            char ch2;
            if(num2.length() - i - 1>= 0){
                 ch2 = num2.charAt(num2.length() - i - 1);
            }
            else{
                ch2 = '0';
            }
            
            
            int res = (ch1 - '0' + ch2 - '0') + carry;
            // System.out.println(ch1 + " " + ch2 + " " + res);
            if(res > 9){
                carry = 1;
                res = res % 10;
            }
            else{
                carry = 0;
            }
            sb.insert(0, res);
            res = 0;
        }
        if(carry == 1) sb.insert(0, "1");
        return String.valueOf(sb);
    }
}
