package modelo;

public class Serie {
	private long codigo;
	private String nombre;
	
	
	public Serie() {
		super();
	}


	public Serie(long codigo) {
		this.codigo = codigo;
	}

	
	public Serie(String nombre) {
		super();
		this.nombre = nombre;
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



	
	
}
