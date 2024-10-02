class Solution {
    public int[] arrayRankTransform(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int value : arr) {
            list.add(value); // Autoboxing from int to Integer
        }
        Collections.sort(list);

        HashMap<Integer,Integer> map = new HashMap<>();
        int val = 1;
        for (int i = 0 ; i < list.size() ; i++){
            if (!map.containsKey(list.get(i))){
                map.put(list.get(i), val++);
            }
            
        }
        for (int i = 0 ; i < arr.length ; i++){
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}
