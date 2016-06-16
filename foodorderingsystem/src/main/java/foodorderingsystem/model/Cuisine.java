package foodorderingsystem.model;

public class Cuisine
{

  private int cuisineID;
  private String cuisineName;

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
}
