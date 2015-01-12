package ch.paranor.grillapp.client.services;

import java.util.Collection;

import ch.paranor.grillapp.shared.model.Person;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>IPersonService</code>.
 */
public interface IPersonServiceAsync {

	public void getPersons(AsyncCallback<Collection<Person>> callback);

	public void personPruefen(String name, String passwort, AsyncCallback<Person> callback);

}
