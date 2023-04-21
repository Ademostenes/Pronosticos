/* Clase creada con la intensión de organizar el funcionamiento del menú principal y sus correspondientes
 * ramificaciones (Sub Menúes)*/

package PronosticosCsv;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Collections;

public class Menu {
    
    public Menu(){
    }
    
     	public static void agregarEquipos() {
     		List<Equipos>equipo;
     		Csv archivo = new Csv("C:\\UTN\\Equipos.csv");
     			try {
     				equipo = archivo.leerCsv();
     					if (equipo.size()<= 32){
     						int id = equipo.size()+1;
     						String name;
     						Scanner leer  = new Scanner(System.in);
     						System.out.print("Ingrese el nombre del equipo: ");
     						name = leer.nextLine();
     						Equipos eq = new Equipos(id, name);
     						equipo.add(eq);
     						archivo.escribirCsv(equipo);
     						leer.close();
     					} else {
     						System.out.println("Se ha alcanzado el número máximo de equipos!");
            		} 
     					}	catch (IOException e) {
            				System.out.println(e.getMessage());
            		}        
				}
        
        public static void listarEquipos(){
        	List<Equipos> equipo;
        	Csv archivo = new Csv("C:\\UTN\\Equipos.csv");
        	try {
        		equipo = archivo.leerCsv();
        System.out.println("Id Equipo" + " !----!  " + "Nombre Equipo");
        System.out.println("--------------------------------");
        System.out.println();
        for ( int i=0; i < equipo.size(); i++){
        if (i<10) {    
        System.out.println("    " + equipo.get(i).getId() + "      |      " + equipo.get(i).getDesc());
        } else {
        System.out.println("    " + equipo.get(i).getId() + "     |      " + equipo.get(i).getDesc());
        }}} catch (IOException e) {
        	System.out.println(e.getMessage());
        }
        
        }
        
        public static void modificarEquipos(){
        	List<Equipos>equipo;
        	Csv archivo = new Csv("C:\\UTN\\Equipos.csv");
           Scanner leer = new Scanner(System.in);
           int id;
           try {
        	   equipo = archivo.leerCsv();
       System.out.print("Ingrese el número de ID del equipo a modificar:");
       id = Integer.parseInt(leer.nextLine());
       if (id > 0 && id < 33){
           System.out.print("Ingrese el nuevo nombre del equipo:");
           String name = leer.nextLine();
           Equipos eq = new Equipos(id, name);
           equipo.set(id-1, eq);
           		archivo.escribirCsv(equipo);
		}
        	leer.close();
           } catch (IOException e) {
			System.out.println(e.getMessage());
		}
             }
              
        public static void agregarPronostico(){
        int idJugador;
        Scanner leer = new Scanner(System.in);
        Csv archPronos = new Csv("C:\\UTN\\Pronos.csv");
        List<Pronos> prono = null;
        String gana;
        String resultados = "";
        boolean jExiste = false;
        try {
        	prono = archPronos.leerPron();
        } catch (IOException e) {
        	System.out.println(e.getMessage());
        }
        System.out.print("Ingrese el número correspondiente a su usuario: ");
        idJugador = Integer.parseInt(leer.nextLine());
        for (int i = 0; i<prono.size(); i++){
        	if (prono.get(i).getIdJugador() == idJugador){
        		jExiste = true;}
        		}
        	if (!jExiste){
        		Csv aPartidos = new Csv("C:\\UTN\\Partidos.csv");
        		Csv aEquipos = new Csv("C:\\UTN\\Equipos.csv");
        			try {
        				List<Equipos> equipo = aEquipos.leerCsv();
        				List<Partidos> partido = aPartidos.leerPartidos();
            for (int i = 0; i<partido.size(); i++){
                int idE1 = partido.get(i).getIdEquipo1()-1;
                int idE2 = partido.get(i).getIdEquipo2()-1;
                System.out.println();
                System.out.print("Partido ID:" + partido.get(i).getIdPartido() + "   ");
                System.out.println(equipo.get(idE1).getDesc() + " VS " + equipo.get(idE2).getDesc());
                System.out.print("Goles " + equipo.get(idE1).getDesc() + ":");
                int gol1 = Integer.parseInt(leer.nextLine());
                System.out.print("Goles " + equipo.get(idE2).getDesc() + ":");
                int gol2 = Integer.parseInt(leer.nextLine());
                if (gol1 == gol2) {gana = "0";} else if
               (gol1 > gol2){
                gana = "1";
                } else {
                gana ="2";
                } resultados = resultados + gana;
                System.out.println(gana);
        
            }
            leer.close();
            Pronos pron = new Pronos(prono.size()+1,idJugador,resultados);
            prono.add(pron);
            archPronos.escribPronos(prono);
            } catch (IOException e){
            System.out.println(e.getMessage()+ "Llega aqui");
            }
        }} 
        
