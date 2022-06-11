/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class conexion {
     public static String jdbcURL = "jdbc:mysql://localhost/clientes";
    public static String jdbcUsername = "crud_administrador";
    public static String jdbcPassword = "admin";
    public static String clase = "com.mysql.jdbc.Driver";
    PreparedStatement ps=null;

    public static Connection conectar() {
        Connection conexion = null;
        try {
            Class.forName(clase);
            conexion = (Connection) DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            System.out.println("Conexion establecida..");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return conexion;
    }
    public ResultSet ejecutarConsulta(String sql) throws Exception{
    Statement st=null;
    st=conectar().createStatement();
    ResultSet rs=st.executeQuery(sql);
    return rs;
    }
    public int ejecutarActualizacionP(String sql,Object[] params)throws SQLException{
        ps=conectar().prepareStatement(sql);
        //definir los valores para los argumentos
        for(int i=0;i<params.length;i++){
                ps.setObject(i+1,params[i]);
                }
        int r=ps.executeUpdate(); //retorna la cantidad de registros actualizados    
        return r;   
    }
    public void desconectar() throws SQLException{
    conectar().close();
    }
    
}
