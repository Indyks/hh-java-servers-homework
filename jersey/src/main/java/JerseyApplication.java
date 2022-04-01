import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import application.MainApplication;

public class JerseyApplication{

  private static Server createServer(int port) {
    Server server = new Server(port);

    ServletContextHandler ctx = new ServletContextHandler();
    server.setHandler(ctx);

    ServletContainer servletContainer = new ServletContainer(ResourceConfig.forApplicationClass(MainApplication.class));
    ServletHolder servletHolder = new ServletHolder(servletContainer);
    servletHolder.setInitOrder(1);
    ctx.addServlet(servletHolder, "/*");
    return server;
  }

  public static void main(String[] args) throws Exception {
    int port = 8081;
    Server server = createServer(port);
    server.start();
    server.join();
  }
}
