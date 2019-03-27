import dto.Person;
import factors.MessageOperationsFactory;
import interfaces.FactoryOperation;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class main {

	public static void main(String[] args) {
		Map<String, String> requestMap = fillMap();
		/*TODO: Implement "request" processing
				Map element Key is body type
				Map element Value is a body
				Please implement main method which should validate incoming body
				and convert it to instance of Person class*/


	}


	private static Map<String, String> fillMap() {
		Map<String, String> map = new HashMap<>();
		map.put("application/json", "{" +
			"  \"name\": \"Zygmunt\", " +
			"  \"surname\": \"Saro\", " +
			"  \"city\": \"Warszawa\", " +
			"  \"age\": \"32\"" +
			"}");


		map.put("application/xml", "<?xml version=\"1.0\" encoding=\"UTF-8\"?> " +
			"<root> " +
			"   <age>33</age> " +
			"   <city>Warszawa</city> " +
			"   <name>Zenek</name> " +
			"   <surname>Makowicz</surname> " +
			"</root>");

		return map;

	}
}
