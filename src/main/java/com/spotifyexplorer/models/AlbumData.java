package com.spotifyexplorer.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class AlbumData {
    private List<Album> items;

    public List<Album> getItems() {
        return items;
    }

    public void setItems(List<Album> items) {
        this.items = items;
    }}
