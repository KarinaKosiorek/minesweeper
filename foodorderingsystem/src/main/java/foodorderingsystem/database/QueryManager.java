package foodorderingsystem.database;

import org.hibernate.SessionFactory;

public class QueryManager {

  private SessionFactory factory;

  public QueryManager(SessionFactory factory) {
    this.factory = factory;
  }

}
