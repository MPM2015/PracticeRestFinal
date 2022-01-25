package com.spotify.oauth2.applicationAPI.playlistcommoncode;

import com.spotify.oauth2.pojo.Playlist;
import com.spotify.oauth2.reusablecode.StatusCode;
import io.qameta.allure.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class PlaylistAssertion {
    @Step
    public static void assertionPlaylistResponseAndRequest(Playlist responsePlaylist, Playlist requestPlaylist ){
        assertThat(responsePlaylist.getName(), is(equalTo(requestPlaylist.getName())));
        assertThat(responsePlaylist.getDescription(), is(equalTo(requestPlaylist.getDescription())));
        assertThat(responsePlaylist.get_public(), is(equalTo(requestPlaylist.get_public())));
    }
    @Step
    public static void assertionPlaylistStatusCode(int actualStatusCode, StatusCode expectedStatusCode){
        assertThat(actualStatusCode, is(equalTo(expectedStatusCode.code)));

    }


}