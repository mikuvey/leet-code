class LRUCache:
    """
    DS: Double Linked List, HashMap
    HashMap: to add, update and retrieve the key-value Pairs
    DLL: For ranking based on the retrival rate. (Queue isn't possible as it's not a good DS for Updating the ranks) 
    """

    # #Create a DLL class
    # class Dnode:
    #     def __init__(self, key: int, value: int):
    #         #Mem vars
    #         self.key = key #key
    #         self.value = value #value(?)
    #         self.prev = None #prev
    #         self.next = None #next
    #         #methods (?) 

    def __init__(self, capacity: int):
        # self.hash = {}
        # self.head = self.Dnode(-1, -1)
        # self.tail = self.Dnode(-1, -1)
        # self.head.next = self.tail
        # self.tail.prev = self.head
        # self.capacity = capacity

    
    def get(self, key: int) -> int:
        

    def put(self, key: int, value: int) -> None:
        
    # #priorityAddOrUpdate
    # def priorityElement():
    #     """
    #     Whenever a new element is added or used, the ranking of the elements is
    #     updated by moving or appending the used/new element in the front(head)
    #     and if(new) upadating the map aswell
    #     """

    #     #


# Your LRUCache object will be instantiated and called as such:
# capacity = 2
# obj = LRUCache(capacity)
# param_1 = obj.head
# print(param_1)