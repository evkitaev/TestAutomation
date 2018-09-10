package SecondPackage;

import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.given;

public class BaseTest {
    public static String token;
    @BeforeAll
    public static void authorization(){
        token = given()
                .baseUri("https://tcrm-api-test.tcsbank.ru/")
                .basePath("uaa")
                .formParam("grant_type", "password")
                .formParam("username", "tcrm_sme_auto")
                .formParam("password", "PnR6RN$7s26D6tCh")
                .headers("Authorization", "Basic d2ViX2FwcDo=")
                .contentType("application/x-www-form-urlencoded")
                .post("/oauth/token")
                .then()
                .log().all()
                .assertThat()
                .extract().jsonPath().getString("access_token");
    }

}
