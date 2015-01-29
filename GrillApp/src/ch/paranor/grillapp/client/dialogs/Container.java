package ch.paranor.grillapp.client.dialogs;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Container extends Composite {

	private static ContainerUiBinder uiBinder = GWT.create(ContainerUiBinder.class);

	interface ContainerUiBinder extends UiBinder<Widget, Container> {
	}

	public Container() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
