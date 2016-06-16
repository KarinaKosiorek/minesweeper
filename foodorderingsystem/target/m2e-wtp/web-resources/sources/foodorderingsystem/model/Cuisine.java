package foodorderingsystem.model;

import java.util.ArrayList;
import java.util.List;

public class Cuisine
{

  private int cuisineID;
  private String cuisineName;
  List<Lunch> lunchMenu = new ArrayList<Lunch>();

  public Cuisine()
  {
  }

  public Cuisine(int cuisineID, String cuisineName)
  {
    this.cuisineID = cuisineID;
    this.cuisineName = cuisineName;
  }

  public int getCuisineID()
  {
    return cuisineID;
  }

  public void setCuisineID(int cuisineID)
  {
    this.cuisineID = cuisineID;
  }

  public String getCuisineName()
  {
    return cuisineName;
  }

  public void setCuisineName(String cuisineName)
  {
    this.cuisineName = cuisineName;
  }

  public List<Lunch> getLunchMenu()
  {
    return lunchMenu;
  }

  public void setLunchMenu(List<Lunch> lunchMenu)
  {
    this.lunchMenu = lunchMenu;
  }
}
