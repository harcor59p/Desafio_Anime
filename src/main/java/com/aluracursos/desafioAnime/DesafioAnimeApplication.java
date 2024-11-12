package com.aluracursos.desafioAnime;

import com.aluracursos.desafioAnime.Principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafioAnimeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DesafioAnimeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.muestraElMenu();
	}
}
