package duplicate;

import com.spotify.oauth2.reusablecode.SpecBuilder;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RestResource13 {

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




}
