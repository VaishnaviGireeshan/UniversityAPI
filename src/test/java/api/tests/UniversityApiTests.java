package api.tests;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
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
    /*@Test
    void testMissingParameterInvalidRequest() {
        // Send a GET request to the endpoint without providing the required parameter (e.g., "universityName")
        given()
                .header(API_KEY_HEADER, API_KEY_VALUE)
                // Not including the required query parameter, e.g., "universityName"
                .when()
                .get("/university")
                .then()
                .statusCode(422) // Expecting HTTP status code 422
                // Optionally, check the response body for an appropriate error message
                .body("error.message", equalTo("Missing required parameter: universityName"));
    }*/

    @Test
    void testMissingAuthHeaderFor401Error() {
        given()
                .when()
                .get("/university") // Endpoint where authentication is required
                .then()
                .statusCode(401); // Expect 401 Unauthorized status code for missing authentication
    }


    @Test
    void testMissingAuthHeaderFor404Error() {
        given()
                .when()
                .get("/universities") // Endpoint where authentication is required
                .then()
                .statusCode(404); // Expect 404 Not Found status code for missing authentication
    }
}


