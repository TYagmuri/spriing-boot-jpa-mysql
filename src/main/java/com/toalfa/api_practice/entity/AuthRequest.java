package com.toalfa.api_practice.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AuthRequest {

    private String username;
    private String password;

}