class Solution {
    List<String> list = new ArrayList<>();
    HashMap<Integer ,List<Character>> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0){
            return list;
        }
        //HashMap Generation.
        int num = 2,count = 0;
        for (char i = 'a' ; i <= 'z' ; i++){
            if (map.containsKey(num)){
                map.get(num).add(i);
            }
            else{
                map.put(num , new ArrayList<>());
                map.get(num).add(i);
            }
            
            count++;
            if (num != 7 && num != 9 && count == 3){
                count = 0;
                num++;
            }
            if ((num == 7 || num == 9) && count == 4){
                    count = 0;
                    num++;
            }
        }
        /////////////////////////////////////////////////

        findComb(digits , 0 ,"");
        return list;
    }

    public void findComb(String digits ,int index , String s){
        if (index == digits.length()){
            list.add(s);
            return;
        }

        int num = Integer.parseInt(digits.substring(index , index + 1));

        List<Character> sub = map.get(num);

        for (int i = 0 ; i < sub.size() ; i++){
            findComb(digits , index + 1 , s + String.valueOf(sub.get(i)) );
        }


    }
}