        public static void agregarJugador(){
        Csv archivo = new Csv("C:\\UTN\\jugadores.csv");
        List<jugador> jugador;
        int dni;
        int idExiste = 0;
        Scanner leer = new Scanner(System.in);
        String name;
        String ape;
        boolean existe = false;
        int opt = 0;
        try {
        	jugador = archivo.leerJugadores();
                do {
            System.out.print("Ingrese el número de DNI del nuevo Jugador:");
            dni = Integer.parseInt(leer.nextLine());
        for (int i = 0; i < jugador.size(); i++){
        if (dni == jugador.get(i).getDni()){
        existe = true;
        idExiste = i;
        i = jugador.size();
        }
                }
        if (!existe){
            System.out.print("Ingrese el nombre del nuevo Jugador:");
            name = leer.nextLine();
            System.out.print("Ingrese el apellido del nuevo Jugador:");
            ape = leer.nextLine();
            int id = jugador.get(jugador.size()-1).getId()+1;
        jugador jug = new jugador(id,dni,name,ape); 
        jugador.add(jug);
        System.out.println();
        System.out.print("Desea continuar cargando jugadores? 1: Sí | 0: No |:");
        opt = Integer.parseInt(leer.nextLine());
       
        
        } else { System.out.println();
        System.out.println("El DNI ingresado, ya se encuentra dado de alta!");
        System.out.println();
        System.out.println("Se encuentra registrado bajo ID: " + jugador.get(idExiste).getId());
        System.out.println("Nombre:   " + jugador.get(idExiste).getnJugador());
        System.out.println("Apellido: " + jugador.get(idExiste).getaJugador());
        System.out.println("DNI:      " +jugador.get(idExiste).getDni());
        System.out.println();
        }
        } while (opt != 0);
        archivo.escJugadores(jugador); leer.close();
        } catch (IOException e) {
        e.printStackTrace(); }
        }
       
        public static void cargarPuntos(){
        	int puntos = 0;
        	int idJugador;
        	Csv archivoPron = new Csv("C:\\UTN\\Pronos.csv");
            Csv archivoPart = new Csv("C:\\UTN\\Partidos.csv");
            Csv archivoJuga = new Csv("C:\\UTN\\jugadores.csv");
            try {
            List<Pronos> pronosticos = archivoPron.leerPron();
            List<Partidos> partidos = archivoPart.leerPartidos();
            List<jugador> jugadores = archivoJuga.leerJugadores();
            for (int i = 0; i<jugadores.size(); i++) {
            	puntos = 0;
            	idJugador = jugadores.get(i).getId();
            	for (int j = 0; j<pronosticos.size(); j++) {
            		if (pronosticos.get(j).getIdJugador() == idJugador) {
            			for (int k=0; k<pronosticos.get(j).getrPartidos().length();k++){
               				    if (Integer.parseInt(String.valueOf(pronosticos.get(j).getrPartidos().charAt(k))) == partidos.get(k).getEPartido()) {
            					puntos = puntos+1;         					
            				}
            			} 
            		}
            	}
            	jugadores.get(i).setPuntosJ(puntos);
            	
            	
            	
            }
            archivoJuga.escJugadores(jugadores);
            } catch (IOException e) {
            	System.out.println(e.getMessage());
            }
        
        
        
        }

