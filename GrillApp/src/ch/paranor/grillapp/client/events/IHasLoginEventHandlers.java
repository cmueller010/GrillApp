package ch.paranor.grillapp.client.events;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

public interface IHasLoginEventHandlers extends HasHandlers {
	public HandlerRegistration addHasLoginEventHandler(ILoginEventHandler handler);

}
