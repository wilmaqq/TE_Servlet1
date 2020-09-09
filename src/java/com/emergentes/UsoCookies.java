/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yurik
 */
@WebServlet(name = "UsoCookies", urlPatterns = {"/UsoCookies"})
public class UsoCookies extends HttpServlet {

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
            out.println("<title>Servlet UsoCookies</title>");            
            out.println("</head>");
            out.println("<body>");
            //Mostrar todas las cookies
            Cookie[] cookies = request.getCookies();
            for (int i=0; i<cookies.length; i++) {
                Cookie c = cookies[i];
                String name = c.getName();
                String value = c.getValue();
                out.println(name + " = " + value + "<br>");
            }
            //Asicionar cookie
            String name = request.getParameter("nombre");
            if (name != null && name.length() > 0) {
                String value = request.getParameter("valor");
                Cookie c = new Cookie(name, value);
                c.setMaxAge(3600);
                response.addCookie(c);
            }
            out.println("</body>");
            out.println("</html>");
        }finally {
            out.close();
        }
    }
}
