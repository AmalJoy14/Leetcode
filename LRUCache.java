class Node {
    int val;
    int key;
    Node prev;
    Node next;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    HashMap<Integer, Node> map;
    int capacity, size;
    Node head, tail;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.size = 0;

        // Dummy head and tail nodes to simplify operations
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            Node node = map.get(key);
            // Move the accessed node to the front (most recently used position)
            moveToHead(node);
            return node.val;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // If key exists, update the value and move it to the front
            Node node = map.get(key);
            node.val = value;
            moveToHead(node);
        } else {
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addNode(newNode);
            size++;

            // If the cache exceeds capacity, remove the least recently used node
            if (size > capacity) {
                Node lru = tail.prev;
                removeNode(lru);
                map.remove(lru.key);
                size--;
            }
        }
    }

    // Utility methods

    // Add a node right after the head (most recently used position)
    private void addNode(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    // Remove a node from the doubly linked list
    private void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    // Move an existing node to the head (most recently used position)
    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
