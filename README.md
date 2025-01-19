This is the Test Project for the Code Challenge. 

The challenge covers 
1. Spring Rest API
2. The API has an endpoint to save batteries informations and persisted in an In-memory database (H2).
3. The API also has endpoint to fetch informations based on post code and watt capacity ranges.
4. The whole application is secured by JWT authentication. I have used two users (admin1, user1) with two different important role (ADMIN, USER). I have set the 
save battery endpoint only to use for ADMIN role. So in that case, the user can not be able to save batteries even if they have valid tokens.


To Run this application:
1. It will automatically configure and create tables for Battery, Users and Authorities for Role.
2. For simplicity of the project, I have loaded two different users (admin1, user1) with their perspective Role (ADMIN, USER).
  For "admin1" user [ username : "admin1", password : "password2"] and "user1" user [ username: "user1", password: "password1"]
3. for login api you need to do this
url : http://localhost:8080/auth/login
Method: POST
Content-Type : application/json
request-body: {
    "username" : "admin1",
    "password" : "password2"
}

we get response :
{
    "jwtToken": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbjEiLCJpYXQiOjE3MzcyNzk0NjIsImV4cCI6MTczNzI4MzA2Mn0.QGuvk7aGNiF2vMfKAHzeBM3fm8MjI5W4Tz41igyJZp0",
    "username": "admin1",
    "roles": [ "ROLE_ADMIN" ]
}

then using this jwtToken we will pass in the request header to call the Rest API endpoints for Battery informations.
for save battery informations :

URL : http://localhost:8080/batteries
Method : POST
Content-Type : application/json
in the requestHeader : Authorization : Bearer {jwtToken} we pass
Reqeust-body : 

[
  {
    "name": "Cannington",
    "postcode": "6107",
    "capacity": 13500
  },
  {
    "name": "Midland",
    "postcode": "6057",
    "capacity": 50500
  },
  {
    "name": "Hay Street",
    "postcode": "6000",
    "capacity": 23500
  },
  {
    "name": "Mount Adams",
    "postcode": "6525",
    "capacity": 12000
  },
  {
    "name": "Koolan Island",
    "postcode": "6733",
    "capacity": 10000
  },
  {
    "name": "Armadale",
    "postcode": "6992",
    "capacity": 25000
  },
  {
    "name": "Lesmurdie",
    "postcode": "6076",
    "capacity": 13500
  },
  {
    "name": "Kalamunda",
    "postcode": "6076",
    "capacity": 13500
  },
  {
    "name": "Carmel",
    "postcode": "6076",
    "capacity": 36000
  },
  {
    "name": "Bentley",
    "postcode": "6102",
    "capacity": 85000
  },
  {
    "name": "Akunda Bay",
    "postcode": "2084",
    "capacity": 13500
  },
  {
    "name": "Werrington County",
    "postcode": "2747",
    "capacity": 13500
  },
  {
    "name": "Bagot",
    "postcode": "0820",
    "capacity": 27000
  },
  {
    "name": "Yirrkala",
    "postcode": "0880",
    "capacity": 13500
  },
  {
    "name": "University of Melbourne",
    "postcode": "3010",
    "capacity": 85000
  },
  {
    "name": "Norfolk Island",
    "postcode": "2899",
    "capacity": 13500
  },
  {
    "name": "Ootha",
    "postcode": "2875",
    "capacity": 13500
  },
  {
    "name": "Kent Town",
    "postcode": "5067",
    "capacity": 13500
  },
  {
    "name": "Northgate Mc",
    "postcode": "9464",
    "capacity": 13500
  },
  {
    "name": "Gold Coast Mc",
    "postcode": "9729",
    "capacity": 50000
  }
]

Response : Batteries added successfully.

To get battery informations as per requirements :

URL : http://localhost:8080/batteries?minPostcode=6000&maxPostcode=9000&minWattCapacity=12000&maxWattCapacity=80000
Method: GET
Request Header : Authorization: Bearer {jwtToken}

Response : 
{
    "names": [
        "Armadale",
        "Cannington",
        "Carmel",
        "Hay Street",
        "Kalamunda",
        "Lesmurdie",
        "Midland",
        "Mount Adams"
    ],
    "totalCapacity": 187500,
    "averageCapacity": 23437.5
}

So this is how this application performming for In-memory Database (testdb).
you can see the database using this url 
URL : http://localhost:8080/h2-console

database : testdb
username: sa
password : password

---------------------------------------------------------------------------------------------------------------

Please let me know if you have any doubt on this. Thank you.


BADHON ROY

