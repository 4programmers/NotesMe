package pl.programmers;

import java.awt.Desktop;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.URI;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.web.WebAppConfiguration;

@ComponentScan
@EnableAutoConfiguration
@WebAppConfiguration
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	@Value("${server.port:8080}")
	private int port;

	private void tryOpenBrowser() {
		try {
			InetAddress localHost = InetAddress.getLocalHost();
			String string = localHost.getHostAddress() + ":" + port;
			Desktop.getDesktop().browse(URI.create(string));
		} catch (Exception e) {
			// ignere
		}

	}

	@Inject
	CarRepository repo;

	@PostConstruct
	public void init() throws Exception {
		Car ford = new Car();
		ford.setName("Ford Focus");
		ford.setPrice(new BigDecimal("54000"));
		ford.setProductionYear(2014);
		repo.save(ford);

		Car honda = new Car();
		honda.setName("Honda Accord");
		honda.setPrice(new BigDecimal("72000"));
		honda.setProductionYear(2014);
		repo.save(honda);

		tryOpenBrowser();
	}

}
