package com.example.spotifyexplorer.service;

import com.example.spotifyexplorer.client.SpotifyAPIClient;
import com.example.spotifyexplorer.models.Album;
import com.example.spotifyexplorer.transformer.AlbumJsonTransformer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewAlbumService {

    public String getStringOutput() throws Exception {

        String response = new SpotifyAPIClient().getNewAlbumRecommendations();

        List<Album> albumAndArtists = new AlbumJsonTransformer().parseAlbums(response);

        return "Here is new album recommendation: " + albumAndArtists.get(0).getName() +
                " - " + albumAndArtists.get(0).getArtists().get(0).getName();
    }
}
