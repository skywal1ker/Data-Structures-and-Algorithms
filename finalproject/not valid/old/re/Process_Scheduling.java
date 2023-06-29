import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;
public class Process_Scheduling {
    protected static class Process {// Each process means process id, priority, duration, and arrival time
        private int processId;
        private int priority;
        private int duration;
        private int arrivalTime;
        public Process() {
            processId = 0;
            priority = 0;
            duration = 0;
            arrivalTime = 0;
        } //creating an empty Process
        public Process(int processId, int priority, int duration, int arrivalTime) {
            this.processId = processId;
            this.priority = priority;
            this.duration = duration;
            this.arrivalTime = arrivalTime;
        }//creating the Process with given values, from Employee class HW2
        public int getProcessId() {
            return processId;
        }
        public int getPriority() {
            return priority;
        }
        public int getDuration() {
            return duration;
        }
        public int getArrivalTime() {
            return arrivalTime;
        }//get value for each processes
        public void setProcessId(int processId) {
            this.processId = processId;
        }
        public void setPriority(int priority) {
            this.priority = priority;
        }
        public void setDuration(int duration) {
            this.duration = duration;
        }
        public void setArrivalTime(int arrivalTime) {this.arrivalTime = arrivalTime;} //set value for each processes
        public String toString() {
            String s = new String();
            s += "Id = " + processId + ", ";
            s += "priority = " + priority + ", ";
            s += "duration = " + duration + ", ";
            s += "arrival time = " + arrivalTime;
            return s;
        }//put process in form of string for future print
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("/Users/dy/Desktop/CS526 HW2/src/process_scheduling_input.txt"));
        PrintWriter writer = new PrintWriter("/Users/dy/Desktop/CS526 HW2/src/process_scheduling_output.txt");
        ArrayList<Process> D = new ArrayList<>();
        while (s.hasNext()) {
            String line = s.nextLine();
            String[] word = line.split(" ");
            Process p1 = new Process(Integer.parseInt(word[0]), Integer.parseInt(word[1]), Integer.parseInt(word[2]), Integer.parseInt(word[3]));
            D.add(p1);
        }//read each line's information from the input file, and set up the elements for each process
        s.close();
        int numberOfProcesses = D.size();//count the total processes time
        for (int i = 0; i < D.size(); i++) {
            writer.println(D.get(i));
        }//write all processes to an output file
        writer.println();
        int currentTime = 0;// count the running time of process, default 0
        boolean running = false;//set up current process running time, default false
        HeapPriorityQueue<Integer, Process> Q = new HeapPriorityQueue<>();//create an empty priority queue
        Process p = new Process();
        Process runningP = new Process();//set up the current running process runningP
        int waitTime = 0;
        double averageWaitTime = 0;//calculate the average wait time, default 0
        int endTime = 0;//count currently process end running time, default 0
        while (!D.isEmpty()) {
            int earliest = D.get(0).getArrivalTime();
            int earliestIndex = 0;
            for (int i = 0; i < D.size(); i++) {
                int temp = D.get(i).getArrivalTime();
                if (temp < earliest) {
                    earliest = temp;
                    earliestIndex = i;
                }
            }// find the earliest process running time in D HW3
            p = D.get(earliestIndex);
            if (p.getArrivalTime() <= currentTime) {
                Q.insert(p.getPriority(), p);
                D.remove(earliestIndex);
            }// If the process arrival time <= current process arrival time, then remove the process p from D and insert it into Q
            if (!Q.isEmpty() && !running) {// If Q is not empty with no currently process running
/* We remove a process with the largest priority from Q */
                runningP = Q.removeMin().getValue();
                waitTime = currentTime - runningP.getArrivalTime();
                averageWaitTime += waitTime;
                endTime = currentTime + runningP.getDuration();//calculate and print the output file
                writer.println("Process removed from queue is: id = " + runningP.getProcessId() + ", at time " + currentTime + ", wait time = " + waitTime + ", Total wait time = " + averageWaitTime);
                writer.println("Process id = " + runningP.getProcessId() + "\n\tPriority = " + runningP.getPriority() + "\n\tArrival = " + runningP.getArrivalTime() + "\n\tDuration = " + runningP.getDuration());
                running = true;//this process is in current running process
            }
            currentTime += 1;// current process running time would increase
            if (running && endTime == currentTime) {// If the current running process just ended
                writer.println("Process " + runningP.getProcessId() + " finished at time " + endTime + "\n");//calculate and print the ending time
                running = false;// process is not running currently at all
            }
        }
        writer.println("\nD becomes empty at time " + (currentTime - 1) + "\n");//calculate and print the total process runnign time in D
        while (!Q.isEmpty()) {
            if (!running) {
/* We remove a process with the largest priority from Q */
                runningP = Q.removeMin().getValue();
                waitTime = currentTime - runningP.getArrivalTime();
                averageWaitTime += waitTime;
                endTime = currentTime + runningP.getDuration();//calculate and print the output file
                writer.println("Process removed from queue is: id = " + runningP.getProcessId() + ", at time " + currentTime + ", wait time = " + waitTime + ", Total wait time = " + averageWaitTime);
                writer.println("Process id = " + runningP.getProcessId() + "\n\tPriority = " + runningP.getPriority() + "\n\tArrival = " + runningP.getArrivalTime() + "\n\tDuration = " + runningP.getDuration());
                running = true;// this process is in current running time
            }
            currentTime += 1;//current process running time would increase
            if (running && endTime == currentTime) {// If the current running process just ended
                writer.println("Process " + runningP.getProcessId() + " finished at time " + endTime + "\n");//calculate and print the ending time
                running = false;// process is not running currently at all
            }
        }
        writer.println("Process " + runningP.getProcessId() + " finished at time " + endTime + "\n");
        writer.println("Total wait time = " + averageWaitTime);
        averageWaitTime /= numberOfProcesses;
        writer.print("Average wait time = " + averageWaitTime);//calculate and print the output file
        writer.close();
    }
}