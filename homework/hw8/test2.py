import random

class MyHashTable:
    def __init__(self, capacity): #this atribute for array's size
        self.capacity = capacity
        self.slots = [None] * self.capacity #this atribute for making fixed size array
        self.count = 0 #empty variable for counting


    def __str__(self): # for printing an array
        return str(self.slots)

    # def __contains__(self, item):
    #     return self.search(item) != -1

    def __len__(self):  # I used this function to show collision number
        return self.count # this variable for counting

    def hash_function(self, key): # this function to define index number
        return hash(key) % self.capacity #return defined value to

    def find_slot(self, key): # this function to find a new slot if the defined index was occupied
        slot = self.hash_function(key)
        while self.slots[slot] is not None and self.slots[slot] != key: #here it will be keep going untill this will be True (self.slots[slot] is not None and self.slots[slot] != key)
            slot = (slot + 1) % self.capacity # switching to the next slot if current occupied
            self.count += 1 # for counting
        return slot

    def insert(self, key): #Function for inserting values
        slot = self.find_slot(key)
        if self.slots[slot] != key:
            self.slots[slot] = key


    def search(self, key):
        i = self.find_slot(key)
        if self.slots[i] is not None:
            return i
        return -1





k = random.sample(range(1, 5000), 400) #this is for creating random but unique int elements
k2 = [400, 500 , 600, 900, 1200]

t = MyHashTable(500)  #fixed-size array T with capacity 500

for i in range(0, len(k)-1):
    t.insert(k[i])

print(t)
print("The number of collusion is",len(t))







