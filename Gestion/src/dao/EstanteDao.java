package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Estante;
import utils.Conexion;

public class EstanteDao {
private Conexion conexion;
	
	private static final String insertarSQL = "INSERT INTO estantes (filas,numero,bloque,tipo) Values (?,?,(SELECT id FROM bloques WHERE letra=?),?)";
    private static final String eliminarSQL = "DELETE FROM estantes WHERE id = ?;";
	private static final String actualizarSQL = "UPDATE estantes SET columnas=?,filas=?,numero=?,bloque=(SELECT bloque FROM bloques WHERE letra=?) WHERE id=?;";
	private static final String seleccionarID = "SELECT * from estantes WHERE id=?;";
	private static final String seleccionarSQL = "SELECT * from estantes;";
	private static final String seleccionarCantidadFilas = "SELECT filas FROM estantes WHERE id=(SELECT id FROM estantes WHERE numero=?);";
	
	public EstanteDao() {
		this.conexion= Conexion.getConexion();
	}
	
	public void insert(Estante estante) throws SQLException {
		try {
			PreparedStatement ps = conexion.setPreparedStatement(insertarSQL);
			ps.setInt(1, estante.getFilas());
			ps.setString(2, estante.getNumero());
			ps.setString(3,estante.getBloque());
			ps.setInt(4, estante.getTipo());
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
	
	public void update(Estante estante) throws SQLException {
		try {
			PreparedStatement ps = conexion.setPreparedStatement(actualizarSQL);
			ps.setInt(2, estante.getFilas());
			ps.setString(3, estante.getNumero());
			ps.setString(4, estante.getBloque());
			ps.setLong(5, estante.getId());
			
			conexion.execute();
		} catch(SQLException e) {
			
		}
	}
	
	public List<Estante> selectAll(){
		List<Estante> estantes =  new ArrayList<>();
		try {
			PreparedStatement ps = conexion.setPreparedStatement(seleccionarSQL);
			ResultSet rs = conexion.query();
			while(rs.next()) {
				Long id = rs.getLong("id");
				String numero = rs.getString("numero");
				int filas = rs.getInt("filas");
				String bloque = rs.getString("bloque");
				estantes.add(new Estante(id,numero,filas,bloque));
			}
		} catch(SQLException e) {
			
		}
		return estantes;
	}
	
	public int selectCantFilas(int numeroEstante){
		
		String numEstante = "";
		numEstante = String.valueOf(numeroEstante);
		int cantFilas = 0;
		try {
			PreparedStatement ps = conexion.setPreparedStatement(seleccionarCantidadFilas);
			ps.setString(1, numEstante);
			ResultSet rs = conexion.query();
			while(rs.next()) {
				cantFilas = rs.getInt("filas");
			}
		} catch(SQLException e) {
			
		}
		return cantFilas;
	}	
	public Estante select(long id){
		Estante estante = null ;
		try {
			PreparedStatement ps = conexion.setPreparedStatement(seleccionarID);
			ps.setLong(1, id);
			ResultSet rs = conexion.query();
			while(rs.next()) {
				String numero = rs.getString("numero");
				int filas= rs.getInt("filas");
				String bloque = rs.getString("bloque");
				estante= new Estante(id,numero,filas,bloque);
			}
		} catch(SQLException e) {
			
		}
		return estante;
	}	
}
