import java.time.*;
import java.util.*;

class Policy
{
    String       policyNumber;
    String       policyholderName;
    LocalDate    expiryDate;
    String       coverageType;

    public Policy(String policyNumber, String policyholderName,LocalDate expiryDate, String coverageType)
    {
        this.policyNumber     = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate       = expiryDate;
        this.coverageType     = coverageType;
    }

    @Override
    public String toString()
    {
        return "[" + policyNumber + ", " + policyholderName + ", " +expiryDate + ", " + coverageType + "]";
    }
}

class Insurance_Manager
{
    Map<String, Policy> hashMap = new HashMap<>();
    Map<String, Policy> linkedMap = new LinkedHashMap<>();
    TreeMap<LocalDate, List<Policy>> treeMap   = new TreeMap<>();

    public void addPolicy(Policy p)
    {
        // Add to HashMap
        hashMap.put(p.policyNumber, p);

        // Add to LinkedHashMap
        linkedMap.put(p.policyNumber, p);

        // Add to TreeMap grouped by expiry date
        treeMap.computeIfAbsent(p.expiryDate, k -> new ArrayList<>()).add(p);
    }

    public Policy getPolicyByNumber(String policyNumber)
    {
        return hashMap.get(policyNumber);
    }

    public List<Policy> getPoliciesExpiringIn30Days()
    {
        List<Policy> expiring = new ArrayList<>();
        LocalDate now = LocalDate.now();
        LocalDate limit = now.plusDays(30);

        for (Map.Entry<LocalDate, List<Policy>> entry : treeMap.subMap(now, true, limit, true).entrySet())
        {
            expiring.addAll(entry.getValue());
        }

        return expiring;
    }

    public List<Policy> getPoliciesByHolder(String holder)
    {
        List<Policy> result = new ArrayList<>();

        for (Policy p : hashMap.values())
        {
            if (p.policyholderName.equalsIgnoreCase(holder))
            {
                result.add(p);
            }
        }

        return result;
    }

    public void removeExpiredPolicies()
    {
        LocalDate today = LocalDate.now();

        // Remove from HashMap
        hashMap.values().removeIf(p -> p.expiryDate.isBefore(today));

        // Remove from LinkedHashMap
        linkedMap.values().removeIf(p -> p.expiryDate.isBefore(today));

        // Remove from TreeMap
        treeMap.headMap(today, false).clear();
    }

    public void printAllPolicies()
    {
        System.out.println("All Policies:");
        for (Policy p : linkedMap.values())
        {
            System.out.println(p);
        }
    }

    public static void main(String[] args)
    {
        Insurance_Manager manager = new Insurance_Manager();

        manager.addPolicy(new Policy("P001", "Alice", LocalDate.now().plusDays(10), "Health"));
        manager.addPolicy(new Policy("P002", "Bob",   LocalDate.now().plusDays(40), "Auto"));
        manager.addPolicy(new Policy("P003", "Alice", LocalDate.now().minusDays(5), "Home"));

        System.out.println("\n Retrieve P002: " + manager.getPolicyByNumber("P002"));

        System.out.println("\n Policies expiring in 30 days:");
        for (Policy p : manager.getPoliciesExpiringIn30Days())
        {
            System.out.println(p);
        }

        System.out.println("\n Policies for Alice:");
        for (Policy p : manager.getPoliciesByHolder("Alice"))
        {
            System.out.println(p);
        }

        manager.removeExpiredPolicies();

        System.out.println("\n All valid policies after removing expired:");
        manager.printAllPolicies();
    }
}
