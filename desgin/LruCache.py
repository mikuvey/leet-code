class LRUCache:
    class DoubleLink:
        #Create a node with 3 fields; Val, left, right
        def __init__(self, val: int, left: self.DoubleLink, right: self.DoubleLink):
            self.val = val
            self.right = right
            self.left = left
    
    #Constructor for LRU Cache
    def __init__(self, capacity: int):
        self.capacity = capacity
        self.cache = {}
        self.head = DoubleLink(0, None, None)
        self.tail = head.right #None

    def get(self, key: int) -> int:
        # If old item is used(get) it's gonna become head aswell 
            #(At the same time check if length is exceeding capacity)
        if key in self.cache:
            return self.cache[key]
        return - 1
       
    def put(self, key: int, value: int) -> None:
        """
        # Put is where the magic happens
        # If the number of keys exceeds the capacity from this operation, evict the least recently used key.
        # DS required for this operation (LRU)?
        # {1:1, 2:2, 3:3}
        # get(2); {2:2, 1:1, 3:3}; We should give ranking to the keys
        # [1, 2, 3] => [2, 1, 3] =>(get(3)) => [3,2,1]
        # If we use an array O(n) for finding element & Shuffling O(n)
        # DoubleLinkedList: 1 - 2 - 3; O(n) finding; 2 - 1 - 3; shuffling O(1)
        """
        # Cache Initialized
        if len(cache) == 0:
            self.head.val = value

        #If len > Capacity -> Remove tail node
        # If New item's added then it's gonna become head
        
        if key not in cache:
            cache[key] = value
            #Create key node
            node = self.DoubleLink(value, None, None)
            self.priorityNode(node)
        else:
            #find the node
            node = self.findNode(value)
            self.priorityNode(node)
        
        #If capacity exceeded del the tail
        if len(cache) > capacity:
            self.delTailNode
        
    
    def findNode(value):
        curr = head
        while(curr.val != value):
            curr = curr.right
        return curr
    
    def priorityNode(node: self.DoubleLink):
        # Store node in temp; and assign left.right as rightNode
        temp = node
        temp.left.right = temp.right
        temp.right.left = temp.left
        # Assign node as head and it's right to current head
        head.left = node
        node.right = head
        head = node
        
    #If capacity is exceeded trim the tail Node
    def delTailNode():
        # Remove tail node
        tail = tail.left
        tail.right = None






# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)