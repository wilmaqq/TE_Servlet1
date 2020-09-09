/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes;

import static java.io.FileDescriptor.out;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yurik
 */
@WebServlet(name = "LeeParametrosGet", urlPatterns = {"/LeeParametrosGet"})
public class LeeParametrosGet extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LeeParametrosGet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LeeParametros GET </h1>");
            String color = request.getParameter("color");
            String numero = request.getParameter("numero");
            if (color != null || numero != null){
                out.println("Su color es : <strong>" + color + "</strong><br>");
                out.println("Su numero es : <strong>" + numero+ "</strong><br>");
            }else{
                out.println("Ponga los parametros en la URL");
            }
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }finally {
            out.close();
        }
    }
}
