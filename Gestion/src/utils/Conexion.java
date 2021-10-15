package utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Conexion {
	private Connection con = null;
	private static Conexion cdb;
	private PreparedStatement ps;
	
	private static final String url = "jdbc:mysql://localhost:3306/";
	private static final String db = "db_archivo_ejemplo";
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String user = "root";
	private static final String pass ="";
	

	public Conexion() {
		try {
			Class.forName(driver).getDeclaredConstructor().newInstance();
			con = ((Connection)DriverManager.getConnection(url+db,user,pass));
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cerrarConexion() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Conexion getConexion() {
		if(cdb==null) {
			cdb = new Conexion();
		}
		return cdb;
	}
	
	public ResultSet query() throws SQLException {
		ResultSet rs = ps.executeQuery();
		return rs;
	}
	
	public int execute() throws SQLException{
		int result = ps.executeUpdate();
		return result;
	}
	
	public Connection getCon(){
		return this.con;
	}
	
	public PreparedStatement setPreparedStatement(String sql) throws SQLException{
		this.ps= con.prepareStatement(sql);
		return this.ps;
	}
}
