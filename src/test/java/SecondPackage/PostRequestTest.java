package SecondPackage;

import com.sun.org.apache.xerces.internal.xs.StringList;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;

public class PostRequestTest extends BaseTest{
    @Test
        public void postRequestTest() {

        HashMap<String, String> body = new HashMap<String, String>(){{
                put("tcrmContactId", "5-F5GNXQCB");
            }};

        String result = "c119b999-5748-4772-b050-730506dd1908";
        given()
                .log().all()
                .baseUri("https://tcrm-api-test.tcsbank.ru")
                .basePath("sme/api/v1")
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .pathParam("accountId", "5-5FRVACNQ")
                .body(body)
                .post("/account/{accountId}/user")
                .then()
                .assertThat()
                .statusCode(200)
                .body("ibulContactId", allOf(notNullValue(),equalTo(result)))
                .log().all();
    }
}
