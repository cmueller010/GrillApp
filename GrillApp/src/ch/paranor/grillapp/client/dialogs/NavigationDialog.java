package ch.paranor.grillapp.client.dialogs;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class NavigationDialog extends Composite {

	private static NavigationDialogUiBinder uiBinder = GWT.create(NavigationDialogUiBinder.class);

	interface NavigationDialogUiBinder extends UiBinder<Widget, NavigationDialog> {
	}

	public NavigationDialog() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
