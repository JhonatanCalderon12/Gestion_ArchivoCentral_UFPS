package modelo;

import java.sql.Date;

public class Caja {
	private long idCaja;//ya
	private int numeroCaja;//ya
	private String codigoDependencia;// obtener
	private String codigoSerie; //obtener
	private String codigoSubserie;//obtener
	private String dependencia; //ya
	
	private String fechaDesde;//ya
	private String fechaHasta;//ya
	
	private String observaciones;//ya
	private String retencion;//ya
	private String serie;//ya
	private String subserie;//ya
	private double tamanio; //ya
	private long idDependenciaFor;
	private long idPosicionFor;
	private int nLegajos;//ya
	
	public Caja(long idCaja) {
		this.idCaja = idCaja;
	}

	
	public Caja(int numeroCaja) {
		this.numeroCaja = numeroCaja;
	}


	public Caja(String codigoDependencia, String dependencia) {
		this.codigoDependencia = codigoDependencia;
		this.dependencia = dependencia;
	}
	
	public Caja(String codigoDependencia, String codigoSerie, String codigoSubserie, String dependencia, String serie,
			String subserie) {
		this.codigoDependencia = codigoDependencia;
		this.codigoSerie = codigoSerie;
		this.codigoSubserie = codigoSubserie;
		this.dependencia = dependencia;
		this.serie = serie;
		this.subserie = subserie;
	}


	public Caja(int numeroCaja, String dependencia, String fechaDesde, String fechaHasta, String observaciones,
			String retencion, String serie, String subserie, double tamanio, int nLegajos) {
		super();
		this.numeroCaja = numeroCaja;
		this.dependencia = dependencia;
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
		this.observaciones = observaciones;
		this.retencion = retencion;
		this.serie = serie;
		this.subserie = subserie;
		this.tamanio = tamanio;
		this.nLegajos = nLegajos;
	}

	public Caja(long idCaja, int numeroCaja, String codigoDependencia, String codigoSerie, String codigoSubserie,
			String dependencia, String fechaDesde, String fechaHasta, String observaciones, String retencion, String serie,
			String subserie, double tamanio, long idDependenciaFor, long idPosicionFor, int nLegajos) {
		this.idCaja = idCaja;
		this.numeroCaja = numeroCaja;
		this.codigoDependencia = codigoDependencia;
		this.codigoSerie = codigoSerie;
		this.codigoSubserie = codigoSubserie;
		this.dependencia = dependencia;
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
		this.observaciones = observaciones;
		this.retencion = retencion;
		this.serie = serie;
		this.subserie = subserie;
		this.tamanio = tamanio;
		this.idDependenciaFor = idDependenciaFor;
		this.idPosicionFor = idPosicionFor;
		this.nLegajos = nLegajos;
	}

	
	
	public Caja(int numeroCaja, String dependencia, String serie, String subserie) {
		super();
		this.numeroCaja = numeroCaja;
		this.dependencia = dependencia;
		this.serie = serie;
		this.subserie = subserie;
	}


	public long getIdCaja() {
		return idCaja;
	}

	public void setIdCaja(long idCaja) {
		this.idCaja = idCaja;
	}

	public int getNumeroCaja() {
		return numeroCaja;
	}

	public void setNumeroCaja(int numeroCaja) {
		this.numeroCaja = numeroCaja;
	}

	public String getCodigoDependencia() {
		return codigoDependencia;
	}

	public void setCodigoDependencia(String codigoDependencia) {
		this.codigoDependencia = codigoDependencia;
	}

	public String getCodigoSerie() {
		return codigoSerie;
	}

	public void setCodigoSerie(String codigoSerie) {
		this.codigoSerie = codigoSerie;
	}

	public String getCodigoSubserie() {
		return codigoSubserie;
	}

	public void setCodigoSubserie(String codigoSubserie) {
		this.codigoSubserie = codigoSubserie;
	}

	public String getDependencia() {
		return dependencia;
	}

	public void setDependencia(String dependencia) {
		this.dependencia = dependencia;
	}

	public String getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(String fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public String getFechasHasta() {
		return fechaHasta;
	}

	public void setFechasHasta(String fechasHasta) {
		this.fechaHasta = fechasHasta;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getRetencion() {
		return retencion;
	}

	public void setRetencion(String retencion) {
		this.retencion = retencion;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getSubserie() {
		return subserie;
	}

	public void setSubserie(String subserie) {
		this.subserie = subserie;
	}

	public double getTamanio() {
		return tamanio;
	}

	public void setTamanio(double tamanio) {
		this.tamanio = tamanio;
	}

	public long getIdDependenciaFor() {
		return idDependenciaFor;
	}

	public void setIdDependenciaFor(long idDependenciaFor) {
		this.idDependenciaFor = idDependenciaFor;
	}

	public long getIdPosicionFor() {
		return idPosicionFor;
	}

	public void setIdPosicionFor(long idPosicionFor) {
		this.idPosicionFor = idPosicionFor;
	}

	public int getnLegajos() {
		return nLegajos;
	}

	public void setnLegajos(int nLegajos) {
		this.nLegajos = nLegajos;
	}
	
	

	
}

