package com.aluracursos.desafioAnime.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AtributosAnimes(
        @JsonAlias("mal_id") Integer id,
        @JsonAlias("title") String titulo ,
        @JsonAlias("score") Double calificacion ,
        @JsonAlias("favorites") Integer conteoFavoritos,
        @JsonAlias("popularity") Integer popularidad ,
        @JsonAlias("year") Integer fechaCreacion
) {
}
