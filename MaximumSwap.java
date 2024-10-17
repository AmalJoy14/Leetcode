class Solution {
    public int maximumSwap(int num) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int newnum = num;
        while(num != 0){
            maxHeap.add( num % 10);
            num = num / 10;
        }
        StringBuilder sb = new StringBuilder("" + newnum);
        for (int i = 0 ; i < sb.length() ; i++){
            int val = maxHeap.poll();
            int s = Integer.parseInt(sb.substring(i,i+1));
            if (val == s){
                continue;
            }
            else if (val > s){
                for (int j = sb.length() - 1 ; j >=0 ; j--){
                    int swapVal = Integer.parseInt(sb.substring(j,j+1));
                    if (swapVal == val){
                        sb.delete(j,j+1);
                        sb.insert(j,String.valueOf(s));
                        sb.delete(i,i+1);
                        sb.insert(i,String.valueOf(val));
                        return Integer.parseInt(String.valueOf(sb));
                    }
                }
            }
        }
        return newnum;
    }
}
