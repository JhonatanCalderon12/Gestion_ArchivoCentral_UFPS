package modelo;

public class SubSerie {

	private long codigo;
	private String nombre;
	private Long idSerieFor;
	
	
	public SubSerie(long codigo) {
		this.codigo = codigo;
	}


	public SubSerie(String nombre) {
		super();
		this.nombre = nombre;
	}


	public SubSerie(Long idSerieFor) {
		super();
		this.idSerieFor = idSerieFor;
	}


	public SubSerie(long codigo, String nombre, Long idSerieFor) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.idSerieFor = idSerieFor;
	}


	public long getCodigo() {
		return codigo;
	}


	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Long getIdSerieFor() {
		return idSerieFor;
	}


	public void setIdSerieFor(Long idSerieFor) {
		this.idSerieFor = idSerieFor;
	}
}
