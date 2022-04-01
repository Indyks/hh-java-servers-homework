import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import servlet.ClearServlet;
import servlet.MainServlet;
import javax.servlet.http.HttpServlet;

public class ServletApplication extends HttpServlet {

  private static Server createServer(int port) {
    Server server = new Server(port);
    ServletHandler servletHandler = new ServletHandler();
    servletHandler.addServletWithMapping(MainServlet.class, "/counter");
    servletHandler.addServletWithMapping(ClearServlet.class, "/counter/clear");
    server.setHandler(servletHandler);
    return server;
  }

  public static void main(String[] args) throws Exception {
    int port = 8081;
    Server server = createServer(port);
    server.start();
    server.join();
  }
}
