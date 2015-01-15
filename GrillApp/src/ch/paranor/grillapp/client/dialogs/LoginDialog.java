package ch.paranor.grillapp.client.dialogs;

import ch.paranor.grillapp.client.events.LoginEvent;
import ch.paranor.grillapp.client.services.IPersonService;
import ch.paranor.grillapp.client.services.IPersonServiceAsync;
import ch.paranor.grillapp.shared.model.Person;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class LoginDialog extends DialogBox implements HasText {

	private static LoginDialogUiBinder uiBinder = GWT.create(LoginDialogUiBinder.class);

	interface LoginDialogUiBinder extends UiBinder<Widget, LoginDialog> {
	}

	public LoginDialog() {
		setWidget(uiBinder.createAndBindUi(this));
	}

	/*---------------UiField wird initialisiert aus dem ui.xml---------------*/
	@UiField
	TextBox benutzername;
	@UiField
	PasswordTextBox passwort;
	@UiField
	Button anmeldenButton;
	@UiField
	DialogBox dialogBox;

	private final IPersonServiceAsync personService = GWT.create(IPersonService.class);

	@UiHandler("anmeldenButton")
	public void anmelden(ClickEvent click) {

		if (getBenutzername() == null || getBenutzername().isEmpty()) {
			Window.alert("Bitte geben Sie einen Benutzername ein!");
		}
		if (getPasswort() == null || getPasswort().isEmpty()) {
			Window.alert("Bitte geben Sie eine Passwort ein!");
		}

		personService.personPruefen(getBenutzername(), getPasswort(), new AsyncCallback<Person>() {

			@Override
			public void onSuccess(Person result) {
				if (result == null) {
					Window.alert("Login nicht korrekt!");
				} else {
					fireEvent(new LoginEvent());

				}

			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());

			}
		});

	}

	/*-----------Getter und Setter werden implementiert aus benutzername, passwort und anmeldenButton-------------*/

	public DialogBox getDialogBox() {
		return dialogBox;
	}

	public String getBenutzername() {
		return benutzername.getValue();
	}

	public void setBenutzername(String benutzername) {
		this.benutzername.setValue(benutzername);
	}

	public String getPasswort() {
		return passwort.getValue();
	}

	public void setPasswort(String passwort) {
		this.passwort.setValue(passwort);
	}

	public Button getAnmeldenButton() {
		return anmeldenButton;
	}

	public void setAnmeldenButton(Button anmeldenButton) {
		this.anmeldenButton = anmeldenButton;
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

}
