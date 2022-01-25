package duplicate;

import com.spotify.oauth2.pojo.Playlist;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class PlaylistTests2PojoRequestPlaylist {

    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    String access_token="BQD6QkK3HcWakIEYs50OitRgIaUuskuCHWmQC2_WE8ngHA33mVBdX2aV0FS--6qHikIeFOIXOjjAdCWcPmqniuex_0IHRyRxTeyJz4NlKTeBYKPdLrR6c0THps1H1mfue3EzClzMlq3p4QIWCKHKD11cOu9m0i8oHpKkJIJHMkA-QqOtRC6_prSFtTQ30qvnWfyfMWKH_OcX4Gt5ygZm8UmaorxQJJsnk9iIrcB51TKz";

    @BeforeClass
    public void beforeClass(){
        RequestSpecBuilder requestSpecBuilder=new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("https://api.spotify.com");
        requestSpecBuilder.setBasePath("/v1");
        requestSpecBuilder.addHeader("Authorization","Bearer "+access_token);
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.log(LogDetail.ALL);

        requestSpecification=requestSpecBuilder.build();

        ResponseSpecBuilder responseSpecBuilder=new ResponseSpecBuilder();
        responseSpecBuilder.expectContentType(ContentType.JSON);
        responseSpecBuilder.log(LogDetail.ALL);

        responseSpecification=responseSpecBuilder.build();


    }

    @Test
    public void ShouldBeAbleToCreatePlaylist(){

        Playlist requestPlaylist=Playlist.builder().
                name("New Playlist MPM").
                description("New playlist description").
                _public(false).
                build();

       /* Playlist requestPlaylist=new Playlist();
            requestPlaylist.setName("New Playlist MPM");
            requestPlaylist.setDescription("New playlist description");
            requestPlaylist.set_public(false);*/

            given(requestSpecification).
                    body(requestPlaylist).
            when().
                    post("/users/zyntzzhi99iy1a6aa6a92o78s/playlists").
            then().spec(responseSpecification).
                    assertThat().
                    statusCode(201).
                    body("name",is(equalTo("New Playlist MPM")),
                            "description",is(equalTo("New playlist description")),
                            "public",is(equalTo(false)));



    }


}
