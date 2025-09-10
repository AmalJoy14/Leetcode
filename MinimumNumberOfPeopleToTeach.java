class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        List<int[]> list = new ArrayList<>();
        for(int i = 0 ; i < friendships.length ; i++){
            int u = friendships[i][0];
            int v = friendships[i][1];
            if(!hasCommon(u , v , languages)){
                list.add(new int[]{u , v});
            }
        }

        Map<Integer,Set<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < languages.length ; i++){
            map.put(i + 1 , new HashSet<>());
            for(int lang : languages[i]){
                map.get(i + 1).add(lang);
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 1 ; i <= n ; i++){
            int count = 0;
            Set<Integer> taught = new HashSet<>();
            for(int j = 0 ; j < list.size() ; j++){
                int u = list.get(j)[0];
                int v = list.get(j)[1];
                if(!map.get(u).contains(i) && !taught.contains(u)){
                    count++;
                    taught.add(u);
                } 
                if(!map.get(v).contains(i) && !taught.contains(v)) {
                    count++;
                    taught.add(v);
                }
            }
            min = Math.min(min , count);
            //System.out.println(i + " "  +min + " " + count);
        }
        return min;
    }

    public boolean hasCommon(int u , int v , int[][] languages){
        int[] lang1 = languages[u - 1];
        Set<Integer> set1 = new HashSet<>();
        for(int num : lang1){
            set1.add(num);
        }
        int[] lang2 = languages[v - 1];
        for(int num : lang2){
            if(set1.contains(num)){
                return true;
            }
        }
        return false;
    }
}
