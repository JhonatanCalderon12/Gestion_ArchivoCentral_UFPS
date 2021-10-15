package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Serie;
import utils.Conexion;

public class SerieDao {
private Conexion conexion;
	
	private static final String seleccionarNombreSerie = "SELECT nombre FROM series";	
	
	public SerieDao() {
		this.conexion= Conexion.getConexion();
	}
	
	public List<Serie> selectAll(){
		List<Serie> series =  new ArrayList<>();
		try {
			PreparedStatement ps = conexion.setPreparedStatement(seleccionarNombreSerie);
			ResultSet rs = conexion.query();
			while(rs.next()) {
				String nombreSerie = rs.getString("nombre");
				series.add(new Serie(nombreSerie));
			}
		} catch(SQLException e) {
			
		}
		return series;
	}
	
	
	public Serie select(String nombreDependencia){
		Serie serie = null ;
		try {
			PreparedStatement ps = conexion.setPreparedStatement(seleccionarNombreSerie);
			ResultSet rs = conexion.query();
			
			while(rs.next()) {
				String nombreSerie = rs.getString("nombre");
				serie = new Serie(nombreSerie);
			}
		} catch(SQLException e) {
		}
		return serie;
	}
	
	public String selectNombreDependencia(HttpServletRequest request, HttpServletResponse response) {
		String nombre = request.getParameter("selectDependencia");
		
		return nombre;
		}
}
