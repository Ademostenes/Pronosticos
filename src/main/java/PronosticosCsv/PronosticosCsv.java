package PronosticosCsv;

import java.io.IOException;

public class PronosticosCsv {
	
    public static void main(String[] args) throws Exception {
    	
        if (args.length >= 2){
        	System.out.println("Ejecutado con Argumentos iniciales!");
        	String rutaSql = args[0];
        	Csv archConf = new Csv(args[1]);
        		try { 
            ConfigData conf = archConf.leerConfig();
            Menu.cargarPuntosSQL(rutaSql, conf.getpAciertos(), conf.getpRonda(), conf.getpFase());
            } 	catch (IOException e){
                System.out.println(e.getMessage());
            }   }    	else    {
            	    System.out.println("Ejecutado sin Argumentos iniciales!");
                    String rutaSql = "jdbc:mysql://localhost:3306/pronosticos";
                    Csv archConf = new Csv("C:\\UTN\\config.csv");
                try     { 
            ConfigData conf = archConf.leerConfig();
            Menu.cargarPuntosSQL(rutaSql, conf.getpAciertos(), conf.getpRonda(), conf.getpFase());
        }       catch (IOException e)   {
        System.out.println(e.getMessage());
            }
            
        }
        	Menu.listarJugXPuntos();
         System.out.println();
         System.out.println("Gracias por utilizar el programa");
	    
	    }
    
}

/* El programa contiene una clase Csv, que se ocupa principalmente de realizar la lectura y escritura
   de archivos csv */ 

/* En el caso de la clase Sql, esta se utiliza para realizar la conexión y lectura de los datos contenidos
   la base de datos pronosticos.*/

/*La clase Menu, es donde estoy realizando la organización del mismo, con la intención de dar un funcionamiento 
 * completo al programa  (Sí, me extendí más a allá de los solicitado, mal interpreté la consigna).*/


/* No se ha implementado aún un método de clase,para crear los archivos csv, principalmente porque
   carerían de datos inicialmente, es por ello que previamente a la ejecución, se realice el copiado de los
   archivos *.csv en la carpeta C:\UTN\*/

/* No se implementa en el presente, que manifieste en pantalla la cantidad de aciertos, ya que para la actual
 * entrega, la cantidad de aciertos es igual a la cantidad de puntos*/
