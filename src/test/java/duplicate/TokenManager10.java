package duplicate;


import com.spotify.oauth2.reusablecode.SpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class TokenManager10 {



    public static String renewToken(){
        HashMap<String,String> formParams = new HashMap<String,String>();
        formParams.put("client_id","7e7a366cdf48437cbce17b330a77874e");
        formParams.put("client_secret","8c177ce92f4f40e38f7e67e464a6dd2f");
        formParams.put("refresh_token","AQD-zDpiXhGOFVdeYICq3u3O2deDuyYWOIQbZO-SrJpTo1gZg8hzj62Q3-dzOPcXb_xgTg0WyTwA-ZLMd9yrsHvcyp33B341Cpsl9KUPJn4GfUGW11rXZ-aSRM2S_VxZPZk");
        formParams.put("grant_type","refresh_token");

        Response response=
        given().
                baseUri("https://accounts.spotify.com").
                contentType(ContentType.URLENC).
                formParams(formParams).
        when().
                post("/api/token").
        then().spec(SpecBuilder.getResponseSpec()).
                extract().
                response();

        if(response.statusCode()!=200){
            throw new RuntimeException("ABORT!!!!!!!Renew Token Failed");
        }
        return response.path("access_token");
    }


}
