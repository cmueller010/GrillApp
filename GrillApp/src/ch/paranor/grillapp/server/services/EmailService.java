package ch.paranor.grillapp.server.services;

import java.util.List;

import ch.paranor.grillapp.client.services.IEmailService;
import ch.paranor.grillapp.shared.model.Email;

import com.google.appengine.labs.repackaged.com.google.common.collect.Lists;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class EmailService extends RemoteServiceServlet implements IEmailService {

	public List<Email> getEmail() {

		List<Email> emailListe = Lists.newArrayList();

		Email personMail = new Email();

		personMail.setBetreff("Paranor Grillabend");
		personMail.setText("Dies ist nur ein Test");

		emailListe.add(personMail);

		return emailListe;
	}
}
