package webservicetest;

import javax.jws.WebService;

// Aquí se define los metodos que van a ser expuestos como un Web Service.
@WebService(endpointInterface = "webservicetest.HelloWorld")

public class HelloWorldImpl implements HelloWorld {
	// Encapsulamiento de metodos comunes:
	@Override
	public String getHelloWorldAsString(String name) {
		return "Hello World JAX-WS " + name;
	}
}
