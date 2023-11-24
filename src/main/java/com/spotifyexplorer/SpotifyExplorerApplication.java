package com.spotifyexplorer;

import com.spotifyexplorer.service.NewAlbumService;
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
            String output = newAlbumsService.getStringOutput();

            System.out.println(output);
        };
    }
}


