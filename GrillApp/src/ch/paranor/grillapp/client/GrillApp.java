package ch.paranor.grillapp.client;

import java.util.List;

import ch.paranor.grillapp.client.services.IPersonService;
import ch.paranor.grillapp.client.services.IPersonServiceAsync;
import ch.paranor.grillapp.shared.model.Person;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
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
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side person service.
	 */
	private final IPersonServiceAsync personService = GWT
			.create(IPersonService.class);

	

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		// Create a table
		final CellTable<Person> table = new CellTable<Person>();

		// Create a column to display the name of the persons.
		TextColumn<Person> nameColumn = new TextColumn<Person>() {

			@Override
			public String getValue(Person p) {
				return p.getName();
			}

		};

		// Add the column to the table and set a column title
		table.addColumn(nameColumn, "Name");

		// Adresse
		TextColumn<Person> adresseColumn = new TextColumn<Person>() {

			@Override
			public String getValue(Person p) {
				return p.getAdresse();
			}

		};

		table.addColumn(adresseColumn, "Adresse");

//		 anwesend
		TextColumn<Person> anwesendColumn = new TextColumn<Person>() {

			@Override
			public String getValue(Person p) {
				return toJaNein(p.getAnwesend());
			}
		};

		table.addColumn(anwesendColumn, "anwesend");

		
//		 Admin
		 TextColumn<Person> adminColumn = new TextColumn<Person>() {

		 @Override
		 public String getValue(Person p) {
		 return toJaNein(p.getAdmin());
		 }

		 };

		 table.addColumn(adminColumn, "Admin");

		// Add the table to the RootPanel
		// Use RootPanel.get() to get the entire body element
		// 'personTableContainer' is defined in GrillApp.html
		
		
		RootPanel.get("personTableContainer").add(table);

		personService.getPersons(new AsyncCallback<List<Person>>() {

			@Override
			public void onFailure(Throwable caught) {
				// Notify the user that an error occurred
				Label error = new Label(SERVER_ERROR);
				// 'errorLabelContainer' is specified in GrillApp.html
				RootPanel.get("errorLabelContainer").add(error);
				;
			}

			@Override
			public void onSuccess(List<Person> result) {
				// Add the persons to the table
				table.setRowData(result);

			}
		});
	}

	static String toJaNein(boolean value) {
		return value ? "Ja" : "Nein";
	}

}

