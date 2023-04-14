package PronosticosCsv;

public class Equipos {
	private int id;
	private String desc;
	
	public Equipos(int id, String name) {
		this.id = id;
		this.desc = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	

}
