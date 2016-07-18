package io.egen.controller;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;

import io.ege.exception.ResponseError;
import io.egen.entity.User;
import io.egen.service.*;
import io.egen.util.JsonUtil;
import spark.Request;
import spark.Response;
import spark.Route;

public class UserController {
	String output = null;

	public UserController(final UserService userService) {

		/* To Create User, if its already there send an exception else create */
		post("/users", new Route() {
			public Object handle(Request request, Response response) {
				User objUser = userService.createUser(request.body());
				if (objUser == null) {
					response.body("This user already in Database");

					return new ResponseError("This user already in Database", response);
				} else {
					output = JsonUtil.toJsonString(objUser);
					return output;
				}
			}
		});

		/* To Get all Users */
		get("/users", new Route() {
			public Object handle(Request request, Response response) {
				output = JsonUtil.toJsonString(userService.findAllUsers());
				return output;
			}
		});

		/* To Update the specific User */
		put("/users/update", new Route() {
			public Object handle(Request request, Response response) {

				User objUser = userService.updateUser(request.body());
				if (objUser == null) {
					response.status(404);
					return new ResponseError("User not found in database, try again", response);

				} else {
					output = JsonUtil.toJsonString(objUser);
					return output;
				}
			}
		});

	}

}
