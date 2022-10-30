def double_hashing(keys, hashtable_size, double_hash_value):
    hashtable_list = [None] * hashtable_size #thid line for making fixed size array
    count = 0 # empty variable to count collisions
    for i in range(len(keys)): # looping all elements
        hashkey = keys[i] % hashtable_size  # define index
        if hashtable_list[hashkey] is None: # check if it is NONE
            hashtable_list[hashkey] = keys[i] #placing element to the defined spot
        else:
            new_hashkey = hashkey #here I changed same variable

            while hashtable_list[new_hashkey] is not None: # check if it is not NONE
                steps = 1 + (keys[i] % double_hash_value) # Here, h(k) = k mod N, h'(k) = 1 + (k mod N '), and N ' = 497
                new_hashkey = (new_hashkey + steps) % hashtable_size # to define spot
                count = count + 1 #adding new count
            hashtable_list[new_hashkey] = keys[i] #placing element to the defined spot

    print("The number of collision is", count)
    print(hashtable_list)

values = [None, 23, 57, None, 15, 18, None, 45, None, 53, 65]

import random
k = random.sample(range(1, 5000), 400) #this is for creating random but unique int elements


double_hashing(k, 499, 497)






