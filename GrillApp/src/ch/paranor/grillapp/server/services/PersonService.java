package ch.paranor.grillapp.server.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		// personPruefen("asdfasd", "aasdf");
	}

	@Override
	public Collection<Person> getPersons() {

		return persons.values();
	}

	@Override
	public Person personPruefen(String name, String passwort) {
		Person person = new Person();

		Connection connection = (Connection) getServletContext().getAttribute("connection");

		try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM PERSON where lower(name) like lower(?) AND passwort like ?")) {

			statement.setString(1, name);
			statement.setString(2, passwort);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				person.setName(resultSet.getString("NAME"));
				person.setPasswort(resultSet.getString("PASSWORT"));
				person.setAdresse(resultSet.getString("EMAILADRESSE"));
				person.setAnwesend(resultSet.getBoolean("ANWESEND"));
				person.setAdmin(resultSet.getBoolean("ADMIN"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Person person = persons.get(name);
		// if (person.getPasswort().equals(passwort)) {
		// return person;
		// } else {
		return person;
		// }

	}
}
// Connection connection = (Connection)
// getServletContext().getAttribute("connection");
//
// try (Statement statement = connection.createStatement()) {
//
// statement.execute("SELECT * FROM Person ");
//
// ResultSet resultSet = statement.getResultSet();
// while (resultSet.next()) {
//
// System.out.println(resultSet.getString("NAME"));
// person.setName(resultSet.getString("NAME"));
// person.setAdresse(resultSet.getString("EMAILADRESSE"));
//
// }
//
// } catch (SQLException e) {
// // TODO Auto-generated catch block
// e.printStackTrace();
// }