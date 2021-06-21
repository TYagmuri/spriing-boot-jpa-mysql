package com.toalfa.api_practice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ARTIST_TBL")
public class Artist {

    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    private String firstName;

    private String lastName;

    private String famousMovie;

    private int age;

    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFamousMovie() {
        return famousMovie;
    }

    public void setFamousMovie(String famousMovie) {
        this.famousMovie = famousMovie;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int dateOfBirth) {
        this.age = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
