/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import BD.conexion;
import modelo.TrabajadorModel;
import java.sql.ResultSet;

public class LoginDAO {
    int rspta=0;
    String sql="";
    ResultSet rs=null;
    conexion cn=new conexion();
    public int validarLogin(TrabajadorModel tm) throws Exception{
        sql="SELECT COUNT(CODTRABAJADOR) AS cantidad FROM `trabajador` WHERE USUARIO='"+tm.getUsuario()+"' AND CLAVE='"+tm.getClave()+"'";
        rs=cn.ejecutarConsulta(sql);
        while(rs.next()){
            rspta=rs.getInt("cantidad");
        }
    return  rspta;
    }
    
}
