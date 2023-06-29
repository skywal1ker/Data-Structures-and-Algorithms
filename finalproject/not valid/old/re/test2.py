class Process:
  def __init__(self, id, pr, duration, arrival_time):
    self.id = id
    self.pr = pr
    self.duration = duration
    self.arrival_time = arrival_time
    

  def __str__(self):
    return f"Id = {self.id}, priority = {self.pr}, duration = {self.duration}, arrival time = {self.arrival_time}"    

p1 = Process(1, 4, 25, 26)
