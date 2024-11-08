public class Meal {
  private final String mealName;
  private final double price;
  private final String mealType;

  public Meal(String mealName, double price, String mealType) {
    this.mealName = mealName;
    this.price = price;
    this.mealType = mealType;
  }

  public String getName() {
    return mealName;
  }

  public String getType() {
    return mealType;
  }

  public double getPrice() {
    return price;
  }

}
