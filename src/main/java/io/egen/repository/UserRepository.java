package io.egen.repository;

import com.mongodb.BasicDBObject;

import io.egen.entity.User;

public class UserRepository {
	public static BasicDBObject createDB(User objUser)
	{
		BasicDBObject updateResult = new BasicDBObject("firstName", objUser.getFirstName())
				.append("lastName", objUser.getLastName())
				.append("email", objUser.getEmail())
				.append("profilePic", objUser.getProfilePic())
				.append("address", new BasicDBObject().append("street", objUser.getAddress().getStreet())
						.append("city", objUser.getAddress().getCity())
						.append("zip", objUser.getAddress().getZip())
						.append("state", objUser.getAddress().getState())
						.append("country", objUser.getAddress().getCountry())
						)
				.append("company", new BasicDBObject().append("name", objUser.getCompany().getName())
						.append("website", objUser.getCompany().getWebsite())
						);
		return updateResult;
	}
	
	
}
