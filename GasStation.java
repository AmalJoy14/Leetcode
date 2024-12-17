class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //Kadane's Algo
        int totalGas = 0,totalCost = 0;
        int[] diff = new int[gas.length];
        for(int i = 0 ; i < gas.length ; i ++){
            diff[i] = gas[i] - cost[i];
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if(totalGas < totalCost){
            return -1;
        }
        int sum = 0;
        int start = 0;
        for(int i = 0 ; i < diff.length ; i++){
            sum += diff[i];
            if(sum < 0){
                start = i + 1;
                sum = 0;
            }
        }
        return start;
    }
}
