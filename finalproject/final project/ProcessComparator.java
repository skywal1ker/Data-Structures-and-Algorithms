import java.util.Comparator;

public class ProcessComparator implements Comparator<Process> {
    /**
     * A user defined comparator which uses the priority of a process to compare processes with one another;
     * a lower priority number means a higher priority
     * @param s1 A process instance to be compared with another process instance
     * @param s2 A process instance to be compared with another process instance
     * @return An integer value (1,-1, or 0) used to determine how to compare two process objects
     */

    public int compare(Process s1, Process s2) {

        // If s2 bigger return 1
        if (s1.getPr() < s2.getPr())
            return 1;

        //If it is same priority, then it will compared by the arrival time
        else if (s1.getPr() == s2.getPr())
        {
            if (s1.getArrivalTime() > s2.getArrivalTime())
                return 1;
            else if (s1.getArrivalTime() < s2.getArrivalTime())
                return -1;
            return 0;
        }

        // If s1 bigger return -1
        else if (s1.getPr() > s2.getPr())
            return -1;

        // otherwise return none
        return 0;
    }
}

