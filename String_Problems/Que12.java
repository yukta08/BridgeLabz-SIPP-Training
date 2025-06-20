import java.util.Scanner;

public class Que12 {

    public static String getComputerChoice() {
        double rand = Math.random();
        if (rand < 1.0 / 3) {
            return "rock";
        } else if (rand < 2.0 / 3) {
            return "paper";
        } else {
            return "scissors";
        }
    }

    public static String getWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return "Draw";
        }
        switch (userChoice) {
            case "rock":
                return (computerChoice.equals("scissors")) ? "User" : "Computer";
            case "paper":
                return (computerChoice.equals("rock")) ? "User" : "Computer";
            case "scissors":
                return (computerChoice.equals("paper")) ? "User" : "Computer";
            default:
                return "Invalid";
        }
    }

    public static String[][] calculateStats(int userWins, int computerWins, int totalGames) {
        double userWinPercent = (totalGames > 0) ? (userWins * 100.0 / totalGames) : 0;
        double computerWinPercent = (totalGames > 0) ? (computerWins * 100.0 / totalGames) : 0;
        double userWinAvg = (totalGames > 0) ? (userWins * 1.0 / totalGames) : 0;
        double computerWinAvg = (totalGames > 0) ? (computerWins * 1.0 / totalGames) : 0;

        String[][] stats = new String[2][3];
        stats[0][0] = "User";
        stats[0][1] = String.format("%.2f", userWinAvg);
        stats[0][2] = String.format("%.2f%%", userWinPercent);
        stats[1][0] = "Computer";
        stats[1][1] = String.format("%.2f", computerWinAvg);
        stats[1][2] = String.format("%.2f%%", computerWinPercent);

        return stats;
    }

    public static void displayResults(String[] userChoices, String[] computerChoices, String[] winners, int userWins,
            int computerWins) {
        System.out.println("\nGame Results:");
        System.out.printf("%-10s %-15s %-15s %-10s\n", "Game No.", "User Choice", "Computer Choice", "Winner");
        for (int i = 0; i < userChoices.length; i++) {
            System.out.printf("%-10d %-15s %-15s %-10s\n", i + 1, userChoices[i], computerChoices[i], winners[i]);
        }

        String[][] stats = calculateStats(userWins, computerWins, userChoices.length);
        System.out.println("\nSummary:");
        System.out.printf("%-10s %-10s %-15s\n", "Player", "Average", "Winning Percentage");
        for (String[] row : stats) {
            System.out.printf("%-10s %-10s %-15s\n", row[0], row[1], row[2]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of games to play: ");
        int numGames = scanner.nextInt();
        scanner.nextLine(); // consume newline

        String[] userChoices = new String[numGames];
        String[] computerChoices = new String[numGames];
        String[] winners = new String[numGames];

        int userWins = 0;
        int computerWins = 0;

        for (int i = 0; i < numGames; i++) {
            String userChoice;
            while (true) {
                System.out.print("Game " + (i + 1) + " - Enter your choice (rock, paper, scissors): ");
                userChoice = scanner.nextLine().toLowerCase();
                if (userChoice.equals("rock") || userChoice.equals("paper") || userChoice.equals("scissors")) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter rock, paper, or scissors.");
                }
            }

            String computerChoice = getComputerChoice();
            String winner = getWinner(userChoice, computerChoice);

            userChoices[i] = userChoice;
            computerChoices[i] = computerChoice;
            winners[i] = winner;

            if (winner.equals("User")) {
                userWins++;
            } else if (winner.equals("Computer")) {
                computerWins++;
            }

            System.out.println("Computer chose: " + computerChoice);
            System.out.println("Winner: " + winner);
            System.out.println();
        }

        displayResults(userChoices, computerChoices, winners, userWins, computerWins);

        scanner.close();
    }
}
