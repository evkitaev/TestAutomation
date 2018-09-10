package SecondPackage;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsEqual.equalTo;

public class DeleteRequestTest extends BaseTest {
    @Test
    public void deleteRequestTest(){

                given()
                .log().all()
                .baseUri("https://tcrm-api-test.tcsbank.ru")
                .basePath("sme/api/v1")
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .pathParam("contactId", "5-F5GNXQCB")
                .delete("/customer/{contactId}/questions")
                .then()
                .assertThat()
                .statusCode(200)
                .log().all();
    }
}
