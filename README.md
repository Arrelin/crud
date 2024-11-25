CRUD service
basic post = 8888

Stack:
App on Spring boot, PostgreSQL, Hibernate, REST
Tests on Testcontainers(Much better then blank mockito), RestAssured(AssertJ better version)
Doc on basic java doc + Swagger Open API
## Documentation for ease of use at localhost:8888/swagger-ui.html
for quick testing in POSTMAN or Curl
Get all stuff : GET http://localhost:8888/api/mobile or GET http://localhost:8888/api/mobile/
Get thing with id GET http://localhost:8888/api/mobile/{id}
Update thing by id PUT  http://localhost:8888/api/mobile/{id} and field that u wanna update in JSON (won't update unselected fields and createdAt field)
Delete thing by id DELETE http://localhost:8888/api/mobile/{id}
