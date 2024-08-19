class Solution {
    public String addBinary(String a, String b) {
        int i = a.length()-1 , j = b.length()-1, carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 && j >= 0){
            if (a.charAt(i) == '1' && b.charAt(j) == '1'){
                if (carry == 1)  sb.insert(0,"1");
                else sb.insert(0,"0");
                carry = 1;
            }else if (a.charAt(i) == '0' && b.charAt(j) == '0'){
                if (carry == 1)  sb.insert(0,"1");
                else sb.insert(0,"0");
                carry = 0;
            }
            else{
                if (carry == 1){
                    sb.insert(0,"0");
                }  
                else 
                    sb.insert(0,"1");
            }
            i--;
            j--;
        }
        while(i >= 0){
            if (a.charAt(i) == '1'){
                if (carry == 1)
                    sb.insert(0,"0");
                else 
                    sb.insert(0,"1");
            } else{
                if (carry == 1)
                    sb.insert(0,"1");
                else 
                    sb.insert(0,"0");
                carry = 0;
            }
            i--;
        }
        while(j >= 0){
            if (b.charAt(j) == '1'){
                if (carry == 1)
                    sb.insert(0,"0");
                else {
                    sb.insert(0,"1");
                    carry = 0;
                }
            } else{
                if (carry == 1)
                    sb.insert(0,"1");
                else 
                    sb.insert(0,"0");
                carry = 0;
            }
            j--;
        }
        if (carry == 1) sb.insert(0,"1");
        return String.valueOf(sb);
    }
}
