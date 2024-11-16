package com.aluracursos.desafioAnime.Principal;

import com.aluracursos.desafioAnime.model.AtributosAnimes;
import com.aluracursos.desafioAnime.model.Datos;
import com.aluracursos.desafioAnime.service.ConsumoApi;
import com.aluracursos.desafioAnime.service.ConvierteDatos;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private static final String URL_BASE = "https://api.jikan.moe/v4/top/anime" ;
    private ConsumoApi consumoApi = new ConsumoApi() ;
    private ConvierteDatos conversor = new ConvierteDatos() ;
    private Scanner teclado = new Scanner(System.in) ;

    public void muestraElMenu(){
        var json = consumoApi.obtenerDatos(URL_BASE) ;
        System.out.println(json);
        var datos = conversor.obtenerDatos(json , Datos.class) ;
        System.out.println(datos);

        // Top 5 Animes mejor rankeados
        System.out.println("Top 5 Animes con mejor popularidad");
        datos.atributosAnimes().stream()
                .sorted(Comparator.comparing(AtributosAnimes::popularidad).reversed())
                .limit(5)
                .map(a -> a.titulo().toUpperCase())
                .forEach(System.out::println);

        //"Top 5 Animes con mejor calificación
        System.out.println("Top 5 Animes con mejor calificación");
        datos.atributosAnimes().stream()
                .sorted(Comparator.comparing(AtributosAnimes::calificacion).reversed())
                .limit(5)
                .map(a -> a.titulo().toUpperCase())
                .forEach(System.out::println);

        //"Top 5 Animes con mas favoritos
        System.out.println("Top 5 Animes con mas favoritos");
        datos.atributosAnimes().stream()
                .sorted(Comparator.comparing(AtributosAnimes::conteoFavoritos).reversed())
                .limit(5)
                .map(a -> a.titulo().toUpperCase())
                .forEach(System.out::println);

        // Busqueda de Anime por nombre
        System.out.println("Ingrese el nombre del anime que desee buscar:");
        var tituloAnime = teclado.nextLine();
        Optional<AtributosAnimes> animeBuscado = datos.atributosAnimes().stream()
                .filter(a -> a.titulo().toUpperCase().contains(tituloAnime.toUpperCase()))
                .findFirst();
        if(animeBuscado.isPresent()){
            System.out.println("Anime encontrado");
            System.out.println(animeBuscado.get());
        }else {
            System.out.println("Anime no encontrado");
        }

        // Trabajando con estadisticas
        DoubleSummaryStatistics est = datos.atributosAnimes().stream()
                .filter(a -> a.calificacion() >0.0)
                .collect(Collectors.summarizingDouble(AtributosAnimes::calificacion));
        System.out.println("Promedio de calificacion de los Animes es: " + est.getAverage());
        System.out.println("El anime con la mejor calificacion fue de: " + est.getMax());
        System.out.println("El anime con la calificacion mas baja es de: " + est.getMin());
        System.out.println("la cantidd de animes tenidos en cuenta en esta estadisticas es de: " + est.getCount());
    }
}
