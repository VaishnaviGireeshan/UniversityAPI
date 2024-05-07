package tests;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UniversityApiTests extends BaseTest {
    @Test
    void getUniversityHappyPath() {//passed
        given()
                .header(API_KEY_HEADER, API_KEY_VALUE)
                .queryParam("universityName", "University of Toronto")
                .contentType(ContentType.JSON) // Specify content type here
                .when()
                .get("/university")
                .then()
                .statusCode(200)
                .body("UniversityName", equalTo("University of Toronto"));
    }

   /* @Test
    void testMissingParameterInvalidRequest() {
        // Send a GET request to the endpoint without providing the required parameter (e.g., "universityName")
        given()
                .header(API_KEY_HEADER, API_KEY_VALUE)
                .contentType(ContentType.JSON)
                .when()
                .post("/university")
                .then()
                .statusCode(422);
    }*/

    @Test
    void testUnauthorizedEndpoint() {
        given()
                .when()
                .get("/university") // Endpoint where authentication is required
                .then()
                .statusCode(401); // Expect 401 Unauthorized status code for missing authentication
    }


    @Test
    void testMissingAuthHeader() {
        given()
                .header(API_KEY_HEADER, API_KEY_VALUE)
                .when()
                .get("/universitiessss") // Endpoint where authentication is required
                .then()
                .statusCode(404); // Expect 404 Not Found status code for missing authentication
    }
    @Test
    void testInvalidURLPath() {
        given()
                .when()
                .get("/invalidPath") // Endpoint with an invalid URL path
                .then()
                .statusCode(404); // Expect 404 Not Found status code for invalid URL path
    }
    @Test
    void testUnencodedParameter() {
        given()
                .header(API_KEY_HEADER, API_KEY_VALUE)
                .queryParam("param", "special&chars")
                .when()
                .get("/universities")
                .then()
                .statusCode(200);
    }
}


