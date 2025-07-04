import java.util.*;

class Process {
    int pid;
    int burstTime;
    int priority;
    int remainingTime;
    int waitingTime;
    int turnaroundTime;
    Process next;

    Process(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.priority = priority;
        this.remainingTime = burstTime;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private Process head = null;
    private Process tail = null;

    // Add process to circular list
    public void addProcess(int pid, int burstTime, int priority) {
        Process p = new Process(pid, burstTime, priority);
        if (head == null) {
            head = tail = p;
            p.next = head;
        } else {
            tail.next = p;
            tail = p;
            tail.next = head;
        }
    }

    // Remove process by ID
    private void removeProcess(Process target) {
        if (head == null) return;
        if (head == target && head == tail) {
            head = tail = null;
            return;
        }

        Process temp = head, prev = tail;
        do {
            if (temp == target) {
                prev.next = temp.next;
                if (temp == head) head = head.next;
                if (temp == tail) tail = prev;
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    // Simulate round robin scheduling
    public void simulate(int quantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int time = 0;
        Process current = head;
        ArrayList<Process> completed = new ArrayList<>();

        System.out.println("\n--- Round Robin Scheduling Start ---");
        while (head != null) {
            if (current.remainingTime > 0) {
                System.out.println("Executing Process: " + current.pid);
                int executeTime = Math.min(quantum, current.remainingTime);
                time += executeTime;
                current.remainingTime -= executeTime;

                if (current.remainingTime == 0) {
                    current.turnaroundTime = time;
                    current.waitingTime = current.turnaroundTime - current.burstTime;
                    completed.add(current);
                    removeProcess(current);
                    if (head == null) break;
                    current = current.next;
                } else {
                    current = current.next;
                }

                displayQueue();
            }
        }

        System.out.println("--- Scheduling Complete ---\n");
        displayResults(completed);
    }

    // Display the current queue of processes
    public void displayQueue() {
        if (head == null) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Current Queue: ");
        Process temp = head;
        do {
            System.out.print("[PID: " + temp.pid + ", RT: " + temp.remainingTime + "] -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to head)");
    }

    // Display waiting and turnaround times
    private void displayResults(ArrayList<Process> completed) {
        double totalWT = 0, totalTAT = 0;

        System.out.println("Process Results:");
        for (Process p : completed) {
            System.out.println("PID: " + p.pid +
                    ", BT: " + p.burstTime +
                    ", WT: " + p.waitingTime +
                    ", TAT: " + p.turnaroundTime);
            totalWT += p.waitingTime;
            totalTAT += p.turnaroundTime;
        }

        System.out.printf("\nAverage Waiting Time: %.2f\n", totalWT / completed.size());
        System.out.printf("Average Turnaround Time: %.2f\n", totalTAT / completed.size());
    }
}

// Main class to drive the program
public class Round_Robin_CPU {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Process " + (i + 1));
            System.out.print("PID: ");
            int pid = sc.nextInt();
            System.out.print("Burst Time: ");
            int bt = sc.nextInt();
            System.out.print("Priority: ");
            int pr = sc.nextInt();
            scheduler.addProcess(pid, bt, pr);
        }

        System.out.print("\nEnter Time Quantum: ");
        int quantum = sc.nextInt();

        scheduler.simulate(quantum);
    }
}
