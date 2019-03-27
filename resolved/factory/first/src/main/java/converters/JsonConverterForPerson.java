package converters;

import com.fasterxml.jackson.databind.ObjectMapper;
import dto.Person;
import interfaces.Converter;

import java.io.IOException;

public class JsonConverterForPerson implements Converter<String, Person> {

	@Override
	public Person convert(String value) {
		ObjectMapper om = new ObjectMapper();
		try {
			Person person = om.readValue(value, Person.class);
			return person;
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Problem while parsing data to person class");
		}
	}
}
