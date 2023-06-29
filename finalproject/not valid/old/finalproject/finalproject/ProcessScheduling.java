/**
 * Alec O'Connor
 * Final Project
 * MET CS 526 02
 * Spring 2021
 */

package finalproject;

import java.util.*;
import java.io.*;

public class ProcessScheduling {

    /**
     * Main function for the ProcessScheduling class
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {

        // An array list data structure is initialized to store process objects
        ArrayList<Process> D = new ArrayList<>();

        // Contents of process scheduling text file are read into the program
        Scanner scanner = new Scanner(new File("process_scheduling_input.txt"));
        // Initializes a counter variable to keep track of how many processes are scheduled to run
        int numProcesses = 0;
        // While loop iterates through the text file line by line
        while (scanner.hasNextLine()) {
            String fileLine = scanner.nextLine();
            // Creates an array which stores the numbers separated by a space in the text file as elements
            String[] lineArray = fileLine.split(" ");
            // Creates a process instance from the data stored in the previsouly created array
            Process process = new Process(Integer.parseInt(lineArray[0]), Integer.parseInt(lineArray[1]), Integer.parseInt(lineArray[2]), Integer.parseInt(lineArray[3]), 0, 0);
            System.out.println(process);
            // Adds the process object to the array list D
            D.add(process);
            // Increments the number of processes counter variable
            numProcesses++;
        }

        // Initializes the maximum wait time for a process and prints the number to the console
        System.out.println();
        int maxWaitTime = 30;
        System.out.println("Maximum wait time = " + maxWaitTime);
        System.out.println();

        // Initializes the current wait time and total wait time counters for the program
        int currentTime = 0;
        double totalWaitTime = 0;
        // Boolean variable is initialized to keep track of the process that is running in the below while loop
        boolean running = false;
        // Initializes a process instance to keep track of the process that is actively executing
        Process runningProcess = new Process();
        // Initializes a priority queue with a user-defined comparator based on the process priority
        PriorityQueue<Process> Q = new PriorityQueue<>(new ProcessComparator());

        // While loop executes until the array list D is empty
        while (!D.isEmpty()) {

            // Initializes the queuedProcess variable to reference the first process element in D
            Process queuedProcess = D.get(0);
            // Removes the queuedProcess from D and adds it to Q if the arrival time of queuedProcess is equal to
            // the current time counter
            if (queuedProcess.getArrivalTime() == currentTime) {
                D.remove(0);
                Q.add(queuedProcess);
            }

            // If statement executes when Q is not empty and when process is not currently executing
            if (!Q.isEmpty() && running == false) {
                // Removes the process with the lowest priority from Q and assigns it to the runningProcess variable
                runningProcess = Q.remove();
                // Calculates and sets the waitTime for the process that is executing
                int waitTime = currentTime - runningProcess.getArrivalTime();
                runningProcess.setWaitTime(waitTime);
                // Sets the execution time for the currently running process
                runningProcess.setExecutionTime(currentTime);
                // Counter that keeps track of the total wait time of all the processes
                totalWaitTime = totalWaitTime + waitTime;
                // Sets the boolean variable to true to ensure this if statement executes at the appropriate time
                running = true;
                // Prints formatted information to the console
                System.out.println("Process removed from queue is: id = " + runningProcess.getId() + ", at time "
                        + currentTime + ", wait time = " + runningProcess.getWaitTime() + ", total wait time = " + totalWaitTime);
                System.out.println("Process id = " + runningProcess.getId());
                System.out.println("\t\tPriority = " + runningProcess.getPr());
                System.out.println("\t\tArrival = " + runningProcess.getArrivalTime());
                System.out.println("\t\tDuration = " + runningProcess.getDuration());
                System.out.println("\t\tProcess " + runningProcess.getId() + " finished at time " + (runningProcess.getExecutionTime() + runningProcess.getDuration()) + "\n");
            }

            // If statement executes when the currently running process finishes
            if (currentTime - runningProcess.getExecutionTime() == runningProcess.getDuration() - 1) {
                // Sets the boolean variable to false to ensure the next process waiting in Q is executed
                running = false;
                // Initializes an iterator object to support updates of the processes waiting in Q
                Iterator<Process> iterQ = Q.iterator();
                System.out.println("Update priority:");
                // While loop executes until the iterator object does not have a next element
                while (iterQ.hasNext()) {
                    Process iterProcess = iterQ.next();
                    // If statement executes if the process has been waiting for longer than the maximum wait time
                    if (iterProcess.getWaitTime() > maxWaitTime) {
                        // Increases the priority of the process by reducing the priority number and prints formatted information to the console
                        System.out.println("PID = " + iterProcess.getId() + ", wait time = " + (iterProcess.getWaitTime() + 1) + ", current priority = " + iterProcess.getPr());
                        iterProcess.decreasePr();
                        System.out.println("PID = " + iterProcess.getId() + ", new priority = " + iterProcess.getPr());
                    }

                }
                System.out.println();

            }

            // Prints the time when D becomes empty to the console
            if (D.isEmpty()) {
                System.out.println("D becomes empty at time " + currentTime);
                System.out.println();
            }

            // Increments the current time counter variable
            currentTime++;

            // Creates an iterator object to increment the wait time for all processes in Q
            Iterator<Process> iterQ = Q.iterator();
            while (iterQ.hasNext()) {
                iterQ.next().incrementWaitTime();
            }
        }

        // While loop executes when D is empty and until Q is empty
        while (D.isEmpty() && !Q.isEmpty()) {

            // If statement executes when Q is empty and the boolean variable is false - similar code above
            if (!Q.isEmpty() && running == false) {
                runningProcess = Q.remove();
                int waitTime = currentTime - runningProcess.getArrivalTime();
                runningProcess.setWaitTime(waitTime);
                runningProcess.setExecutionTime(currentTime);
                totalWaitTime = totalWaitTime + waitTime;
                running = true;
                System.out.println("Process removed from queue is: id = " + runningProcess.getId() + ", at time "
                        + currentTime + ", wait time = " + runningProcess.getWaitTime() + ", total wait time = " + totalWaitTime);
                System.out.println("Process id = " + runningProcess.getId());
                System.out.println("\t\tPriority = " + runningProcess.getPr());
                System.out.println("\t\tArrival = " + runningProcess.getArrivalTime());
                System.out.println("\t\tDuration = " + runningProcess.getDuration());
                System.out.println("\t\tProcess " + runningProcess.getId() + " finished at time " + (runningProcess.getExecutionTime() + runningProcess.getDuration()) + "\n");
            }

            // If statement executes when the currently running process finishes - similar code above
            if (currentTime - runningProcess.getExecutionTime() == runningProcess.getDuration() - 1) {
                running = false;
                Iterator<Process> iterQ = Q.iterator();
                System.out.println("Update priority:");
                while (iterQ.hasNext()) {
                    Process iterProcess = iterQ.next();

                    if (iterProcess.getWaitTime() > maxWaitTime) {
                        System.out.println("PID = " + iterProcess.getId() + ", wait time = " + (iterProcess.getWaitTime() + 1) + ", current priority = " + iterProcess.getPr());
                        iterProcess.decreasePr();
                        System.out.println("PID = " + iterProcess.getId() + ", new priority = " + iterProcess.getPr());
                    }
                }
                System.out.println();
            }

            // Increments the current time counter variable
            currentTime++;

            // Creates an iterator object to increment the wait time for all processes in Q
            Iterator<Process> iterQ = Q.iterator();
            while (iterQ.hasNext()) {
                iterQ.next().incrementWaitTime();
            }
        }

        double finalWaitTime = totalWaitTime;

        // Prints the total wait time and average wait time to the console
        System.out.println("Total wait time = " + finalWaitTime);
        System.out.println("Average wait time = " + (finalWaitTime/numProcesses));
    }
}

