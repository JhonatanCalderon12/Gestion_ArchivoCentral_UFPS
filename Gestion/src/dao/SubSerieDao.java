package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Serie;
import modelo.SubSerie;
import utils.Conexion;

public class SubSerieDao {
private Conexion conexion;
	
	private static final String seleccionarNombreSubSerie = "SELECT nombre FROM subseries";
	
	public SubSerieDao() {
		this.conexion= Conexion.getConexion();
	}
	
	public List<SubSerie> selectAll(){
		List<SubSerie> subseries =  new ArrayList<>();
		try {
			PreparedStatement ps = conexion.setPreparedStatement(seleccionarNombreSubSerie);
			ResultSet rs = conexion.query();
			while(rs.next()) {
				
				String nombreSubSerie = rs.getString("nombre");
				
				subseries.add(new SubSerie(nombreSubSerie));
			}
		} catch(SQLException e) {
			
		}
		return subseries;
	}
	
	
	public Serie select(String nombreDependencia){
		Serie serie = null ;
		try {
			
			//Conexion conexion=null;
			//conexion = Conexion.getConexion();
			
			PreparedStatement ps = conexion.setPreparedStatement(seleccionarNombreSubSerie);
			ResultSet rs = conexion.query();
			
			while(rs.next()) {
				String nombreSerie = rs.getString("nombre");
				serie = new Serie(nombreSerie);
			}
		} catch(SQLException e) {
			System.out.print("No está tomando el nombre de la serie de la base de datos");
		}
		return serie;
	}
	
	public String selectNombreDependencia(HttpServletRequest request, HttpServletResponse response) {
		String nombre = request.getParameter("selectDependencia");
		
		return nombre;
		}
}
