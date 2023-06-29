from queue import PriorityQueue


class Process:
    def __init__(self, id, pr, duration, arrival_time):
        self.id = id
        self.pr = pr
        self.duration = duration
        self.arrival_time = arrival_time

    def __str__(self):
        return f"Id = {self.id}, priority = {self.pr}, duration = {self.duration}, arrival time = {self.arrival_time}"

    def get_id(self):
        return self.id

    def get_pr(self):
        return self.pr

    def get_duration(self):
        return self.duration

    def get_arrival_time(self):
        return self.arrival_time


row_array = []
D = []



for line in open("qwer.txt"):
    line = [int(item) for item in line.split()]
    row_array.append(line)

for x in range(0, len(row_array)):
    prsx = Process(row_array[x][0], row_array[x][1], row_array[x][2], row_array[x][3])
    # print(prsx)
    D.append(prsx)

running = False
Q = PriorityQueue()

P = Process(0, 0, 0, 0)
running_P = Process(0, 0, 0, 0)
current_time = 0
wait_time = 0
average_wait_time = 0
end_time = 0
earliest = 0
earliestIndex = 0


for i in range(0, len(D)):
    if earliest == 0 or earliest > D[i].get_arrival_time():
        earliest = D[i].get_arrival_time()
        earliestIndex = i
        P = D[earliestIndex]
        Q.put(P)
        print(Q.get())


while len(D) != 0:
    for i in range(0, len(D)):
        if earliest == 0 or earliest > D[i].get_arrival_time():
            earliest = D[i].get_arrival_time()
            earliestIndex = i
            P = D[earliestIndex]

    if P.get_arrival_time() <= current_time:
        Q.put(P)
        D.pop(earliestIndex)

    if Q.not_empty and running is False:
        running_P = Q.get()
        waitTime = current_time - running_P.get_arrival_time()
        average_wait_time += waitTime
        end_time = current_time + running_P.get_duration()
        print(
            f"Process removed from queue is: id = {running_P.get_id()}, at time {current_time}, wait time = {wait_time} Total wait time = {average_wait_time}")
        print(f"Process id = {running_P.get_id()}"
              f"Priority = {running_P.get_pr()}, "
              f"Arrival = {running_P.get_arrival_time()}, "
              f"Duration = {running_P.get_duration()}")
        running = True

    current_time += 1

    if running and end_time == current_time:
        print(f"Process {running_P.get_arrival_time()} finished at time {end_time}")
        running = False

print(f"D becomes empty at time {(current_time - 1)}")

while Q.not_empty:
    if running is False:
        running_P = Q.get()
        waitTime = current_time - running_P.get_arrival_time()
        average_wait_time += waitTime
        end_time = current_time + running_P.get_duration()
        print(
            f"Process removed from queue is: id = {running_P.get_id()}, at time {current_time}, wait time = {wait_time} Total wait time = {average_wait_time}")
        print(f"Process id = {running_P.get_id()}"
              f"Priority = {running_P.get_pr()}, "
              f"Arrival = {running_P.get_arrival_time()}, "
              f"Duration = {running_P.get_duration()}")
        running = True

    current_time += 1

    if running is True and end_time == current_time:
        print(f"Process {running_P.get_id()} finished at time {end_time}")

print(f"Total wait time = {average_wait_time}")
average_wait_time /= 10
print(f"Average wait time = {average_wait_time}")