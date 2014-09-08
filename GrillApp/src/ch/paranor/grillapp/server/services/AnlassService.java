package ch.paranor.grillapp.server.services;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ch.paranor.grillapp.client.services.IAnlassService;
import ch.paranor.grillapp.shared.model.Anlass;
import ch.paranor.grillapp.shared.model.AnlassTyp;
import ch.paranor.grillapp.shared.model.Person;
import ch.paranor.grillapp.shared.model.Status;

import com.google.appengine.labs.repackaged.com.google.common.collect.Lists;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class AnlassService extends RemoteServiceServlet implements
		IAnlassService {

	@Override
	public List<Anlass> getAnlaesse() {

		List<Anlass> anlassListe = Lists.newArrayList();

		Calendar calendar = Calendar.getInstance();

		Date datumZeit = calendar.getTime();
		calendar.set(2014, 8, 25);

		Date anmeldenBis = calendar.getTime();

		Person organisator = new Person();

		organisator.setName("neshi");
		organisator.setAdresse("Musterstrasse");
		organisator.setAdmin(true);
		organisator.setAnwesend(true);

		Anlass paranor = new Anlass(datumZeit, "Paranor", "Test", anmeldenBis,
				AnlassTyp.FREIE_WAHL, Status.NEU, organisator);

		anlassListe.add(paranor);
		return anlassListe;
	}

}
