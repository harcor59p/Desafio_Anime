package com.aluracursos.desafioAnime.Principal;

import com.aluracursos.desafioAnime.model.AtributosAnimes;
import com.aluracursos.desafioAnime.model.Datos;
import com.aluracursos.desafioAnime.model.DatosAnimes;
import com.aluracursos.desafioAnime.service.ConsumoApi;
import com.aluracursos.desafioAnime.service.ConvierteDatos;

public class Principal {
    private static final String URL_BASE = "https://kitsu.io/api/edge/anime?filter[categories]=adventure" ;
    private ConsumoApi consumoApi = new ConsumoApi() ;
    private ConvierteDatos conversor = new ConvierteDatos() ;

    public void muestraElMenu(){
        var json = consumoApi.obtenerDatos(URL_BASE) ;
        System.out.println(json);
        var datos1 = conversor.obtenerDatos(json , AtributosAnimes.class) ;
        var datos = conversor.obtenerDatos(json , Datos.class) ;
        var datos2 = conversor.obtenerDatos(json , DatosAnimes.class) ;
        System.out.println(datos);
        System.out.println(datos1);
        System.out.println(datos2);
    }
}
