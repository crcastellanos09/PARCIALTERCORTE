package controlador;
 
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ClienteDAO;
import modelo.Cliente;
 
@WebServlet("/")
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClienteDAO clienteDAO;
 
	public void init() {
		clienteDAO = new ClienteDAO();
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertCliente(request, response);
				break;
			case "/delete":
				deleteCliente(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateCliente(request, response);
				break;
			case "/loginSuccess":
				showInicio(request, response);
				break;
			case "/logOut":
				showLogin(request, response);
				break;
			case "/mainPage":
				showMainPage(request, response);
				break;
			default:
				listCliente(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
 
	private void listCliente(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Cliente> listCliente = clienteDAO.selectAllClientes();
		request.setAttribute("listCliente", listCliente);
		RequestDispatcher dispatcher = request.getRequestDispatcher("cliente-list.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("cliente-form.jsp");
		dispatcher.forward(request, response);
	}
 
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
		Cliente existingCliente = clienteDAO.selectCliente(id_cliente);
		RequestDispatcher dispatcher = request.getRequestDispatcher("cliente-form.jsp");
		request.setAttribute("cliente", existingCliente);
		dispatcher.forward(request, response);
	}
	
	private void showInicio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("inicio.jsp");
		dispatcher.forward(request, response);
	}

	private void showMainPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("inicio.jsp");
		dispatcher.forward(request, response);
	}
 
	private void insertCliente(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// convertir caracteres a UTF-8
		request.setCharacterEncoding("UTF-8");
		String nombre_cliente = request.getParameter("nombre_cliente");
		String genero_cliente = request.getParameter("genero_cliente");
		String direccion_cliente = request.getParameter("direccion_cliente");
		String ciudad_cliente = request.getParameter("ciudad_cliente");
		String correo_cliente = request.getParameter("correo_cliente");
		Cliente newCliente = new Cliente(nombre_cliente, genero_cliente, direccion_cliente, ciudad_cliente, correo_cliente);
		clienteDAO.insertCliente(newCliente);
		response.sendRedirect("list");
	}
 
	private void updateCliente(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// convertir caracteres a UTF-8
		request.setCharacterEncoding("UTF-8");
		int id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
		String nombre_cliente = request.getParameter("nombre_cliente");
		String genero_cliente = request.getParameter("genero_cliente");
		String direccion_cliente = request.getParameter("direccion_cliente");
		String ciudad_cliente = request.getParameter("ciudad_cliente");
		String correo_cliente = request.getParameter("correo_cliente");
		Cliente book = new Cliente(id_cliente, nombre_cliente, genero_cliente, direccion_cliente, ciudad_cliente, correo_cliente);
		clienteDAO.updateCliente(book);
		response.sendRedirect("list");
	}
 
	private void deleteCliente(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
		clienteDAO.deleteCliente(id_cliente);
		response.sendRedirect("list");
	}
	
	private void showLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
}