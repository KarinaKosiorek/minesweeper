package foodorderingsystem.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Drink")
public class Drink {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "DrinkID")
  private int drinkID;

  @Column(name = "Name")
  private String name;

  @Column(name = "Price")
  private BigDecimal price;

  public Drink() {
  }

  public Drink(int drinkID, String name, BigDecimal price) {
    this.drinkID = drinkID;
    this.name = name;
    this.price = price;
  }

  public int getDrinkID() {
    return drinkID;
  }

  public void setDrinkID(int drinkID) {
    this.drinkID = drinkID;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
