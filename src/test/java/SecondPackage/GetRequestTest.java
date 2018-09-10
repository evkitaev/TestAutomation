package SecondPackage;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetRequestTest extends BaseTest {
    @Test
    public void GetRequestTest(){
        given()
        .log().all()
                .baseUri("https://tcrm-api-test.tcsbank.ru")
                .basePath("sme/api/v1")
                .header("Authorization", "Bearer " + token)
                .get("/account/5-5FRVACNQ")
                .then()
                .assertThat()
                .statusCode(200)
                .log().all();
    }
}
