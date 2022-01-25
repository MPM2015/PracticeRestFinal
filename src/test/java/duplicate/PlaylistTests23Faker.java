package duplicate;

import com.spotify.oauth2.applicationAPI.PlaylistAPI;
import com.spotify.oauth2.applicationAPI.playlistcommoncode.PlaylistAssertion;
import com.spotify.oauth2.applicationAPI.playlistcommoncode.PlaylistRequest;
import com.spotify.oauth2.pojo.Playlist;
import com.spotify.oauth2.reusablecode.StatusCode;
import com.spotify.oauth2.utility.FakerUtils;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.annotations.Test;

@Epic("Spotify Oauth 2.0")
@Feature("Playlist API")
public class PlaylistTests23Faker {
    @Story("Creation of Playlist Story")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://example.org")
    @Link(name = "allure", type = "mylink")
    @Issue("5789")
    @TmsLink("test-238")
    @Description("Description for Spotify Create Playlist")
    @Test(description = "Spotify CreatePlaylist")
    public void ShouldBeAbleToCreatePlaylist() {

        Playlist requestPlaylist = PlaylistRequest.requestPlaylistBuilder("New Playlist MPM","New playlist description",false);
        Response response = PlaylistAPI.post(requestPlaylist);
        PlaylistAssertion.assertionPlaylistStatusCode(response.statusCode(), StatusCode.CODE_201);
        Playlist responsePlaylist = response.as(Playlist.class);
        PlaylistAssertion.assertionPlaylistResponseAndRequest(responsePlaylist,requestPlaylist);

    }

    @Story("Creation of Playlist Story")
    @Severity(SeverityLevel.MINOR)
    @Link("https://example.org")
    @Link(name = "allure", type = "mylink")
    @Issue("1234")
    @TmsLink("test-111")
    @Description("Description for Spotify Create Playlist1")
    @Test(description = "Spotify CreatePlaylist1")
    public void ShouldBeAbleToCreatePlaylist1() {

        Playlist requestPlaylist = PlaylistRequest.requestPlaylistBuilder(FakerUtils.generateName(),FakerUtils.generateDescription(),false);
        Response response = PlaylistAPI.post(requestPlaylist);
        PlaylistAssertion.assertionPlaylistStatusCode(response.statusCode(),StatusCode.CODE_201);
        Playlist responsePlaylist = response.as(Playlist.class);
        PlaylistAssertion.assertionPlaylistResponseAndRequest(responsePlaylist,requestPlaylist);

    }

    @Story("Creation of Playlist Story Part 2")
    @Link("https://example.org")
    @Link(name = "allure", type = "mylink")
    @Issue("999")
    @TmsLink("test-222")
    @Description("Description for Spotify Create Playlist2")
    @Test(description = "Spotify CreatePlaylist2")
    public void ShouldBeAbleToCreatePlaylist2() {

        Playlist requestPlaylist = PlaylistRequest.requestPlaylistBuilder("New Playlist MPM","New playlist description",false);
        Response response = PlaylistAPI.post(requestPlaylist);
        PlaylistAssertion.assertionPlaylistStatusCode(response.statusCode(),StatusCode.CODE_201);
        Playlist responsePlaylist = response.as(Playlist.class);
        PlaylistAssertion.assertionPlaylistResponseAndRequest(responsePlaylist,requestPlaylist);

    }
}
