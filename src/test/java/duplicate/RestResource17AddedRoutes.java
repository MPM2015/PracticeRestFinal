package duplicate;

import com.spotify.oauth2.utility.Routes;
import com.spotify.oauth2.reusablecode.SpecBuilder;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class RestResource17AddedRoutes {

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
        return  given(SpecBuilder.getRequestSpecRenewToken()).
                    formParams(formParams).
                when().
                    post(Routes.API+Routes.TOKEN).
                then().spec(SpecBuilder.getResponseSpec()).
                    extract().
                    response();
    }

}
