package ch.paranor.grillapp.client.services;

import java.util.List;

import ch.paranor.grillapp.shared.model.Email;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("email")
public interface IEmailService extends RemoteService {

	public List<Email> getEmail();

}
