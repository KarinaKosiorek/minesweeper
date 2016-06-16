package foodorderingsystem.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Properties;

public class HttpRequestService
{

  public void printOrderSyntax(String host, String port)
  {
    try
    {
      String url = "http://" + host + ":" + port + "/foodOrderingSystem/orderSyntax";

      System.out.println("\nSending 'GET' request to URL : " + url);

      URL obj = new URL(url);
      HttpURLConnection con = (HttpURLConnection) obj.openConnection();

      // optional default is GET
      con.setRequestMethod("GET");

      // add request header
      con.setRequestProperty("User-Agent", "User Agent");

      int responseCode = con.getResponseCode();
      System.out.println("Response Code : " + responseCode);

      BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
      String inputLine;
      StringBuffer response = new StringBuffer();

      while ((inputLine = in.readLine()) != null)
      {
        response.append(inputLine);
      }
      in.close();

      System.out.println(response.toString());
    } catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  public void sendRequest(String host, String port, Properties properties)
  {
    String url = "";
    try
    {
      StringBuilder parametersBuilder = new StringBuilder();
      for (String key : properties.stringPropertyNames())
      {
        if (!key.equals(ClientMain.HOST) && !key.equals(ClientMain.PORT))
        {
          if (key.startsWith("-"))
          {
            parametersBuilder.append(key.substring(1));
          } else
          {
            parametersBuilder.append(key);
          }

          parametersBuilder.append("=");
          String property = properties.getProperty(key);
          parametersBuilder.append(URLEncoder.encode(property, "UTF-8"));
          parametersBuilder.append("&");
        }
      }
      if (parametersBuilder.charAt(parametersBuilder.length() - 1) == '&')
      {
        parametersBuilder.deleteCharAt(parametersBuilder.length() - 1);
      }

      url = "http://" + host + ":" + port + "/foodOrderingSystem/order?" + parametersBuilder.toString();

      System.out.println("\nSending 'GET' request to URL : " + url);

      URL obj = new URL(url);
      HttpURLConnection con = (HttpURLConnection) obj.openConnection();

      // optional default is GET
      con.setRequestMethod("GET");

      // add request header
      con.setRequestProperty("User-Agent", "User Agent");

      int responseCode = con.getResponseCode();
      System.out.println("Response Code : " + responseCode);

      BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
      String inputLine;
      StringBuffer response = new StringBuffer();

      while ((inputLine = in.readLine()) != null)
      {
        response.append(inputLine);
      }
      in.close();

      System.out.println("Response: " + response.toString());
    } catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  public void printOrderSyntaxHardcoded()
  {
    // TODO Auto-generated method stub
  }
}
