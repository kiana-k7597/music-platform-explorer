package com.example.spotifyexplorer.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NewAlbumService {

    @Value("${spotify.bearer-token}")
    private String bearerToken;
    private final RestTemplate restTemplate;
    public NewAlbumService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

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
}
