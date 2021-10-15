package modelo;

// Atributo columna fue eliminado de la base de datos, ya no se utiliza
public class Posicion {
	 private Long id;
	 private int columna;
	 private int fila;
	 private double estado;
	 private long idEstanteFor;
	 
	 
	public Posicion() {
		
	}
	 
	public Posicion(Long id) {
		this.id = id;
	}
	public Posicion(int columna, int fila) {
		this.columna = columna;
		this.fila = fila;
	}
	public Posicion(double estado) {
		this.estado = estado;
	}
	public Posicion(long idEstanteFor) {
		this.idEstanteFor = idEstanteFor;
	}
	
	
	public Posicion(int fila, long idEstanteFor) {
		super();
		this.fila = fila;
		this.idEstanteFor = idEstanteFor;
	}
	public Posicion(int columna, int fila, long idEstanteFor) {
		this.columna = columna;
		this.fila = fila;
		this.idEstanteFor = idEstanteFor;
	}
	public Posicion(int columna, int fila, double estado, long idEstanteFor) {
		this.columna = columna;
		this.fila = fila;
		this.estado = estado;
		this.idEstanteFor = idEstanteFor;
	}
	public Posicion(Long id, int columna, int fila, double estado, long idEstanteFor) {
		this.id = id;
		this.columna = columna;
		this.fila = fila;
		this.estado = estado;
		this.idEstanteFor = idEstanteFor;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getColumna() {
		return columna;
	}
	public void setColumna(int columna) {
		this.columna = columna;
	}
	public int getFila() {
		return fila;
	}
	public void setFila(int fila) {
		this.fila = fila;
	}
	public double getEstado() {
		return estado;
	}
	public void setEstado(double estado) {
		this.estado = estado;
	}
	public long getIdEstanteFor() {
		return idEstanteFor;
	}
	public void setIdEstanteFor(long idEstanteFor) {
		this.idEstanteFor = idEstanteFor;
	}
}
