package com.example.spotifyexplorer.transformer;

import com.example.spotifyexplorer.models.Album;
import com.example.spotifyexplorer.models.AlbumResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class AlbumJsonTransformer {
    private final ObjectMapper mapper;

    public AlbumJsonTransformer() {
        this.mapper = new ObjectMapper();
    }

    public List<Album> parseAlbums(String json) throws Exception {
        AlbumResponse response = mapper.readValue(json, AlbumResponse.class);
        return response.getAlbums().getItems();
     }
    }

