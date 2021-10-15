package dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import modelo.Bloque;
import modelo.Caja;
import modelo.Estante;
import utils.Conexion;

public class CajaDao {
private Conexion conexion;  // mod: static
	
	private static final String insertarSQL = "INSERT INTO cajas (ncaja,codigo_dependencia,codigo_serie,codigo_subserie,dependencia,fecha_desde,fecha_hasta,observaciones,retencion,serie,subserie,tamanio,dependencia_object,posicion,n_legajos) Values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";    
    private static final String eliminarSQL = "DELETE FROM estantes WHERE id = ?;";
	private static final String actualizarSQL = "UPDATE estantes SET columnas=?,filas=?,numero=?,bloque=(SELECT bloque FROM bloques WHERE letra=?) WHERE id=?;";
	private static final String actualizarEspacio = "UPDATE posiciones SET estado=? WHERE id=?;";
	private static final String seleccionarEstado = "SELECT estado from posiciones WHERE id=?;";
	private static final String seleccionarID = "SELECT * from estantes WHERE id=?;";
	private static final String seleccionarDependencia = "SELECT * FROM dependencias WHERE nombre=?";
	private static final String seleccionarSerie = "SELECT * FROM series WHERE nombre=?";
	private static final String seleccionarSubSerie = "SELECT * FROM subseries WHERE nombre=?";
	private static final String seleccionarEstantes = "SELECT * FROM estantes WHERE numero=?";
	private static final String seleccionarPosicion = "SELECT * FROM posiciones WHERE fila=? AND estante=?";
	private static final String seleccionarNumeroCaja = "SELECT nCaja FROM cajas WHERE posicion=(SELECT id FROM posiciones WHERE fila=? AND estante=(SELECT id FROM estantes WHERE numero=?))";
	private static final String seleccionarSQL = "SELECT * from cajas;";
	//private static final String seleccionarNumeroCaja = "SELECT * FROM cajas";
	public CajaDao() {
		this.conexion= Conexion.getConexion();
		
	}

	
	public void insert(Caja caja, int fila, int numeroEstante, int numeroLegajos){
		
			
		System.out.println("estás en cajaDao");
		try {
			System.out.println("estás en el try del cajaDao");
			PreparedStatement ps = conexion.setPreparedStatement(seleccionarDependencia);
			ps.setString(1, caja.getDependencia());
			long idDependencia=0;
			long codigoDependencia=0;
			ResultSet rs = conexion.query();
			while(rs.next()) {
				idDependencia = rs.getLong("id");
				codigoDependencia = rs.getLong("codigo_dep");
			}
			
			//--------------------------------
			
			PreparedStatement ps2 = conexion.setPreparedStatement(seleccionarSerie);
			ps2.setString(1, caja.getSerie());
			String codigoSerie = "";
			ResultSet rs2 = conexion.query();
			while(rs2.next()) {
				codigoSerie = rs2.getString("codigo_serie");
			}
			//--------------------------------
			PreparedStatement ps3 = conexion.setPreparedStatement(seleccionarSubSerie);
			ps3.setString(1, caja.getSubserie());
			String codigoSubSerie = "";
			ResultSet rs3 = conexion.query();
			while(rs3.next()) {
				codigoSubSerie = rs3.getString("codigo_subserie");
			}
			//--------------------------------
			PreparedStatement ps4 = conexion.setPreparedStatement(seleccionarEstantes);
			ps4.setInt(1, numeroEstante);
			long idEstante =0;
			ResultSet rs4 = conexion.query();
			while(rs4.next()) {
				idEstante = rs4.getLong("id");
			}
			//--------------------------------
			PreparedStatement ps5 = conexion.setPreparedStatement(seleccionarPosicion);
			ps5.setInt(1, fila);
			ps5.setLong(2, idEstante);
			long idPosicion=0;
			ResultSet rs5 = conexion.query();
			while(rs5.next()) {
				idPosicion = rs5.getLong("id");
			}
			//--------------------------------
			
			
			System.out.println("Estás en Dao de caja");
			System.out.println("idDependcia: " + idDependencia);
			System.out.println("codigo dep: " + codigoDependencia);
			System.out.println("codigo serie: " + codigoSerie);
			System.out.println("codigo subserie: " + codigoSubSerie);
			System.out.println("id estante: " + idEstante);
			System.out.println("id posicion: " + idPosicion);
			
			
			//--------------------------------
			
			PreparedStatement ps6 = conexion.setPreparedStatement(insertarSQL);
			ps6.setInt(1, caja.getNumeroCaja());
			ps6.setLong(2, codigoDependencia);
			ps6.setString(3, codigoSerie);
			ps6.setString(4, codigoSubSerie);
			ps6.setString(5, caja.getDependencia());
			ps6.setString(6, caja.getFechaDesde());
			ps6.setString(7, caja.getFechasHasta());
			ps6.setString(8, caja.getObservaciones());
			ps6.setString(9, caja.getRetencion());
			ps6.setString(10, caja.getSerie());
			ps6.setString(11, caja.getSubserie());
			ps6.setDouble(12, caja.getTamanio());
			ps6.setLong(13, idDependencia);
			ps6.setLong(14, idPosicion);
			ps6.setLong(15, numeroLegajos);
			
			//conexion.execute();
			ps6.executeUpdate();
			
			double tamanioResta = caja.getTamanio();
			long idPosicionResta = idPosicion;
			
			
			
		} catch(SQLException e) {
			
		}
		
	}
	
	public void restarEspacio(double tamanio, long idPosicion) {
		
		//Traemos el estado de la posicion en la base de datos
		
		int estadoActual = 0;
		try {
			PreparedStatement ps = conexion.setPreparedStatement(seleccionarEstado);
			ps.setLong(1, idPosicion);
			//ps.setInt(2, numeroEstante);
			ResultSet rs = conexion.query();
		}catch(Exception e) {
			
		}
		//Tipo de caja: pequeña, mediana, grande
	
	}
	
/*	public List<Caja> selectAll(int numeroFila, int numeroEstante){
	//public List<Caja> selectAll(){
		List<Caja> cajas =  new ArrayList<>();
		int ncaja=0;
		try {
			PreparedStatement ps = conexion.setPreparedStatement(seleccionarNumeroCaja);
			ps.setInt(1, numeroFila);
			ps.setInt(2, numeroEstante);
			ResultSet rs = conexion.query();
			
			while(rs.next()) {
				ncaja = rs.getInt("ncaja");
				cajas.add(new Caja(ncaja));
			}
		} catch(SQLException e) {
			
		}
		return cajas;
	}*/
	
	public List<Caja> selectAll(){
		List<Caja> cajas =  new ArrayList<>();
		try {
			PreparedStatement ps = conexion.setPreparedStatement(seleccionarSQL);
			ResultSet rs = conexion.query();
			while(rs.next()) {
				int numCaja = rs.getInt("ncaja");
				String nombreDependencia = rs.getString("dependencia");
				String nombreSerie = rs.getString("serie");
				String nombreSubSerie = rs.getString("subserie");
				cajas.add(new Caja(numCaja, nombreDependencia, nombreSerie, nombreSubSerie));
			}
		} catch(SQLException e) {
			
		}
		return cajas;
	}

}
