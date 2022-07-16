package com.informatorio.moviesfest.converter;

import com.informatorio.moviesfest.domain.CastMember;
import com.informatorio.moviesfest.dto.CastMemberDTO;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CastMemberConverter {

    public Set<CastMemberDTO> ToDto (Set<CastMember> castMembers){
        return castMembers.stream()
                .map( castMember -> ToDto(castMember))
                .collect(Collectors.toSet());
    }

    public CastMemberDTO ToDto(CastMember castMember){
        return new CastMemberDTO(castMember.getId(),
                castMember.getDni(),
                castMember.getName(),
                castMember.getLastname(),
                castMember.getBirthDate()
        );
    }
}
