class Solution {
    String res = "";
    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> set = new HashSet<>();
        for(String s : nums){
            set.add(s);
        }
        String curr = "0".repeat(nums.length);
        find(new StringBuilder(curr) , 0 , nums.length , set);
        return res;
    }
    public boolean find(StringBuilder sb , int idx , int len , HashSet<String> set){
        if(!set.contains(String.valueOf(sb))){
            res = String.valueOf(sb);
            return true;
        }
        
        if(idx == len){
            return false;
        }

        if(find(sb , idx + 1 , len , set)) return true;

        sb.setCharAt(idx , '1');
        if(find(sb , idx + 1 , len , set)) return true;
        sb.setCharAt(idx , '0');
        return false;
    }
}
