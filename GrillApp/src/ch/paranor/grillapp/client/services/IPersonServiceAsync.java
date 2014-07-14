package ch.paranor.grillapp.client.services;

import java.util.List;

import ch.paranor.grillapp.shared.model.Person;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>IPersonService</code>.
 */
public interface IPersonServiceAsync {
	
	public void getPersons(AsyncCallback<List<Person>>callback);

}
