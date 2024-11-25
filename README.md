CRUD service
basic post = 8888

Stack:
App on Spring boot, PostgreSQL, Hibernate, REST Java 17 just for multi-line strings
Tests on Testcontainers(Much better then blank mockito), RestAssured(AssertJ better version)
Doc on basic java doc + Swagger Open API
## Documentation for ease of use at localhost:8888/swagger-ui.html
for quick testing in POSTMAN or Curl
Get all stuff : GET http://localhost:8888/api/mobile or GET http://localhost:8888/api/mobile/
Get thing by id GET http://localhost:8888/api/mobile/{id}
Update thing by id PUT  http://localhost:8888/api/mobile/{id} and field that u wanna update in JSON (won't update unselected fields and createdAt field)
Delete thing by id DELETE http://localhost:8888/api/mobile/{id}

Also includes liquibase with initdb insret to create 1 simple entity
And docker-compose file so it will create postgresql instance on application execution automatically
if any problems with db simply run docker-compose up -d in ur terminal


Test will randomly take port and run creating a real database for the data assurance, note what if u wanna disable liquibase from tests u need to create profile with liquibase disabled
