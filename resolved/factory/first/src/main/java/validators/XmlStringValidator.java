package validators;

import interfaces.Validator;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class XmlStringValidator implements Validator<String> {

	@Override
	public boolean isValid(String value) {
		if (value == null || value.isEmpty()) {
			return false;
		}
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(false);
		factory.setNamespaceAware(true);

		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
//			e.printStackTrace();
//			throw new RuntimeException("Can't create DocumentBuilder");
			return false;
		}
		builder.setErrorHandler(new SimpleErrorHandler());
		InputStream stream;
		stream = new ByteArrayInputStream(value.getBytes(StandardCharsets.UTF_8));

		try {
			builder.parse(stream);
			return true;
		} catch (SAXException e) {
//			e.printStackTrace();
			return false;
		} catch (IOException e) {
//			e.printStackTrace();
			throw new RuntimeException("Problem with input stream while parsing xml string", e);
		}
	}

	public class SimpleErrorHandler implements ErrorHandler {
		public void warning(SAXParseException e) throws SAXException {
			throw new SAXException("Minor warning", e);

		}

		public void error(SAXParseException e) throws SAXException {
			throw new SAXException("Main Error", e);
		}

		public void fatalError(SAXParseException e) throws SAXException {
			throw new SAXException("Fatal Error", e);
		}
	}
}
