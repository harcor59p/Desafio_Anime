package com.aluracursos.desafioAnime.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AtributosAnimes(
        @JsonAlias("attributes") DatosAnimes datosAnimes
        ) {
}
