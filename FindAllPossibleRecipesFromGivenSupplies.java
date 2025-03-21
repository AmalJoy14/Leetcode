class Edge{
    List<String> neighbours;
    String val;
    int isPresent = 0;
    Edge(List<String> neighbours , String val){
        this.neighbours = neighbours;
        this.val = val;
    }
}

class Solution {
    List<String> res = new ArrayList<>();
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashMap<String , Edge> map = new HashMap<>();
        for(int i = 0 ; i < recipes.length ; i++){
            map.put(recipes[i] , new Edge(ingredients.get(i) , recipes[i]));
        }

        HashSet<String> suppliesSet = new HashSet<>();
        for(String s : supplies){
            suppliesSet.add(s);
        }

        
        for(int i = 0 ; i < recipes.length ; i++){
            dfs(recipes[i] , map , suppliesSet , new HashSet<>());
        }
        return res;
    }
    public boolean dfs(String food , HashMap<String , Edge> map, HashSet<String> supplies , HashSet<String> set){
        if(supplies.contains(food)){
            return true;
        }
        if(!map.containsKey(food) || set.contains(food)) return false;
        Edge e = map.get(food);
        if(e.isPresent == 1) return true;
        if(e.isPresent == -1) return false;

        boolean retVal = true;
        set.add(food);
        for(String s : e.neighbours){
            retVal = retVal && dfs(s , map , supplies , set);
        }
        set.remove(food);
        if(retVal){
            e.isPresent = 1;
            res.add(e.val);
        }
        else{
            e.isPresent = -1;
        }
        return retVal;
    }
}
