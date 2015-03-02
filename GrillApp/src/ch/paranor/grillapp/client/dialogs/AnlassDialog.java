package ch.paranor.grillapp.client.dialogs;

import ch.paranor.grillapp.client.services.IAnlassService;
import ch.paranor.grillapp.client.services.IAnlassServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class AnlassDialog extends Composite implements HasText {

	private static HomeDialogUiBinder uiBinder = GWT.create(HomeDialogUiBinder.class);
	private final IAnlassServiceAsync anlassService = GWT.create(IAnlassService.class);

	interface HomeDialogUiBinder extends UiBinder<Widget, AnlassDialog> {
	}

	public AnlassDialog() {
		initWidget(uiBinder.createAndBindUi(this));

	}

	@UiField
	Label anlassAction;
	@UiField
	Label anlassTitel;
	@UiField
	Label anlassFindetStatt;
	@UiField
	Label anlassAnmeldung;
	@UiField
	Label anlassStatus;
	@UiField
	Button organisierenButton;

	public Label getAnlassTitel() {
		return anlassTitel;
	}

	public void setAnlassTitel(Label anlassTitel) {
		this.anlassTitel = anlassTitel;
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setText(String text) {
		// TODO Auto-generated method stub

	}

	public Button getOrganisierenButton() {
		return organisierenButton;
	}

	public void setOrganisierenButton(Button organisierenButton) {
		this.organisierenButton = organisierenButton;
	}

	@UiHandler("organisierenButton")
	public void onClick(ClickEvent e) {

		DialogBox dialogbox = new DialogBox();
		dialogbox.setPixelSize(1000, 1000);
		dialogbox.center();

	}
}
