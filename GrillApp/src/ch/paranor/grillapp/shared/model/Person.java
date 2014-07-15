package ch.paranor.grillapp.shared.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Person implements Serializable {

	String name;
	String adresse;
	boolean anwesend; // false or true
	boolean admin; // false 
	

	// Important: there must be a zero-arg constructor and setters and getter for all attributes for the serialization to work!
	public Person() {
	}

	public Person(String name, String adresse, Boolean anwesend, Boolean admin) {
		this.name = name;
		this.adresse = adresse;
		this.anwesend = anwesend;
		this.admin = admin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Boolean getAnwesend() {
		return anwesend;
	}

	public void setAnwesend(Boolean anwesend) {
		this.anwesend = anwesend;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

}
