package foodorderingsystem.model;

import java.math.BigDecimal;

public class ClientOrder
{

  private int orderID;
  private Lunch lunch;
  private Drink drink;
  private BigDecimal price;
  private boolean lemon = false;
  private boolean iceCubes = false;

  public ClientOrder()
  {
  }

  public ClientOrder(int orderID, Lunch lunch, Drink drink, BigDecimal price, boolean lemon, boolean iceCubes)
  {
    this.orderID = orderID;
    this.lunch = lunch;
    this.drink = drink;
    this.price = price;
    this.lemon = lemon;
    this.iceCubes = iceCubes;
  }

  public int getOrderID()
  {
    return orderID;
  }

  public void setOrderID(int orderID)
  {
    this.orderID = orderID;
  }

  public BigDecimal getPrice()
  {
    return price;
  }

  public void setPrice(BigDecimal price)
  {
    this.price = price;
  }

  public boolean isLemon()
  {
    return lemon;
  }

  public void setLemon(boolean lemon)
  {
    this.lemon = lemon;
  }

  public boolean isIceCubes()
  {
    return iceCubes;
  }

  public void setIceCubes(boolean iceCubes)
  {
    this.iceCubes = iceCubes;
  }

  public Lunch getLunch()
  {
    return lunch;
  }

  public void setLunch(Lunch lunch)
  {
    this.lunch = lunch;
  }

  public Drink getDrink()
  {
    return drink;
  }

  public void setDrink(Drink drink)
  {
    this.drink = drink;
  }
}
