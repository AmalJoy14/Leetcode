class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> trueStr = new HashSet<>();
        Map<String ,String> capt = new HashMap<>();
        Map<String , String> vowels = new HashMap<>();
        for(String str : wordlist){
            trueStr.add(str);
            String lowerStr = str.toLowerCase();
            if(!capt.containsKey(lowerStr)){
                capt.put(lowerStr , str);
            }
            StringBuilder sb = new StringBuilder();
            for(int j = 0 ; j < str.length() ; j++){
                char ch = lowerStr.charAt(j);
                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                    sb.append('#');
                }else{
                    sb.append(ch);
                }
            }
            
            if(!vowels.containsKey(String.valueOf(sb))){
                vowels.put(String.valueOf(sb) ,str);
            }
            
        }
        int n = queries.length;
        String[] res = new String[n];
        for(int i = 0 ; i < n ; i++){
            String query = queries[i];
            if(trueStr.contains(query)){
                res[i] = query;
            }else if(capt.containsKey(query.toLowerCase())){
                res[i] = capt.get(query.toLowerCase());
            }else{
                StringBuilder sb = new StringBuilder();
                String lowerStr = query.toLowerCase();
                for(int j = 0 ; j < query.length() ;j++){
                    char ch = lowerStr.charAt(j);
                    if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                        sb.append('#');
                    }else{
                        sb.append(ch);
                    }
                }
                if(vowels.containsKey(String.valueOf(sb))){
                    res[i] = vowels.get(String.valueOf(sb));
                }else{
                    res[i] = "";
                }
            }
        }
        return res;    
    }
}
