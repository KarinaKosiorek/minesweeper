package foodorderingsystem.database.tablemanager;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import foodorderingsystem.model.Dessert;

public class DessertManager
{

  private SessionFactory factory;

  public void setFactory(SessionFactory factory)
  {
    this.factory = factory;
  }

  public void initDesserts()
  {
    if (!exists(getDessert("Ice cream")))
    {
      addDessert("Ice cream", new BigDecimal(8));
    }
    if (!exists(getDessert("Ice cream")))
    {
      addDessert("Apple cake", new BigDecimal(8));
    }
    if (!exists(getDessert("Ice cream")))
    {
      addDessert("Fruit salad", new BigDecimal(8));
    }
  }

  private boolean exists(Dessert dessert)
  {
    return dessert != null;
  }

  public Integer addDessert(String name, BigDecimal price)
  {
    Session session = factory.openSession();
    Transaction tx = null;
    Integer dessertId = null;
    try
    {
      tx = session.beginTransaction();
      Dessert dessert = new Dessert(name, price);
      dessertId = (Integer) session.save(dessert);
      tx.commit();
    } catch (HibernateException e)
    {
      if (tx != null)
        tx.rollback();
      e.printStackTrace();
    } finally
    {
      session.close();
    }
    return dessertId;
  }

  @SuppressWarnings({ "unchecked", "deprecation" })
  public List<Dessert> listDesserts()
  {
    List<Dessert> desserts = new ArrayList<Dessert>();
    Session session = factory.openSession();
    Transaction tx = null;
    try
    {
      tx = session.beginTransaction();
      desserts = session.createQuery("FROM Dessert").list();
      // for (Iterator<Cuisine> iterator = cuisines.iterator(); iterator.hasNext();) {
      // Cuisine cuisine = iterator.next();
      // }
      tx.commit();
    } catch (HibernateException e)
    {
      if (tx != null)
        tx.rollback();
      e.printStackTrace();
    } finally
    {
      session.close();
    }
    return desserts;
  }

  public void updateDessert(Integer dessertId, String name, BigDecimal price)
  {
    Session session = factory.openSession();
    Transaction tx = null;
    try
    {
      tx = session.beginTransaction();
      Dessert dessert = session.get(Dessert.class, dessertId);
      dessert.setName(name);
      dessert.setPrice(price);
      session.update(dessert);
      tx.commit();
    } catch (HibernateException e)
    {
      if (tx != null)
        tx.rollback();
      e.printStackTrace();
    } finally
    {
      session.close();
    }
  }

  public void deleteDessert(Integer dessertId)
  {
    Session session = factory.openSession();
    Transaction tx = null;
    try
    {
      tx = session.beginTransaction();
      Dessert dessert = session.get(Dessert.class, dessertId);
      session.delete(dessert);
      tx.commit();
    } catch (HibernateException e)
    {
      if (tx != null)
        tx.rollback();
      e.printStackTrace();
    } finally
    {
      session.close();
    }
  }

  @SuppressWarnings("deprecation")
  public Dessert getDessert(String name)
  {
    List<Dessert> drinks = new ArrayList<Dessert>();
    Session session = factory.openSession();
    Transaction tx = null;
    try
    {
      tx = session.beginTransaction();
      Query<Dessert> query = session.createQuery("FROM Dessert WHERE Name = :name");
      query.setParameter("name", name);
      drinks = query.list();
      tx.commit();
    } catch (HibernateException e)
    {
      if (tx != null)
      {
        tx.rollback();
      }
      e.printStackTrace();
    } finally
    {
      session.close();
    }
    if (drinks.size() > 0)
    {
      return drinks.get(0);
    } else
    {
      return null;
    }
  }
}
