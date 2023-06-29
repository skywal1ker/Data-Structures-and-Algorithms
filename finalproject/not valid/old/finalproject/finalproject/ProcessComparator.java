/**
 * Alec O'Connor
 * Final Project
 * MET CS 526 02
 * Spring 2021
 */

package finalproject;

import java.util.Comparator;

public class ProcessComparator implements Comparator<Process> {

    /**
     * A user defined comparator which uses the priority of a process to compare processes with one another;
     * a lower priority number means a higher priority
     * @param proc1 A process instance to be compared with another process instance
     * @param proc2 A process instance to be compared with another process instance
     * @return An integer value (1,-1, or 0) used to determine how to compare two process objects
     */
    public int compare(Process proc1, Process proc2) {
        if (proc1.getPr() > proc2.getPr())
            return 1;
        else if (proc1.getPr() < proc2.getPr())
            return -1;
        else
            return 0;
    }
}
