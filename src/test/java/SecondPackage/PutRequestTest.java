package SecondPackage;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class PutRequestTest extends BaseTest{
    @Test
    public void putRequestTest() {

        HashMap<String, String> body = new HashMap<String, String>(){{
            put("value", "test send put request");
        }};
        HashMap<String, String> result = new HashMap<String, String>(){{
            put("message: ", "error.404");
            put("description: ", "Entity ACCOUNT with id=5-2OEQGR7 is not found.");
            put("fieldErrors: ", null);
            put("params: ", null);
        }};
//        java.lang.AssertionError: 1 expectation failed.
//        Response body doesn't match expectation.
//        Expected: <{message: =error.404, description: =Entity ACCOUNT with id=5-2OEQGR7 is not found., params: =null, fieldErrors: =null}>
//        Actual: {"message":"error.404","description":"Entity ACCOUNT with id=5-2OEQGR7 is not found.","fieldErrors":null,"params":null}

              given()
                .log().all()
                .baseUri("https://tcrm-api-test.tcsbank.ru")
                .basePath("sme/api/v1")
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .pathParam("accountId", "5-2OEQGR7")
                .body(body)
                .put("/account/{accountId}/internal-info/comment")
                .then()
                .assertThat()
                .statusCode(404)
                .body("description",equalTo("Entity ACCOUNT with id=5-2OEQGR7 is not found."))
                .body("message", equalTo("error.404"))
                .log().all();
    }
}

