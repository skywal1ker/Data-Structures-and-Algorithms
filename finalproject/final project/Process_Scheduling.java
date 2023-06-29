import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.PriorityQueue;

public class Process_Scheduling {
    public static void main(String[] args) throws FileNotFoundException {
        // This part of code for opening input file and fill the empty created array of D
        Scanner s = new Scanner(new File("src/process_scheduling_input.txt"));
        PrintWriter textMakerForFile = new PrintWriter("src/process_scheduling_output.txt");
        ArrayList<Process> D = new ArrayList<Process>();
        
        while (s.hasNext()) { //It will keep reading each line until reach the bottom
            String line = s.nextLine();
            String[] word = line.split(" ");
            
            // Here we need to parse int value to the our object according their orders
            Process p1 = new Process(Integer.parseInt(word[0]), Integer.parseInt(word[1]), Integer.parseInt(word[2]), Integer.parseInt(word[3]), 0, 0);
            
            //and finally values will be collected here in array D
            D.add(p1);
        }
        s.close(); //After reading we need close the file

        int numberOfProcesses = D.size(); // this variable we need for calculation average time of whole process
        for (int i = 0; i < D.size(); i++) {textMakerForFile.println(D.get(i)); System.out.println(D.get(i));} // Here it is going to show main information about process
        textMakerForFile.println();
        System.out.println();

        
        // Here we created empty variables for using them to collect data according their names
        int currentTime = 0; //To track current time
        boolean running = false; //For running processes
        PriorityQueue<Process> Q = new PriorityQueue<>(new ProcessComparator()); //Empty Q priority queue list
        Process p = new Process(); // we created this for use for the process which is arrival time is less
        Process runningP = new Process(); //For running processes
        int waitTime = 0; // To calculate waitTime
        double averageWaitTime = 0; // To calculate averageWaitTime
        int endTime = 0;// To calculate endTime

        // Here it will be keep going until this condition will be True, D becomes empty
        while (!D.isEmpty()) {int earliest = 0; int earliestIndex = 0;

            //this for loop for defining earliest arrival time for the first object
            for (int i = 0; i < D.size(); i++) {if (earliest == 0 || earliest > D.get(i).getArrivalTime()) {earliest = D.get(i).getArrivalTime(); earliestIndex = i;}}

            p = D.get(earliestIndex);//this for define index of the earliest arrival time object

            if (p.getArrivalTime() <= currentTime)//If it is True, arrival time less or equal current time
            {Q.add(p); D.remove(earliestIndex);} //It will postponing from D to Q priority queue lists

            if (running && endTime == currentTime) //If it is True, running and endTime equal to currentTime, so it will be printing process finishing time
            {
                textMakerForFile.println("Process " + runningP.getId() + " finished at time " + endTime + "\n");
                System.out.println("Process " + runningP.getId() + " finished at time " + endTime + "\n");
                running = false; // process is not running currently at all
            }

            if (!Q.isEmpty() && !running) { //if process still going on and D is not empty,
                runningP = Q.poll(); //deleting element according priority
                waitTime = currentTime - runningP.getArrivalTime(); // calculating wait time
                averageWaitTime += waitTime; // collecting whole time
                endTime = currentTime + runningP.getDuration(); // calculating endTime

                textMakerForFile.println("Process removed from queue is: id = " + runningP.getId() + ", at time " + currentTime + ", wait time = " + waitTime + ", Total wait time = " + averageWaitTime);
                textMakerForFile.println("Process id = " + runningP.getId() + "\n\tPriority = " + runningP.getPr() + "\n\tArrival = " + runningP.getArrivalTime() + "\n\tDuration = " + runningP.getDuration());

                System.out.println("Process removed from queue is: id = " + runningP.getId() + ", at time " + currentTime + ", wait time = " + waitTime + ", Total wait time = " + averageWaitTime);
                System.out.println("Process id = " + runningP.getId() + "\n\tPriority = " + runningP.getPr() + "\n\tArrival = " + runningP.getArrivalTime() + "\n\tDuration = " + runningP.getDuration());

                running = true; // this process is in current running time
            }
            currentTime += 1; //current process running time would increase
        }

        textMakerForFile.println("\nD becomes empty at time " + (currentTime-1) + "\n");
        System.out.println("\nD becomes empty at time " + (currentTime-1) + "\n");

        while (!Q.isEmpty()) { //While there is a process waiting in Q

            if (!running) {runningP = Q.poll();//deleting element according priority
                currentTime -= 1;                                   // current process running time would decrease, here we need deduct by -1 to get desired output
                waitTime = currentTime - runningP.getArrivalTime(); // calculating wait time
                averageWaitTime += waitTime;                        // collecting whole time
                endTime = currentTime + runningP.getDuration();     // calculating endTime

                textMakerForFile.println("Process removed from queue is: id = " + runningP.getId() + ", at time " + currentTime + ", wait time = " + waitTime + ", Total wait time = " + averageWaitTime);
                textMakerForFile.println("Process id = " + runningP.getId() + "\n\tPriority = " + runningP.getPr() + "\n\tArrival = " + runningP.getArrivalTime() + "\n\tDuration = " + runningP.getDuration());

                System.out.println("Process removed from queue is: id = " + runningP.getId() + ", at time " + currentTime + ", wait time = " + waitTime + ", Total wait time = " + averageWaitTime);
                System.out.println("Process id = " + runningP.getId() + "\n\tPriority = " + runningP.getPr() + "\n\tArrival = " + runningP.getArrivalTime() + "\n\tDuration = " + runningP.getDuration());

                running = true;// this process is in current running time
            }

            if (running && endTime == currentTime) { // If the current running process just ended
                textMakerForFile.println("Process " + runningP.getId() + " finished at time " + endTime + "\n");
                System.out.println("Process " + runningP.getId() + " finished at time " + endTime + "\n");
                running = false; // process is not running currently at all
            }

            currentTime += 1; //current process running time would increase

        }

        textMakerForFile.println("Process " + runningP.getId() + " finished at time " + endTime + "\n");
        textMakerForFile.println("Total wait time = " + averageWaitTime);
        System.out.println("Process " + runningP.getId() + " finished at time " + endTime + "\n");
        System.out.println("Total wait time = " + averageWaitTime);

        averageWaitTime /= numberOfProcesses; // calculating average time

        textMakerForFile.print("Average wait time = " + averageWaitTime);
        System.out.print("Average wait time = " + averageWaitTime);
        System.out.println();
        textMakerForFile.close();
    }
}

