package pl.programmers.config;

import java.awt.Desktop;
import java.net.InetAddress;
import java.net.URI;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.web.WebAppConfiguration;

@ComponentScan(basePackages = Application.ROOT_PACKAGE)
@EnableJpaRepositories(basePackages = Application.ROOT_PACKAGE)
@EntityScan(basePackages = Application.ROOT_PACKAGE)
@EnableAutoConfiguration
@WebAppConfiguration
public class Application {

	static final String ROOT_PACKAGE = "pl.programmers";

	@Value("${server.port:8080}")
	private int port;

	Logger logger = Logger.getLogger(Application.class);

	@PostConstruct
	private void tryOpenBrowser() throws Exception {
		InetAddress localHost = InetAddress.getLocalHost();
		String address = localHost.getHostAddress() + ":" + port;
		try {
			Desktop.getDesktop().browse(URI.create(address));
		} catch (Exception e) {
			logger.info("I can't open your browser " + address);
		}

	}

}
