package modelo;
 
public class Cliente implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
// atributos
	protected int id_cliente;
	protected String nombre_cliente;
	protected String genero_cliente;
	protected String direccion_cliente;
	protected String ciudad_cliente;
	protected String correo_cliente;
 
//constructor vacío
	public Cliente() {
	}
 
	public Cliente(String nombre_cliente, String genero_cliente, String direccion_cliente, String ciudad_cliente, String correo_cliente) {
		this.nombre_cliente = nombre_cliente;
		this.genero_cliente = genero_cliente;
		this.direccion_cliente = direccion_cliente;
		this.ciudad_cliente = ciudad_cliente;
		this.correo_cliente = correo_cliente;
		
	}
 
	public Cliente(int id_cliente, String nombre_cliente, String genero_cliente, String direccion_cliente, String ciudad_cliente, String correo_cliente) {
		this.id_cliente = id_cliente;
		this.nombre_cliente = nombre_cliente;
		this.genero_cliente = genero_cliente;
		this.direccion_cliente = direccion_cliente;
		this.ciudad_cliente = ciudad_cliente;
		this.correo_cliente = correo_cliente;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public String getGenero_cliente() {
		return genero_cliente;
	}

	public void setGenero_cliente(String genero_cliente) {
		this.genero_cliente = genero_cliente;
	}

	public String getDireccion_cliente() {
		return direccion_cliente;
	}

	public void setDireccion_cliente(String direccion_cliente) {
		this.direccion_cliente = direccion_cliente;
	}

	public String getCiudad_cliente() {
		return ciudad_cliente;
	}

	public void setCiudad_cliente(String ciudad_cliente) {
		this.ciudad_cliente = ciudad_cliente;
	}
	
	public String getCorreo_cliente() {
		return correo_cliente;
	}

	public void setCorreo_cliente(String correo_cliente) {
		this.correo_cliente = correo_cliente;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
 
	
