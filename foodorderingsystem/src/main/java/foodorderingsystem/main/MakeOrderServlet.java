package foodorderingsystem.main;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MakeOrderServlet extends HttpServlet
{

  public final static Logger LOGGER = LoggerFactory.getLogger(MakeOrderServlet.class);
  private static final long serialVersionUID = -4802159941011807667L;

  @Override
  public void init(ServletConfig servletConfig) throws ServletException
  {
    LOGGER.info("Database service initialized.");
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    LOGGER.info("Post method execution");
  }

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    doPost(request, response);
  }

  @Override
  public void destroy()
  {
  }
}