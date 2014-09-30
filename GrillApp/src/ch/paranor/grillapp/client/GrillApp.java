package ch.paranor.grillapp.client;

import java.util.List;

import ch.paranor.grillapp.client.services.IAnlassService;
import ch.paranor.grillapp.client.services.IAnlassServiceAsync;
import ch.paranor.grillapp.client.services.IEmailService;
import ch.paranor.grillapp.client.services.IEmailServiceAsync;
import ch.paranor.grillapp.client.services.IPersonService;
import ch.paranor.grillapp.client.services.IPersonServiceAsync;
import ch.paranor.grillapp.shared.model.Anlass;
import ch.paranor.grillapp.shared.model.Email;
import ch.paranor.grillapp.shared.model.Person;

import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GrillApp implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again: ";

	/**
	 * Create a remote service proxy to talk to the server-side person service.
	 */
	private final IPersonServiceAsync personService = GWT
			.create(IPersonService.class);

	private final IAnlassServiceAsync anlassService = GWT
			.create(IAnlassService.class);

	private final IEmailServiceAsync emailService = GWT
			.create(IEmailService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		// Create a table

		final CellTable<Person> personTable = new CellTable<Person>();

		// Create a column to display the name of the persons.
		TextColumn<Person> nameColumn = new TextColumn<Person>() {

			@Override
			public String getValue(Person p) {
				return p.getName();
			}

		};
		// Add the column to the table and set a column title
		personTable.addColumn(nameColumn, "Name");

		// Adresse
		TextColumn<Person> adresseColumn = new TextColumn<Person>() {

			@Override
			public String getValue(Person p) {
				return p.getAdresse();
			}

		};
		personTable.addColumn(adresseColumn, "Adresse");

		// anwesend
		TextColumn<Person> anwesendColumn = new TextColumn<Person>() {

			@Override
			public String getValue(Person p) {
				return toJaNein(p.getAnwesend());
			}
		};
		personTable.addColumn(anwesendColumn, "anwesend");

		// Admin
		TextColumn<Person> adminColumn = new TextColumn<Person>() {

			@Override
			public String getValue(Person p) {
				return toJaNein(p.getAdmin());
			}

		};
		personTable.addColumn(adminColumn, "Admin");

		// Add the table to the RootPanel
		// Use RootPanel.get() to get the entire body element
		// 'personTableContainer' is defined in GrillApp.html

		RootPanel.get("personTableContainer").add(personTable);

		personService.getPersons(new AsyncCallback<List<Person>>() {

			@Override
			public void onFailure(Throwable caught) {
				// Notify the user that an error occurred
				Label error = new Label(SERVER_ERROR
						+ caught.getLocalizedMessage());
				// 'errorLabelContainer' is specified in GrillApp.html
				RootPanel.get("personErrorLabelContainer").add(error);
			}

			@Override
			public void onSuccess(List<Person> result) {
				// Add the persons to the table
				personTable.setRowData(result);
			}
		});

		final CellTable<Email> emailTable = new CellTable<Email>();

		// Betreff
		TextColumn<Email> betreffColumn = new TextColumn<Email>() {

			@Override
			public String getValue(Email e) {
				return e.getBetreff();
			}

		};
		emailTable.addColumn(betreffColumn, "Betreff");

		// Text
		TextColumn<Email> textColumn = new TextColumn<Email>() {

			@Override
			public String getValue(Email e) {
				return e.getText();
			}

		};
		emailTable.addColumn(textColumn, "Text");

		RootPanel.get("emailTableContainer").add(emailTable);

		emailService.getEmail(new AsyncCallback<List<Email>>() {

			@Override
			public void onFailure(Throwable caught) {
				// Notify the user that an error occurred
				Label error = new Label(SERVER_ERROR
						+ caught.getLocalizedMessage());
				// 'errorLabelContainer' is specified in GrillApp.html
				RootPanel.get("emailErrorLabelContainer").add(error);
			}

			@Override
			public void onSuccess(List<Email> result) {
				emailTable.setRowData(result);
			}
		});

		// TODO Anlass Table
		final CellTable<Anlass> anlassTable = new CellTable<Anlass>();

		addButtonColumn(anlassTable, "Teilnehmer", "Anmelden");
		addButtonColumn(anlassTable, "Organisator", "Bearbeiten");

		TextColumn<Anlass> titelColumn = new TextColumn<Anlass>() {

			@Override
			public String getValue(Anlass a) {
				return a.getTitel();
			}
		};

		anlassTable.addColumn(titelColumn, "Titel");

		TextColumn<Anlass> datumZeitColumn = new TextColumn<Anlass>() {

			@Override
			public String getValue(Anlass a) {
				return a.getKommentar();
			}
		};

		anlassTable.addColumn(datumZeitColumn, "Datum");

		TextColumn<Anlass> kommentarColumn = new TextColumn<Anlass>() {

			@Override
			public String getValue(Anlass a) {
				return a.getKommentar();
			}
		};

		anlassTable.addColumn(kommentarColumn, "Kommentar");

		TextColumn<Anlass> anmeldenBisColumn = new TextColumn<Anlass>() {

			@Override
			public String getValue(Anlass a) {

				DateTimeFormat zeitFormat = DateTimeFormat
						.getFormat("dd MMM yyyy");
				return zeitFormat.format(a.getAnmeldenBis());
			}
		};

		anlassTable.addColumn(anmeldenBisColumn, "anmelden bis");

		TextColumn<Anlass> typColumn = new TextColumn<Anlass>() {

			@Override
			public String getValue(Anlass a) {
				return a.getTyp().toString();
			}
		};

		anlassTable.addColumn(typColumn, "Anlass Typ");

		TextColumn<Anlass> statusColumn = new TextColumn<Anlass>() {

			@Override
			public String getValue(Anlass a) {
				return a.getStatus().toString();
			}
		};

		anlassTable.addColumn(statusColumn, "Status");

		RootPanel.get("anlassTableContainer").add(anlassTable);

		anlassService.getAnlaesse(new AsyncCallback<List<Anlass>>() {

			@Override
			public void onFailure(Throwable caught) {
				// Notify the user that an error occurred
				Label error = new Label(SERVER_ERROR
						+ caught.getLocalizedMessage());
				// 'errorLabelContainer' is specified in GrillApp.html
				RootPanel.get("anlassErrorLabelContainer").add(error);
			}

			@Override
			public void onSuccess(List<Anlass> result) {
				anlassTable.setRowData(result);
			}
		});

	}

	private void addButtonColumn(final CellTable<Anlass> anlassTable,
			String columnHeader, final String buttonLabel) {
		ButtonColumn<Anlass> bearbeitenColumn = new ButtonColumn<Anlass>() {

			@Override
			public String getValue(Anlass anlass) {
				// only set sensitive if user is the organizer
				return buttonLabel;
			}
		};
		anlassTable.addColumn(bearbeitenColumn, columnHeader);

		bearbeitenColumn.setFieldUpdater(new FieldUpdater<Anlass, String>() {
			@Override
			public void update(int index, Anlass object, String value) {
				Window.alert("You clicked " + object.getTitel());
			}
		});
	}

	static String toJaNein(boolean value) {
		return value ? "Ja" : "Nein";
	}

}
