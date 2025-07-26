import java.util.*;

class Voting_System 
{

    // HashMap: Candidate → Votes
    private Map<String, Integer> voteCountMap = new HashMap<>();

    // LinkedHashMap: Vote Order → Candidate
    private List<String> voteOrder = new LinkedList<>();

    // Cast a vote
    public void castVote(String candidate) 
    {
        // Add to vote count
        voteCountMap.put(candidate, voteCountMap.getOrDefault(candidate, 0) + 1);

        // Record the vote order
        voteOrder.add(candidate);
    }

    // Display votes in insertion order (LinkedHashMap-like)
    public void displayVoteOrder() 
    {
        System.out.println(" Vote Order:");
        for (String name : voteOrder) 
        {
            System.out.println(name);
        }
    }

    // Display vote count (HashMap)
    public void displayVoteCount() 
    {
        System.out.println("\n Vote Count:");
        for (Map.Entry<String, Integer> entry : voteCountMap.entrySet()) 
        {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }
    }

    // Display sorted vote result using TreeMap
    public void displaySortedResults() 
    {
        System.out.println("\n Sorted Results (TreeMap):");
        TreeMap<String, Integer> sortedMap = new TreeMap<>(voteCountMap);
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) 
        {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }
    }

    public static void main(String[] args) 
    {
        Voting_System voting = new Voting_System();

        voting.castVote("Alice");
        voting.castVote("Bob");
        voting.castVote("Alice");
        voting.castVote("Charlie");
        voting.castVote("Bob");

        voting.displayVoteOrder();
        voting.displayVoteCount();
        voting.displaySortedResults();
    }
}
