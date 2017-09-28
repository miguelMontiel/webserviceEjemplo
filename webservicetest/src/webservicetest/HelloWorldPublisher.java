package webservicetest;

import javax.xml.ws.Endpoint;
import webservicetest.HelloWorldImpl;

public class HelloWorldPublisher {
	public static void main(String[] args) {
		// publish: Crea y publica un endpoint para el implementado en especifico la
		// dirección obtenida (localhost).
		Endpoint.publish("http://localhost:9999/ws/hello", new HelloWorldImpl());
	}
}
