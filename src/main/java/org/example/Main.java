
package org.example;

import org.eclipse.jetty.ee11.servlet.ServletContextHandler;
import org.eclipse.jetty.ee11.servlet.ServletHolder;
import org.eclipse.jetty.server.Server;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

public class Main {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        ServletContextHandler context = new ServletContextHandler();

        ResourceConfig config = new ResourceConfig();
        config.register(BookResource.class);
        config.register(LoggingInterceptor.class);

        ServletContainer servlet = new ServletContainer(config);
        ServletHolder servletHolder = new ServletHolder(servlet);

        context.addServlet(servletHolder, "/*");

        server.setHandler(context);

        try {
            server.start();
            server.join();
        }
        finally {
            server.destroy();
        }
    }
}