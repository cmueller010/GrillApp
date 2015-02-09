package ch.paranor.grillapp.client;

import ch.paranor.grillapp.client.dialogs.AnlassDialog;
import ch.paranor.grillapp.client.dialogs.Container;
import ch.paranor.grillapp.client.dialogs.LoginDialog;
import ch.paranor.grillapp.client.dialogs.MainContainer;
import ch.paranor.grillapp.client.dialogs.NavigationDialog;
import ch.paranor.grillapp.client.events.ILoginEventHandler;
import ch.paranor.grillapp.client.events.LoginEvent;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GrillApp implements EntryPoint, ILoginEventHandler {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	// private static final String SERVER_ERROR = "An error occurred while " +
	// "attempting to contact the server. Please check your network "
	// + "connection and try again: ";

	// LoginDialog loginDialog = new LoginDialog();
	LoginDialog log = new LoginDialog();
	AnlassDialog anlassDialog = new AnlassDialog();
	Container container = new Container();
	MainContainer maincontainer = new MainContainer();
	NavigationDialog navigationDialog = new NavigationDialog();

	// MainContainer mainContainer = new MainContainer();

	/**
	 * This is the entry point method.
	 */

	public void onModuleLoad() {

		RootLayoutPanel.get().add(container);
		container.getCenterpanel().add(log);
		log.addHandler(this, LoginEvent.TYPE);

		// loginDialog.show();
	}

	@Override
	public void login(LoginEvent event) {
		// TODO Person speichern
		// String loginName = loginDialog.getBenutzername();
		container.getCenterpanel().clear();
		RootLayoutPanel.get().clear();
		RootLayoutPanel.get().add(maincontainer);

		maincontainer.getCenterpanel().add(anlassDialog);
		// maincontainer.getWestpanel().add(navigationDialog);

		// loginDialog.hide();

		// mainContainer.getNorthpanel();
		// TODO neue Seite laden
	}
}