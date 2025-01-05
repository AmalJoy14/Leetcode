class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        HashMap<Integer , Integer > start = new HashMap<>();
        HashMap<Integer , Integer > end = new HashMap<>();
        

        for(int i = 0 ; i < shifts.length ; i++){
            int val = shifts[i][2] == 0 ? -1 : 1;
            start.put(shifts[i][0] , start.getOrDefault(shifts[i][0], 0) + val);
            end.put(shifts[i][1] + 1, end.getOrDefault(shifts[i][1] + 1, 0) - val);
        }
        // System.out.println(start + " " + end);

        StringBuilder sb = new StringBuilder();
        int change = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(start.containsKey(i)){
                change = start.get(i) + change;
            }
            if(end.containsKey(i)){
                change = end.get(i) + change;
            }
            char ch = (char) ('a' + (s.charAt(i) - 'a' + (change % 26 + 26)) % 26);
            sb.append(ch);
        }
        return String.valueOf(sb);
    }
}
