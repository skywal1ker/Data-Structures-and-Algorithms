import random 

count = 0
k = random.sample(range(1, 50), 20)
t = [None] * 30
 

for i in range(0, len(k)-1):

        if t[i] is None:
            t.pop(i)
            t.insert(k[i]%len(t), k[i])
        if t[i] is not None:
            t.pop(i + 1)
            t.insert((k[i]%len(t))+1, k[i])
            count = count + 1



print(t)
print()
print(len(t))
print(count)