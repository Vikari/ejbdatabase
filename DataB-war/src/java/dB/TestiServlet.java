/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dB;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jukka
 */
public class TestiServlet extends HttpServlet {

    @EJB
    private TestiFacadeLocal testiFacade;
    private List<Testi> testi;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Namebase</title>"
                    + "<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\" title=\"Style\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TestiServlet at " + request.getContextPath() + "</h1>");

            String command = request.getParameter("com");
            switch (command) {
                case "Create":
                    addItem(request);
                    break;
                case "Edit":
                    editItem(request);
                    break;
                case "Remove":
                    removeItem(request);
                    break;
                case "Find":
                    out.println("<p>" + findItem(request).getId()
                            + "<tab1></tab1>" + findItem(request).getNimi()
                            + "</p>");
                    break;
            }

            testi = testiFacade.findAll();
            testi.forEach((name) -> {
                out.println("<pre>" + name.getId() + "<tab1></tab1>    " + name.getNimi() + "</pre>");
            });

            out.println("<form name=\"Add\" action=\"TestiServlet\">\n"
                    + "<input type=\"text\" name=\"id\" value=\"\" />\n"
                    + "<input type=\"text\" name=\"x1\" value=\"\" />\n"
                    + "<input type=\"submit\" value=\"Create\" name=\"com\" />\n"
                    + "<input type=\"submit\" value=\"Edit\" name=\"com\" />\n"
                    + "<input type=\"submit\" value=\"Remove\" name=\"com\" />\n"
                    + "<input type=\"submit\" value=\"Find\" name=\"com\" />"
                    + "</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    void addItem(HttpServletRequest request) {
        Testi e = new Testi();
        Integer i = Integer.parseInt(request.getParameter("id"));
        String s = request.getParameter("x1");
        e.setId(i);
        e.setNimi(s);
        testiFacade.create(e);
    }

    void editItem(HttpServletRequest request) {
        Testi e = new Testi();
        Integer i = Integer.parseInt(request.getParameter("id"));
        String s = request.getParameter("x1");
        e.setId(i);
        e.setNimi(s);
        testiFacade.edit(e);
    }

    void removeItem(HttpServletRequest request) {
        Testi e = new Testi();
        Integer i = Integer.parseInt(request.getParameter("id"));
        String s = request.getParameter("x1");
        e.setId(i);
        e.setNimi(s);
        testiFacade.remove(e);
    }

    Testi findItem(HttpServletRequest request) {
        Testi e = new Testi();
        Integer i = Integer.parseInt(request.getParameter("id"));
        //String s = request.getParameter("x1");
        //e.setId(i);
        //e.setNimi(s);
        return testiFacade.find(i);
    }
}
