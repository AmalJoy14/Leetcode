class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] min = new int[26];
        int[] max = new int[26];
        Arrays.fill(min , -1);
        Arrays.fill(max , -1);

        for(int i = 0 ; i < s.length() ; i++){
            int ch = s.charAt(i) - 'a';
            if(min[ch] == -1){
                min[ch] = i;
            }
            max[ch] = i;
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < s.length() ; i++){
            int start = i,end = max[s.charAt(i) -'a'];
            for(int j = start ; j < end ; j++){
                if(max[s.charAt(j) -'a'] > end){
                    end = max[s.charAt(j) -'a'];
                }
            }
            i = end;
            list.add(end - start + 1);
        }
        return list;
    }
}
