package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import repaso.Atleta;
import repaso.Genero;
import repaso.Medalla;
import repaso.Metal;
import repaso.Paris2024;

class Paris24Test extends Paris2024 {

	@BeforeEach
	void setUp(){
		List<Atleta> atletas = List.of(
			    new Atleta(1, "Carlos Alcaraz", Genero.MASCULINO, "España", LocalDate.of(2003, 5, 5), 1.83f, 74.0f),
			    new Atleta(2, "Yulimar Rojas", Genero.FEMENINO, "España", LocalDate.of(1995, 10, 21), 1.92f, 72.0f),
			    new Atleta(3, "Eliud Kipchoge", Genero.MASCULINO, "Usa", LocalDate.of(1984, 11, 5), 1.67f, 52.0f),
			    new Atleta(4, "Katie Ledecky", Genero.FEMENINO, "Usa", LocalDate.of(1997, 3, 17), 1.83f, 73.0f),
			    new Atleta(5, "Armand Duplantis", Genero.MASCULINO, "Uk", LocalDate.of(1999, 11, 10), 1.81f, 79.0f)
			);
		List<Medalla> medallas = List.of(
			    new Medalla(Metal.ORO, LocalDate.of(2024, 8, 4), atletas.get(0), "Tenis Individual"),
			    new Medalla(Metal.PLATA, LocalDate.of(2024, 8, 3), atletas.get(0), "Tenis Dobles"),
			    new Medalla(Metal.ORO, LocalDate.of(2021, 8, 1), atletas.get(1), "Triple Salto"),
			    new Medalla(Metal.PLATA, LocalDate.of(2016, 8, 14), atletas.get(1), "Triple Salto"),
			    new Medalla(Metal.ORO, LocalDate.of(2021, 8, 8), atletas.get(2), "Maratón"),
			    new Medalla(Metal.ORO, LocalDate.of(2016, 8, 21), atletas.get(2), "Maratón"),
			    new Medalla(Metal.ORO, LocalDate.of(2024, 7, 31), atletas.get(3), "1500m Estilo Libre"),
			    new Medalla(Metal.PLATA, LocalDate.of(2024, 7, 27), atletas.get(3), "400m Estilo Libre"),
			    new Medalla(Metal.ORO, LocalDate.of(2024, 8, 5), atletas.get(4), "Salto con Pértiga"),
			    new Medalla(Metal.ORO, LocalDate.of(2021, 8, 3), atletas.get(4), "Salto con Pértiga")
			);	
	}

//	@AfterEach
//	void tearDown(){
//		
//	}
//
//	@Test	
//	void test() {
//		
//		HashMap<String, List<Atleta>> atletasPais = obtenerAtletasPorPais();
//		
//		HashMap<String, List<Atleta>> atletasPaisTest = new HashMap<String, List<Atleta>>();
//		List<Atleta> atEsp = List.of(
//			    new Atleta(1, "Carlos Alcaraz", Genero.MASCULINO, "España", LocalDate.of(2003, 5, 5), 1.83f, 74.0f),
//			    new Atleta(2, "Yulimar Rojas", Genero.FEMENINO, "España", LocalDate.of(1995, 10, 21), 1.92f, 72.0f)
//			);
//		List<Atleta> atUsa = List.of(
//			    new Atleta(3, "Eliud Kipchoge", Genero.MASCULINO, "Usa", LocalDate.of(1984, 11, 5), 1.67f, 52.0f),
//			    new Atleta(4, "Katie Ledecky", Genero.FEMENINO, "Usa", LocalDate.of(1997, 3, 17), 1.83f, 73.0f),
//			);
//		List<Atleta> atUk = List.of(
//				 new Atleta(5, "Armand Duplantis", Genero.MASCULINO, "Uk", LocalDate.of(1999, 11, 10), 1.81f, 79.0f)
//				);
//		atletasPaisTest.put("España",atEsp);
//		atletasPaisTest.put("Usa",atUsa);
//		atletasPaisTest.put("Uk",atUk);
//		
//		assertEquals(atletasPaisTest, atletasPais);
//	}
}
