package duplicate;

import com.spotify.oauth2.reusablecode.SpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class RestResource14PostRenewToken {

    public static Response post(String path, String token, Object requestPlaylist) {
        return given(SpecBuilder.getRequestSpec()).
                    body(requestPlaylist).
                    header("Authorization", "Bearer " + token).
                when().
                    post(path).
                then().spec(SpecBuilder.getResponseSpec()).
                    extract().
                    response();
    }
    public static Response postRenewToken(HashMap<String,String> formParams){
        return   given().
                baseUri("https://accounts.spotify.com").
                contentType(ContentType.URLENC).
                formParams(formParams).
                log().all().
                when().
                post("/api/token").
                then().spec(SpecBuilder.getResponseSpec()).
                extract().
                response();
    }

}
