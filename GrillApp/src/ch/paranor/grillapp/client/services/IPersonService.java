package ch.paranor.grillapp.client.services;

import java.util.Collection;

import ch.paranor.grillapp.shared.model.Person;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the Person RPC service.
 */
@RemoteServiceRelativePath("person")
public interface IPersonService extends RemoteService {

	/** Returns all persons. */
	public Collection<Person> getPersons();

	Person personPruefen(String name, String passwort);
}
