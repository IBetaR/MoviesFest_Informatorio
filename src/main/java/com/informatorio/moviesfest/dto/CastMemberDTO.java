package com.informatorio.moviesfest.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Getter @Setter
public class CastMemberDTO {

    private Long id;
    private Integer dni;
    private String name;
    private String lastname;
    private LocalDate birthDate;

    public CastMemberDTO(Long id, Integer dni, String name, String lastname, LocalDate birthDate) {
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.lastname = lastname;
        this.birthDate = birthDate;
    }

    public CastMemberDTO() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CastMemberDTO that = (CastMemberDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(dni, that.dni) && Objects.equals(name, that.name) && Objects.equals(lastname, that.lastname) && Objects.equals(birthDate, that.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dni, name, lastname, birthDate);
    }

    @Override
    public String   toString() {
        return "CastMemberDTO{" +
                "id=" + id +
                ", dni=" + dni +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
