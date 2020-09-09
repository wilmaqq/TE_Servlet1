/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes;

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
@WebServlet(name = "InfoRequest", urlPatterns = {"/InfoRequest"})
public class InfoRequest extends HttpServlet {

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
        PrintWriter out = response.getWriter();
          
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>información del objeto request</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h3>Request</h3>");
            out.println("Metodo:" + request.getMethod() + "<br>");
            out.println("Dirección URI: " + request.getRequestURI() + "<br>");
            out.println("Protocolo: " + request.getProtocol() + "<br>");
            out.println("Ruta contexto: " + request.getContextPath() + "<br>");
            out.println("Servidor: " + request.getServerName() + "<br>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   

