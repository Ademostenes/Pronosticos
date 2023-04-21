/* Clase para facilitar de manera organizada, la configuración de puntos del programa.*/
/* Considero lo siguiente: */
/* Del partido 1 al 16 - Primera Ronda*/
/* Del partido 17 al 32 - Segunda Ronda*/
/* Del partido 33 al 48 - Tercer Ronda*/
/* Del partido 1 al 48 - Primera Fase*/
/* Del partido 49 al 56 - Cuarta Ronda - 2da. Fase*/
/* Del partido 57 al 60 - Quinta Ronda - 3ra. Fase*/
/* Del partido 61 al 62 - Sexta Ronda - 4ta. Fase */
/* Del partido 63 al 64 - Séptima Ronda - 5ta. Fase*/

package PronosticosCsv;

public class ConfigData {
    
    private int pAciertos; // Valor de puntos por acierto.
    private int pRonda; // Valor de puntos por acierto ronda entera.
    private int pFase; // Valor de puntos por acierto fase completa.
    
    // Constructor.
    
    public ConfigData(int pa,int pr, int pf){
    this.pAciertos = pa;
    this.pRonda = pr;
    this.pFase = pf;
    }

    //Getters.
    
    public int getpAciertos() {
        return pAciertos;
    }

    public int getpRonda() {
        return pRonda;
    }

    public int getpFase() {
        return pFase;
    }

    //Setters.
    
    public void setpAciertos(int pAciertos) {
        this.pAciertos = pAciertos;
    }

    public void setpRonda(int pRonda) {
        this.pRonda = pRonda;
    }

    public void setpFase(int pFase) {
        this.pFase = pFase;
    }
    
}