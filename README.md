CRUD service <br>
basic post = 8888 <br>

Stack:
App on Spring boot, PostgreSQL, Hibernate, REST Java 17 just for multi-line strings <br>
Tests on Testcontainers(Much better then blank mockito), RestAssured(AssertJ better version) <br>
Doc on basic java doc + Swagger Open API <br>
## Documentation for ease of use at localhost:8888/swagger-ui.html
for quick testing in POSTMAN or Curl <br>
Get all stuff : GET http://localhost:8888/api/mobile or GET http://localhost:8888/api/mobile/ <br>
Get thing by id GET http://localhost:8888/api/mobile/{id} <br>
Update thing by id PUT  http://localhost:8888/api/mobile/{id} and field that u wanna update in JSON (won't update unselected fields and createdAt field) <br>
Delete thing by id DELETE http://localhost:8888/api/mobile/{id} <br>

Also includes liquibase with initdb insert to create 1 simple entity
And docker-compose file so it will create postgresql instance on application execution automatically <br>
If any problems with db simply run <docker-compose up -d> in ur terminal


Test will randomly take port and run creating a real database for the data assurance, note what if u wanna disable liquibase from tests u need to create profile  with liquibase disabled and attach it to TestApp with @ActiveProfiles("nameofprofile) annotation
