package com.informatorio.moviesfest.controller;
import com.informatorio.moviesfest.converter.FilmConverter;
import com.informatorio.moviesfest.domain.CastMember;
import com.informatorio.moviesfest.domain.Film;
import com.informatorio.moviesfest.dto.FilmDTO;
import com.informatorio.moviesfest.repository.CastMemberRepository;
import com.informatorio.moviesfest.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class FilmController {

    private final FilmRepository filmRepository;
    private final CastMemberRepository castMemberRepository;
    private final FilmConverter filmConverter;

    @Autowired
    public FilmController(FilmRepository filmRepository, CastMemberRepository castMemberRepository, FilmConverter filmConverter) {
        this.filmRepository = filmRepository;
        this.castMemberRepository = castMemberRepository;
        this.filmConverter = filmConverter;
    }

    @PostMapping("/film")
    public Film createFilm (@RequestBody Film film){
        return filmRepository.save(film);
    }

    @PostMapping("/film/{idFilm}/cast-member")
    public FilmDTO addCastMemberToMovie (@PathVariable Long idFilm, @RequestBody List<Long> castMemberIds) {
        Film film = filmRepository.findById(idFilm).orElse(null);
        List<CastMember> castMembers = castMemberIds.stream()
                .map(id -> castMemberRepository.findById(id))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
        for (CastMember castMember : castMembers){
            film.addCastMember(castMember);
        }
        filmRepository.save(film);
        return filmConverter.toDto(film);
    }
}
