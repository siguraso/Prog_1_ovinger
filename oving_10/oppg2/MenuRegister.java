import java.util.ArrayList;

public class MenuRegister {
  ArrayList<Menu> menus;

  public MenuRegister(ArrayList<Menu> menus) {
    this.menus = menus;
  }

  public Menu getMenu(int index) {
    return this.menus.get(index);
  }

  public ArrayList<Menu> getMenus() {
    return this.menus;
  }

  public void registerMenu(Menu menu) {
    this.menus.add(menu);
  }

  public ArrayList<Meal> searchMealName(String searchTerm) {
    ArrayList<Meal> searchResults = new ArrayList<>();

    for (Menu menu : menus) {
      for (Meal meal : menu.getAllMeals()) {
        if (meal.getName().toLowerCase().contains(searchTerm.toLowerCase())) {
          searchResults.add(meal);
        }
      }
    }

    return searchResults;
  }

  public ArrayList<Meal> searchMealType(String searchTerm) {
    ArrayList<Meal> searchResults = new ArrayList<>();

    for (Menu menu : menus) {
      for (Meal meal : menu.getAllMeals()) {
        if (meal.getType().equalsIgnoreCase(searchTerm)) {
          searchResults.add(meal);
        }
      }
    }

    return searchResults;
  }

  public ArrayList<Meal> searchPriceRange(double lowestPrice, double highestPrice) {
    ArrayList<Meal> searchResults = new ArrayList<>();

    for (Menu menu : menus) {
      for (Meal meal : menu.getAllMeals()) {
        if (meal.getPrice() >= lowestPrice && meal.getPrice() <= highestPrice) {
          searchResults.add(meal);
        }
      }
    }

    return searchResults;
  }


}
