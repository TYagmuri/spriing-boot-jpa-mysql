package com.toalfa.api_practice.repository;

import com.toalfa.api_practice.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer> {
    Artist getArtistByUsername(String username);
    Artist getArtistById(Integer id);
}
