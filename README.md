# Egen Coding Challenge – Level 1

----

## TECHNOLOGIES USED

----
* SPARK JAVA
* Mongodb
* GSON
* Maven
* JUnit


## FUNCTIONALITIES

* CREATE USER
* FIND ALL USER
* UPDATE USER 


## SERVICES

* Create User (POST /users)
* FindAllUser (GET /users)
* UpdateUser (PUT /users/update)
* These Service can be accessed through POSTMAN, or curl Command to the terminal 
* curl -X GET http://localhost:4567/users


## JUnit Testing

* CREATE USER TESTING
* FIND ALL USER TESTING
* UPDATE USER TESTING



**Mongodb Database** :- egenUserMgmt

**Database Collection Name** :- user

## Sample JSON Data

code({  
   "firstName":"Dorris",
   "lastName":"Keeling",
   "email":"Darby_Leffler68@gmail.com",
   "address":{  
      "street":"193 Talon Valley",
      "city":"South Tate furt",
      "zip":"47069",
      "state":"IA",
      "country":"US"
   },
   "dateCreated":"2016-03-15T07:02:40.896Z",
   "company":{  
      "name":"Denesik Group",
      "website":"http://jodie.org"
   },
   "profilePic":"http://lorempixel.com/640/480/people"
})
