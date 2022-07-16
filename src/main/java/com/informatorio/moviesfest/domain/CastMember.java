package com.informatorio.moviesfest.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class CastMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Basic
    private Integer dni;
    private String name;
    private String lastname;

    private LocalDate birthDate;

    @ManyToMany(mappedBy = "castMembers")
    public final Set<Film> films = new HashSet<>();

    public CastMember(String name, String lastname, Integer dni, LocalDate birthDate) {

        this.dni = dni;
        this.name = name;
        this.lastname = lastname;
        this.birthDate = birthDate;
    }

    public CastMember() {
    }

    public Set<Film> getFilms() {
        return films;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "CastMember{" +
                "id=" + id +
                ", dni=" + dni +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthDate=" + birthDate +
                ", films=" + films +
                '}';
    }
}
