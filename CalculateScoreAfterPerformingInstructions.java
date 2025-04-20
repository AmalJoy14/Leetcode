class Solution {
    public long calculateScore(String[] instructions, int[] values) {
        int n = instructions.length;
        long score = 0;
        for(int i = 0 ; i < n ; i++){
            if(instructions[i] == "done") return score;
            if(i < 0 ) return score;
            if(instructions[i].equals("add")){
                if(i >= n || i < 0 ) return score;
                score += values[i];
                instructions[i] = "done";
                //System.out.println("heyy");
            }
            else if(instructions[i].equals("jump")){
                
                if(values[i] == 0) return score;
                instructions[i] = "done";
                i += values[i];
                if(i >= n || i < 0 ) return score;
                
                i--;
                //System.out.println("heyy22");
            }
            //System.out.println(i + " " + score);
            // // if(values[i] == Integer.MAX_VALUE) return score;
            // if(i >= n || i < 0 ) return score;
        }
        return score;
    }
}
