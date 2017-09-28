package webclienttest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.ws.Service;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import webservicetest.HelloWorld;

public class HelloWorldClient 
{
	private static Scanner scanner;

	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://localhost:9999/ws/hello?wsdl");

		// QualifiedName: contiene un Namespace URI, local part y prefijo, utilizados
		// para representar elementos en particular o atributos en documentos XML.
		QName qname = new QName("http://webservicetest/", "HelloWorldImplService");

		// Provee la vista del cliente cómo un Servicio Web: Instancias de envío para
		// una dinamica mensaje-orientada invocación de una operación remota.
		Service service = Service.create(url, qname);

		// Paso el puerto que se esta utilizando en la clase HelloWorld
		HelloWorld hello = service.getPort(HelloWorld.class);

		////////////////////////////////////////////////////////////////////////////////////////////////

		// Define una fabrica de APIs que permite a las aplicaciones obtener un parseo
		// que produce objetos de DOM (Document Object Model) para documentos XML.
		// DOM: Permite el acceso dinámico a traves de la programación para acceder,
		// añadir y cambiar dinamicamente el contenido estructurado de un documento.
		DocumentBuilderFactory documentbuilderfactory = DocumentBuilderFactory.newInstance();

		// Especifica que el parseo producido por este código proporcionara 'namespaces'
		// para XML
		documentbuilderfactory.setNamespaceAware(true);

		// Define la API para obtener el documento DOM de las instancias de un XML
		DocumentBuilder documentbuilder;
		Document document;

		try 
                {
			documentbuilder = documentbuilderfactory.newDocumentBuilder();
			document = documentbuilder.parse("src/Test.xml");

			// Se usa para crear los objetos 'XPath'.
			XPathFactory xpathfactory = XPathFactory.newInstance();

			// La libreria que nos permite buscar información dentro de un XML, navegar
			// entre etiquetas y atributos.
			XPath xpath = xpathfactory.newXPath();

			// Contiene diversos metodos para la libreria XPath
			XPathExpression xpathexpression = xpath.compile("//*[not(*)]");

			// Provee la abstracción de una ordenada colección de nodos, sin definir ni
			// obstruir como se implementan los objetos en el DOM, se accesan de manera de
			// iteración.
			NodeList nodelist = (NodeList) xpathexpression.evaluate(document, XPathConstants.NODESET);

			for (int i = 0; i < nodelist.getLength(); i++) 
                        {
				// Cómo se mencionaba, se accesan los valores de los nodos de manera de
				// iteración.
				System.out.println(nodelist.item(i));
			}
		} 
                catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException e) {
			e.printStackTrace();
		}

		///////////////////////////////////////////////////////////////////////////////////////////////

		scanner = new Scanner(System.in);

		System.out.println("Ingresa el dato de webservice: ");
		String dato = scanner.nextLine();

		System.out.println(hello.getHelloWorldAsString(dato));
	}
}
