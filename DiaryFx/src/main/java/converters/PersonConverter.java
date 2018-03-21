package converters;

import model.Person;
import model.PersonFx;

public class PersonConverter {

	/**
	 * Developed by anisz
	 */

	public static Person converToPerson(PersonFx personFx) {
		Person person = new Person();
		person.setId(personFx.getId());
		person.setName(personFx.getName());
		person.setSurname(personFx.getSurname());
		return person;
	}

	public static PersonFx convertToPersonFx(Person person) {
		PersonFx personFx = new PersonFx();
		personFx.setId(person.getId());
		personFx.setName(person.getName());
		personFx.setSurname(person.getSurname());
		return personFx;
	}
}
