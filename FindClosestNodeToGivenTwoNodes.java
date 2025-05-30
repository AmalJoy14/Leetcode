class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];

        Arrays.fill(dist1 , -1);
        Arrays.fill(dist2 , -1);

        int count1 = 0 ;
        while(node1 != -1 && dist1[node1] == -1){
            dist1[node1] = count1;
            count1++;
            node1 = edges[node1];
        }
        int count2 = 0;
        while(node2 != -1 && dist2[node2] == -1){
            dist2[node2] = count2;
            count2++;
            node2 = edges[node2];
        }
        // System.out.println(Arrays.toString(dist1));
        // System.out.println(Arrays.toString(dist2));

        int max = Integer.MAX_VALUE , res = -1;
        for(int i = 0 ; i < n ; i++){
            if(dist1[i] != -1 && dist2[i] != -1 && max > Math.max(dist1[i] , dist2[i])){
                res = i;
                max = Math.max(dist1[i] , dist2[i]);
            }
        }
        return res;
    }
}
