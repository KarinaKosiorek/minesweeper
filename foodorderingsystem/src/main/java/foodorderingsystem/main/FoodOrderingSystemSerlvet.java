package foodorderingsystem.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import foodorderingsystem.database.DatabaseService;

public class FoodOrderingSystemSerlvet extends HttpServlet
{

  public final static Logger LOGGER = LoggerFactory.getLogger(FoodOrderingSystemSerlvet.class);
  private static final long serialVersionUID = -4802159941011807667L;
  private DatabaseService databaseservcie = new DatabaseService();
  private StringBuilder userHelp = new StringBuilder();

  @Override
  public void init(ServletConfig servletConfig) throws ServletException
  {
    initDatabase();
    initHelpForClient();
  }

  private void initHelpForClient()
  {
    try
    {
      InputStream in = FoodOrderingSystemSerlvet.class.getClassLoader()
          .getResourceAsStream(FOSClientConfiguration.SYNTAX_HELP_FILE);
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
      String line = bufferedReader.readLine();
      while (line != null)
      {
        userHelp.append(line);
        userHelp.append('\n');
        line = bufferedReader.readLine();
      }
      bufferedReader.close();
    } catch (Exception e)
    {
      LOGGER.error("Error reading from client help file: " + FOSClientConfiguration.SYNTAX_HELP_FILE);
    }
  }

  private void initDatabase()
  {
    LOGGER.info("Welcome in FoodOrderingSystem service.");
    LOGGER.info("Database initialization:: FoodOrderingSystemDB.");
    try
    {
      databaseservcie.initDatabase();
    } catch (Exception e)
    {
      LOGGER.error("Error with initialization of database:: FoodOrderingSystemDB");
      LOGGER.error("Exception message:");
      e.printStackTrace();
    }
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    doGet(request, response);
  }

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {

    response.setContentType("text/plain");
    PrintWriter out = response.getWriter();

    String menu = request.getParameter(FOSClientConfiguration.MENU_OPTION);
    String help = request.getParameter(FOSClientConfiguration.HELP_OPTION);
    String cuisines = request.getParameter(FOSClientConfiguration.CUISINES_OPTION);
    String cuisine = request.getParameter(FOSClientConfiguration.CUISINE_OPTION);
    String drinks = request.getParameter(FOSClientConfiguration.DRINKS_OPTION);
    String desserts = request.getParameter(FOSClientConfiguration.DESSERTS_OPTION);
    String order = request.getParameter(FOSClientConfiguration.ORDER_OPTION);
    String lunch = request.getParameter(FOSClientConfiguration.LUNCH_OPTION);
    String drink = request.getParameter(FOSClientConfiguration.DRINK_OPTION);
    String lemon = request.getParameter(FOSClientConfiguration.LEMON_OPTION);
    String icecubes = request.getParameter(FOSClientConfiguration.ICECUBES_OPTION);
    String address = request.getParameter(FOSClientConfiguration.ADDRESS_OPTION);
    String phone = request.getParameter(FOSClientConfiguration.PHONE_OPTION);

    if (request.getParameterMap().size() == 0)
    {
      out.println(userHelp.toString());
      return;
    }
    if (help != null && help.equals(FOSClientConfiguration.HELP_OPTION))
    {
      out.println(userHelp.toString());
    }
    if (menu != null && menu.equals(FOSClientConfiguration.MENU_OPTION))
    {
      out.println(databaseservcie.getMenu());
    }
    if (cuisines != null && menu.equals(FOSClientConfiguration.CUISINES_OPTION))
    {
      out.println(databaseservcie.getCuisines());
    }
    if (cuisine != null)
    {
      out.println(databaseservcie.getCuisine(cuisine));
    }
    if (drinks != null && drinks.equals(FOSClientConfiguration.DRINKS_OPTION))
    {
      out.println(databaseservcie.getDrinks());
    }
    if (desserts != null && desserts.equals(FOSClientConfiguration.DESSERTS_OPTION))
    {
      out.println(databaseservcie.getDrinks());
    }
    if (order != null && order.equals(FOSClientConfiguration.ORDER_OPTION))
    {
      out.println(databaseservcie.makeOrder(lunch, drink, lemon, icecubes, address, phone));
    }
  }

  @Override
  public void destroy()
  {
  }
}