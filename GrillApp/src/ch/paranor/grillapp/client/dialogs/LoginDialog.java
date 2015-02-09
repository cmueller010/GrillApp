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
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class LoginDialog extends Composite {

	private static LogUiBinder uiBinder = GWT.create(LogUiBinder.class);

	interface LogUiBinder extends UiBinder<Widget, LoginDialog> {
	}

	public LoginDialog() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	TextBox benutzername;
	@UiField
	TextBox passwort;
	@UiField
	Button anmeldenButton;

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

}
