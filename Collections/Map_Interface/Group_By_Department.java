import java.util.*;

class Employee
{
    String name;
    String department;

    public Employee(String name, String department)
    {
        this.name        = name;
        this.department  = department;
    }

    @Override
    public String toString()
    {
        return name;
    }
}

class Group_By_Department
{
    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees)
    {
        Map<String, List<Employee>> map = new HashMap<>();

        for (Employee e : employees)
        {
            map.computeIfAbsent(e.department, k -> new ArrayList<>()).add(e);
        }

        return map;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < n; i++)
        {
            System.out.print("Enter name of employee #" + (i + 1) + ": ");
            String name = sc.next();

            System.out.print("Enter department of " + name + ": ");
            String dept = sc.next();

            employees.add(new Employee(name, dept));
        }

        Map<String, List<Employee>> grouped = groupByDepartment(employees);

        System.out.println("\nGrouped by Department:");
        for (Map.Entry<String, List<Employee>> entry : grouped.entrySet())
        {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        sc.close();
    }
}
