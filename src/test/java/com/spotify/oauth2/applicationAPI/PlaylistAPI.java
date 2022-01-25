package com.spotify.oauth2.applicationAPI;

import com.spotify.oauth2.reusablecode.RestResource;
import com.spotify.oauth2.utility.ConfigLoader;
import com.spotify.oauth2.utility.Routes;
import com.spotify.oauth2.reusablecode.TokenManager;
import com.spotify.oauth2.pojo.Playlist;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PlaylistAPI {
    @Step
    public static Response post(Playlist requestPlaylist) {
        return RestResource.post(Routes.USERS +"/"+ ConfigLoader.getInstance().getUserId() +Routes.PLAYLISTS, TokenManager.getToken(), requestPlaylist);

    }


}
