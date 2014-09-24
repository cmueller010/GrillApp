package ch.paranor.grillapp.server.services;

import java.util.List;

import ch.paranor.grillapp.client.services.IPersonService;
import ch.paranor.grillapp.shared.model.Person;

import com.google.gwt.thirdparty.guava.common.collect.Lists;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the Person RPC service. Note: the service
 * must be registered in web.xml
 */
@SuppressWarnings("serial")
public class PersonService extends RemoteServiceServlet implements
		IPersonService {

	@Override
	public List<Person> getPersons() {
		List<Person> persons = Lists.newArrayList();

		Person neshi = new Person("Neshi", "Musterweg", true, true);
		persons.add(neshi);

		Person oliver = new Person("Oliver", "Hardeggerstrasse 12, 3008 Bern",
				true, false);
		persons.add(oliver);

		Person Peter = new Person("Peter", "Peterweg 14, 3021 Bern", true,
				false);
		persons.add(Peter);

		return persons;
	}

}
