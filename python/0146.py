class Node:
    def __init__(self, key: int, val: int, prev = None, next = None):
        self.key = int(key)
        self.val = int(val)
        self.prev = prev
        self.next = next
class LRUCache:
    def __init__(self, capacity: int):
        self.cache = {}
        self.lru = None
        self.mru = None
        self.capacity = capacity

    def get(self, key: int) -> int:
        node = self.cache.get(key)
        if node:
            self.move_to_mru(node)
            return node.val
        else:
            return -1

    def put(self, key: int, value: int) -> None:
        node = self.cache.get(key)
        if node:
            self.move_to_mru(node)
            node.val = value
        else:
            if len(self.cache) == self.capacity:
                self.eject_lru()
            node = Node(key, value)
            self.set_mru(node)
            self.cache[key] = node

    def eject_lru(self) -> None:
        if self.lru:
            self.cache.pop(self.lru.key)
            self.lru = self.lru.next
    
    def move_to_mru(self, node) -> None:
        if self.mru is node: return

        if self.lru is node:
            self.lru = node.next
        else:
            node.prev.next = node.next
        
        node.next.prev = node.prev

        self.mru.next = node
        node.prev = self.mru
        node.next = None
        self.mru = node
    
    def set_mru(self, node) -> None:
        if self.mru:
            self.mru.next = node
            node.prev = self.mru
        if not self.lru: self.lru = node
        self.mru = node

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
