package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Bloque;
import utils.Conexion;

public class BloqueDao {
private Conexion conexion;
	
	private static final String insertarSQL = "INSERT INTO bloques (letra,ubicacion) VALUES (?,?)";
	private static final String eliminarSQL = "DELETE FROM bloques WHERE id = ?";
	private static final String actualizarSQL = "UPDATE bloques SET letra=?,ubicacion=? WHERE id=?;";
	private static final String seleccionarID = "SELECT * from bloques WHERE id=?;";
	private static final String seleccionarSQL = "SELECT * from bloques;";
	
	public BloqueDao() {
		this.conexion= Conexion.getConexion();
	}
	
	public void insert(Bloque bloque) throws SQLException {
		try {
			PreparedStatement ps = conexion.setPreparedStatement(insertarSQL);
			ps.setString(1, bloque.getLetra());
			ps.setString(2, bloque.getUbicacion());
			ps.executeUpdate();
		} catch(SQLException e) {
			
		}
	}
	
	public void delete(Long id) throws SQLException {
		try {
			PreparedStatement ps = conexion.setPreparedStatement(eliminarSQL);
			ps.setLong(1, id);
			conexion.execute();
		} catch(SQLException e) {
			
		}
	}
	
	public void update(Bloque bloque) throws SQLException {
		try {
			PreparedStatement ps = conexion.setPreparedStatement(actualizarSQL);
			ps.setString(1, bloque.getLetra());
			ps.setString(2, bloque.getUbicacion());
			ps.setLong(3, bloque.getId());
			
			conexion.execute();
		} catch(SQLException e) {
			
		}
	}
	
	public List<Bloque> selectAll(){
		List<Bloque> bloques =  new ArrayList<>();
		try {
			PreparedStatement ps = conexion.setPreparedStatement(seleccionarSQL);
			ResultSet rs = conexion.query();
			while(rs.next()) {
				Long id = rs.getLong("id");
				String letra = rs.getString("letra");
				String ubicacion = rs.getString("ubicacion");
				bloques.add(new Bloque(id,letra,ubicacion));
			}
		} catch(SQLException e) {
			
		}
		return bloques;
	}
	
	public Bloque select(long id){
		Bloque bloque = null ;
		try {
			PreparedStatement ps = conexion.setPreparedStatement(seleccionarID);
			ps.setLong(1, id);
			ResultSet rs = conexion.query();
			while(rs.next()) {
				String letra = rs.getString("letra");
				String ubicacion = rs.getString("ubicacion");
				bloque= new Bloque(id,letra,ubicacion);
			}
		} catch(SQLException e) {
			
		}
		return bloque;
	}

}
