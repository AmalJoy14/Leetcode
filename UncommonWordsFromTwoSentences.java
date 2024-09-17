class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashSet<String> set = new HashSet<>();
        HashSet<String> res = new HashSet<>();

        String[] a = s1.split(" ");
        String[] b = s2.split(" ");

        for (String s : a){
            if (!set.contains(s)){
                set.add(s);
                res.add(s);
            }
            else{
                if (res.contains(s)){
                    res.remove(s);
                }
            }
        }

        for (String s : b){
            if (!set.contains(s)){
                set.add(s);
                res.add(s);
            }
            else{
                if (res.contains(s)){
                    res.remove(s);
                }
            }
        }
        String[] result = new String[res.size()];
        int i = 0;
        for (String s : res){
            result[i] = s;
            i++;
        }
        return result;
    }
}
