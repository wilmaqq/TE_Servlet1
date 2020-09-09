/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes;

import static java.io.FileDescriptor.out;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yurik
 */
@WebServlet(name = "UsoSession", urlPatterns = {"/UsoSession"})
public class UsoSession extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UsoSession</title>");            
            out.println("</head>");
            out.println("<body>");
            HttpSession session = request.getSession(true);
            Date created = new Date(session.getCreationTime());
            Date accessed = new Date(session.getLastAccessedTime());
            out.println("ID: " + session.getId() + "<br>");
            out.println("Creado: " + created + "<br>");
            out.println("Ultimo acceso: " + accessed + "<br>");
            out.println("Universidad: UPEA <br>");
            
            
            //Introducir un dato de session
            String nomDato =request.getParameter("nomDato");
            if (nomDato != null && nomDato.length() > 0){
                String valor =request.getParameter("valor");
                session.setAttribute(nomDato, valor);
            }
            //Mostrar datos de la session
            Enumeration e = session.getAttributeNames();
            while (e.hasMoreElements()){
                String nombre = (String) e.nextElement();
                String valor = session.getAttribute(nombre).toString ();
                out.println(nombre + " = " + valor + "<br>");
            }
            out.println("</body>");
            out.println("</html>");
        }finally {
            out.close();
        }
    }  
}
