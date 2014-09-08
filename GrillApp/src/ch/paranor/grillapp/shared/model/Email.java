package ch.paranor.grillapp.shared.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Email implements Serializable {

	String betreff;
	String text;
	Email person;
	Email anlass;

	public Email() {

	}

	public Email(String betreff, String text, Email person, Email anlass) {
		this.betreff = betreff;
		this.text = text;
		this.person = person;
		this.anlass = anlass;
	}

	public Email getAnlass() {
		return anlass;
	}

	public void setAnlass(Email anlass) {
		this.anlass = anlass;
	}

	public Email getPerson() {
		return person;
	}

	public void setPerson(Email person) {
		this.person = person;
	}

	public String getBetreff() {
		return betreff;
	}

	public void setBetreff(String betreff) {
		this.betreff = betreff;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}