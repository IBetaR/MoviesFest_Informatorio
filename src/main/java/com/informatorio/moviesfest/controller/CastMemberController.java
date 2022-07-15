package com.informatorio.moviesfest.controller;

import com.informatorio.moviesfest.domain.CastMember;
import com.informatorio.moviesfest.repository.CastMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CastMemberController {

    private final CastMemberRepository castMemberRepository;

    @Autowired
    public CastMemberController(CastMemberRepository castMemberRepository) {
        this.castMemberRepository = castMemberRepository;
    }

    @PostMapping("/cast-member")
    public CastMember createCastMembers(@RequestBody CastMember castMember){
        return castMemberRepository.save(castMember);
    }
}
