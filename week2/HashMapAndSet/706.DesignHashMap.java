class MyHashMap {

    class LinkedNode {
        int key;
        int value;
        LinkedNode next;
        public LinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    /** Initialize your data structure here. */
    LinkedNode[] arr;
    int size;
    public MyHashMap() {
        this.size = 1000;
        this.arr = new LinkedNode[size];
        for(int i = 0; i < size; i++) {
            arr[i] = new LinkedNode(0, 0);
        }
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash = Integer.hashCode(key) % size;
        
        LinkedNode node = arr[hash].next;
        while(node != null) {
            if(node.key == key) {
                node.value = value;
                return;
            }
            node = node.next;
        }
        
        LinkedNode newNode = new LinkedNode(key, value);
        newNode.next = arr[hash].next;
        arr[hash].next = newNode;
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = Integer.hashCode(key) % size;
        
        LinkedNode node = arr[hash].next;
        while(node != null) {
            if(node.key == key) return node.value;
            node = node.next;
        }
        
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = Integer.hashCode(key) % size;
        
        LinkedNode node = arr[hash].next;
        LinkedNode prev = arr[hash];
        while(node != null) {
            if(node.key == key) {
                prev.next = node.next;
                break;
            }
            prev = node;
            node = node.next;
        }
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */