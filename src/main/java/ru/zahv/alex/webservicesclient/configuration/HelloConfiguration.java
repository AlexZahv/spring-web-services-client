package ru.zahv.alex.webservicesclient.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import ru.zahv.alex.webservicesclient.client.HelloClient;

@Configuration
public class HelloConfiguration {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("hello.wsdl");
		return marshaller;
	}

	@Bean
	public HelloClient greetingClient(Jaxb2Marshaller marshaller) {
		HelloClient helloClient = new HelloClient();
		helloClient.setDefaultUri("http://localhost:8090/ws/");
		helloClient.setMarshaller(marshaller);
		helloClient.setUnmarshaller(marshaller);
		return helloClient;
	}

}
