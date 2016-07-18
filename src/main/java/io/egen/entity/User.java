package io.egen.entity;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;

public class User {
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private Address address;
	private Company company;
	private String dateCreated;
	private String profilePic;

	/* Converting DBObject to Java Object while retrieve values from MongoDB */
	public User(BasicDBObject basicDbUser) {

		this.id = basicDbUser.getString("_id");
		this.firstName = basicDbUser.getString("firstName");
		this.lastName = basicDbUser.getString("lastName");
		this.email = basicDbUser.getString("email");
		this.address = new Gson().fromJson(basicDbUser.getString("address"), Address.class); // ??
		this.dateCreated = basicDbUser.getString("dateCreated");
		this.company = new Gson().fromJson(basicDbUser.getString("company"), Company.class); // ??
		this.profilePic = basicDbUser.getString("profilePic");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}
