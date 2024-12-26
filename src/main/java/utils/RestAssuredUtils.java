package utils;

import configs.Config;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


public class RestAssuredUtils {

    protected static RequestSpecification requestSpec;

    static {
        requestSpec = RestAssured.given()
                .baseUri(Config.getInstance("local").getProperty("rest.baseUri"))
                .contentType("application/json")
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter()); // Логирование запросов и ответов
        RestAssured.filters(new AllureRestAssured());
    }

    public static Response createGet(String jsonSchema, int statusCode, String endpoint) {
        return RestAssured
                .given()
                .spec(requestSpec)
                .when()
                .get(endpoint)
                .then()
                .statusCode(statusCode)
                .body(matchesJsonSchemaInClasspath("schemas/" + jsonSchema))
                .extract().response();
    }

    public static Response createPost(String body, String endpoint) {
        return RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post("/posts");
    }

}
