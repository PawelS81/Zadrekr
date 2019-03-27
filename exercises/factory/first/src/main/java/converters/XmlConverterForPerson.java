package converters;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import dto.Person;
import interfaces.Converter;

import java.io.IOException;

public class XmlConverterForPerson implements Converter<String, Person> {

	@Override
	public Person convert(String value) {
		XmlMapper xmlMapper = new XmlMapper();
		try {
			Person person = xmlMapper.readValue(value, Person.class);
			return person;
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Problem while parsing xml string to Person object");
		}
	}
}
