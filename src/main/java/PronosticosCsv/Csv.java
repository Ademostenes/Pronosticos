package PronosticosCsv;

import java.io.*;
import java.nio.file.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Csv {
    private Path ruta;

    public Csv(String ruta1) {
        this.ruta = Paths.get(ruta1);
     }
/* Creación de metodos de lectura / escritura de clase Equipos */
    
    public List<Equipos> leerCsv() throws IOException {
        List<Equipos> equipos = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(this.ruta)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Equipos equipo = new Equipos(Integer.parseInt(data[0]), data[1]);
                equipos.add(equipo);
            }
        }

        return equipos;
    }

    public void escribirCsv(List<Equipos> equipos) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(this.ruta)) {
            for (Equipos equipo : equipos) {
                String line = String.format("%d,%s", equipo.getId(), equipo.getDesc());
                writer.write(line);
                writer.newLine();
            }
        }
    }
 /* Fin métodos lectura / escritura de clase Equipo */
    
 /* Creación de métodos lectura / escritura para clase Partidos */   
    public List<Partidos> leerPartidos() throws IOException {
        List<Partidos> partidos = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(this.ruta)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Partidos partido = new Partidos(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]),Integer.parseInt(data[3]), Integer.parseInt(data[4]), Integer.parseInt(data[5]));
                partidos.add(partido);
            }
        }
        return partidos;
        }
    
    public void escribirPartido(List<Partidos> partidos) throws IOException {

        try (BufferedWriter writer = Files.newBufferedWriter(this.ruta)) {
            for (Partidos partido : partidos) {
                String line = String.format("%d,%d,%d,%d,%d,%d,%d", partido.getIdPartido(), partido.getIdRonda(), partido.getIdEquipo1(), partido.getIdEquipo2(), partido.getGolE1(), partido.getGolE2(), partido.getEPartido());
                writer.write(line);
                writer.newLine();
            }
        }
    }

    public List<Pronos> leerPron() throws IOException {
        List<Pronos> pronos = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(this.ruta)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Pronos pron = new Pronos(Integer.parseInt(data[0]),Integer.parseInt(data[1]), String.valueOf(data[2]));
                pronos.add(pron);
            }
        }

        return pronos;
    }
    
    public void escribPronos(List<Pronos> pronos) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(this.ruta)) {
            for (Pronos prono : pronos) {
                String line = String.format("%d,%d,%s", prono.getIdPro(),prono.getIdJugador(),prono.getrPartidos());
                writer.write(line);
                writer.newLine();
            }
            writer.close();
        }
    
    }
    
    public void escJugadores(List<jugador> jugadores) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(this.ruta)) {
            for (jugador jugador : jugadores) {
                String line = String.format("%d,%d,%s,%s,%d", jugador.getId(), jugador.getDni(), jugador.getnJugador(), jugador.getaJugador(), jugador.getPuntosJ());
                writer.write(line);
                writer.newLine();
            }
            writer.close();
        }
    }
    
    public List<jugador> leerJugadores() throws IOException {
        List<jugador> juga = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(this.ruta)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                jugador pron = new jugador(Integer.parseInt(data[0]), Integer.parseInt(data[1]), data[2],data[3]);
                juga.add(pron);
            }
        }

        return juga;
    }
    
    public List<jugador> leerJugCPuntos() throws IOException {
        List<jugador> juga = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(this.ruta)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                jugador pron = new jugador(Integer.parseInt(data[0]), Integer.parseInt(data[1]), data[2],data[3], Integer.parseInt(data[4]));
                juga.add(pron);
            }
        }

        return juga;
    }

    public ConfigData leerConfig() throws IOException {
        ConfigData config = new ConfigData(0,0,0);
            try (BufferedReader reader = Files.newBufferedReader(this.ruta)) {
                String line;
                    while ((line = reader.readLine()) != null) {
                        String[] data = line.split(",");
                        ConfigData configTemp = new ConfigData(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
                        config = configTemp;
            }
                    
        } return config;
    
    }
	
    
    
}
