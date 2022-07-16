package com.informatorio.moviesfest.converter;

import com.informatorio.moviesfest.domain.Film;
import com.informatorio.moviesfest.dto.FilmDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FilmConverter {

    private final CastMemberConverter castMemberConverter;

    @Autowired
    public FilmConverter(CastMemberConverter castMemberConverter) {
        this.castMemberConverter = castMemberConverter;
    }



    public FilmDTO toDto (Film film){
        return new FilmDTO(film.getId(),
                film.getTitle(),
                film.getDescription(),
                castMemberConverter.ToDto(film.getCastMembers()));
    }

}
