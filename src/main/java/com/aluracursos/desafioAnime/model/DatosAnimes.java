package com.aluracursos.desafioAnime.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public record DatosAnimes(
       @JsonAlias("canonicalTitle") String titulo ,
       @JsonAlias("averageRating") double calificacion ,
       @JsonAlias("userCount") Integer cantidadUsusarios,
       @JsonAlias("favoritesCount") Integer conteoFavoritos,
       @JsonAlias("startDate") String fechaCreacion

) {
}
