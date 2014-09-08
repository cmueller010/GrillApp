package ch.paranor.grillapp.client.services;

import java.util.List;

import ch.paranor.grillapp.shared.model.Anlass;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface IAnlassServiceAsync {

	void getAnlaesse(AsyncCallback<List<Anlass>> callback);

}