        public static void listarJugXPuntos() {
        	Csv archJugadores = new Csv("C:\\UTN\\jugadores.csv");
        	List<jugador> jugadores;
        	List<Integer> jugaOrden = new ArrayList<Integer>();
        	   	try {
        		jugadores = archJugadores.leerJugCPuntos();
        		for (int i = 0; i<jugadores.size();i++) {
        			if (jugadores.get(i).getPuntosJ() != 0) {
        			 jugaOrden.add(jugadores.get(i).getPuntosJ());
       		}}
        		List<Object> ordenada = jugaOrden.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        		for (int k = 0; k<ordenada.size(); k++) {
        			for (int h = 0; h<ordenada.size(); h++) {
        				if (jugadores.get(h).getPuntosJ() == Integer.parseInt(ordenada.get(k).toString())) {
        				System.out.println(jugadores.get(h).getnJugador() + ": " + jugadores.get(h).getPuntosJ() + " Puntos." );
        			} }
        		}
        		System.out.println();
        	} catch (IOException e) {
        		System.out.println(e.getMessage());
        	}
        }

        public static void menuJugadores() {
        	int opt;
        	do {
        	Scanner leer = new Scanner(System.in);
        	System.out.println();
        	System.out.println(" |     Menu Jugadores.   |");
        	System.out.println(" |-----------------------|");
        	System.out.println(" | 1: Agregar jugador    |");
        	System.out.println(" |-----------------------|");
        	System.out.println(" | 2: Modificar jugador  |");
        	System.out.println(" |-----------------------|");
        	System.out.println(" | 3: Eliminar jugador   |");
        	System.out.println(" |-----------------------|");
        	System.out.println(" | 4: Listar jugadores   |");
        	System.out.println(" |-----------------------|");
        	System.out.println(" | 5: Calcular puntaje   |");
        	System.out.println(" |-----------------------|");
        	System.out.println(" | 6: Salir              |");
        	System.out.println(" |-----------------------|");
        	System.out.println();
        	System.out.print("Ingrese el número de la opción deseada: ");
        	opt = Integer.parseInt(leer.nextLine());
        	switch (opt) {
        			case 1:Menu.agregarJugador();
           			       break;
        			case 2:Menu.modificarJugador();
        				   break;
        			case 3:Menu.eliminarJugador();
        				   break;
        			case 4:Menu.listarJugadores();
        			       break;
        			case 5:Menu.cargarPuntos();
        			       System.out.println("Puntos cargados correctamente, presione enter para continuar.");
        			       leer.nextLine();
        			       opt = 5;
        			       break;
        			case 6:System.out.println("Saliendo del menu Jugadores, presione enter para continuar");
        			       leer.nextLine();
        			       break;
        			default : System.out.println("Opción no válida!");
        	} leer.close();} while(opt != 6);
        	}	

        public static void listarJugadores() {
        	Csv archJugadores = new Csv("C:\\UTN\\jugadores.csv");
        	try {
        		List<jugador>jugadores = archJugadores.leerJugadores();
        		System.out.println("ID Nombre      Apellido      DNI");
        		for (int i = 0; i<jugadores.size(); i++) {
        			System.out.println(jugadores.get(i).getId()+"  "+jugadores.get(i).getnJugador() + "   " + jugadores.get(i).getaJugador() + "  " + jugadores.get(i).getDni());
        		}
        	}catch (IOException e) {
        		System.out.println(e.getMessage());
        	}
        }

