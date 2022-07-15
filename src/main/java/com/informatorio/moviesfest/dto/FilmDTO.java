package com.informatorio.moviesfest.dto;

import com.informatorio.moviesfest.domain.CastMember;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class FilmDTO {

    private Long id;
    private String title;
    private String description;

    private Set<CastMemberDTO> castMembers = new HashSet<>();

    public FilmDTO(Long id, String title, String description, Set<CastMemberDTO> castMembers) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.castMembers = castMembers;
    }

    public FilmDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<CastMemberDTO> getCastMembers() {
        return castMembers;
    }

    public void setCastMembers(Set<CastMemberDTO> castMembers) {
        this.castMembers = castMembers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmDTO filmDTO = (FilmDTO) o;
        return Objects.equals(id, filmDTO.id) && Objects.equals(title, filmDTO.title) && Objects.equals(description, filmDTO.description) && Objects.equals(castMembers, filmDTO.castMembers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, castMembers);
    }

    @Override
    public String toString() {
        return "FilmDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", castMembers=" + castMembers +
                '}';
    }
}
