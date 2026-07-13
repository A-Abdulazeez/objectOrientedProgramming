class Stack:
    def __init__(self):
        self.items = []
        self.size = 0

    def is_empty(self):
        return len(self.items) == 0
    
    def add(self, item):
        self.items = self.items + [item]
        self.size = self.size + 1

    def pop(self):
        if not self.is_empty():
            item = self.items[-1]
            self.items = self.items[:-1]
            self.size = self.size - 1
            return item
        else:
            raise IndexError(" cant pop from empty stack")
        
    def peek(self):
        if not self.is_empty():
            return self.items[-1]
        else:
            raise IndexError("cant peek from empty stack")
        
    def get_stack(self):
        return self.items
    
    def get_size(self):
        return self.size
        