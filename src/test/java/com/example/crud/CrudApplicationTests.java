package com.example.crud;

import io.restassured.RestAssured;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;

import org.hamcrest.Matchers;


@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RequiredArgsConstructor
class CrudApplicationTests {

	@LocalServerPort
	private Integer port;

	@BeforeEach
	void setUp() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}



	@Test
	void shouldCreateMobile() {
		String requestBody = """
				{
				   "manufacturer": "Test",
				   "ram": "12GB",
				   "memory": "322GB",
				   "battery": "1100Mh",
				   "processor": "11gen",
				   "price": 1132.00
				
				}""";

		RestAssured.given()
				.contentType("application/json")
				.body(requestBody)
				.when()
				.post("/api/mobile")
				.then()
				.statusCode(201)
				.body("manufacturer", Matchers.equalTo("Test"))
				.body("ram", Matchers.equalTo("12GB"))
				.body("memory", Matchers.equalTo("322GB"))
				.body("battery", Matchers.equalTo("1100Mh"));

	}

	@Test
	void shouldGetMobile() {
		String requestBody = "";


		RestAssured.given()
				.contentType("application/json")
				.body(requestBody)
				.when()
				.get("/api/mobile/1")
				.then()
				.statusCode(200)
				.body("id", Matchers.equalTo(1))
				.body("manufacturer", Matchers.equalTo("Apple"));

	}

	@Test
	void shouldDeleteMobile() {
		String requestBody = "";

		RestAssured.given()
				.contentType("application/json")
				.body(requestBody)
				.when()
				.delete("/api/mobile/1")
				.then()
				.statusCode(200);
	}
}
