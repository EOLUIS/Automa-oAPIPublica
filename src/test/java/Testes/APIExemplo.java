package Testes;

import org.junit.jupiter.api.Test;
import org.hamcrest.core.Is;
import org.junit.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.is;
import static  io.restassured.RestAssured.*;

public class APIExemplo {

	private Response response;

	@org.junit.Test
	public void teste() {
		response = RestAssured.request(io.restassured.http.Method.GET,
				"https://dummy.restapiexample.com/api/v1/employee/8014");
		System.out.println(response.getBody().asString());
		System.out.println("Retorno do status code " + response.statusCode());
		System.out.println(response.statusCode() == 200);
		response.then().statusCode(200).body("status", is("success"))
		.body("message", is("Successfully! Record has been added."));
	}
	
	@org.junit.Test
   public void criar () {
		given().log().all().contentType(ContentType.JSON).body("{\r\n"
				+ "    \"status\": \"success\",\r\n"
				+ "    \"data\": {\r\n"
				+ "        \"name\": \"luis\",\r\n"
				+ "        \"salary\": \"777\",\r\n"
				+ "        \"age\": \"03\",\r\n"
				+ "        \"id\": 4019\r\n"
				+ "    },\r\n"
				+ "    \"message\": \"Successfully! Record has been added.\"\r\n"
				+ "}").when().post("https://dummy.restapiexample.com/api/v1/create");
	   
   }
}
