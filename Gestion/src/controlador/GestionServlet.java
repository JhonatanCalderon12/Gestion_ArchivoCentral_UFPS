package controlador;

import java.io.*;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BloqueDao;
import dao.CajaDao;
import dao.EstanteDao;
import dao.LegajoDao;
import dao.PosicionDao;
import modelo.Bloque;
import modelo.Caja;
import modelo.Estante;
import modelo.Legajo;
import modelo.Posicion;

/**
 * Servlet implementation class GestionServlet
 */
@WebServlet({ "/GestionServlet", "/" })
public class GestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BloqueDao bloqueDao;
	EstanteDao estanteDao;
	PosicionDao posicionDao;
	CajaDao cajaDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GestionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init(ServletConfig config) throws ServletException {
		this.bloqueDao = new BloqueDao();
		this.estanteDao = new EstanteDao();
		this.posicionDao = new PosicionDao();
		this.cajaDao = new CajaDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/nuevo":
				verNuevo(request, response);
				break;
			case "/insertar":
				insertarBloque(request, response);
				break;
			case "/eliminar":
				eliminarBloque(request, response);
				break;
			case "/editar":
				editarNuevo(request, response);
				break;
			case "/actualizar":
				actualizarBloque(request, response);
				break;
			case "/insertarEstante":
				insertarEstante(request, response);
				break;
			case "/insertarCaja":
				insertarCaja(request, response);
				break;
			case "/listarCajas":
				listarCajas(request, response);
				break;
			case "/listarFilas":
				listarFilas(request, response);
				break;
			case "/insertarLegajo":
				insertarLegajo(request, response);
				break;
			default:
				listarBloque(request, response);
				break;
			}
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	// -------- CRUD BLOQUE ------------//
	private void listarBloque(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Bloque> lista = bloqueDao.selectAll();
		request.setAttribute("lista", lista);
		RequestDispatcher rd = request.getRequestDispatcher("bloqueList.jsp");
		rd.forward(request, response);
	}

	private void actualizarBloque(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		String letra = request.getParameter("letra");
		String ubicacion = request.getParameter("ubicacion");
		Bloque bloque = new Bloque(id, letra, ubicacion);
		bloqueDao.update(bloque);
		response.sendRedirect("list");
	}

	private void editarNuevo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		Bloque actual = bloqueDao.select(id);
		request.setAttribute("bloques", actual);
		RequestDispatcher rd = request.getRequestDispatcher("bloque.jsp");
		rd.forward(request, response);
	}

	private void eliminarBloque(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		bloqueDao.delete(id);
		response.sendRedirect("list");
	}

	private void insertarBloque(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String letra = request.getParameter("letra");
		String ubicacion = request.getParameter("ubicacion");
		Bloque bloque = new Bloque(letra, ubicacion);
		bloqueDao.insert(bloque);
		response.sendRedirect("list");
	}

	private void verNuevo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("bloque.jsp");
		rd.forward(request, response);
	}

	// ------- CRUD ESTANTE ----------//
	private void insertarEstante(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException, ServletException {

		int filas = Integer.parseInt(request.getParameter("selectFilaEstante"));
		String numeroEstante = request.getParameter("inputNEstante");
		String letraBloque = request.getParameter("cboBlock");
		int tipoEstante = Integer.parseInt(request.getParameter("selectTipoEstante"));
		Estante estante = new Estante(filas, numeroEstante, letraBloque, tipoEstante);
		estanteDao.insert(estante);
		insertarPosicion(request, response, numeroEstante, filas, tipoEstante);
	}

	// ------ CRUD POSICION ------- //
	private void insertarPosicion(HttpServletRequest request, HttpServletResponse response, String numeroEstante,
			int filas, int tipoEstante) throws ServletException, IOException, SQLException, ServletException {

		long nEstante = Long.parseLong(numeroEstante);
		double estado = 0;

		if (tipoEstante == 1) {
			estado = 3;
		} else {
			estado = 4.5;
		}

		int[] arrayFilas = new int[filas];
		for (int i = 0; i < filas; i++) {
			arrayFilas[i] = i + 1;
		}

		posicionDao.insert(arrayFilas, nEstante, filas, estado);
		response.sendRedirect("ListarEstantes");
	}

	// ------- CRUD CAJAS ----------//

	private void insertarCaja(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException, ServletException {

		int numeroCaja = Integer.parseInt(request.getParameter("nCaja"));
		// Codigo dependencia
		// Codigo serie
		// Codigo SubSerie
		String nombreDependencia = request.getParameter("nameNombreDependencia");
		String fechaDesde = request.getParameter("fechaDesde");
		String fechaHasta = request.getParameter("fechaHasta");
		String observaciones = request.getParameter("nameObservaciones");
		String retencion = request.getParameter("nameRetencion");
		String serie = request.getParameter("nameNombreSerie");
		String subserie = request.getParameter("nameNombreSubSerie");
		double tamanio = Double.parseDouble(request.getParameter("nameTamanio"));
		int numeroLegajos = Integer.parseInt(request.getParameter("nLegajos"));
		// Id dependencia

		int filaSelect = Integer.parseInt(request.getParameter("nameSelectFilas"));
		int numeroEstante = Integer.parseInt(request.getParameter("nameSelectEstantes"));


		Caja caja = new Caja(numeroCaja, nombreDependencia, fechaDesde, fechaHasta, observaciones, retencion, serie,
				subserie, tamanio, numeroLegajos);

		CajaDao cajaDao2 = new CajaDao();

		cajaDao2.insert(caja, filaSelect, numeroEstante, numeroLegajos);

		PosicionDao posDao = new PosicionDao();

		posDao.actualizarEstado(numeroEstante, tamanio, filaSelect);;
	}

	private void listarCajas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int numeroEstante = Integer.parseInt(request.getParameter("nameSelectEstantes"));
		int numeroFila = Integer.parseInt(request.getParameter("nameFila"));

		List<Caja> listaCaja = new ArrayList<>();
		listaCaja = cajaDao.selectAll();
		request.setAttribute("listaCaja", listaCaja);
		RequestDispatcher rd = request.getRequestDispatcher("caja.jsp");
		rd.forward(request, response);
	}

	private void listarFilas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EstanteDao estDao = new EstanteDao();
		int numeroEstante = Integer.parseInt(request.getParameter("nameSelectEstantes"));

		int cantidadFilas = estDao.selectCantFilas(numeroEstante);
		List<Estante> listaEstante = new ArrayList<>();

		Estante estante = new Estante(cantidadFilas);

		listaEstante.add(estante);
		request.setAttribute("listaEstante", listaEstante);
		RequestDispatcher rd = request.getRequestDispatcher("registrarCaja.jsp");
		// rd.forward(request, response);
	}
	
	//------------- CRUD LEGAJOS -------------
	

	private void insertarLegajo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		long idCaja = Long.parseLong(request.getParameter("nameSelectCajas"));
		int numeroLegajo = Integer.parseInt(request.getParameter("nameNumeroLegajo"));
		String expediente = request.getParameter("nameExpediente");
		String fechaDesde = request.getParameter("nameFechaDesde");
		String fechaHasta = request.getParameter("nameFechaHasta");
		int totalFolios = Integer.parseInt(request.getParameter("nameTotalFolios"));
		
		
		PrintWriter out = response.getWriter();
		out.print("id caja: " + idCaja);
		//Legajo legajo = new Legajo(idCaja,numeroLegajo,expediente,fechaDesde,fechaHasta,totalFolios);

		//LegajoDao legajoDao = new LegajoDao();

		//legajoDao.insert(legajo);
	}

}
