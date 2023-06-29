import random


def linearprobing(K):  # Function for linearprbing method
    T = [None] * 500  # Fixed size array
    count = 0  # Empty variable for using to count the collision

    for i in range(0, len(K)):  # Looping all values in array
        result = K[i] % len(T)  # Devide value by the size of array to define spot in array

        if T[result] is None:  # If defined index is not occupied
            T[result] = K[i]

        else:  # If defined index is occupied
            while T[result] is not None:  # It will be keep going untill the spot will be found
                result = (result + 1) % len(T)  # Finding new spot for the value
                count += 1  # For incrementing number of collision
            T[result] = K[i]

    print(f"The size of an array {len(T)}")
    print(T)
    print(f"The number of collision using linear probing is {count}")


def doublehashing(K):  # Function for doublehashing method
    T = [None] * 499  # Fixed size array
    count = 0  # Empty variable for using to count the collision

    for i in range(0, len(K)):  # Looping all values in array
        result = K[i] % len(T)  # Devide value by the size of array to define spot in array
        if T[result] is None:  # If defined index is not occupied
            T[result] = K[i]
        else:  # If defined index is occupied
            each = 1 + (K[i] % 497)  # This variable for double hashing method
            while T[result] is not None:  # It will be keep going untill the spot will be found
                result = (result + each) % len(T)  # Finding new spot for the value
                count += 1  # For incrementing number of collision
            T[result] = K[i]

    print(f"The size of an array {len(T)}")
    print(T)
    print(f"The number of collision using double hasing is {count}")


K = random.sample(range(1, 5000), 400)  # Creating random but unique integer elements

linearprobing(K)
print()
doublehashing(K)
