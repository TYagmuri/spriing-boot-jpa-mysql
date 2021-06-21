package com.toalfa.api_practice.controller;

import com.toalfa.api_practice.entity.Artist;
import com.toalfa.api_practice.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ArtistController {

    @Autowired
    private ArtistService service;

    @PostMapping("/addArtist")
    public Artist addArtist(@RequestBody Artist artist) {
        return service.saveArtist(artist);
    }

    @PostMapping("/addArtists")
    public List<Artist> addArtist(@RequestBody List<Artist> artists) {
        return service.saveArtists(artists);
    }

    @GetMapping("/getArtists")
    public List<Artist> findArtists() {
        return service.getArtists();
    }

    @GetMapping("/getArtistByID/{id}")
    public Artist findArtist(@PathVariable int id) {
        return service.getArtistByID(id);
    }

    @PutMapping("/updateArtist")
    public Artist updateArtistByID(Artist artist) {
        return service.updateArtist(artist);
    }

    @DeleteMapping("/deleteArtistByID/{id}")
    public String deleteArtist(@PathVariable int id) {
        return service.deleteArtistByID(id);
    }

    @GetMapping("/test")
    public String test() {
        return "ADIOS (:";
    }
}
