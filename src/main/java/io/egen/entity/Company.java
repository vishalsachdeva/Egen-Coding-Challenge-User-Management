package io.egen.entity;

import com.mongodb.BasicDBObject;

public class Company {
	private String name;
	private String website;

	/* Converting DBObject to Java Object while retrieve values from MongoDB */
	public Company(BasicDBObject basicDbCompany) {
		this.name = basicDbCompany.getString("name");
		this.website = basicDbCompany.getString("website");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

}
