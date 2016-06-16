package foodorderingsystem.client;

import java.util.Properties;

/**
 *
 * @author karkos
 *
 *         foodorderingsystem -host localhost -port port -cuisine Polish -meal Dumplings -drink Juice
 * 
 *         foodorderingsystem : sending syntax
 * 
 *         foodorderingsystem -menu
 *
 *
 */

public class ClientMain
{
  public static final String HOST = "-host";
  public static final String PORT = "-port";

  public static void main(String[] args)
  {

    HttpRequestService httpRequestService = new HttpRequestService();
    Properties commandLineProperties = new Properties();

    ClientConfiguration clientConfiguration = new ClientConfiguration();
    clientConfiguration.loadConfiguration();
    String host = clientConfiguration.getHost();
    String port = clientConfiguration.getPort();

    try
    {
      if (args.length == 0)
      {
        httpRequestService.printOrderSyntax(host, port);
        System.exit(0);
      }

      for (int i = 0; i < args.length; i++)
      {
        commandLineProperties.put(args[i], args[i + 1]);
        i++;
      }

      if (commandLineProperties.getProperty(HOST) != null)
      {
        host = commandLineProperties.getProperty(HOST);
      }
      if (commandLineProperties.getProperty(PORT) != null)
      {
        port = commandLineProperties.getProperty(PORT);
      }
      httpRequestService.sendRequest(host, port, commandLineProperties);
    } catch (Exception e)
    {
      httpRequestService.printOrderSyntaxHardcoded();
    }

    for (String key : commandLineProperties.stringPropertyNames())
    {
      System.out.println(key + " " + commandLineProperties.getProperty(key));
    }
  }
}
