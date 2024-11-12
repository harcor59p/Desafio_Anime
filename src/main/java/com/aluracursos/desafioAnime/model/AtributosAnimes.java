package com.aluracursos.desafioAnime.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AtributosAnimes(
        @JsonAlias("id") Integer id,
        @JsonAlias("attributes") DatosAnimes datosAnimes
        //DatosAnimes datosAnimes

        ) {
}