        public static void listarPartidos() {
        	List<Partidos>partidos;
        	List<Equipos>eq;
        	int rondas = 1;
        	Scanner leer = new Scanner(System.in);
        	
        	Csv archPart =  new Csv("C:\\UTN\\partidos.csv");
        	Csv archEquipos = new Csv("C:\\UTN\\Equipos.csv");
        	int id1, id2;
        	try {
        		eq = archEquipos.leerCsv();
        		partidos = archPart.leerPartidos();
        		System.out.println("                     Ronda: "+ rondas);
        		System.out.println();
        		for (int i = 1; i<65;i++) {
        				id1 = partidos.get((i)-1).getIdEquipo1();
        				id2 = partidos.get((i)-1).getIdEquipo2();
        				System.out.println("                "+eq.get(id1-1).getDesc() + ": " + partidos.get(i-1).getGolE1()+ " VS "  + eq.get(id2-1).getDesc() + ": " + partidos.get(i-1).getGolE2());
        				if ( i == 16 || i == 32 || i == 48 || i == 56 || i == 60 || i== 62) {
        					rondas = rondas +1;
        					System.out.println();
        					System.out.println("                Enter para continuar a ronda " + rondas);
        					leer.nextLine();
        					System.out.println();
        					System.out.println("                     Ronda: "+ rondas);
        					System.out.println();
        					
        				}
        			
        		} leer.close();
        	} catch (IOException e) {
        		System.out.println(e.getMessage());
        	}
        	
        }
   
        public static void modificarJugador() {
        	Csv archJugadores = new Csv("C:\\UTN\\jugadores.csv");
        	List<jugador>jugador;
        	boolean existe = false;
        	int id;
        	int dni;
        	String name;
        	String ape;
        	Scanner leer = new Scanner(System.in);
        	System.out.print("Ingrese por favor el ID del jugador a modificar: ");
        	id = Integer.parseInt(leer.nextLine());
        	try {
        		jugador = archJugadores.leerJugadores();
        		for (int i = 0; i<jugador.size(); i++) {
        			if (jugador.get(i).getId()==id) {
        				existe = true;
        				id = i;
        				i = jugador.size();
        				
        			}
        		}
        		if (existe) {
        			System.out.println();
        			System.out.print("Ingrese el nombre: ");
        			name = leer.nextLine();
        			System.out.println();
        			System.out.print("Ingrese el apellido: ");
        			ape = leer.nextLine();
        			System.out.println();
        			System.out.print("Ingrese el DNI: ");
        			dni = Integer.parseInt(leer.nextLine());
        			jugador.get(id).setnJugador(name);
        			jugador.get(id).setaJugador(ape);
        			jugador.get(id).setDni(dni);
        			archJugadores.escJugadores(jugador);
        			Menu.cargarPuntos();
        		} else {
        			System.out.println();
        			System.out.print("El ID buscado no existe. Presione ENTER para continuar");
        			leer.nextLine();
        		}
        		leer.close();
        	} catch (IOException e) {
        		System.out.println();
        	    System.out.println(e.getMessage());
        	    leer.nextLine();
        	    
        	}
        	}

