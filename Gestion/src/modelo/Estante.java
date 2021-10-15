package modelo;

public class Estante {
	private Long id;
	private String numero;
	private int filas;
	private String bloque;
	private int tipo;

	public Estante() {

	}

	public Estante(int filas, String numero, String bloque, int tipo) {
		this.filas = filas;
		this.numero = numero;
		this.bloque = bloque;
		this.tipo = tipo;
	}
	
	public Estante(int filas, String numero) {
		this.numero = numero;
		this.filas = filas;
	}
	
	public Estante(Long id, String numero, int filas, String bloque) {
		this.id = id;
		this.numero = numero;
		this.filas = filas;
		this.bloque = bloque;

	}
	
	public Estante(int filas) {
		super();
		this.filas = filas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getFilas() {
		return filas;
	}

	public void setFilas(int filas) {
		this.filas = filas;
	}

	public String getBloque() {
		return bloque;
	}

	public void setBloque(String bloque) {
		this.bloque = bloque;
	}

	
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Estante [id=" + id + ", numero=" + numero + ", filas=" + filas
				+ ", bloque=" + bloque + "]";
	}

}
