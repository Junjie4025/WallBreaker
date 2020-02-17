class MyHashSet {
    
    LinkedList<Integer>[] arr;
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        this.arr = new LinkedList[1000];
        for(int i = 0; i < 1000; i++) {
            arr[i] = new LinkedList<>();
        }
    }
    
    private int hashCode(int key) {
        return Integer.hashCode(key) % arr.length;
    }
    
    public void add(int key) {
        int hash = hashCode(key);
        
        if(!arr[hash].contains(key)) arr[hash].add(key);
    }
    
    public void remove(int key) {
        int hash = hashCode(key);
        
        arr[hash].remove((Integer)key);
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hash = hashCode(key);
        
        return arr[hash].contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */