class Solution {
    public String convertBin(int num){
        StringBuilder sb = new StringBuilder();
        while(num != 0){
            sb.insert(0,num % 2);
            num /= 2;
        }
        return String.valueOf(sb);
    }
    public String convertDateToBinary(String date) {
        int year = Integer.parseInt(date.substring(0,4));
        int month = Integer.parseInt(date.substring(5,7));
        int day = Integer.parseInt(date.substring(8,10));

        return convertBin(year) +"-"+ convertBin(month) + "-" + convertBin(day);
        
    }
}
