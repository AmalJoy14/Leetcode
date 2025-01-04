class Task{
    int userId, taskId,priority;
    public Task(int userId , int taskId , int priority){
        this.taskId = taskId;
        this.userId = userId;
        this.priority = priority;
    }
}
class TaskManager {
    PriorityQueue<Task> pq = null;
    HashMap<Integer , Task > map = null;
    public TaskManager(List<List<Integer>> tasks) {
        pq = new PriorityQueue<>((task1, task2) -> {
            if(Integer.compare(task2.priority , task1.priority) == 0){
                return Integer.compare(task2.taskId , task1.taskId);
            }
            else{
                return Integer.compare(task2.priority , task1.priority);
            }
        });
        map = new HashMap<>();
        int userId= 0 ,taskId = 0,priority = 0;
        for (List<Integer> task : tasks) {
            userId = task.get(0);
            taskId = task.get(1);
            priority = task.get(2);
            add(userId, taskId, priority);
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        Task sub = new Task(userId , taskId , priority);
        pq.add(sub);
        map.put(taskId , sub);
    }
    
    public void edit(int taskId, int newPriority) {
        if(map.containsKey(taskId)){
            Task abc = map.get(taskId);
            add(abc.userId , abc.taskId , newPriority);
            abc.userId = -1;
        }
    }
    
    public void rmv(int taskId) {
        if(map.containsKey(taskId)){
            map.get(taskId).userId = -1;
            map.remove(taskId);
        }
        
    }
    
    public int execTop() {
        if(pq.isEmpty()){
            return -1;
        }
        while (!pq.isEmpty()) {
            
            Task arr = pq.peek();
            
            if (arr.userId == -1) {
                pq.poll();
            }
            else{
                map.remove(arr.taskId);
                pq.poll();
                return arr.userId;
            }
        }
        
        return -1;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */
