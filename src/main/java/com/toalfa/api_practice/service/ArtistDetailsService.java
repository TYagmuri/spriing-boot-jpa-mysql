package com.toalfa.api_practice.service;

import com.toalfa.api_practice.entity.Artist;
import com.toalfa.api_practice.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ArtistDetailsService implements UserDetailsService {

    @Autowired
    private ArtistService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String password = service.getArtistByUsername(username).getPassword();
        return new User(username, password, new ArrayList<>());
    }
}
