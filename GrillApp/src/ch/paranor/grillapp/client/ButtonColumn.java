package ch.paranor.grillapp.client;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.user.cellview.client.Column;

public abstract class ButtonColumn<T> extends Column<T, String> {

	public ButtonColumn() {
		super(new ButtonCell());
	}

}
