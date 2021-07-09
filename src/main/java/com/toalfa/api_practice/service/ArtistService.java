package com.toalfa.api_practice.service;

import com.toalfa.api_practice.entity.Artist;
import com.toalfa.api_practice.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {

    @Autowired
    private ArtistRepository repository;

    public Artist saveArtist(Artist artist) {
        return repository.save(artist);
    }

    public List<Artist> saveArtists(List<Artist> artists) {
        return repository.saveAll(artists);
    }

    public List<Artist> getArtists() {
        return repository.findAll();
    }

    public Artist getArtistByID(Integer id) {
        return repository.getArtistById(id);
    }

    public Artist getArtistByUsername(String username) {
        return repository.getArtistByUsername(username);
    }

    public String deleteArtistByID(int id) {
        repository.deleteById(id);
        return "Artist with 'ID: " + id + "' deleted successfully.";
    }

    public Artist updateArtist(Artist artist) {
        Artist existedArtist = repository.findById(artist.getId()).orElse(null);
        existedArtist.setFirstName(artist.getFirstName());
        existedArtist.setLastName(artist.getLastName());
        existedArtist.setAge(artist.getAge());
        existedArtist.setFamousMovie(artist.getFamousMovie());
        return repository.save(existedArtist);
    }

}