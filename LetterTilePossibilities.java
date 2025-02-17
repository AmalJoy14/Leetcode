class Solution {
    public int numTilePossibilities(String tiles) {
        HashSet<String> list = new HashSet<>();
        findPerm(new StringBuilder(tiles) , new StringBuilder() , list, tiles.length());
        return list.size() - 1;
    }

    public void findPerm(StringBuilder tiles , StringBuilder sb , HashSet<String> list ,int len){
        list.add(String.valueOf(sb));
        if(sb.length() == len){
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

}
