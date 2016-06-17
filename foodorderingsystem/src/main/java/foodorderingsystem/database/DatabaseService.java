package foodorderingsystem.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
    // try {
    factory = new Configuration().configure().buildSessionFactory();
    if (factory == null) {
      throw new IllegalStateException("");
    }
    this.queryManager = new QueryManager(factory);
    // } catch (Throwable ex) {
    // / System.err.println("Failed to create sessionFactory object." + ex);
    // throw new ExceptionInInitializerError(ex);
    // }
  }

  private void createDatabaseIfNotExists() throws Exception {
    Connection conn = null;
    Statement stmt = null;
    try {
      // Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      // Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      // Execute a query
      System.out.println("Creating database...");
      stmt = conn.createStatement();

      String sql = "CREATE DATABASE IF NOT EXISTS FoodOrderingSystemDB";
      stmt.executeUpdate(sql);
      System.out.println("Database created successfully...");
    } catch (SQLException se) {
      // Handle errors for JDBC
      se.printStackTrace();
    } catch (Exception e) {
      // Handle errors for Class.forName
      // e.printStackTrace();
      throw e;
    } finally {
      // finally block used to close resources
      try {
        if (stmt != null)
          stmt.close();
      } catch (SQLException se2) {
      }
      try {
        if (conn != null)
          conn.close();
      } catch (SQLException se) {
        // se.printStackTrace();
      }
    }
  }
}
