package ch.paranor.grillapp.client.events;

import com.google.gwt.event.shared.GwtEvent;

public class LoginEvent extends GwtEvent<ILoginEventHandler> {

	public static final Type<ILoginEventHandler> TYPE = new Type<ILoginEventHandler>();

	@Override
	public Type<ILoginEventHandler> getAssociatedType() {

		return TYPE;
	}

	@Override
	protected void dispatch(ILoginEventHandler handler) {
		handler.login(this);
	}

}
