import java.util.ArrayList;

public class smallClient {
  public static void main(String[] args) {
    ArrayList<Meal> menu1 = new ArrayList<>();
    menu1.add(new Meal("fiskeboller", 200, "main"));
    menu1.add(new Meal("fiskekaker", 100, "main"));
    menu1.add(new Meal("fiskepudding", 150, "main"));

    Menu menu_1 = new Menu(menu1);

    ArrayList<Meal> menu2 = new ArrayList<>();
    menu2.add(new Meal("is", 70, "dessert"));
    menu2.add(new Meal("sjokoladepure", 95, "dessert"));
    menu2.add(new Meal("vaniljekrem", 30, "dessert"));

    Menu menu_2 = new Menu(menu2);

    ArrayList<Meal> menu3 = new ArrayList<>();
    menu3.add(new Meal("brødpinner", 20, "starter"));
    menu3.add(new Meal("nachos", 95, "starter"));
    menu3.add(new Meal("salt", 30, "starter"));

    Menu menu_3 = new Menu(menu3);

    ArrayList<Menu> menus = new ArrayList<>();

    menus.add(menu_1);
    menus.add(menu_2);
    menus.add(menu_3);

    MenuRegister mr = new MenuRegister(menus);

    ArrayList<Meal> search1 = mr.searchMealName("fisk");

    System.out.println("\nfisk:");
    for (Meal m : search1) {
      System.out.println(m.getName() + ", " + m.getPrice() + ", " + m.getType());
    }

    System.out.println("\ndessert:");
    ArrayList<Meal> search2 = mr.searchMealType("dessert");
    for (Meal m : search2) {
      System.out.println(m.getName() + ", " + m.getPrice() + ", " + m.getType());
    }

    System.out.println("\npris 50-100:");
    ArrayList<Meal> search3 = mr.searchPriceRange(50, 150);
    for (Meal m : search3) {
      System.out.println(m.getName() + ", " + m.getPrice() + ", " + m.getType());
    }


  }
}
