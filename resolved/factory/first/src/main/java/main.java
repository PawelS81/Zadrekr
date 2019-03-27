import dto.Person;
import factors.MessageOperationsFactory;
import interfaces.FactoryOperation;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class main {

	public static void main(String[] args) {
		Map<String, String> requestMap = fillMap();

		requestMap.entrySet()
			.stream()
			.filter(main::test)
			.map(main::convert)
			.collect(Collectors.toList())
			.forEach(System.out::println);

	}

	private static Person convert(Map.Entry<String, String> p) {
		FactoryOperation factory = MessageOperationsFactory.getFactory(p.getKey());
		return (Person) factory.getConverter().convert(p.getValue());
	}

	private static boolean test(Map.Entry<String, String> p) {
		FactoryOperation factory = MessageOperationsFactory.getFactory(p.getKey());
		boolean isValid = factory.getValidator().isValid(p.getValue());
		System.out.println("Is data valid = [" + isValid + "]");
		return isValid;
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
