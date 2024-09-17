class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        //Map the position of car with its speed before sorting. 
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i < position.length ; i++){
            map.put(position[i], speed[i]);
        }
        Arrays.sort(position);
        //Now we have the cars in correct order of position.

        Stack<Double> stk = new Stack<>();

        //Calculate time taken for each car to reach destination.
        for (int i = position.length - 1 ; i >= 0 ; i--){
            double time = (target - position[i])/(double)map.get(position[i]);     // [ Time = Distance / Speed ]
            
            // Only push the time if this car can't merge with the fleet in front.
            if (!stk.isEmpty() && time <= stk.peek()) {
                continue; // Skip pushing if it joins the fleet.
            }
            stk.push(time); // New fleet starts here.
            
        } 
        return stk.size();
    }
}
