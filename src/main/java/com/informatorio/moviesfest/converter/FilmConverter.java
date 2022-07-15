package com.informatorio.moviesfest.converter;

import com.informatorio.moviesfest.domain.CastMember;
import com.informatorio.moviesfest.domain.Film;
import com.informatorio.moviesfest.dto.CastMemberDTO;
import com.informatorio.moviesfest.dto.FilmDTO;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class FilmConverter {

    public FilmDTO toDto (Film film){
        return new FilmDTO(film.getId(),
                film.getTitle(),
                film.getDescription(),
                convertCastMembersToDto(film.getCastMembers()));
    }

    private Set<CastMemberDTO> convertCastMembersToDto (Set<CastMember> castMembers){
        return castMembers.stream()
                .map( castMember -> convertCastMemberToDTO(castMember))
                .collect(Collectors.toSet());
    }

    private CastMemberDTO convertCastMemberToDTO(CastMember castMember){
        return new CastMemberDTO(castMember.getId(),
                castMember.getDni(),
                castMember.getName(),
                castMember.getLastname(),
                castMember.getBirthDate()
        );
    }
}
