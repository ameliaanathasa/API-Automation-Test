import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class APITest {

    @Test
    public void TC04UpdateIDUserTidakValid() {
        // Prepare request
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("app-id", "6627151a6cae036629dee799");

        // Send request to update user with invalid ID
        Response response = request.put("https://dummyapi.io/data/v1/user/60d0fe4f5311236168a109dc");

        // Get status code and response body
        int statusCode = response.getStatusCode();
        String responseBody = response.getBody().asString();

        // Print status code and response body
        System.out.println("Status Code: " + statusCode);
        System.out.println("Response Body: " + responseBody);

        // Assert status code and response body
        Assert.assertEquals(statusCode, 404);
        Assert.assertEquals(responseBody, "{\"error\":\"RESOURCE_NOT_FOUND\"}");

        // Validate response against JSON schema
        String jsonSchemaPath = "schema.json";
        response.then().assertThat().body(matchesJsonSchemaInClasspath(jsonSchemaPath));
    }

    @Test
    public void TC06UpdatefirstNameValid() {
        // Prepare request
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("app-id", "6627151a6cae036629dee799");

        // Prepare data for update
        String updateData = "{\"firstName\":\"Rachel\"}";

        // Send request to update user with valid ID
        Response response = request.body(updateData)
                .put("https://dummyapi.io/data/v1/user/60d0fe4f5311236168a109cc");

        // Get status code and response body
        int statusCode = response.getStatusCode();
        String responseBody = response.getBody().asString();

        // Print status code and response body
        System.out.println("Status Code: " + statusCode);
        System.out.println("Response Body: " + responseBody);

        // Assert status code
        Assert.assertEquals(statusCode, 200);

        // Validate response against JSON schema
        String jsonSchemaPath = "schema.json";
        response.then().assertThat().body(matchesJsonSchemaInClasspath(jsonSchemaPath));
    }

    @Test
    public void TC18UpdatefirstNameInvalid() {
        // Prepare request
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("app-id", "6627151a6cae036629dee799");

        // Prepare data for update
        String updateData = "{\"firstName\":123}";

        // Send request to update user with valid ID
        Response response = request.body(updateData)
                .put("https://dummyapi.io/data/v1/user/60d0fe4f5311236168a109cc");

        // Get status code and response body
        int statusCode = response.getStatusCode();
        String responseBody = response.getBody().asString();

        // Print status code and response body
        System.out.println("Status Code: " + statusCode);
        System.out.println("Response Body: " + responseBody);

        // Assert status code
        Assert.assertEquals(statusCode, 200);

        // Validate response against JSON schema
        String jsonSchemaPath = "schema.json";
        response.then().assertThat().body(matchesJsonSchemaInClasspath(jsonSchemaPath));
    }

    @Test
    public void TC19UpdatefirstNameKurangDari2Karakter() {
        // Prepare request
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("app-id", "6627151a6cae036629dee799");

        // Prepare data for update
        String updateData = "{\"firstName\":\"a\"}";

        // Send request to update user with valid ID
        Response response = request.body(updateData)
                .put("https://dummyapi.io/data/v1/user/60d0fe4f5311236168a109cc");

        // Get status code and response body
        int statusCode = response.getStatusCode();
        String responseBody = response.getBody().asString();

        // Print status code and response body
        System.out.println("Status Code: " + statusCode);
        System.out.println("Response Body: " + responseBody);

        // Assert status code
        Assert.assertEquals(statusCode, 200);

        // Validate response against JSON schema
        String jsonSchemaPath = "schema.json";
        response.then().assertThat().body(matchesJsonSchemaInClasspath(jsonSchemaPath));
    }

    @Test
    public void TC48UpdateemailKosong() {
        // Prepare request
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("app-id", "6627151a6cae036629dee799");

        // Prepare data for update
        String updateData = "{\"email\":\"\",\"firstName\":\"Rachel\"}";

        // Send request to update user with valid ID
        Response response = request.body(updateData)
                .put("https://dummyapi.io/data/v1/user/60d0fe4f5311236168a109cc");

        // Get status code and response body
        int statusCode = response.getStatusCode();
        String responseBody = response.getBody().asString();

        // Print status code and response body
        System.out.println("Status Code: " + statusCode);
        System.out.println("Response Body: " + responseBody);

        // Assert status code
        Assert.assertEquals(statusCode, 200);

        // Validate response against JSON schema
        String jsonSchemaPath = "schema.json";
        response.then().assertThat().body(matchesJsonSchemaInClasspath(jsonSchemaPath));
    }
}
