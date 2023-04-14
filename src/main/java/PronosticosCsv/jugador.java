package PronosticosCsv;

public class jugador {
    private int id;
    private int dni;
    private String nJugador; //Nombre
    private String aJugador; //Apellido
    private int puntosJ; //Puntos por acierto.
    
      public  jugador (int id, int dni, String name, String ape){
    this.id = id;
    this.dni = dni;
    this.nJugador = name;
    this.aJugador = ape;
    this.puntosJ = 0;
    }
      
      public  jugador (int id, int dni, String name, String ape, int num){
    	    this.id = id;
    	    this.dni = dni;
    	    this.nJugador = name;
    	    this.aJugador = ape;
    	    this.puntosJ = num;
    	    }
      

    public int getId() {
        return id;
    }

    public int getDni() {
        return dni;
    }

    public String getnJugador() {
        return nJugador;
    }

    public String getaJugador() {
        return aJugador;
    }

    public int getPuntosJ() {
        return puntosJ;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setnJugador(String nJugador) {
        this.nJugador = nJugador;
    }

    public void setaJugador(String aJugador) {
        this.aJugador = aJugador;
    }

    public void setPuntosJ(int puntosJ) {
        this.puntosJ = puntosJ;
    }
    
    
    
}