class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>();
        int curr = 1;
        for(int i = 0 ; i < target.length ; i++){
            if(target[i] == curr){
                list.add("Push");
                curr++;
            }else{
                list.add("Push");
                list.add("Pop");
                curr++;
                i--;
            }
        }
        return list;
    }
}
