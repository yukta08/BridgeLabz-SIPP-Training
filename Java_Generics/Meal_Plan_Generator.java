import java.util.*;

// ===== Interface for Meal Plan =====
interface MealPlan 
{
    String getType();
    List<String> getMeals();
    void displayPlan();
}

// ===== Concrete Meal Types =====
class VegetarianMeal implements MealPlan 
{
    public String getType() 
    {
        return "Vegetarian";
    }

    public List<String> getMeals() 
    {
        return Arrays.asList("Paneer Curry", "Mixed Veg Salad", "Fruit Bowl");
    }

    public void displayPlan() 
    {
        System.out.println("[" + getType() + " Meal Plan]");
        for (String meal : getMeals()) 
        {
            System.out.println("- " + meal);
        }
    }
}

class VeganMeal implements MealPlan 
{
    public String getType() 
    {
        return "Vegan";
    }

    public List<String> getMeals() 
    {
        return Arrays.asList("Tofu Stir Fry", "Vegan Smoothie", "Lentil Soup");
    }

    public void displayPlan() 
    {
        System.out.println("[" + getType() + " Meal Plan]");
        for (String meal : getMeals()) 
        {
            System.out.println("- " + meal);
        }
    }
}

class KetoMeal implements MealPlan 
{
    public String getType() 
    {
        return "Keto";
    }

    public List<String> getMeals() 
    {
        return Arrays.asList("Grilled Chicken", "Boiled Eggs", "Avocado Salad");
    }

    public void displayPlan() 
    {
        System.out.println("[" + getType() + " Meal Plan]");
        for (String meal : getMeals()) 
        {
            System.out.println("- " + meal);
        }
    }
}

class HighProteinMeal implements MealPlan 
{
    public String getType() 
    {
        return "High-Protein";
    }

    public List<String> getMeals() 
    {
        return Arrays.asList("Protein Shake", "Turkey Breast", "Chickpea Salad");
    }

    public void displayPlan() 
    {
        System.out.println("[" + getType() + " Meal Plan]");
        for (String meal : getMeals()) 
        {
            System.out.println("- " + meal);
        }
    }
}

// ===== Generic Meal Handler =====
class Meal<T extends MealPlan> 
{
    private T mealPlan;

    public Meal(T mealPlan) 
    {
        this.mealPlan = mealPlan;
    }

    public void generateMealPlan() 
    {
        mealPlan.displayPlan();
    }

    public T getPlan() 
    {
        return mealPlan;
    }
}

// ===== Utility Class with Generic Method =====
class MealUtility 
{
    public static <T extends MealPlan> void validateAndGenerate(T plan) 
    {
        if (plan.getMeals() == null || plan.getMeals().isEmpty()) 
        {
            System.out.println("Invalid meal plan for: " + plan.getType());
        } 
        else 
        {
            System.out.println("Personalized Meal Plan: " + plan.getType());
            plan.displayPlan();
        }
    }
}

// ===== Main Program =====
public class Meal_Plan_Generator 
{
    public static void main(String[] args) 
    {
        Meal<VegetarianMeal> vegPlan = new Meal<>(new VegetarianMeal());
        Meal<VeganMeal> veganPlan = new Meal<>(new VeganMeal());
        Meal<KetoMeal> ketoPlan = new Meal<>(new KetoMeal());
        Meal<HighProteinMeal> proteinPlan = new Meal<>(new HighProteinMeal());

        System.out.println("=== Personalized Meal Plans ===");
        MealUtility.validateAndGenerate(vegPlan.getPlan());
        System.out.println();
        MealUtility.validateAndGenerate(veganPlan.getPlan());
        System.out.println();
        MealUtility.validateAndGenerate(ketoPlan.getPlan());
        System.out.println();
        MealUtility.validateAndGenerate(proteinPlan.getPlan());
    }
}
