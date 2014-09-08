package ch.paranor.grillapp;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import ch.paranor.grillapp.shared.model.Person;

public class PersonTest {

	@Test
	public void getName() {
		Person christine = new Person();
		christine.setName("Christine");
		assertEquals("getName gibt den erwarteten Wert", "Christine",
				christine.getName());
	}

	@Test
	public void getNameFails() {
		Person christine = new Person();
		christine.setName("Christine");
		Assert.assertNotEquals("getName gibt nicht den erwarteten Wert",
				"Christin", christine.getName());
	}

	@Test
	public void getAdresse() {
		Person adresse = new Person();
		adresse.setAdresse("Musterweg");
		assertEquals("getAdresse gibt den erwarteten Wert", "Musterweg",adresse.getAdresse());
	}

	@Test
	public void getAdresseFails() {
		Person adresse = new Person();
		adresse.setAdresse("Musterstrasse");
		Assert.assertNotEquals("getAdresse gibt nicht den erwarteten Wert",
				"Muster", adresse.getAdresse());
	}

	@Test
	public void getAnwesend() {
		Person anwesend = new Person();
		anwesend.setAnwesend(true);
		Assert.assertTrue("getAnwesend gibt nicht den erwarteten Wert",anwesend.getAnwesend());;
	}

	@Test
	public void getAnwesendfails() {
		Person anwesend = new Person();
		anwesend.setAnwesend(false);
		Assert.assertFalse("getAnwesend gibt nicht den erwarteten Wert",anwesend.getAnwesend());

	}

	@Test
	public void getAdmin() {
		Person admin = new Person();
		admin.setAdmin(true);
		Assert.assertTrue("getAdmin gibt nicht den erwarteten Wert",admin.getAdmin());
	}

	@Test
	public void getAdminfails() {
		Person admin = new Person();
		admin.setAdmin(false);
		Assert.assertFalse("getAdmin gibt nicht den erwarteten Wert",admin.getAdmin());
	}
}
