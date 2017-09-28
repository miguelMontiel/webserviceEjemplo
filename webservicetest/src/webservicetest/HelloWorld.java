package webservicetest;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

// Voy a indicar que es una clase de Java normal pero que lo tome como un servicio Web.
@WebService

// Determina si los parametros del metodo representan el mensaje entro o si los
// parametros son elementos envueltos dentro de un elemento de alto nivel
// después de la operación.
@SOAPBinding(style = Style.RPC)

// interface: Tipo de referencia, similar a una clase que contiene solamente
// constantes, metodos de firmas, metodos por default, estaticos etc..
public interface HelloWorld {
	// Metodo de Java, pasalo a Metodo en SOAP
	@WebMethod
	String getHelloWorldAsString(String name);
}
