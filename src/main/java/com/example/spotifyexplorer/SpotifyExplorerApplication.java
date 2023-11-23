package com.example.spotifyexplorer;

import com.example.spotifyexplorer.Service.NewAlbumService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpotifyExplorerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpotifyExplorerApplication.class, args);
    }

    @Bean
    CommandLineRunner run(NewAlbumService newAlbumsService) {
        return args -> {
            String response = newAlbumsService.getNewAlbumRecommendations();
            System.out.println("Here are some new albums recommended for you: " + response);
        };
    }
}


