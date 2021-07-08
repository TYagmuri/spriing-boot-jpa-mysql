package com.toalfa.api_practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ArtistDetailsService implements UserDetailsService {

    private final ArtistService service;

    @Autowired
    public ArtistDetailsService(ArtistService artistService) {
        this.service = artistService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String password = service.getArtistByUsername(username).getPassword();
        return new User(username, password, new ArrayList<>());
    }
}
