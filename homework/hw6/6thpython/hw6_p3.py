import array_stack #For imoprting stacks

buffer = array_stack.ArrayStack() #to create empty stack
    
    
for line in open("hw6_sentence.txt"): #for open input file 
    for word in line:                 #to get access to each word step by step
        buffer.push(word)             #to put every word into empty stack
    
for line in open("hw6_sentence.txt"):  #for open input file again
    for word in line:                  #to get access to each word step by step again
        print(buffer.pop(), end="")    # this is for reversing
        
        

