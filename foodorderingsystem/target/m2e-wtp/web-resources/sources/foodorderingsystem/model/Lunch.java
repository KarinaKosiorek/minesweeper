package foodorderingsystem.model;

import java.math.BigDecimal;

public class Lunch
{

  private int lunchID;
  private String maincourse;
  private String dessert;
  private BigDecimal price;

  public Lunch()
  {
  }

  public Lunch(int lunchID, int cuisineID, String maincourse, String dessert, BigDecimal price)
  {
    this.lunchID = lunchID;
    this.maincourse = maincourse;
    this.dessert = dessert;
    this.price = price;
  }

  public int getLunchID()
  {
    return lunchID;
  }

  public void setLunchID(int lunchID)
  {
    this.lunchID = lunchID;
  }

  public String getMaincourse()
  {
    return maincourse;
  }

  public void setMaincourse(String maincourse)
  {
    this.maincourse = maincourse;
  }

  public String getDessert()
  {
    return dessert;
  }

  public void setDessert(String dessert)
  {
    this.dessert = dessert;
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