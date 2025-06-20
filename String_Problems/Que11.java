import java.util.Scanner;

public class Que11 {

    public static String getComputerChoice() {
        double random = Math.random();
        if (random < 0.33) {
            return "rock";
        } else if (random < 0.66) {
            return "paper";
        } else {
            return "scissors";
        }
    }

    public static String findWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return "draw";
        }
        if (userChoice.equals("rock")) {
            return (computerChoice.equals("scissors")) ? "user" : "computer";
        } else if (userChoice.equals("paper")) {
            return (computerChoice.equals("rock")) ? "user" : "computer";
        } else if (userChoice.equals("scissors")) {
            return (computerChoice.equals("paper")) ? "user" : "computer";
        }
        return "invalid";
    }

    public static String[][] calculateStats(int userWins, int computerWins, int draws, int totalGames) {
        double userWinPercent = (userWins * 100.0) / totalGames;
        double computerWinPercent = (computerWins * 100.0) / totalGames;
        double drawPercent = (draws * 100.0) / totalGames;

        String[][] stats = {
                { "Player Wins", Integer.toString(userWins), String.format("%.2f%%", userWinPercent) },
                { "Computer Wins", Integer.toString(computerWins), String.format("%.2f%%", computerWinPercent) },
                { "Draws", Integer.toString(draws), String.format("%.2f%%", drawPercent) }
        };
        return stats;
    }

    public static void displayResults(String[] userChoices, String[] computerChoices, String[] winners,
            String[][] stats) {
        System.out.println("Game\tPlayer\tComputer\tWinner");
        for (int i = 0; i < userChoices.length; i++) {
            System.out.printf("%d\t%s\t%s\t\t%s\n", i + 1, userChoices[i], computerChoices[i], winners[i]);
        }
        System.out.println("\nSummary:");
        System.out.println("Result\t\tCount\tPercentage");
        for (String[] row : stats) {
            System.out.printf("%s\t%s\t%s\n", row[0], row[1], row[2]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of games to play: ");
        int numGames = scanner.nextInt();
        scanner.nextLine(); // consume newline

        String[] userChoices = new String[numGames];
        String[] computerChoices = new String[numGames];
        String[] winners = new String[numGames];

        int userWins = 0, computerWins = 0, draws = 0;

        for (int i = 0; i < numGames; i++) {
            System.out.print("Enter your choice (rock, paper, scissors) for game " + (i + 1) + ": ");
            String userChoice = scanner.nextLine().toLowerCase();
            while (!userChoice.equals("rock") && !userChoice.equals("paper") && !userChoice.equals("scissors")) {
                System.out.print("Invalid choice. Please enter rock, paper, or scissors: ");
                userChoice = scanner.nextLine().toLowerCase();
            }
            String computerChoice = getComputerChoice();
            String winner = findWinner(userChoice, computerChoice);

            userChoices[i] = userChoice;
            computerChoices[i] = computerChoice;
            winners[i] = winner;

            if (winner.equals("user")) {
                userWins++;
            } else if (winner.equals("computer")) {
                computerWins++;
            } else {
                draws++;
            }
        }

        String[][] stats = calculateStats(userWins, computerWins, draws, numGames);
        displayResults(userChoices, computerChoices, winners, stats);

        scanner.close();
    }
}
