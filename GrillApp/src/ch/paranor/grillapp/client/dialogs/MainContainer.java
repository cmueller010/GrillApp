package ch.paranor.grillapp.client.dialogs;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HeaderPanel;
import com.google.gwt.user.client.ui.Widget;

public class MainContainer extends Composite {

	private static ContainerUiBinder uiBinder = GWT.create(ContainerUiBinder.class);

	interface ContainerUiBinder extends UiBinder<Widget, MainContainer> {
	}

	public MainContainer() {
		initWidget(uiBinder.createAndBindUi(this));

	}

	AnlassDialog anlassDialog;

	@UiField
	HeaderPanel panel;

	@UiField
	HeaderPanel centerpanel;

	public HeaderPanel getCenterpanel() {
		return centerpanel;
	}

	public void setCenterpanel(HeaderPanel centerpanel) {
		this.centerpanel = centerpanel;
	}

	public HeaderPanel getPanel() {
		return panel;
	}

	public void setPanel(HeaderPanel panel) {
		this.panel = panel;
	}

}
