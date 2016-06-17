package foodorderingsystem.main;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import foodorderingsystem.database.DatabaseService;

public class FoodOrderingSystemSerlvet extends HttpServlet {

  public final static Logger LOGGER = LoggerFactory.getLogger(FoodOrderingSystemSerlvet.class);
  private static final long serialVersionUID = -4802159941011807667L;
  DatabaseService databaseservcie = new DatabaseService();

  @Override
  public void init(ServletConfig servletConfig) throws ServletException {
    LOGGER.info("Welcome in FoodOrderingSystem service.");
    LOGGER.info("Database initialization:: FoodOrderingSystemDB.");
    try {
      databaseservcie.initDatabase();
    } catch (Exception e) {
      LOGGER.error("Error with initialization of database:: FoodOrderingSystemDB");
      LOGGER.error("Exception message:");
      LOGGER.error(e.getMessage());
    }
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    LOGGER.info("Post method execution");
  }

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
  }

  @Override
  public void destroy() {
  }
}