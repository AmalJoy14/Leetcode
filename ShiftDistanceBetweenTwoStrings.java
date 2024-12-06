class Solution {
    public long shiftDistance(String s, String t, int[] nextCost, int[] previousCost) {
        long sum = 0;
        for (int i = 0 ; i < s.length() ; i++){
            int index = s.charAt(i) - 'a';
            char ch = t.charAt(i);
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(i);
            long prevCost = 0, nextcost = 0;
            while(ch1 != ch){
                if (ch1 == 'a') ch1 = 'z';
                else ch1--;
                
                prevCost += previousCost[index];
                 // System.out.println(prevCost);
                
                if (index == 0) index = 25;
                else index--;
                
            }
            index = s.charAt(i) - 'a';

            while(ch2 != ch){
                if (ch2 == 'z') ch2 = 'a';
                else ch2++;
                
                nextcost += nextCost[index];
                // System.out.println("next : " +nextcost);
                if (index == 25) index = 0;
                else index++;
                
            }
            sum += Math.min(prevCost, nextcost);
            // System.out.println("Donne");
        }
        return sum;
    }
}
