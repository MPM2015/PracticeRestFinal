package duplicate;

import com.spotify.oauth2.applicationAPI.PlaylistAPI;
import com.spotify.oauth2.applicationAPI.playlistcommoncode.PlaylistAssertion;
import com.spotify.oauth2.applicationAPI.playlistcommoncode.PlaylistRequest;
import com.spotify.oauth2.pojo.Playlist;
import com.spotify.oauth2.reusablecode.StatusCode;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class PlaylistTests20Assertions {

    @Test
    public void ShouldBeAbleToCreatePlaylist() {

        Playlist requestPlaylist = PlaylistRequest.requestPlaylistBuilder("New Playlist MPM","New playlist description",false);
        Response response = PlaylistAPI.post(requestPlaylist);
        PlaylistAssertion.assertionPlaylistStatusCode(response.statusCode(), StatusCode.CODE_201);
        Playlist responsePlaylist = response.as(Playlist.class);
        PlaylistAssertion.assertionPlaylistResponseAndRequest(responsePlaylist,requestPlaylist);

    }
}
