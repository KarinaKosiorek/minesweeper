package foodorderingsystem.model;

import java.math.BigDecimal;

public class Drink
{

  private int drinkID;
  private String drinkName;
  private BigDecimal price;

  public Drink()
  {
  }

  public Drink(int drinkID, String drinkName, BigDecimal price)
  {
    this.drinkID = drinkID;
    this.drinkName = drinkName;
    this.price = price;
  }

  public int getDrinkID()
  {
    return drinkID;
  }

  public void setDrinkID(int drinkID)
  {
    this.drinkID = drinkID;
  }

  public String getDrinkName()
  {
    return drinkName;
  }

  public void setDrinkName(String drinkName)
  {
    this.drinkName = drinkName;
  }

  public BigDecimal getPrice()
  {
    return price;
  }

  public void setPrice(BigDecimal price)
  {
    this.price = price;
  }

}
