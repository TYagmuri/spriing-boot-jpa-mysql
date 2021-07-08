package com.toalfa.api_practice.controller;

import com.toalfa.api_practice.entity.AuthRequest;
import com.toalfa.api_practice.entity.AuthResponse;
import com.toalfa.api_practice.service.ArtistDetailsService;
import com.toalfa.api_practice.util.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final ArtistDetailsService detailsService;

    public AuthenticationController(JwtUtil jwtUtil,
                                    AuthenticationManager authenticationManager,
                                    ArtistDetailsService detailsService) {
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
        this.detailsService = detailsService;
    }

    @PostMapping
    public AuthResponse authenticate(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authRequest.getUsername(),
                            authRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Invalid Credential", e);
        }
        final UserDetails userDetails =
                detailsService.loadUserByUsername(authRequest.getUsername());

        final String token =
                jwtUtil.generateToken(userDetails);
        return new AuthResponse(token);
    }
}
