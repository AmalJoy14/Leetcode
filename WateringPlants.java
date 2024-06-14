class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int step = 0, waterBucket = 0,completed = 0;
        
        for (int i = -1; i < plants.length; i++) {
            
            if (i == -1) {
                waterBucket = capacity;
            }
            else {
                    if (plants[i] <= waterBucket){
                        waterBucket -= plants[i];
                    }
                    if (i != plants.length-1 && plants[i+1] > waterBucket){
                    step+= 2*(i+1);
                    waterBucket = capacity;
                    }
            }
            step++;
        }
        return step-1;
    }
}
