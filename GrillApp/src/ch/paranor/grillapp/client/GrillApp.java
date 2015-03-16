package ch.paranor.grillapp.client;

import ch.paranor.grillapp.client.dialogs.AnlassOverview;
import ch.paranor.grillapp.client.dialogs.Container;
import ch.paranor.grillapp.client.dialogs.LoginDialog;
import ch.paranor.grillapp.client.dialogs.MainContainer;
import ch.paranor.grillapp.client.events.ILoginEventHandler;
import ch.paranor.grillapp.client.events.LoginEvent;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GrillApp implements EntryPoint, ILoginEventHandler {

	LoginDialog loginDialog = new LoginDialog();
	AnlassOverview anlassDialog = new AnlassOverview();
	Container container = new Container();

	MainContainer maincontainer = new MainContainer();

	/**
	 * This is the entry point method.
	 */

	public void onModuleLoad() {

		RootLayoutPanel.get().add(maincontainer);
		maincontainer.getWestpanel().setVisible(false);

		maincontainer.getCenterpanel().add(loginDialog);
		loginDialog.addHandler(this, LoginEvent.TYPE);

	}

	@Override
	public void login(LoginEvent event) {
		// TODO Person speichern

		maincontainer.getCenterpanel().clear();
		maincontainer.getWestpanel().setVisible(true);
		// RootLayoutPanel.get().clear();
		// RootLayoutPanel.get().add(maincontainer);

		maincontainer.getCenterpanel().add(anlassDialog);
	}
}