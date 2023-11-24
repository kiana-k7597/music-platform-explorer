package com.spotifyexplorer.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Album {
    private String name;
    private List<Artist> artists;

    @JsonCreator
    public Album(@JsonProperty("name") String name,
                 @JsonProperty("artists") List<Artist> artists) {
        this.name = name;
        this.artists = artists;
    }

    public String getName() {
        return name;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }
}
