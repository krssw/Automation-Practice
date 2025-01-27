package api;

import io.restassured.response.Response;

public class GetAllUsersEndpoint extends UserService {

    public void ShouldBeAbleToGetAllUsers() {


        Playlist requestPlaylist = playlistBuilder("Updated Playlist Name", "Updated playlist description", false);
        Response response = PlaylistApi.get(DataLoader.getInstance().getGetPlaylistId());
        assertStatusCode(response.statusCode(), StatusCode.CODE_200);
        assertPlaylistEqual(response.as(Playlist.class), requestPlaylist);
    }
}