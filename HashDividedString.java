class Solution {
    public String stringHash(String s, int k) {
        if (s.length() == 0) return "";
        HashMap <Character,Integer> map = new HashMap<>();
        int index = 0;
        for (char i = 'a' ; i <= 'z' ; i++){
            map.put(i,index);
            index++;
        }

        HashMap <Integer,Character> map2 = new HashMap<>();
        char index2 = 'a';
        for (int i = 0 ; i < 26 ; i++){
            map2.put(i,index2);
            index2++;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0 ; i < s.length() ; i++){
            int sum = 0;
            index = 0;
            while (index < k){
                sum += map.get(s.charAt(i));
                i++;
                index++;
            }
            i--;
            int rem = sum % 26;
            char ch = map2.get(rem);
            result.append(String.valueOf(ch));
        }
        return String.valueOf(result);  
    }
}
