package scaffold;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

import java.io.File;
import java.net.URL;
import java.security.ProtectionDomain;

public class Runner {

    public static void main(String[] args) throws Exception {
        int port = 8080;
        Server server = new Server(port);
        ProtectionDomain domain = Runner.class.getProtectionDomain();
        URL location = domain.getCodeSource().getLocation();
        WebAppContext webapp = new WebAppContext();
        webapp.setContextPath("/");
        webapp.setDescriptor(location.toExternalForm() + "/WEB-INF/web.xml");
        webapp.setServer(server);
        webapp.setWar(location.toExternalForm());
        webapp.setTempDirectory(new File("webapp"));
        server.setHandler(webapp);
        server.start();
        server.join();
    }
}
