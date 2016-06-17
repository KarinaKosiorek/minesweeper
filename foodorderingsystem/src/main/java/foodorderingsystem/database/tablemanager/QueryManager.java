package foodorderingsystem.database.tablemanager;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.SessionFactory;

import foodorderingsystem.model.Cuisine;
import foodorderingsystem.model.Dessert;
import foodorderingsystem.model.Drink;
import foodorderingsystem.model.MainCourse;

public class QueryManager {

  private ClientOrderManager clientOrderManager = new ClientOrderManager();
  private CuisineManager cuisineManager = new CuisineManager();
  private MainCourseManager mainCourseManager = new MainCourseManager();
  private DessertManager dessertManager = new DessertManager();
  private DrinkManager drinkManager = new DrinkManager();

  public QueryManager(SessionFactory factory) {
    clientOrderManager.setFactory(factory);
    cuisineManager.setFactory(factory);
    mainCourseManager.setFactory(factory);
    dessertManager.setFactory(factory);
    drinkManager.setFactory(factory);
  }

  public void addMainCourses() {
    Cuisine polishCuisine = cuisineManager.getCuisine("Polish");
    mainCourseManager.addMainCourse(polishCuisine, "Dumplings", new BigDecimal(15));
    mainCourseManager.addMainCourse(polishCuisine, "Pork Chop", new BigDecimal(17));

    Cuisine italianCuisine = cuisineManager.getCuisine("Italian");
    mainCourseManager.addMainCourse(italianCuisine, "Spaghetti Bolognese", new BigDecimal(16));
    mainCourseManager.addMainCourse(italianCuisine, "Pizza", new BigDecimal(20));

    Cuisine mexicanCuisine = cuisineManager.getCuisine("Mexican");
    mainCourseManager.addMainCourse(mexicanCuisine, "Burrito", new BigDecimal(16));
    mainCourseManager.addMainCourse(mexicanCuisine, "Nachos", new BigDecimal(18));
  }

  public String getMenu() {
    StringBuilder result = new StringBuilder();
    List<Cuisine> listCuisines = cuisineManager.listCuisines();
    for (Cuisine cuisine : listCuisines) {
      result.append(getMainCourses(cuisine));
    }
    result.append(getDesserts());
    result.append(getDrinks());
    return result.toString();
  }

  public String getCuisines() {
    StringBuilder result = new StringBuilder();
    result.append("Cuisine:");
    List<Cuisine> listCuisines = cuisineManager.listCuisines();
    for (Cuisine cuisine : listCuisines) {
      result.append(cuisine.toString());
      result.append("\n");
    }
    result.append("\n");
    return result.toString();
  }

  public String getCuisine(String name) {
    Cuisine cuisine = cuisineManager.getCuisine(name);
    return getMainCourses(cuisine);
  }

  public String getDrinks() {
    StringBuilder result = new StringBuilder();
    result.append("Drinks:");
    result.append("\n");
    for (Drink drink : drinkManager.listDrinks()) {
      result.append(drink.toString());
    }
    result.append("\n");
    return result.toString();
  }

  public String getDesserts() {
    StringBuilder result = new StringBuilder();
    result.append("Desserts:");
    result.append("\n");
    for (Dessert dessert : dessertManager.listDesserts()) {
      result.append(dessert.toString());
      result.append("\n");
    }
    result.append("\n");
    return result.toString();
  }

  public String makeOrder(String lunch, String drinkName, boolean lemon, boolean icecubes, String address, String phone) {
    String[] split = lunch.split("+");
    String mainCourseName = split[0];
    String dessertName = split[1];
    BigDecimal price = new BigDecimal(0);
    MainCourse mainCourse = mainCourseManager.getMainCourse(mainCourseName);
    Dessert dessert = dessertManager.getDessert(dessertName);
    Drink drink = drinkManager.getDrink(drinkName);
    price.add(mainCourse.getPrice()).add(dessert.getPrice()).add(drink.getPrice());
    Integer addClientOrder = clientOrderManager.addClientOrder(mainCourse, dessert, drink, price, lemon, icecubes, address, phone);
    return "Order received!";
  }

  public String getMainCourses(Cuisine cuisine) {
    StringBuilder result = new StringBuilder();
    List<MainCourse> mainCourses = mainCourseManager.getMainCourses(cuisine);
    result.append("Main courses for cuisine:" + cuisine.toString());
    result.append("\n");

    for (MainCourse mainCourse : mainCourses) {
      result.append(mainCourse.toString());
      result.append("\n");
    }
    result.append("\n");
    return result.toString();
  }
}
