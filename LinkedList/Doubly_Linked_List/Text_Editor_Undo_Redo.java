import java.util.Scanner;

// Node representing each state of the text editor
class TextState {
    String content;
    TextState prev, next;

    TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

// Editor class managing the doubly linked list
class TextEditor {
    private TextState head, tail, current;
    private int size;
    private final int MAX_HISTORY = 10;

    // Add new text state after current (clears forward history)
    void addState(String newText) {
        TextState newState = new TextState(newText);

        if (head == null) {
            head = tail = current = newState;
            size = 1;
        } else {
            // Remove forward states (redo history)
            current.next = null;
            tail = current;

            // Link new state
            newState.prev = current;
            current.next = newState;
            current = newState;
            tail = newState;
            size++;

            // Limit history size to last 10
            if (size > MAX_HISTORY) {
                head = head.next;
                head.prev = null;
                size--;
            }
        }
        System.out.println("State saved.");
    }

    // Undo (move to previous state)
    void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo successful.");
        } else {
            System.out.println("No more undo available.");
        }
    }

    // Redo (move to next state)
    void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo successful.");
        } else {
            System.out.println("No more redo available.");
        }
    }

    // Display current text
    void showCurrentState() {
        if (current != null) {
            System.out.println("Current Text:\n" + current.content);
        } else {
            System.out.println("No text available.");
        }
    }
}

// Main class
public class Text_Editor_Undo_Redo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TextEditor editor = new TextEditor();

        while (true) {
            System.out.println("\n--- Text Editor Menu ---");
            System.out.println("1. Type Text / Add New State");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Show Current State");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter new text state: ");
                    String text = sc.nextLine();
                    editor.addState(text);
                }
                case 2 -> editor.undo();
                case 3 -> editor.redo();
                case 4 -> editor.showCurrentState();
                case 5 -> {
                    System.out.println("Exiting editor...");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
