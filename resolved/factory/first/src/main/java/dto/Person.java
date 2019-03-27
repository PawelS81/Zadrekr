package dto;

public class Person {

	private String name;
	private String surname;
	private String city;
	private Integer age;

	public Person() {
	}

	public Person(String name, String surname, String city, Integer age) {
		this.name = name;
		this.surname = surname;
		this.city = city;
		this.age = age;
	}

	public String getSurname() {
		return surname;
	}

	public String getName() {
		return name;
	}

	public String getCity() {
		return city;
	}

	public Integer getAge() {
		return age;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person{" +
			"name='" + name + '\'' +
			", surname='" + surname + '\'' +
			", city='" + city + '\'' +
			", age=" + age +
			'}';
	}
}
