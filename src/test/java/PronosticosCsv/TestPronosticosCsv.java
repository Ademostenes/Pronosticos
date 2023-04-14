package PronosticosCsv;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestPronosticosCsv {

	@Test
	public void testCargarPuntosSinJugadores() {
	    
	    // Crear una lista vacía de jugadores
	    	List<jugador> jugadores = new ArrayList<jugador>();

	    // Comprobar el resultado
	    assertTrue(jugadores.isEmpty());
	}
	
	@Test
	public void testComprobarOrigenPuntos(){

	    List<jugador> jugadores = new ArrayList<jugador>();
	    jugadores.add(new jugador(5,25447879,"NombreTest","ApellidoTest",10));
    	jugadores.add(new jugador(12,46770288,"NombreTest2","ApellidoTest2",15));
	    jugador jugador1 = jugadores.get(0);
	    jugador jugador2 = jugadores.get(1);
	    //Comprobar que el valor sea tomado del campo correcto.
	    assertEquals(10, jugador1.getPuntosJ());
	    assertEquals(15, jugador2.getPuntosJ());
	}
	
   @Test
   public void compruebaTipoDatos() {
	   List<jugador> jugadores = new ArrayList<jugador>();
	   jugadores.add(new jugador(5,25447879,"NombreTest","ApellidoTest",10));
	   assertEquals("Integer",((Object)jugadores.get(0).getId()).getClass().getSimpleName());
	   assertEquals("Integer",((Object)jugadores.get(0).getDni()).getClass().getSimpleName());
	   assertEquals("String",((Object)jugadores.get(0).getnJugador()).getClass().getSimpleName());
	   assertEquals("String",((Object)jugadores.get(0).getaJugador()).getClass().getSimpleName());
	   assertEquals("Integer",((Object)jugadores.get(0).getPuntosJ()).getClass().getSimpleName());
	   
   }
   
   @Test
   public void compPuntosArchivo() {  					//Comprobar puntos jugador, desde archivo.
	   Csv archJ = new Csv("C:\\UTN\\jugadores.csv");
	   List<jugador>jugadores;
	   int points = 0;
	   try {
		   jugadores = archJ.leerJugCPuntos();
		   jugadores.add(new jugador(20,11223223,"nTest","aTest", 55));
		   archJ.escJugadores(jugadores);
		   jugadores = archJ.leerJugCPuntos();
		   points = jugadores.get(jugadores.size()-1).getPuntosJ();
		   jugadores.remove(jugadores.size()-1);
		   archJ.escJugadores(jugadores);
		   
	   } catch (IOException e) {
		   System.out.println(e.getMessage());
	   }
	   assertEquals(55, points);
   }



}
