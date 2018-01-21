package ru.zahv.alex.webservicesclient.client;

import hello.wsdl.GetHelloRequest;
import hello.wsdl.GetHelloResponse;
import hello.wsdl.Hello;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class HelloClient extends WebServiceGatewaySupport {
	
	private static final Logger log = LoggerFactory.getLogger(HelloClient.class);
	
	public GetHelloResponse getHello(String name) {

		GetHelloRequest request = new GetHelloRequest();
		request.setName(name);

		log.info("Requesting hello for " + name);

		return (GetHelloResponse) getWebServiceTemplate()
				.marshalSendAndReceive(
						"http://localhost:8090/ws/hello",
						request,
						new SoapActionCallback("http://localhost:8080/ws/hello"));
	}

	public void logResponse(GetHelloResponse response) {

		Hello greeting = response.getHello();

		if (!(greeting == null)) {
			log.info(String.format("Hello [ date = %s, content = %s]",greeting.getDate(),greeting.getContent()));
		} else {
			log.info("No greeting received");
		}
	}

}
