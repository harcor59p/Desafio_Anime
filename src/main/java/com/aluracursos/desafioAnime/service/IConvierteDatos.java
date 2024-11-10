package com.aluracursos.desafioAnime.service;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json ,  Class<T> clase) ;
}
