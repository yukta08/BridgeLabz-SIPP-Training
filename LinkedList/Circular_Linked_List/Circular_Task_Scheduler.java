import java.util.*;

// Node class representing a Task
class Task {
    int taskId;
    String taskName;
    String priority;
    String dueDate;
    Task next;

    Task(int taskId, String taskName, String priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

// Scheduler class using circular linked list
class TaskScheduler {
    private Task head = null;
    private Task tail = null;
    private Task current = null;

    // Add task at beginning
    public void addAtBeginning(Task newTask) {
        if (head == null) {
            head = tail = newTask;
            newTask.next = newTask;
            current = head;
        } else {
            newTask.next = head;
            head = newTask;
            tail.next = head;
        }
        System.out.println("Task added at beginning.");
    }

    // Add task at end
    public void addAtEnd(Task newTask) {
        if (head == null) {
            addAtBeginning(newTask);
        } else {
            tail.next = newTask;
            newTask.next = head;
            tail = newTask;
            System.out.println("Task added at end.");
        }
    }

    // Add task at specific position (1-based)
    public void addAtPosition(Task newTask, int pos) {
        if (pos <= 1 || head == null) {
            addAtBeginning(newTask);
            return;
        }
        Task temp = head;
        int count = 1;
        while (count < pos - 1 && temp.next != head) {
            temp = temp.next;
            count++;
        }
        newTask.next = temp.next;
        temp.next = newTask;
        if (temp == tail) tail = newTask;
        System.out.println("Task added at position " + pos);
    }

    // Remove task by ID
    public void removeById(int id) {
        if (head == null) {
            System.out.println("No tasks to remove.");
            return;
        }
        Task temp = head, prev = tail;
        boolean found = false;

        do {
            if (temp.taskId == id) {
                found = true;
                break;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("Task ID not found.");
            return;
        }

        if (temp == head && temp == tail) {
            head = tail = null;
        } else {
            prev.next = temp.next;
            if (temp == head) head = temp.next;
            if (temp == tail) tail = prev;
        }

        if (current == temp) current = current.next;

        System.out.println("Task with ID " + id + " removed.");
    }

    // View current task
    public void viewCurrentTask() {
        if (current == null) {
            System.out.println("No tasks in scheduler.");
        } else {
            displayTask(current);
        }
    }

    // Move to next task
    public void moveToNextTask() {
        if (current != null) {
            current = current.next;
            System.out.println("Moved to next task.");
        } else {
            System.out.println("No tasks available.");
        }
    }

    // Display all tasks
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }
        Task temp = head;
        System.out.println("--- Task List ---");
        do {
            displayTask(temp);
            temp = temp.next;
        } while (temp != head);
    }

    // Search by priority
    public void searchByPriority(String prio) {
        if (head == null) {
            System.out.println("No tasks to search.");
            return;
        }
        Task temp = head;
        boolean found = false;
        System.out.println("Tasks with priority '" + prio + "':");
        do {
            if (temp.priority.equalsIgnoreCase(prio)) {
                displayTask(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) {
            System.out.println("No tasks found with given priority.");
        }
    }

    // Helper: Print a task
    private void displayTask(Task t) {
        System.out.println("ID: " + t.taskId + ", Name: " + t.taskName + ", Priority: " + t.priority + ", Due: " + t.dueDate);
    }
}

// Main class to run the Task Scheduler
public class Circular_Task_Scheduler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskScheduler scheduler = new TaskScheduler();

        while (true) {
            System.out.println("\n--- Task Scheduler Menu ---");
            System.out.println("1. Add Task at Beginning");
            System.out.println("2. Add Task at End");
            System.out.println("3. Add Task at Position");
            System.out.println("4. Remove Task by ID");
            System.out.println("5. View Current Task");
            System.out.println("6. Move to Next Task");
            System.out.println("7. Display All Tasks");
            System.out.println("8. Search by Priority");
            System.out.println("9. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear newline

            switch (choice) {
                case 1, 2, 3 -> {
                    System.out.print("Enter Task ID: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Task Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Priority: ");
                    String priority = sc.nextLine();
                    System.out.print("Enter Due Date: ");
                    String date = sc.nextLine();
                    Task task = new Task(id, name, priority, date);

                    if (choice == 1) scheduler.addAtBeginning(task);
                    else if (choice == 2) scheduler.addAtEnd(task);
                    else {
                        System.out.print("Enter Position: ");
                        int pos = sc.nextInt();
                        scheduler.addAtPosition(task, pos);
                    }
                }
                case 4 -> {
                    System.out.print("Enter Task ID to remove: ");
                    int id = sc.nextInt();
                    scheduler.removeById(id);
                }
                case 5 -> scheduler.viewCurrentTask();
                case 6 -> scheduler.moveToNextTask();
                case 7 -> scheduler.displayAllTasks();
                case 8 -> {
                    System.out.print("Enter Priority to search: ");
                    String p = sc.nextLine();
                    scheduler.searchByPriority(p);
                }
                case 9 -> {
                    System.out.println("Exiting Task Scheduler.");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}
