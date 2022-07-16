package com.informatorio.moviesfest.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Basic
    private String title;
    private String director;
    private String description;
    private String duration;
    private LocalDate creationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    public Category category;
    //@ManyToOne annotation: goes to left side class owner (Film only has one category)

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "film_castMember",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "castMember_id"))
    public Set<CastMember> castMembers = new HashSet<>();

    public Film() {
    }


    public Film (String title, String director, String description, String duration, Category category, LocalDate creationDate) {
        this.title = title;
        this.director = director;
        this.description = description;
        this.duration = duration;
        this.creationDate = creationDate;
        this.category = category;

    }

    public void addCastMember (CastMember castMember){
        castMembers.add(castMember);
        castMember.getFilms().add(this);
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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<CastMember> getCastMembers() {
        return castMembers;
    }

    public void setCastMembers(Set<CastMember> castMembers) {
        this.castMembers = castMembers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return Objects.equals(id, film.id) && Objects.equals(title, film.title) && Objects.equals(director, film.director) && Objects.equals(description, film.description) && Objects.equals(duration, film.duration) && Objects.equals(creationDate, film.creationDate) && Objects.equals(category, film.category) && Objects.equals(castMembers, film.castMembers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, director, description, duration, creationDate, category, castMembers);
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", description='" + description + '\'' +
                ", duration='" + duration + '\'' +
                ", creationDate=" + creationDate +
                ", category=" + category +
                ", castMembers=" + castMembers +
                '}';
    }
}
