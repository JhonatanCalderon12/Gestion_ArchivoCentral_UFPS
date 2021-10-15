package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Dependencia;
import utils.Conexion;

public class DependenciaDao {
private Conexion conexion;
	
	private static final String seleccionarCodigoDep = "SELECT codigo_dep FROM dependencias WHERE nombre=?";
	private static final String seleccionarSQL = "SELECT * FROM dependencias;";
	
	public DependenciaDao() {
		this.conexion= Conexion.getConexion();
	}
	
	public List<Dependencia> selectAll(){
		List<Dependencia> dependencias =  new ArrayList<>();
		try {
			PreparedStatement ps = conexion.setPreparedStatement(seleccionarSQL);
			ResultSet rs = conexion.query();
			while(rs.next()) {
				Long id = rs.getLong("id");
				String nombre = rs.getString("nombre");
				String descripcion = rs.getString("descripcion");
				Long codigoDep = rs.getLong("codigo_dep");
				dependencias.add(new Dependencia(id,nombre,descripcion,codigoDep));
			}
		} catch(SQLException e) {
			
		}
		return dependencias;
	}
	
	
	public Dependencia select(String nombreDependencia){
		Dependencia dependencia = null ;
		try {
			System.out.println("Pasó el servlet la dependencia");
			//Conexion conexion=null;
			//conexion = Conexion.getConexion();
			System.out.println("Se hizo la conexión");
			PreparedStatement ps = conexion.setPreparedStatement(seleccionarCodigoDep);
			System.out.println("Se hizo el PreparedStatement");
			ps.setString(1, nombreDependencia);
			System.out.println("Se modificó la sentencia esta--> " + nombreDependencia + "sale?");
			ResultSet rs = conexion.query();
			
			System.out.print("Estoy a punto de entrar al while");
			while(rs.next()) {
				Long codigoDependencia = rs.getLong("codigo_dep");
				System.out.print("Toma el valor del codigoDependencia vea: " + codigoDependencia);
				dependencia = new Dependencia(codigoDependencia);
			}
		} catch(SQLException e) {
			System.out.print("No está tomando el código dep de la base de datos");
		}
		return dependencia;
	}
	
	public String selectNombreDependencia(HttpServletRequest request, HttpServletResponse response) {
		String nombre = request.getParameter("selectDependencia");
		
		return nombre;
		}
}
