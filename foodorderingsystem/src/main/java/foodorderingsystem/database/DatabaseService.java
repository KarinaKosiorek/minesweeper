package foodorderingsystem.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import foodorderingsystem.database.tablemanager.QueryManager;
import foodorderingsystem.main.FOSClientConfiguration;

public class DatabaseService {

  // JDBC driver name and database URL
  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
  static final String DB_URL = "jdbc:mysql://localhost/";

  // Database credentials
  static final String USER = "username";
  static final String PASS = "password";

  private static SessionFactory factory;

  private QueryManager queryManager;

  public void initDatabase() throws Exception {
    createDatabaseIfNotExists();
    initHibernateManagement();
  }

  private void initHibernateManagement() {
    factory = new Configuration().configure().buildSessionFactory();
    if (factory == null) {
      throw new IllegalStateException("Cannot instantiate hibernate factory.");
    }
    this.queryManager = new QueryManager(factory);
  }

  private void createDatabaseIfNotExists() throws Exception {
    Connection conn = null;
    Statement stmt = null;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      stmt = conn.createStatement();
      String sql = "CREATE DATABASE IF NOT EXISTS FoodOrderingSystemDB";
      stmt.executeUpdate(sql);
    } catch (SQLException se) {
      throw se;
    } catch (Exception e) {
      throw e;
    } finally {
      try {
        if (stmt != null)
          stmt.close();
      } catch (SQLException se2) {
      }
      try {
        if (conn != null)
          conn.close();
      } catch (SQLException se) {
      }
    }
  }

  public String getMenu() {
    return queryManager.getMenu();
  }

  public String getCuisines() {
    return queryManager.getCuisines();
  }

  public String getCuisine(String cuisine) {
    return queryManager.getCuisine(cuisine);
  }

  public String getDrinks() {
    return queryManager.getDrinks();
  }

  public String makeOrder(String lunch, String drink, String lemon, String icecubes, String address, String phone) {
    boolean lemonOption = false;
    boolean iceCubesOption = false;
    if (lemon != null && lemon.equals(FOSClientConfiguration.LEMON_OPTION)) {
      lemonOption = true;
    }
    if (icecubes != null && icecubes.equals(FOSClientConfiguration.ICECUBES_OPTION)) {
      iceCubesOption = true;
    }
    return queryManager.makeOrder(lunch, drink, lemonOption, iceCubesOption, address, phone);
  }
}
