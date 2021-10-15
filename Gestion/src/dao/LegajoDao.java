package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Estante;
import modelo.Legajo;
import utils.Conexion;

public class LegajoDao {
private Conexion conexion;
	
	private static final String insertarSQL = "INSERT INTO legajos (n_legajo,expediente,fecha_desde,fecha_hasta, total_folios, caja) Values (?,?,?,?,?,?)";
    private static final String eliminarSQL = "DELETE FROM estantes WHERE id = ?;";
	private static final String actualizarSQL = "UPDATE estantes SET columnas=?,filas=?,numero=?,bloque=(SELECT bloque FROM bloques WHERE letra=?) WHERE id=?;";
	private static final String seleccionarID = "SELECT * from estantes WHERE id=?;";
	private static final String seleccionarSQL = "SELECT * from estantes;";
	private static final String seleccionarCantidadFilas = "SELECT filas FROM estantes WHERE id=(SELECT id FROM estantes WHERE numero=?);";
	
	public LegajoDao() {
		this.conexion= Conexion.getConexion();
	}
	
	public void insert(Legajo legajo) throws SQLException {
		try {
			PreparedStatement ps = conexion.setPreparedStatement(insertarSQL);
			ps.setInt(1, legajo.getNumeroLegajo());
			ps.setString(2, legajo.getExpediente());
			ps.setString(3,legajo.getFechaDesde());
			ps.setString(4, legajo.getFechaHasta());
			ps.setInt(5, legajo.getFolios());
			ps.setLong(6, legajo.getIdCaja());
			ps.executeUpdate();
		} catch(SQLException e) {
			
		}
	}
}
