package dao;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;
 
public class ClienteDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/clientes?useSSL=false";
	private String jdbcUsername = "crud_administrador";
	private String jdbcPassword = "admin";
	private static final String INSERT_CLIENTES_SQL = "INSERT INTO clientes" + " (id_cliente, nombre_cliente, genero_cliente, direccion_cliente, ciudad_cliente, correo_cliente) VALUES "
			+ " (?, ?, ?, ?, ?, ?);";
	private static final String SELECT_CLIENTE_BY_ID = "select id_cliente,nombre_cliente,genero_cliente,direccion_cliente,ciudad_cliente,correo_cliente from clientes where id_cliente =?;";
	private static final String SELECT_ALL_CLIENTES = "select * from clientes";
	private static final String DELETE_CLIENTES_SQL = "delete from clientes where id_cliente = ?;";
	private static final String UPDATE_CLIENTES_SQL = "update clientes set nombre_cliente = ?,genero_cliente= ?, direccion_cliente =?, ciudad_cliente=?, correo_cliente=? where id_cliente = ?;";
 
	public ClienteDAO() {
	}
 
	protected Connection getConnection() {
		Connection connection = null;
		try {
//registra el driver de conexión para la base de datos
//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
 
	public void insertCliente(Cliente cliente) throws SQLException {
		System.out.println(INSERT_CLIENTES_SQL);
// Se conecta a la base de datos
		try (Connection connection = getConnection();
// Prepara la sentencia sql a ejecutar con el objeto conexion
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CLIENTES_SQL);) {
			preparedStatement.setInt(1, cliente.getId_cliente());
			preparedStatement.setString(2, cliente.getNombre_cliente());
			preparedStatement.setString(3, cliente.getGenero_cliente());
			preparedStatement.setString(4, cliente.getDireccion_cliente());
			preparedStatement.setString(5, cliente.getCiudad_cliente());
			preparedStatement.setString(6, cliente.getCorreo_cliente());
//System.out.println(preparedStatement);
// Ejecuta la consulta
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
 
// METODO PARA BUSCAR POR USUARIO (ID)
	public Cliente selectCliente(int id_cliente) {
		Cliente cliente = null;
//Se conecta a la base de datos
		try (Connection connection = getConnection();
//Prepara la sentencia sql a ejecutar con el objeto conexion
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CLIENTE_BY_ID);) {
			preparedStatement.setInt(1, id_cliente);
//System.out.println(preparedStatement);
//Ejecuta la consulta
			ResultSet rs = preparedStatement.executeQuery();
//Recorre los resultados y los devuelve en el objeto user
			while (rs.next()) {
				String nombre_cliente = rs.getString("Nombre_cliente");
				String genero_cliente = rs.getString("Genero_cliente");
				String direccion_cliente = rs.getString("Direccion_cliente");
				String ciudad_cliente = rs.getString("Ciudad_cliente");
				String correo_cliente = rs.getString("Correo_cliente");
				cliente = new Cliente(id_cliente, nombre_cliente, genero_cliente, direccion_cliente, ciudad_cliente, correo_cliente);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return cliente;
	}
 
//METODO PARA MOSTRAR TODA LA LISTA DE USUARIOS
	public List<Cliente> selectAllClientes() {
//crea el array para mostrar los resultados
		List<Cliente> clientes = new ArrayList<>();
//Conecta con la bd
		try (Connection connection = getConnection();
//Prepara la consulta sql
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CLIENTES);) {
//System.out.println(preparedStatement);
//Ejecuta la consulta y la almacena en un objeto ResultSet
			ResultSet rs = preparedStatement.executeQuery();
//Recorre el resultado y lo almacena en el objeto users
			while (rs.next()) {
				int id_cliente = rs.getInt("id_cliente");
				String nombre_cliente = rs.getString("nombre_cliente");
				String genero_cliente = rs.getString("genero_cliente");
				String direccion_cliente = rs.getString("direccion_cliente");
				String ciudad_cliente = rs.getString("ciudad_cliente");
				String correo_cliente = rs.getString("correo_cliente");
				clientes.add(new Cliente(id_cliente, nombre_cliente, genero_cliente, direccion_cliente, ciudad_cliente, correo_cliente));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return clientes;
	}
 
//METODO PARA BORRAR UN USUARIO DE LA BD
	public boolean deleteCliente(int id_cliente) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_CLIENTES_SQL);) {
			statement.setInt(1, id_cliente);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
 
	// METODO PARA ACTUALIZAR DATOS DE UN USUARIO GUARDADO EN BD
	public boolean updateCliente(Cliente cliente) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_CLIENTES_SQL);) {
			statement.setString(1, cliente.getNombre_cliente());
			statement.setString(2, cliente.getGenero_cliente());
			statement.setString(3, cliente.getDireccion_cliente());
			statement.setString(4, cliente.getCiudad_cliente());
			statement.setString(5, cliente.getCorreo_cliente());
			statement.setInt(6, cliente.getId_cliente());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
 
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}