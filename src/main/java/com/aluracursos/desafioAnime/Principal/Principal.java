package com.aluracursos.desafioAnime.Principal;

import com.aluracursos.desafioAnime.model.AtributosAnimes;
import com.aluracursos.desafioAnime.model.Datos;
import com.aluracursos.desafioAnime.model.DatosAnimes;
import com.aluracursos.desafioAnime.service.ConsumoApi;
import com.aluracursos.desafioAnime.service.ConvierteDatos;

import java.util.Comparator;

public class Principal {
    private static final String URL_BASE = "https://kitsu.io/api/edge/anime?filter[categories]=adventure" ;
    private ConsumoApi consumoApi = new ConsumoApi() ;
    private ConvierteDatos conversor = new ConvierteDatos() ;

    public void muestraElMenu(){
        var json = consumoApi.obtenerDatos(URL_BASE) ;
        //System.out.println(json);
        var datos = conversor.obtenerDatos(json , Datos.class) ;
        System.out.println(datos);

        // Top 5 Animes mejor rankeados
        System.out.println("Top 5 Animes mejor rankeados");
        datos.

    }
}
