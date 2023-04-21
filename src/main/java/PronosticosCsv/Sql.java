package PronosticosCsv;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Sql {
	
	public Sql() {
		
	}
	
	public static List<Pronos> leerPronSQL(String ruta, String user, String pass) throws Exception{
                List<Pronos> res = new ArrayList<>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(ruta,user,pass);
		Statement stmt = con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from pronosticos");
		while(rs.next()){
		Pronos pron = new Pronos(rs.getInt(1),rs.getInt(2),rs.getString(3));
                res.add(pron);
                }
		
		con.close();
		return res;
	}
}


