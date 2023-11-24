package com.spotifyexplorer.unit;

import com.spotifyexplorer.client.SpotifyAPIClient;
import com.spotifyexplorer.service.NewAlbumService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.io.ClassPathResource;

import java.nio.file.Files;
import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class NewAlbumServiceUnitTests {

    @Mock
    private SpotifyAPIClient spotifyAPIClient;

    @InjectMocks
    private NewAlbumService newAlbumService;

    @Test
    void testGetStringOutput() throws Exception {
        String mockResponse = readJsonFromFile();
        when(spotifyAPIClient.getNewAlbumRecommendations()).thenReturn(mockResponse);

        String result = newAlbumService.getStringOutput();

        assertNotNull(result);
        assertTrue(result.startsWith("Here is new album recommendation: "));

        verify(spotifyAPIClient).getNewAlbumRecommendations();
    }

    private String readJsonFromFile() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("new_album_response.json");
        return new String(Files.readAllBytes(classPathResource.getFile().toPath()));
    }
}
