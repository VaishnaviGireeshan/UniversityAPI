package api.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class BaseTest {

        public BaseTest() {
            RestAssured.baseURI = "http://127.0.0.1:4010"; // Base URI for the mock server
        }

        public static final String API_KEY_HEADER = "api_key";
        public static final String API_KEY_VALUE = "f3c84cbb-1f9a-4b87-bb5b-2d1691b24e1e"; // API key value
    }
