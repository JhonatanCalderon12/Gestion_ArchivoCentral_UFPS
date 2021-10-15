package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Posicion;
import utils.Conexion;

public class PosicionDao {
private Conexion conexion;
	
	private static final String insertarSQL = "INSERT INTO posiciones (estado,fila,estante) VALUES (?,?,(SELECT id FROM estantes WHERE numero=?))";
	//private static final String actualizarSQL = "UPDATE posiciones SET estante=(SELECT id FROM estantes WHERE numero=?) WHERE id=?";
	private static final String actualizarSQL = "UPDATE posiciones SET estante=(SELECT id FROM estantes WHERE numero=?) WHERE id=(SELECT id FROM posiciones WHERE columna= ? AND fila=?)";
	private static final String actualizarEstado = "UPDATE posiciones SET estado=? WHERE id=(SELECT id FROM posiciones WHERE fila=? AND estante=(SELECT id FROM estantes WHERE numero=?))";
	private static final String seleccionarEstado = "SELECT estado FROM posiciones WHERE fila=? AND estante=(SELECT id FROM estantes WHERE numero=?)";
	private static final String seleccionarColumnaYfila = "SELECT * FROM posiciones";
	private static final String seleccionarIdPosicion = "SELECT id FROM posiciones WHERE columna=? AND fila=?;";
	
	public PosicionDao() {
		this.conexion= Conexion.getConexion();
	}
	
	public void insert(int[]filas, long numeroEstante, int cantFilas, double estado) throws SQLException {
		try {
			PreparedStatement ps = conexion.setPreparedStatement(insertarSQL);
			
			//Ciclo que inserta 6 registros con las filas cada que se agrega un estante nuevo
			
			for(int i=0; i<cantFilas;i++) {
				ps.setDouble(1, estado);
				ps.setInt(2, filas[i]);
				ps.setLong(3,numeroEstante);
				ps.executeUpdate();
			}
		} catch(SQLException e) {	
		}
	}
	
	public void actualizarEstado(int numeroEstante, double tamanio, int fila) {
		try {
			PreparedStatement ps = conexion.setPreparedStatement(actualizarEstado);
			double estadoActual = selectEstado(fila,numeroEstante);
			
			estadoActual = estadoActual - tamanio;
			
			ps.setDouble(1, estadoActual );
			ps.setInt(2, fila);
			ps.setInt(3, numeroEstante);
			ps.execute();
		} catch(SQLException e) {
			
		}
	}
	
	public double selectEstado(int fila, int numeroEstante) {
		double estado = 0;
		try {
			Conexion conexion=null;
			conexion = Conexion.getConexion();
			PreparedStatement ps = conexion.setPreparedStatement(seleccionarEstado);
			ps.setInt(1, fila);
			ps.setInt(2, numeroEstante);
			
			ResultSet rs = conexion.query();
			while(rs.next()) {
				estado=rs.getDouble("estado");
			}
		} catch(SQLException e) {
			
		}
		return estado;
		}
	public void update(Posicion posicion) throws SQLException {
		try {
			PreparedStatement ps = conexion.setPreparedStatement(actualizarSQL);
			ps.setLong(1, posicion.getIdEstanteFor());
			ps.setInt(2, posicion.getColumna());
			ps.setInt(3, posicion.getFila());
			ps.execute();
		} catch(SQLException e) {
			
		}
	}
	
	public List<Posicion> selectAll(){
		List<Posicion>posiciones =  new ArrayList<>();
		try {
			PreparedStatement ps = conexion.setPreparedStatement(seleccionarColumnaYfila);
			ResultSet rs = conexion.query();
			while(rs.next()) {
				int columna = rs.getInt("columna");
				int fila = rs.getInt("fila");
				
				posiciones.add(new Posicion(columna, fila));
			}
		} catch(SQLException e) {
			
		}
		return posiciones;
	}
	
	public Posicion selectIdPosicion(Posicion posicion) {
		long id;
		Posicion px=null;
		try {
			Conexion conexion=null;
			conexion = Conexion.getConexion();
			PreparedStatement ps = conexion.setPreparedStatement(seleccionarIdPosicion);
			ps.setInt(1, posicion.getColumna());
			ps.setInt(2, posicion.getFila());
			
			ResultSet rs = conexion.query();
			while(rs.next()) {
				id=rs.getLong("id");
			    px = new Posicion(id);
			}
		} catch(SQLException e) {
			
		}
		return px;
		}
}
