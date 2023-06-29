from queue import PriorityQueue

class Process:
  def __init__(self, id, pr, duration, arrival_time):
    self.id = id
    self.pr = pr
    self.duration = duration
    self.arrival_time = arrival_time
    

  def __str__(self):
    return f"Id = {self.id}, priority = {self.pr}, duration = {self.duration}, arrival time = {self.arrival_time}"    


row_array = []
D = []

for line in open("text.txt"):
    line = line.split()
    row_array.append(line)

for x in range(0, len(row_array)):
    prsx = Process(row_array[x][0], row_array[x][1], row_array[x][2], row_array[x][3])
    print(prsx)
    D.append(prsx)
    





# currentTime = 0
# running = False
# q = PriorityQueue()
# # p = Process()
# # running_P = Process()
# wait_time = 0
# averageWaitTime = 0
# endTime = 0


# while len(D) != 0:
#     earliest = min(row_array[3])
#     earliestIndex = 0
#     for i in range(1, len(row_array[3])-1):
#       temp = row_array[3][i]
#       if temp < earliest:
#         earliest = temp
#         earliestIndex = i
    



for i in range(1, len(row_array[3])-1):
  print(i)
















