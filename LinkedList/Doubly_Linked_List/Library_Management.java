import java.util.*;

// Node class representing a Book
class Book {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    Book next, prev;

    Book(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

// Library class implementing Doubly Linked List
class Library {
    Book head, tail;

    // Add at beginning
    void addAtBeginning(Book newBook) {
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        System.out.println("Book added at beginning.");
    }

    // Add at end
    void addAtEnd(Book newBook) {
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        System.out.println("Book added at end.");
    }

    // Add at specific position (1-based)
    void addAtPosition(Book newBook, int position) {
        if (position <= 1 || head == null) {
            addAtBeginning(newBook);
            return;
        }
        Book temp = head;
        int index = 1;
        while (temp.next != null && index < position - 1) {
            temp = temp.next;
            index++;
        }
        if (temp.next == null) {
            addAtEnd(newBook);
        } else {
            newBook.next = temp.next;
            newBook.prev = temp;
            temp.next.prev = newBook;
            temp.next = newBook;
            System.out.println("Book added at position " + position);
        }
    }

    // Remove by Book ID
    void removeById(int bookId) {
        Book temp = head;
        while (temp != null && temp.bookId != bookId) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Book ID not found.");
            return;
        }
        if (temp == head) head = head.next;
        if (temp == tail) tail = tail.prev;
        if (temp.prev != null) temp.prev.next = temp.next;
        if (temp.next != null) temp.next.prev = temp.prev;
        System.out.println("Book removed.");
    }

    // Search by Title
    void searchByTitle(String title) {
        Book temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                displayBook(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No book found with the given title.");
    }

    // Search by Author
    void searchByAuthor(String author) {
        Book temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                displayBook(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No book found with the given author.");
    }

    // Update availability by Book ID
    void updateAvailability(int bookId, boolean status) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.isAvailable = status;
                System.out.println("Availability updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book ID not found.");
    }

    // Display all books forward
    void displayForward() {
        System.out.println("\n--- Library (Forward) ---");
        Book temp = head;
        while (temp != null) {
            displayBook(temp);
            temp = temp.next;
        }
    }

    // Display all books reverse
    void displayReverse() {
        System.out.println("\n--- Library (Reverse) ---");
        Book temp = tail;
        while (temp != null) {
            displayBook(temp);
            temp = temp.prev;
        }
    }

    // Count total books
    int countBooks() {
        Book temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // Print book details
    void displayBook(Book b) {
        System.out.println("ID: " + b.bookId + ", Title: " + b.title + ", Author: " + b.author +
                ", Genre: " + b.genre + ", Available: " + (b.isAvailable ? "Yes" : "No"));
    }
}

// Main class to run the program
public class Library_Management {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();

        while (true) {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Book at Beginning");
            System.out.println("2. Add Book at End");
            System.out.println("3. Add Book at Position");
            System.out.println("4. Remove Book by ID");
            System.out.println("5. Search Book by Title");
            System.out.println("6. Search Book by Author");
            System.out.println("7. Update Book Availability");
            System.out.println("8. Display All Books (Forward)");
            System.out.println("9. Display All Books (Reverse)");
            System.out.println("10. Count Total Books");
            System.out.println("11. Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            if (ch == 11) break;

            String title, author, genre;
            int id, pos;
            boolean available;
            Book book;

            switch (ch) {
                case 1 -> {
                    System.out.print("Enter ID: "); id = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Title: "); title = sc.nextLine();
                    System.out.print("Enter Author: "); author = sc.nextLine();
                    System.out.print("Enter Genre: "); genre = sc.nextLine();
                    System.out.print("Available (true/false): "); available = sc.nextBoolean();
                    book = new Book(title, author, genre, id, available);
                    lib.addAtBeginning(book);
                }
                case 2 -> {
                    System.out.print("Enter ID: "); id = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Title: "); title = sc.nextLine();
                    System.out.print("Enter Author: "); author = sc.nextLine();
                    System.out.print("Enter Genre: "); genre = sc.nextLine();
                    System.out.print("Available (true/false): "); available = sc.nextBoolean();
                    book = new Book(title, author, genre, id, available);
                    lib.addAtEnd(book);
                }
                case 3 -> {
                    System.out.print("Enter ID: "); id = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Title: "); title = sc.nextLine();
                    System.out.print("Enter Author: "); author = sc.nextLine();
                    System.out.print("Enter Genre: "); genre = sc.nextLine();
                    System.out.print("Available (true/false): "); available = sc.nextBoolean();
                    System.out.print("Enter Position: "); pos = sc.nextInt();
                    book = new Book(title, author, genre, id, available);
                    lib.addAtPosition(book, pos);
                }
                case 4 -> {
                    System.out.print("Enter Book ID: ");
                    id = sc.nextInt();
                    lib.removeById(id);
                }
                case 5 -> {
                    System.out.print("Enter Title: ");
                    title = sc.nextLine();
                    lib.searchByTitle(title);
                }
                case 6 -> {
                    System.out.print("Enter Author: ");
                    author = sc.nextLine();
                    lib.searchByAuthor(author);
                }
                case 7 -> {
                    System.out.print("Enter Book ID: ");
                    id = sc.nextInt();
                    System.out.print("Enter new availability (true/false): ");
                    available = sc.nextBoolean();
                    lib.updateAvailability(id, available);
                }
                case 8 -> lib.displayForward();
                case 9 -> lib.displayReverse();
                case 10 -> System.out.println("Total Books: " + lib.countBooks());
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
