import java.util.*;

// Node representing a movie
class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie prev, next;

    Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.prev = null;
        this.next = null;
    }
}

// Class managing the doubly linked list
class MovieManager {
    Movie head, tail;

    // Add at beginning
    void addAtBeginning(String title, String director, int year, double rating) {
        Movie m = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = m;
        } else {
            m.next = head;
            head.prev = m;
            head = m;
        }
        System.out.println("Movie added at beginning.");
    }

    // Add at end
    void addAtEnd(String title, String director, int year, double rating) {
        Movie m = new Movie(title, director, year, rating);
        if (tail == null) {
            head = tail = m;
        } else {
            tail.next = m;
            m.prev = tail;
            tail = m;
        }
        System.out.println("Movie added at end.");
    }

    // Add at specific position (1-based)
    void addAtPosition(String title, String director, int year, double rating, int pos) {
        if (pos <= 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }

        Movie m = new Movie(title, director, year, rating);
        Movie temp = head;
        int count = 1;

        while (temp != null && count < pos - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null || temp.next == null) {
            addAtEnd(title, director, year, rating);
        } else {
            m.next = temp.next;
            m.prev = temp;
            temp.next.prev = m;
            temp.next = m;
            System.out.println("Movie added at position " + pos + ".");
        }
    }

    // Delete by title
    void deleteByTitle(String title) {
        Movie temp = head;
        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Movie not found.");
            return;
        }

        if (temp == head) head = head.next;
        if (temp == tail) tail = tail.prev;
        if (temp.prev != null) temp.prev.next = temp.next;
        if (temp.next != null) temp.next.prev = temp.prev;

        System.out.println("Movie deleted: " + title);
    }

    // Search by director
    void searchByDirector(String director) {
        Movie temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                printMovie(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No movie found by this director.");
    }

    // Search by rating
    void searchByRating(double rating) {
        Movie temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.rating == rating) {
                printMovie(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No movie found with this rating.");
    }

    // Display forward
    void displayForward() {
        Movie temp = head;
        System.out.println("\n--- Movie List (Forward) ---");
        while (temp != null) {
            printMovie(temp);
            temp = temp.next;
        }
    }

    // Display reverse
    void displayReverse() {
        Movie temp = tail;
        System.out.println("\n--- Movie List (Reverse) ---");
        while (temp != null) {
            printMovie(temp);
            temp = temp.prev;
        }
    }

    // Update rating by title
    void updateRating(String title, double newRating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }

    // Print movie info
    void printMovie(Movie m) {
        System.out.println("Title: " + m.title + ", Director: " + m.director +
                ", Year: " + m.year + ", Rating: " + m.rating);
    }
}

// Main class to run the program
public class Movie_Management {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieManager mm = new MovieManager();

        while (true) {
            System.out.println("\n--- Movie Management ---");
            System.out.println("1. Add Movie at Beginning");
            System.out.println("2. Add Movie at End");
            System.out.println("3. Add Movie at Position");
            System.out.println("4. Delete Movie by Title");
            System.out.println("5. Search Movie by Director");
            System.out.println("6. Search Movie by Rating");
            System.out.println("7. Display All Movies (Forward)");
            System.out.println("8. Display All Movies (Reverse)");
            System.out.println("9. Update Movie Rating");
            System.out.println("10. Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt();
            sc.nextLine(); // consume newline

            if (ch == 10) break;

            String title, director;
            int year, pos;
            double rating;

            switch (ch) {
                case 1 -> {
                    System.out.print("Title: "); title = sc.nextLine();
                    System.out.print("Director: "); director = sc.nextLine();
                    System.out.print("Year: "); year = sc.nextInt();
                    System.out.print("Rating: "); rating = sc.nextDouble();
                    mm.addAtBeginning(title, director, year, rating);
                }
                case 2 -> {
                    System.out.print("Title: "); title = sc.nextLine();
                    System.out.print("Director: "); director = sc.nextLine();
                    System.out.print("Year: "); year = sc.nextInt();
                    System.out.print("Rating: "); rating = sc.nextDouble();
                    mm.addAtEnd(title, director, year, rating);
                }
                case 3 -> {
                    System.out.print("Title: "); title = sc.nextLine();
                    System.out.print("Director: "); director = sc.nextLine();
                    System.out.print("Year: "); year = sc.nextInt();
                    System.out.print("Rating: "); rating = sc.nextDouble();
                    System.out.print("Position: "); pos = sc.nextInt();
                    mm.addAtPosition(title, director, year, rating, pos);
                }
                case 4 -> {
                    System.out.print("Enter title to delete: ");
                    title = sc.nextLine();
                    mm.deleteByTitle(title);
                }
                case 5 -> {
                    System.out.print("Enter director name: ");
                    director = sc.nextLine();
                    mm.searchByDirector(director);
                }
                case 6 -> {
                    System.out.print("Enter rating: ");
                    rating = sc.nextDouble();
                    mm.searchByRating(rating);
                }
                case 7 -> mm.displayForward();
                case 8 -> mm.displayReverse();
                case 9 -> {
                    System.out.print("Enter title: ");
                    title = sc.nextLine();
                    System.out.print("Enter new rating: ");
                    rating = sc.nextDouble();
                    mm.updateRating(title, rating);
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
