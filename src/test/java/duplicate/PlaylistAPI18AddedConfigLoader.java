package duplicate;

import com.spotify.oauth2.reusablecode.RestResource;
import com.spotify.oauth2.reusablecode.TokenManager;
import com.spotify.oauth2.pojo.Playlist;
import com.spotify.oauth2.utility.ConfigLoader;
import com.spotify.oauth2.utility.Routes;
import io.restassured.response.Response;

public class PlaylistAPI18AddedConfigLoader {

    public static Response post(Playlist requestPlaylist) {
        return RestResource.post(Routes.USERS +"/"+ ConfigLoader.getInstance().getUserId() +Routes.PLAYLISTS, TokenManager.getToken(), requestPlaylist);

    }


}
