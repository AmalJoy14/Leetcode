class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        double res = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Double.compare(a[0]/(double)a[1] - (a[0]+1)/(double)(a[1]+1), b[0]/(double)b[1] - (b[0]+1)/(double)(b[1]+1)) );
        for (int i = 0 ; i < classes.length ; i++){
            pq.add(classes[i]);
        }
        for(int i = 0 ; i < extraStudents ; i++){
            int [] arr = pq.poll();
            arr[0]++;
            arr[1]++;
            pq.add(arr);
        }
        while(!pq.isEmpty()){
            int [] arr = pq.poll();
            res += arr[0]/(double)arr[1];
        }
        return res/(double)classes.length;
    }
}
