package ch.paranor.grillapp.server.services;

import java.util.Collection;
import java.util.Map;

import ch.paranor.grillapp.client.services.IPersonService;
import ch.paranor.grillapp.shared.model.Person;

import com.google.gwt.thirdparty.guava.common.collect.Maps;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the Person RPC service. Note: the service
 * must be registered in web.xml
 */
@SuppressWarnings("serial")
public class PersonService extends RemoteServiceServlet implements IPersonService {

	Map<String, Person> persons = Maps.newHashMap();

	public PersonService() {
		persons.put("Neshi", new Person("Neshi", "1234", "Musterweg", true, true));
		persons.put("Peter", new Person("Peter", "12345", "Peterweg 14, 3021 Bern", true, false));
	}

	@Override
	public Collection<Person> getPersons() {

		return persons.values();
	}

	@Override
	public Person personPruefen(String name, String passwort) {

		Person person = persons.get(name);
		if (person.getPasswort().equals(passwort)) {
			return person;
		} else {
			return null;
		}

	}

}
