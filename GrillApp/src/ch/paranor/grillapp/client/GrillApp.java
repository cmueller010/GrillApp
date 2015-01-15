package ch.paranor.grillapp.client;

import ch.paranor.grillapp.client.dialogs.LoginDialog;
import ch.paranor.grillapp.client.events.ILoginEventHandler;
import ch.paranor.grillapp.client.events.LoginEvent;

import com.google.gwt.core.client.EntryPoint;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GrillApp implements EntryPoint, ILoginEventHandler {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while " + "attempting to contact the server. Please check your network "
			+ "connection and try again: ";

	LoginDialog loginDialog = new LoginDialog();

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		loginDialog.addHandler(this, LoginEvent.TYPE);
		loginDialog.show();

	}

	@Override
	public void login(LoginEvent event) {
		// TODO Person speichern
		loginDialog.hide();
		// TODO neue Seite laden
	}
}