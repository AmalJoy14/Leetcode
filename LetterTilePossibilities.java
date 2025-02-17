class Solution {
    public int numTilePossibilities(String tiles) {
        HashSet<String> set = new HashSet<>();
        HashSet<String> list = new HashSet<>();
        findPerm(new StringBuilder(tiles) , new StringBuilder() , list, tiles.length());
        for(String s : list)
            findCount( s , set , 0 , new StringBuilder() , s.length());
        return set.size() - 1;
    }

    public void findPerm(StringBuilder tiles , StringBuilder sb , HashSet<String> list ,int len){
        if(sb.length() == len){
            list.add(String.valueOf(sb));
            return;
        }
        
        for(int i = 0 ; i < tiles.length() ; i++){
            sb.append(tiles.charAt(i));
            tiles.deleteCharAt(i);
            findPerm(tiles , sb , list, len);
            tiles.insert(i , sb.charAt(sb.length() - 1));
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public void findCount(String tiles , HashSet<String> set , int i , StringBuilder sb , int len){
        set.add(String.valueOf(sb));
        
        if(i == len){
            return;
        }
        
        findCount(tiles , set , i + 1 , sb ,len);
        
        sb.append(tiles.charAt(i));
        findCount(tiles , set , i + 1 , sb ,len);
        sb.deleteCharAt(sb.length() - 1);

    }

}
