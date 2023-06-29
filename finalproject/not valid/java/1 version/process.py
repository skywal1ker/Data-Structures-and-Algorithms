/**
 * Alec O'Connor
 * Final Project
 * MET CS 526 02
 * Spring 2021
 */

package finalproject;

public class Process {
    // Initializes the variables used to define the Process class
    private int id;
    private int pr;
    private int duration;
    private int arrivalTime;
    private int executionTime;
    private int waitTime;

    /**
     * Constructor for the Process class; creates a process object
     * @param identity The identity number of the process
     * @param priority The priority level of the process used to determine execution order
     * @param dur The time duration that the process executes over
     * @param arrival The time at which the process arrives in execution queue (Q)
     * @param execution The time at which the process is executed
     * @param wait The amount of time the process waited in the execution queue (Q)
     */
    public Process(int identity, int priority, int dur, int arrival, int execution, int wait) {
        id = identity;
        pr = priority;
        duration = dur;
        arrivalTime = arrival;
        executionTime = execution;
        waitTime = wait;
    }

    /**
     * Alternate constructor for the Process class; creates a process object without parameters
     */
    public Process() {
        super();
    }

    /**
     * Overwrites the toString() method so a custom message can be printed to the screen for a Process instance
     * @return A string that provides formatted information about a Process instance
     */
    @Override
    public String toString() {
        return "Id = " + id +
                ", priority = " + pr +
                ", duration = " + duration +
                ", arrival time= " + arrivalTime;
    }

    /**
     * Gets the identity number of a process
     * @return The identity number of a process instance
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the priority number of a process
     * @return The priority number of a process instance
     */
    public int getPr() {
        return pr;
    }

    /**
     * Gets the duration of a process
     * @return The duration of time a process runs
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Gets the arrival time of a process
     * @return The time that a process arrives in the execution queue (Q)
     */
    public int getArrivalTime() {
        return arrivalTime;
    }

    /**
     * Gets the time at which a process is executed
     * @return The time at which a process is executed
     */
    public int getExecutionTime() {
        return executionTime;
    }

    /**
     * Gets the wait time of a process
     * @return The identity number of a process instance
     */
    public int getWaitTime() {
        return waitTime;
    }

    /**
     * Sets the execution time of a process to a specified value
     * @param executionTime The time at which a process is executed from the execution queue (Q)
     */
    public void setExecutionTime(int executionTime) {
        this.executionTime = executionTime;
    }

    /**
     * Sets the wait time of a process to a specified process
     * @param waitTime The time at which a process waits before being executed
     */
    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }

    /**
     * Decreases the priority of a process instance by 1
     */
    public void decreasePr() { pr++; }

    /**
     * Increases the wait time of a process instance by 1
     */
    public void incrementWaitTime() {
        waitTime++;
    }
}
