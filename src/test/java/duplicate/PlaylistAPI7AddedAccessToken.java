package duplicate;

import com.spotify.oauth2.reusablecode.SpecBuilder;
import com.spotify.oauth2.pojo.Playlist;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PlaylistAPI7AddedAccessToken {

    static String  access_token="BQClaHUwdTETXlMwdybeyLqC5bTH-OkgTvqhNjMgM3JgHhcDLOVkcBSn19ZCTLbjpDOZCO2gOGQTStXqYFwrBMhMmdyuXlZMjniEE7Io98R6lYtf02H7WMJYG2cgr1VZV9OAKVnt8xxqqxyPSzJzPAswKLdZC95Napg_DhG5pTN-J3Mca4fiVIhbwztqtkcZsP09W0sg9N_RooKCeCsKkW7VRGRXE_hxnd9_ng-9Yfyb";

    public static Response post(Playlist requestPlaylist){
        return  given(SpecBuilder.getRequestSpec()).
                        body(requestPlaylist).
                        header("Authorization","Bearer "+access_token).
                when().
                        post("/users/zyntzzhi99iy1a6aa6a92o78s/playlists").
                then().spec(SpecBuilder.getResponseSpec()).
                        extract().
                        response();

    }


}
