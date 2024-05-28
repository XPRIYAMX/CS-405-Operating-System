import java.util.*;

public class FCFS {
    public static void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of processes:");
        n = in.nextInt();
        Process[] p = new Process[n];
        for (int i = 0; i < n; i++) {
            p[i] = new Process();
            System.out.println("Enter the arrival time and burst time for process " + (i + 1));
            p[i].arrivalTime = in.nextInt();
            p[i].burstTime = in.nextInt();
        }
        fcfs(p, n);
    }

    public static void fcfs(Process[] p, int n) {
        int i, temp;
        for (i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (p[i].arrivalTime > p[j].arrivalTime) {
                    temp = p[i].arrivalTime;
                    p[i].arrivalTime = p[j].arrivalTime;
                    p[j].arrivalTime = temp;

                    temp = p[i].burstTime;
                    p[i].burstTime = p[j].burstTime;
                    p[j].burstTime = temp;
                }
            }
        }
        System.out.println("Order of processes as per FCFS scheduling algorithm:");
        for (i = 0; i < n; i++) {
            System.out.println("Process " + (i + 1) + " Arrival Time: " + p[i].arrivalTime + " Burst Time: " + p[i].burstTime);
        }
        int totalWaitingTime = 0, totalTurnAroundTime = 0;
        int completionTime = 0;
        for (i = 0; i < n; i++) {
            completionTime = completionTime + p[i].burstTime;
            totalTurnAroundTime = totalTurnAroundTime + (completionTime - p[i].arrivalTime);
            totalWaitingTime = totalWaitingTime + (completionTime - p[i].burstTime - p[i].arrivalTime);
        }
        System.out.println("Total Waiting Time: " + totalWaitingTime);
        System.out.println("Total Turn Around Time: " + totalTurnAroundTime);
    }
}

class Process {
    int arrivalTime, burstTime;
}