package io.egen.UserTesting;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;


import org.junit.AfterClass;
//import org.junit.BeforeClass;
import org.junit.Test;

import com.google.gson.Gson;

import io.egen.entity.User;
import io.egen.util.JsonUtil;
import spark.Spark;
import spark.utils.IOUtils;

public class UserTests {

	@AfterClass
	public static void afterClass() {
		Spark.stop();
	}

	/* Create User Testing */
	@Test
	public void createUserTest() {
		UserTestCreate testCreate = userTestCreateResponse("POST", "/users");
		assertEquals(200, testCreate.status);
		testCreate = userTestCreateResponse("POST", "/users");
		assertEquals("This user already in Database", testCreate.body);
	}

	/* Get all User Testing */
	@Test
	public void findAllUserTest() {
		UserTestCreate testCreate = userTestCreateResponse("POST", "/users");
		assertEquals(200,testCreate.status);
		UserTestCreate testResponse1 = userTestCreateResponse("GET", "/users");
		assertEquals(testResponse1.body, testCreate.body);
	}

	/* Find User Testing */
	@Test
	public void updateUserTest() {
		UserTestCreate testCreate = userTestCreateResponse1("PUT", "/users/update");
		assertEquals(200, testCreate.status);
		String expected = "{" + "\"id\":\"578bcf617f7aeda0517a6a55\"," + "\"firstName\":\"Dorris45\","
				+ "\"lastName\":\"Keeling45\"," + "\"email\":\"Darby_Leffler4568@gmail.com\","
				+ "\"address\":{\"street\":\"193 Talon Valley\",\"city\":\"South Tate furt\",\"zip\":\"47069\",\"state\":\"IA\",\"country\":\"US\"},"
				+ "\"company\":{\"name\":\"Denesik Group\",\"website\":\"http://jodie.org\"},"
				+ "\"profilePic\":\"http://lorempixel.com/640/480/people\"}";
		assertEquals(expected, testCreate.body);
	}

	private UserTestCreate userTestCreateResponse(String method, String path) {
		try {
			String createString = "{" + "\"firstName\":\"Dorris\"," + "\"lastName\":\"Keeling\","
					+ "\"email\":\"Darby_Leffler68@gmail.com\","
					+ "\"address\":{\"street\":\"193 Talon Valley\",\"city\":\"South Tate furt\",\"zip\":\"47069\",\"state\":\"IA\",\"country\":\"US\"},"
					+ "\"company\":{\"name\":\"Denesik Group\",\"website\":\"http://jodie.org\"},"
					+ "\"profilePic\":\"http://lorempixel.com/640/480/people\"}";
			User objUser = new Gson().fromJson(createString, User.class);
			String body = JsonUtil.toJsonString(objUser);
			URL url = new URL("http://localhost:4567" + path);
		
			HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
			httpConnection.setRequestMethod(method);
			httpConnection.setDoOutput(true);
			httpConnection.setRequestProperty("Content-length", Integer.toString(body.length()));
			httpConnection.getOutputStream().write(body.getBytes("UTF8"));
			httpConnection.connect();
			body = IOUtils.toString(httpConnection.getInputStream());

			return new UserTestCreate(httpConnection.getResponseCode(), body);
		} catch (IOException e) {
			e.printStackTrace();
			fail("Failure : " + e.getMessage());
			return null;
		}
	}

	private UserTestCreate userTestCreateResponse1(String method, String path) {
		try {
			String createString = "{" + "\"id\":\"578bcf617f7aeda0517a6a55\"," + "\"firstName\":\"Dorris45\","
					+ "\"lastName\":\"Keeling45\"," + "\"email\":\"Darby_Leffler4568@gmail.com\","
					+ "\"address\":{\"street\":\"193 Talon Valley\",\"city\":\"South Tate furt\",\"zip\":\"47069\",\"state\":\"IA\",\"country\":\"US\"},"
					+ "\"company\":{\"name\":\"Denesik Group\",\"website\":\"http://jodie.org\"},"
					+ "\"profilePic\":\"http://lorempixel.com/640/480/people\"}";
			User objUser = new Gson().fromJson(createString, User.class);
			String body = JsonUtil.toJsonString(objUser);
			URL url = new URL("http://localhost:4567" + path);

			HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
			httpConnection.setRequestMethod(method);
			httpConnection.setDoOutput(true);
			httpConnection.setRequestProperty("Content-length", Integer.toString(body.length()));
			httpConnection.getOutputStream().write(body.getBytes("UTF8"));
			httpConnection.connect();
			body = IOUtils.toString(httpConnection.getInputStream());

			return new UserTestCreate(httpConnection.getResponseCode(), body);
		} catch (IOException e) {
			e.printStackTrace();
			fail("Failure : " + e.getMessage());
			return null;
		}
	}

	private static class UserTestCreate {

		public final String body;
		public final int status;

		public UserTestCreate(int status, String body) {
			this.status = status;
			this.body = body;
		}

	}
}