        public static void eliminarJugador() {
        	Csv archJug = new Csv("C:\\UTN\\jugadores.csv");
        	List<jugador>jugadores;
        	Scanner leer = new Scanner(System.in);
        	boolean existe = false;
            int opt = 0;
        	int id;
        	try {
        		jugadores = archJug.leerJugadores();
        		System.out.println("Ingrese el ID del jugador a borrar: ");
        		id = Integer.parseInt(leer.nextLine());
        		for (int i = 0; i<jugadores.size(); i++) {
        			if (jugadores.get(i).getId() == id) {
        				id = i;
        				i = jugadores.size();
        				existe = true;
        			}
        		}
        		if (existe) {
        			System.out.println();
        			System.out.println("El registro del jugador " + jugadores.get(id).getnJugador() + " " + jugadores.get(id).getaJugador());
        			System.out.println("está por ser eliminado, confirma la operación? Ingrese 1 para confirmar. Cualquier otro para desistir.");
        			System.out.print("Ingrese su opción: ");
        			opt = Integer.parseInt(leer.nextLine());
        			if (opt == 1) {
        				jugadores.remove(id);
        			    archJug.escJugadores(jugadores);
        			    System.out.println("Jugador eliminado con exito. Presione ENTER para terminar.");
        			    leer.nextLine();
        			} else {
        				System.out.println("Eliminación cancelada. Presione ENTER para salir.");
        				leer.nextLine();
        			}
        		} else {
        			System.out.println();
        			System.out.println("El ID buscado NO EXISTE. Presione ENTER para terminar.");
        			leer.nextLine();
        		}
        		leer.close();
        	} catch (IOException e) {
        	       System.out.println();
        	       System.out.println(e.getMessage());
        	}
        	
        	
        	
        }

        public static void cargarPuntosSQL(String ruta, int pAcierto, int eRonda, int eFase) throws Exception{
        	Scanner leer = new Scanner(System.in);
                int puntos = 0;
                int cAciertos = 0;
                int cFases = 0;
        	int idJugador;
            Csv archivoPart = new Csv("C:\\UTN\\Partidos.csv");
            Csv archivoJuga = new Csv("C:\\UTN\\jugadores.csv");
            try {
            List<Pronos> pronosticos = Sql.leerPronSQL(ruta, "root", "ratata128"); // Cambiar aquí por su correspondiente user/Password.
            List<Partidos> partidos = archivoPart.leerPartidos();
            List<jugador> jugadores = archivoJuga.leerJugadores();
            for (int i = 0; i<jugadores.size(); i++) {
            	puntos = 0;
            	idJugador = jugadores.get(i).getId();
            	for (int j = 0; j<pronosticos.size(); j++) {
            		if (pronosticos.get(j).getIdJugador() == idJugador) {
            			for (int k=0; k<pronosticos.get(j).getrPartidos().length();k++){
               				    if (Integer.parseInt(String.valueOf(pronosticos.get(j).getrPartidos().charAt(k))) == partidos.get(k).getEPartido()) {
            					puntos = puntos + pAcierto;  
                                cAciertos = cAciertos + 1;                                                
            				}
                                            if (k+1 == 16 || k+1 == 32 || k+1 == 48){
                                            if (cAciertos == 16){
                                            puntos =puntos + eRonda;
                                            cFases = cFases + 1;
                                            }
                                            if (k+1 == 48){
                                              if (cFases == 3){
                                                  puntos = puntos + eFase;
                                                 
                                            }
                                             cFases = 0;
                                            }
                                             cAciertos = 0;
                                            }
                                            
                                            if ( k+1 == 56){
                                            	if (cAciertos == 8){
                                                    puntos = puntos + eRonda;
                                                    puntos = puntos + eFase;
                                                    
                                                    }
                                              cAciertos = 0;
                                              }
                                            
                                            if(k+1 == 60){
                                              if (cAciertos == 4){
                                              puntos = puntos + eRonda;
                                              puntos = puntos + eFase;
                                              }
                                              cAciertos = 0;
                                            }
                                            if (k+1 == 62 || k+1 == 64){
                                            if (cAciertos == 2){
                                            puntos = puntos + eRonda;
                                            puntos = puntos + eFase;
                                            }
                                           cAciertos = 0;
                                        }
            			}

            		}
            		
            	}
            	jugadores.get(i).setPuntosJ(puntos);
            	cAciertos = 0;
            }
            archivoJuga.escJugadores(jugadores);
            System.out.println();
            System.out.println("Puntos asignados correctamente. Enter para continuar");
            leer.nextLine();
            } catch (IOException e) {
            	System.out.println(e.getMessage());
            }
            leer.close();
        }

}


    
