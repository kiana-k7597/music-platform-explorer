package com.spotifyexplorer.service;

import com.spotifyexplorer.client.SpotifyAPIClient;
import com.spotifyexplorer.models.Album;
import com.spotifyexplorer.transformer.AlbumJsonTransformer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewAlbumService {

    private final SpotifyAPIClient spotifyAPIClient;

    public NewAlbumService(SpotifyAPIClient spotifyAPIClient) {
        this.spotifyAPIClient = spotifyAPIClient;
    }


    public String getStringOutput() throws Exception {

        String response = spotifyAPIClient.getNewAlbumRecommendations();

        List<Album> albumAndArtists = new AlbumJsonTransformer().parseAlbums(response);

        return "Here is new album recommendation: " + albumAndArtists.get(0).getName() +
                " - " + albumAndArtists.get(0).getArtists().get(0).getName();
    }
}