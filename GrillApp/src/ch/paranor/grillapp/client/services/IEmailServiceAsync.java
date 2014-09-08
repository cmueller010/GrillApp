package ch.paranor.grillapp.client.services;

import java.util.List;

import ch.paranor.grillapp.shared.model.Email;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface IEmailServiceAsync {

	void getEmail(AsyncCallback<List<Email>> callback);
}
