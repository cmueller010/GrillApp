package ch.paranor.grillapp.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {

	/** Returns all persons. */
	void greetServer(String input, AsyncCallback<String> callback)
			throws IllegalArgumentException;
}
