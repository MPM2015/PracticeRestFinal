package duplicate;

import com.spotify.oauth2.reusablecode.SpecBuilder;
import com.spotify.oauth2.pojo.Playlist;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class PlaylistTests5StaticSpecBuilder {

    @Test
    public void ShouldBeAbleToCreatePlaylist(){

        Playlist requestPlaylist=Playlist.builder().
                name("New Playlist MPM").
                description("New playlist description").
                _public(false).
                build();

       /* Playlist requestPlaylist=new Playlist().
                setName("New Playlist MPM").
                setDescription("New playlist description").
                set_public(false);*/


            Playlist responsePlaylist=
            given(SpecBuilder.getRequestSpec()).
                    body(requestPlaylist).
            when().
                    post("/users/zyntzzhi99iy1a6aa6a92o78s/playlists").
            then().spec(SpecBuilder.getResponseSpec()).
                    assertThat().
                    statusCode(201).
                    extract().
                    response().
                    as(Playlist.class);
                    assertThat(responsePlaylist.getName(),is(equalTo(requestPlaylist.getName())));
                    assertThat(responsePlaylist.getDescription(),is(equalTo(requestPlaylist.getDescription())));
                    assertThat(responsePlaylist.get_public(),is(equalTo(requestPlaylist.get_public())));




    }


}
