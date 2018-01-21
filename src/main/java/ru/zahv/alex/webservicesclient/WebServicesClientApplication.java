package ru.zahv.alex.webservicesclient;

import hello.wsdl.GetHelloResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.zahv.alex.webservicesclient.client.HelloClient;

@SpringBootApplication
public class WebServicesClientApplication implements CommandLineRunner {

	@Autowired
	HelloClient helloClient;

	public static void main(String[] args) {
		SpringApplication.run(WebServicesClientApplication.class);
	}

	@Override
	public void run(String... arg0) throws Exception {
		String name = "Alex zahv";
		GetHelloResponse response = helloClient.getHello(name);
		helloClient.logResponse(response);
	}
}
