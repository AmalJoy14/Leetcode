class Solution {
    public boolean hasMatch(String s, String p) {
        
        String[] arr = p.split("\\*");
        ArrayList<String> list = new ArrayList<>();
        for(String ss : arr){
            if(ss.equals("")){
                continue;
            }
            list.add(ss);
        }
        if(list.size() == 0) return true;
        if(list.size() == 1){
            if(s.contains(list.get(0))) return true;
            return false;
        }
        System.out.println(Arrays.toString(arr));
        int k = 0;
        for(int i = 0 ; i < s.length() ; i++){
            for (int j = i ; j < s.length()  ; j++){
                // System.out.println(s.substring(i , j+1));
                if(s.substring(i , j+1).equals(arr[k])){
                    
                    k++;
                    i = j;
                    break;
                }
            }
            if(k >= 2){
                return true;
            }
        }
        return false;
    }
}
