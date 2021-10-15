package modelo;

public class Dependencia {
	private long id_dependencia;
	private String nombre;
	private String descripcion;
	private long codigoDependencia;

	public Dependencia() {
		super();
	}

	public Dependencia(long codigoDependencia) {
		this.codigoDependencia = codigoDependencia;
	}

	public Dependencia(long id_dependencia, String nombre, String descripcion, long codigoDependencia) {
		this.id_dependencia = id_dependencia;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.codigoDependencia = codigoDependencia;
	}

	public long getId_dependencia() {
		return id_dependencia;
	}

	public void setId_dependencia(long id_dependencia) {
		this.id_dependencia = id_dependencia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public long getCodigoDependencia() {
		return codigoDependencia;
	}

	public void setCodigoDependencia(long codigoDependencia) {
		this.codigoDependencia = codigoDependencia;
	}



}
