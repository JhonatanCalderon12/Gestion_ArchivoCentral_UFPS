package modelo;

public class Bloque {
	private Long id;
	private String letra;
	private String ubicacion;

	public Bloque() {
	}
	
	
	
	public Bloque(Long id) {
		super();
		this.id = id;
	}



	public Bloque(String letra, String ubicacion) {
		super();
		this.letra = letra;
		this.ubicacion = ubicacion;
	}

	public Bloque(Long id, String letra, String ubicacion) {
		this.id = id;
		this.letra = letra;
		this.ubicacion = ubicacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}



	@Override
	public String toString() {
		return "Bloque [id=" + id + ", letra=" + letra + ", ubicacion=" + ubicacion + "]";
	}
}
