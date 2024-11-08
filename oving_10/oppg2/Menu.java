import java.util.ArrayList;

public class Menu {
  ArrayList<Meal> meals;

  public Menu(ArrayList<Meal> meals) {
    this.meals = meals;
  }

  public Meal getMeal(int index) {
    return this.meals.get(index);
  }

  public ArrayList<Meal> getAllMeals() {
    return this.meals;
  }

  public void addMeal(Meal meal) {
    this.meals.add(meal);
  }

}
