package PronosticosCsv;

public class Partidos {

	private int idPartido;
	private int idRonda;
	private int idEquipo1;
	private int idEquipo2;
	private int golE1;
	private int golE2;
	private int ePartido; // 0: Empate - 1: Gana Equipo1 - 2: Gana Equipo2.
	
	public Partidos(int id, int ronda, int e1, int e2, int g1, int g2 ) {
		this.idPartido = id;
		this.idRonda = ronda;
		this.idEquipo1 = e1;
		this.idEquipo2 = e2;
		this.golE1 = g1;
		this.golE2 = g2;
		this.ePartido = estadoPartido(g1,g2);
	}
        
	public Partidos(int id, int ronda, int e1, int e2, int g1, int g2, int e ) {
		this.idPartido = id;
		this.idRonda = ronda;
		this.idEquipo1 = e1;
		this.idEquipo2 = e2;
		this.golE1 = g1;
		this.golE2 = g2;
		this.ePartido = e;
	}
        
	
	public int estadoPartido(int g1, int g2) {
                int res = 0;
		if (g1 > g2) {
		res = 1; }
                if (g2 > g1){
                res = 2;
                }
                return res;
		}

	public int getIdPartido() {
		return idPartido;
	}

	public void setIdPartido(int idPartido) {
		this.idPartido = idPartido;
	}

	public int getIdRonda() {
		return idRonda;
	}

	public void setIdRonda(int idRonda) {
		this.idRonda = idRonda;
	}

	public int getIdEquipo1() {
		return idEquipo1;
	}

	public void setIdEquipo1(int idEquipo1) {
		this.idEquipo1 = idEquipo1;
	}

	public int getIdEquipo2() {
		return idEquipo2;
	}

	public void setIdEquipo2(int idEquipo2) {
		this.idEquipo2 = idEquipo2;
	}

	public int getGolE1() {
		return golE1;
	}

	public void setGolE1(int golE1) {
		this.golE1 = golE1;
	}

	public int getGolE2() {
		return golE2;
	}

	public void setGolE2(int golE2) {
		this.golE2 = golE2;
	}
	
	public int getEPartido() {
		return this.ePartido;
	}
	
	public void setEPartido(int e) {
		this.ePartido = e;
	}
	
	}
