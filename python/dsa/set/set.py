class Set:
    def __init__(self):
        self.items = []
        self.size = 0

    def is_empty(self):
        return self.size == 0

    def add(self, item):
        if item not in self.items:
            self.items = self.items + [item]
            self.size = self.size + 1

    def get_set(self):
        return self.items

    def get_size(self):
        return self.size
    
    def remove(self, item):
        if item not in self.items:
            raise ValueError("item not found in set")
        
        new_items = []

        for element in self.items:
            if element != item:
                new_items = new_items + [element]

                self.items = new_items
                self.size = self.size - 1
        
    def clear(self):
        self.items = []
        self.size = 0