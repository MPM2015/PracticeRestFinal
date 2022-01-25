package duplicate;

import com.spotify.oauth2.utility.Routes;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilder17AddedRoutes {

    public static RequestSpecification getRequestSpec(){
        return new RequestSpecBuilder().
            setBaseUri("https://api.spotify.com").
            setBasePath(Routes.BASE_PATH).
            setContentType(ContentType.JSON).
            log(LogDetail.ALL).
            build();

    }
    public static RequestSpecification getRequestSpecRenewToken(){
        return new RequestSpecBuilder().
                setBaseUri("https://accounts.spotify.com").
                setContentType(ContentType.URLENC).
                log(LogDetail.ALL).
                build();

    }


    public static ResponseSpecification getResponseSpec(){
        return new ResponseSpecBuilder().
            expectContentType(ContentType.JSON).
            log(LogDetail.ALL).
            build();

    }
}
