package duplicate;

import com.spotify.oauth2.applicationAPI.PlaylistAPI;
import com.spotify.oauth2.applicationAPI.playlistcommoncode.PlaylistRequest;
import com.spotify.oauth2.pojo.Playlist;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class PlaylistTests19AddedRequestPlaylist {

    @Test
    public void ShouldBeAbleToCreatePlaylist() {

        Playlist requestPlaylist = PlaylistRequest.requestPlaylistBuilder("New Playlist MPM","New playlist description",false);
        Response response = PlaylistAPI.post(requestPlaylist);
        assertThat(response.statusCode(), is(equalTo(201)));
        Playlist responsePlaylist = response.as(Playlist.class);

        assertThat(responsePlaylist.getName(), is(equalTo(requestPlaylist.getName())));
        assertThat(responsePlaylist.getDescription(), is(equalTo(requestPlaylist.getDescription())));
        assertThat(responsePlaylist.get_public(), is(equalTo(requestPlaylist.get_public())));

    }
}
