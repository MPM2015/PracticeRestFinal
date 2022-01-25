package duplicate;

import com.spotify.oauth2.reusablecode.RestResource;
import com.spotify.oauth2.pojo.Playlist;
import io.restassured.response.Response;

public class PlaylistAPI8RestReusableMethod {

    static String access_token = "BQClaHUwdTETXlMwdybeyLqC5bTH-OkgTvqhNjMgM3JgHhcDLOVkcBSn19ZCTLbjpDOZCO2gOGQTStXqYFwrBMhMmdyuXlZMjniEE7Io98R6lYtf02H7WMJYG2cgr1VZV9OAKVnt8xxqqxyPSzJzPAswKLdZC95Napg_DhG5pTN-J3Mca4fiVIhbwztqtkcZsP09W0sg9N_RooKCeCsKkW7VRGRXE_hxnd9_ng-9Yfyb";

    public static Response post(Playlist requestPlaylist) {
        return RestResource.post("/users/zyntzzhi99iy1a6aa6a92o78s/playlists", access_token, requestPlaylist);

    }


}
