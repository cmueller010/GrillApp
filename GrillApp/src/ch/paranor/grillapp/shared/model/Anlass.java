package ch.paranor.grillapp.shared.model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Anlass implements Serializable {

	Date datumZeit;
	String titel;
	String kommentar;
	Date anmeldenBis;
	AnlassTyp typ;
	Status status;
	Person organisator;

	public Anlass() {

	}

	public Anlass(Date datumZeit, String titel, String kommentar,
			Date anmeldenBis, AnlassTyp typ, Status status, Person organisator) {

		this.datumZeit = datumZeit;
		this.titel = titel;
		this.kommentar = kommentar;
		this.anmeldenBis = anmeldenBis;
		this.typ = typ;
		this.status = status;
		this.organisator = organisator;

	}

	public Person getOrganisator() {
		return organisator;
	}

	public void setOrganisator(Person organisator) {
		this.organisator = organisator;
	}

	public Date getAnmeldenBis() {
		return anmeldenBis;
	}

	public void setAnmeldenBis(Date anmeldenBis) {
		this.anmeldenBis = anmeldenBis;
	}

	public AnlassTyp getTyp() {
		return typ;
	}

	public void setTyp(AnlassTyp typ) {
		this.typ = typ;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getDatumZeit() {
		return datumZeit;
	}

	public String getTitel() {
		return titel;
	}

	public String getKommentar() {
		return kommentar;
	}

	public void setDatumZeit(Date datumZeit) {
		this.datumZeit = datumZeit;
	}

	public void setTitel(String titel) {
		this.titel = titel;

	}

	public void setKommentar(String kommentar) {
		this.kommentar = kommentar;
	}

}