/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DAO.AuthorDAO;
import DAO.AuthorSpecialityDAO;
import DAO.CountryDAO;
import DAO.MediaDAO;
import DAO.SpecialityDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author marce
 */
@WebServlet(name = "InsertAuthorSpeciality", urlPatterns = {"/InsertAuthorSpeciality"})
public class InsertAuthorSpeciality extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InsertAuthorSpeciality</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InsertAuthorSpeciality at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
        
        response.setContentType("text/html");

        PrintWriter pw = response.getWriter();
        int i = 0;
        try{
            AuthorSpecialityDAO daoas = new AuthorSpecialityDAO();
            CountryDAO daoc = new CountryDAO();
            AuthorDAO daoa = new AuthorDAO();
            SpecialityDAO daos = new SpecialityDAO();
            MediaDAO daom = new MediaDAO();
            int id_author = daoa.getAuthorId(request.getParameter("NAME_AUTHOR"));
            int id_spec = daos.getSpecialityId(request.getParameter("NAME_SPEC"));
            int id_country = daoc.getCountryId(request.getParameter("NAME_COUNTRY"));
            int id_media = daom.getMediaId(request.getParameter("NAME_MEDIA"));
            daoas.insertAuthorSpeciality(id_author, id_spec, id_country, id_media);
            response.sendRedirect("/Media_author/authorSpeciality.jsp");
        }
        catch (Exception e){
            pw.println(e);
        }
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

}