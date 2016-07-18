package io.egen.entity;

import com.mongodb.BasicDBObject;

public class Address {
	private String street;
	private String city;
	private String zip;
	private String state;
	private String country;

	/* Converting DBObject to Java Object while retrieve values from MongoDB */
	public Address(BasicDBObject basicDbAddress) {
		this.street = basicDbAddress.getString("street");
		this.city = basicDbAddress.getString("city");
		this.zip = basicDbAddress.getString("zip");
		this.state = basicDbAddress.getString("state");
		this.country = basicDbAddress.getString("country");
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(this.getStreet());
		s.append(this.getCity());
		s.append(this.getState());
		s.append(this.getCountry());
		s.append(this.getZip());
		return s.toString();
	}

}
