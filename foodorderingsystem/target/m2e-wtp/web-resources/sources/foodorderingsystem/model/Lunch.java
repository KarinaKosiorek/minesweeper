package foodorderingsystem.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Lunch")
public class Lunch
{

  @Id
  @Column(name = "LunchID")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int lunchID;

  @ManyToOne
  @JoinColumn(name = "CuisineID")
  private Cuisine cuisine;

  @Column(name = "MainCourse")
  private String maincourse;

  @Column(name = "Dessert")
  private String dessert;

  @Column(name = "Price")
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
