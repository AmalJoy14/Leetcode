class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }
        int intervals = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int e : map.values()) {
            pq.add(e);
        }
        

        Queue<List<Integer>> que = new LinkedList<>();
        int top;

        while (!pq.isEmpty() || !que.isEmpty()) {

            if (!pq.isEmpty()) {
                int val = pq.poll() - 1;
                if (val != 0) {
                    int time = intervals + n ;
                    List<Integer> sublist = new ArrayList<>();
                    sublist.add(val);
                    sublist.add(time);
                    que.add(sublist);
                }
            }

            if (!que.isEmpty() && que.peek().get(1) <= intervals) {
                top = que.remove().get(0);
                pq.add(top);
            }

            intervals++;
        }
        return intervals;
    }
}
