package com.toalfa.api_practice.controller;

import com.toalfa.api_practice.entity.Artist;
import com.toalfa.api_practice.entity.AuthRequest;
import com.toalfa.api_practice.entity.AuthResponse;
//import com.toalfa.api_practice.service.ArtistDetailsService;
import com.toalfa.api_practice.service.ArtistService;
//import com.toalfa.api_practice.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ArtistController {

    private final ArtistService service;

    @Autowired
    public ArtistController(ArtistService service) {
        this.service = service;
    }

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

    @GetMapping("/getArtistByUsername/{username}")
    public Artist findArtistByUsername(@PathVariable String username) {
        return service.getArtistByUsername(username);
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
