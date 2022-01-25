package duplicate;

import com.spotify.oauth2.reusablecode.RestResource;
import com.spotify.oauth2.reusablecode.TokenManager;
import com.spotify.oauth2.pojo.Playlist;
import io.restassured.response.Response;

public class PlaylistAPI12GetTokenMethodCalled {

    public static Response post(Playlist requestPlaylist) {
        return RestResource.post("/users/zyntzzhi99iy1a6aa6a92o78s/playlists", TokenManager.getToken(), requestPlaylist);

    }


}
