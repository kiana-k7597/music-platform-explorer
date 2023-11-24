package com.example.spotifyexplorer.service;

import com.example.spotifyexplorer.models.Album;
import com.example.spotifyexplorer.transformer.AlbumJsonTransformer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class NewAlbumService {
    public NewAlbumService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private final RestTemplate restTemplate;

    @Value("${spotify.bearer-token}")
    private String bearerToken;

    public String getNewAlbumRecommendations() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(bearerToken);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                "https://api.spotify.com/v1/browse/new-releases",
                HttpMethod.GET,
                entity,
                String.class);

        return response.getBody();
    }

    public String getStringOutput() throws Exception {

        String json = getNewAlbumRecommendations();

        List<Album> albumAndArtists = new AlbumJsonTransformer().parseAlbums(json);

        return "Here is new album recommendation: " + albumAndArtists.get(0).getName() +
                " - " + albumAndArtists.get(0).getArtists().get(0).getName();
    }
}
