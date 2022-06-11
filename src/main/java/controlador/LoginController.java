/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.LoginDAO;
import modelo.TrabajadorModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            TrabajadorModel tm=new TrabajadorModel();
            LoginDAO lg=new LoginDAO();
            int rspta=0;
            if(request.getParameter("btn-login")!=null){
            String usuario=request.getParameter("txtusuario");
            String clave=request.getParameter("txtclave");
            tm.setUsuario(usuario);
            tm.setClave(clave);
                try {
                    rspta=lg.validarLogin(tm);
                } catch (Exception ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
              if(rspta!=0){
                  response.sendRedirect("/CRUDJAVA/loginSuccess");
              }else{
                  response.sendRedirect("/CRUDJAVA/login.jsp?rspta="+rspta);
              } 
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
