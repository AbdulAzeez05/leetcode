class Node{
     int key;
    int val;
    Node prev,next;
    public Node(int key,int val)
    {
        this.key=key;
        this.val=val;
    }
}
class LRUCache {
        int cap;
        Map<Integer,Node> map;
        Node lru,mru;

    public LRUCache(int capacity) {
        this.cap=capacity;
        this.map=new HashMap<>();
        this.lru=new Node(0,0);
        this.mru=new Node(0,0);
        this.lru.next=this.mru;
        this.mru.prev=this.lru;
        
    }
    public void insert(Node node)
    {
        node.next=mru;
        node.prev=mru.prev;

        mru.prev.next=node;
    mru.prev=node;

    }
    public void delete(Node node)
    {
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    
    public int get(int key) {
        if(map.containsKey(key))
        {
            delete(map.get(key));
            insert(map.get(key));
            return map.get(key).val;
        }
        return -1;


        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            delete(map.get(key));
        }
        map.put(key,new Node(key,value));
        insert(map.get(key));
        if(map.size()>cap)
        {
            Node l=lru.next;
            delete(l);
            map.remove(l.key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */