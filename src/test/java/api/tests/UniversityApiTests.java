
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UniversityApiTests {
    @Test
    void getUniversityHappyPath() {

        given()
                .baseUri("http://127.0.0.1:4010") // Base URI for the mock server
                .header("api_key", "f3c84cbb-1f9a-4b87-bb5b-2d1691b24e1e") // Passing API key as a header
                .queryParam("universityName", "University of Toronto") // Query parameter for the request
        .when()
                .get("/university")
        .then()
                .statusCode(200) // Verify the response status code
                .contentType(ContentType.JSON) // Verify the response content type
                .body("UniversityName", equalTo("University of Toronto")); // Validate specific response fields
    }
    }


