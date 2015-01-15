package ch.paranor.grillapp.client.events;

import com.google.gwt.event.shared.EventHandler;

public interface ILoginEventHandler extends EventHandler {

	public void login(LoginEvent event);

}
