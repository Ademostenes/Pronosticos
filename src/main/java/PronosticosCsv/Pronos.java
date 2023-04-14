package PronosticosCsv;


public class Pronos {
    
   private int idPro;
   private int idJugador;
   private String rPartidos;

   
   public Pronos(int idP, int idJ){
   this.idPro = idP;
   this.idJugador = idJ;
   rPartidos = "";
   }
   
   public Pronos(int idP, int idJ, String r){
   this.idPro = idP;
   this.idJugador = idJ;
   this.rPartidos = r;
   }
   
   public int getIdPro() {
        return idPro;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public String getrPartidos() {
        return rPartidos;
    }


    public void setIdPro(int idPro) {
        this.idPro = idPro;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public void setrPartido(String rPartidos) {
        this.rPartidos = rPartidos;
    }
    
      public void setRpartido(int i, String value) {
        this.rPartidos = value;
    }

    
}