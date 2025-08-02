class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        long res = 0 , n = basket1.length;
        Map<Integer , Integer> map1 = new HashMap<>();
        Map<Integer , Integer> map2 = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            map1.put(basket1[i] , map1.getOrDefault(basket1[i] , 0) + 1);
            map2.put(basket2[i] , map2.getOrDefault(basket2[i] , 0) + 1);
        }

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for(int key : map1.keySet()){
            int val1 = map1.get(key);
            int val2 = map2.getOrDefault(key , 0);
            if((val1 + val2) % 2 != 0) return -1;
            int half = (val1 + val2) / 2;
            int diff = 0;
            if(val1 > half){
                diff = val1 - half;
            }
            for(int i = 0 ; i < diff ; i++){
                list1.add(key);
            }
        }
        for(int key : map2.keySet()){
            int val1 = map1.getOrDefault(key , 0);
            int val2 = map2.get(key);

            int half = (val1 + val2) / 2;
            int diff = 0;
            if(val2 > half){
                diff = val2 - half;
            }
            for(int i = 0 ; i < diff ; i++){
                list2.add(key);
            }
        }
        Collections.sort(list1);
        Collections.sort(list2);
        //System.out.println(list1 + " " + list2);
        int i1 = 0 , i2 = 0 , j1 = list1.size() - 1 , j2 = list2.size() - 1;
        int min = Integer.MAX_VALUE;
        for(int i = 0 ;i < n ; i++){
            min = Math.min(min , basket1[i]);
            min = Math.min(min , basket2[i]);
        }
        min *= 2;
        while(i1 <= j1){
            if(list1.get(i1) < list2.get(i2)){
                if(min < list1.get(i1)) res += min;
                else res += list1.get(i1);
                i1++;
                j2--;
            }else{
                if(min < list2.get(i2)) res += min;
                else res += list2.get(i2);
                i2++;
                j1--;
            }
        }
        return res;
    }
}
