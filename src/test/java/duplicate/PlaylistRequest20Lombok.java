package duplicate;

import com.spotify.oauth2.pojo.Playlist;

public class PlaylistRequest20Lombok {

    public static Playlist requestPlaylistBuilder(String name,String description,boolean _public) {
        return Playlist.builder().
                name(name).
                description(description).
                _public(_public).
                build();

       /* return new Playlist().
                   setName(name).
                   setDescription(description).
                   set_public(_public);*/


    }


}
