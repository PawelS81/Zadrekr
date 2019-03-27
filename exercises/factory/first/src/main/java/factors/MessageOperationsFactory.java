package factors;

import com.sun.xml.internal.ws.server.UnsupportedMediaException;
import operations.MessagesOperations;
import interfaces.FactoryOperation;
import converters.JsonConverterForPerson;
import validators.JsonStringValidator;
import converters.XmlConverterForPerson;
import validators.XmlStringValidator;

public class MessageOperationsFactory {

	private static final String APPLICATION_JSON = "application/json";
	private static final String APPLICATION_XML = "application/xml";

	public static FactoryOperation getFactory(String type) {
		throw new UnsupportedOperationException("Implement factory method");
	}
}
