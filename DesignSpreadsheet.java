class Spreadsheet {
    int[][] sheet = null;
    public Spreadsheet(int rows) {
        sheet = new int[rows + 1][26];
    }
    
    public void setCell(String cell, int value) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1,cell.length()));
        // System.out.println(row);
        sheet[row][col] = value;
    }
    
    public void resetCell(String cell) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1,cell.length()));
        sheet[row][col] = 0;
    }
    
    public int getValue(String formula) {
        // System.out.println(Arrays.deepToString(sheet));
        int pivot = -1;
        for(int i = 0 ; i < formula.length() ; i++){
            if(formula.charAt(i) == '+'){
                pivot = i;
            }
        }
        String s1 = formula.substring(1 , pivot);
        String s2 = formula.substring(pivot + 1 , formula.length());
        int val1 = 0, val2 = 0;
        if(s1.charAt(0) >= 'A' && s1.charAt(0) <= 'Z'){
            int col = s1.charAt(0) - 'A';
            int row = Integer.parseInt(s1.substring(1,s1.length()));
            val1 = sheet[row][col];
        }
        else{
            val1 = Integer.parseInt(s1);
        }

        if(s2.charAt(0) >= 'A' && s2.charAt(0) <= 'Z'){
            int col = s2.charAt(0) - 'A';
            int row = Integer.parseInt(s2.substring(1,s2.length()));
            val2 = sheet[row][col];
        }
        else{
            val2 = Integer.parseInt(s2);
        }
         // System.out.println(val1 + " "+ val2);
        
        return val1 + val2;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */
