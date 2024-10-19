class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>((list1,list2) -> Integer.compare(list1.get(0), list2.get(0)));
        int[][] res = new int[k][2];

        for (int i = 0 ; i < points.length ; i++){
            int x = points[i][0];
            int y = points[i][1];
            int dis =x * x + y * y;
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(dis);
            arr.add(x);
            arr.add(y);
            minHeap.add(arr);
        }
        for (int i = 0 ; i < k ; i++){
            List<Integer> a = minHeap.poll();
            res[i] = new int[]{a.get(1) , a.get(2)};
        }
        return res;
    }
}
