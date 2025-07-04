import java.util.*;

// Class representing each User node in the linked list
class User {
    int userId;
    String name;
    int age;
    ArrayList<Integer> friends; // Stores userIds of connected friends
    User next; // Pointer to the next user in the linked list

    User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friends = new ArrayList<>();
        this.next = null;
    }
}

// Class representing the Social Network functionality
class SocialNetwork {
    User head; // Head of the singly linked list

    // Add new user to the list
    void addUser(int userId, String name, int age) {
        if (getUserById(userId) != null) {
            System.out.println("User ID already exists.");
            return;
        }

        User newUser = new User(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newUser;
        }
        System.out.println("User added successfully.");
    }

    // Find and return user by ID
    User getUserById(int id) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == id) return temp;
            temp = temp.next;
        }
        return null;
    }

    // Add friend connection between two users
    void addFriend(int id1, int id2) {
        if (id1 == id2) {
            System.out.println("Cannot friend self.");
            return;
        }

        User u1 = getUserById(id1);
        User u2 = getUserById(id2);

        if (u1 == null || u2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        // Add each other's IDs to their friend lists if not already connected
        if (!u1.friends.contains(id2)) u1.friends.add(id2);
        if (!u2.friends.contains(id1)) u2.friends.add(id1);

        System.out.println("Friend connection added.");
    }

    // Remove friend connection between two users
    void removeFriend(int id1, int id2) {
        User u1 = getUserById(id1);
        User u2 = getUserById(id2);

        if (u1 == null || u2 == null) {
            System.out.println("User not found.");
            return;
        }

        u1.friends.remove(Integer.valueOf(id2));
        u2.friends.remove(Integer.valueOf(id1));

        System.out.println("Friend connection removed.");
    }

    // Display all friends of a specific user
    void displayFriends(int id) {
        User user = getUserById(id);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        if (user.friends.isEmpty()) {
            System.out.println(user.name + " has no friends.");
            return;
        }

        System.out.println("Friends of " + user.name + ":");
        for (int fid : user.friends) {
            User friend = getUserById(fid);
            if (friend != null) {
                System.out.println("- " + friend.name + " (ID: " + friend.userId + ")");
            }
        }
    }

    // Show mutual friends between two users
    void mutualFriends(int id1, int id2) {
        User u1 = getUserById(id1);
        User u2 = getUserById(id2);

        if (u1 == null || u2 == null) {
            System.out.println("User not found.");
            return;
        }

        Set<Integer> set = new HashSet<>(u1.friends);
        List<String> mutual = new ArrayList<>();

        for (int fid : u2.friends) {
            if (set.contains(fid)) {
                User mutualUser = getUserById(fid);
                mutual.add(mutualUser.name + " (ID: " + mutualUser.userId + ")");
            }
        }

        if (mutual.isEmpty()) {
            System.out.println("No mutual friends.");
        } else {
            System.out.println("Mutual friends:");
            for (String m : mutual) System.out.println("- " + m);
        }
    }

    // Search for a user by ID or Name
    void searchUser(String keyword) {
        boolean found = false;
        User temp = head;
        while (temp != null) {
            if (String.valueOf(temp.userId).equals(keyword) || temp.name.equalsIgnoreCase(keyword)) {
                System.out.println("User Found: ID: " + temp.userId + ", Name: " + temp.name + ", Age: " + temp.age);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("User not found.");
    }

    // Count number of friends for each user
    void countAllFriends() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.name + " (ID: " + temp.userId + ") has " + temp.friends.size() + " friend(s).");
            temp = temp.next;
        }
    }
}

// Main class with user input for the system
public class Social_Media_System {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SocialNetwork network = new SocialNetwork();

        while (true) {
            System.out.println("\n1. Add User\n2. Add Friend\n3. Remove Friend\n4. Mutual Friends");
            System.out.println("5. Display Friends\n6. Search User\n7. Count Friends\n8. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();  // consume leftover newline

            switch (ch) {
                case 1 -> {
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    network.addUser(id, name, age);
                }
                case 2 -> {
                    System.out.print("Enter First User ID: ");
                    int id1 = sc.nextInt();
                    System.out.print("Enter Second User ID: ");
                    int id2 = sc.nextInt();
                    network.addFriend(id1, id2);
                }
                case 3 -> {
                    System.out.print("Enter First User ID: ");
                    int id1 = sc.nextInt();
                    System.out.print("Enter Second User ID: ");
                    int id2 = sc.nextInt();
                    network.removeFriend(id1, id2);
                }
                case 4 -> {
                    System.out.print("Enter First User ID: ");
                    int id1 = sc.nextInt();
                    System.out.print("Enter Second User ID: ");
                    int id2 = sc.nextInt();
                    network.mutualFriends(id1, id2);
                }
                case 5 -> {
                    System.out.print("Enter User ID: ");
                    int id = sc.nextInt();
                    network.displayFriends(id);
                }
                case 6 -> {
                    System.out.print("Enter User ID or Name: ");
                    String key = sc.nextLine();
                    network.searchUser(key);
                }
                case 7 -> network.countAllFriends();
                case 8 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
