class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int[] users = new int[numberOfUsers];
        Collections.sort(events , (a,b) -> {
            if(Integer.compare( Integer.parseInt(a.get(1)), Integer.parseInt(b.get(1))) == 0){
                return b.get(0).compareTo(a.get(0));
            }
            else{
                return Integer.compare( Integer.parseInt(a.get(1)), Integer.parseInt(b.get(1)));
            }
                });
        int[] mentions = new int[numberOfUsers];

        for(int i = 0 ; i < events.size() ; i++){
            if(events.get(i).get(0).equals("OFFLINE")){
                int id = Integer.parseInt(events.get(i).get(2));
                int time = Integer.parseInt(events.get(i).get(1));
                users[id] = time + 60;
            }
            else if(events.get(i).get(0).equals("MESSAGE")){
                if(events.get(i).get(2).equals("ALL")){
                    for(int j = 0 ; j < numberOfUsers ; j++){
                        mentions[j]++;
                    }
                }
                else if(events.get(i).get(2).equals("HERE")){
                    for(int j = 0 ; j < numberOfUsers ; j++){
                        if(users[j] <= Integer.parseInt(events.get(i).get(1))){
                            mentions[j]++;
                        }   
                    }
                }
                else{
                    String[] ids = events.get(i).get(2).split(" ");
                    for(String id : ids){
                        mentions[Integer.parseInt(id.substring(2))]++;
                    }
                }
            }
        }
        return mentions;
    }
}
