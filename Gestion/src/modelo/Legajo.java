package modelo;

public class Legajo {
	long id;
	int numeroLegajo;
	String expediente;
	String fechaDesde;
	String fechaHasta;
	int folios;
	long idCaja;
	
	
	public Legajo() {
		super();
	}


	public Legajo(long id, int numeroLegajo, String expediente, String fechaDesde, String fechaHasta, int folios,
			long idCaja) {
		super();
		this.id = id;
		this.numeroLegajo = numeroLegajo;
		this.expediente = expediente;
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
		this.folios = folios;
		this.idCaja = idCaja;
	}

	public Legajo(long idCaja, int numeroLegajo, String expediente, String fechaDesde, String fechaHasta, int folios) {
		this.numeroLegajo = numeroLegajo;
		this.expediente = expediente;
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
		this.folios = folios;
		this.idCaja = idCaja;
	}
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public int getNumeroLegajo() {
		return numeroLegajo;
	}


	public void setNumeroLegajo(int numeroLegajo) {
		this.numeroLegajo = numeroLegajo;
	}


	public String getExpediente() {
		return expediente;
	}


	public void setExpediente(String expediente) {
		this.expediente = expediente;
	}


	public String getFechaDesde() {
		return fechaDesde;
	}


	public void setFechaDesde(String fechaDesde) {
		this.fechaDesde = fechaDesde;
	}


	public String getFechaHasta() {
		return fechaHasta;
	}


	public void setFechaHasta(String fechaHasta) {
		this.fechaHasta = fechaHasta;
	}


	public int getFolios() {
		return folios;
	}


	public void setFolios(int folios) {
		this.folios = folios;
	}


	public long getIdCaja() {
		return idCaja;
	}


	public void setIdCaja(int idCaja) {
		this.idCaja = idCaja;
	}
	
	
	
}
