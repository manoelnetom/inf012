/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import negocio.QuadradoMagico;

/**
 *
 * @author ManoelNeto
 */
@WebServlet(name = "AcaoVerificarQuadrado", urlPatterns = {"/AcaoVerificarQuadrado"})
public class AcaoVerificarQuadrado extends HttpServlet {

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
            HttpSession ses = request.getSession();
            QuadradoMagico qm = (QuadradoMagico) ses.getAttribute("quadrado");

            qm.setP00(Integer.parseInt(request.getParameter("p00")));

            qm.setP01(Integer.parseInt(request.getParameter("p01")));

            qm.setP02(Integer.parseInt(request.getParameter("p02")));

            qm.setP10(Integer.parseInt(request.getParameter("p10")));

            qm.setP11(Integer.parseInt(request.getParameter("p11")));

            qm.setP12(Integer.parseInt(request.getParameter("p12")));
            
            qm.setP20(Integer.parseInt(request.getParameter("p20")));

            qm.setP21(Integer.parseInt(request.getParameter("p21")));

            qm.setP22(Integer.parseInt(request.getParameter("p22")));
            
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AcaoVerificarQuadrado</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Este " + qm.getResultado() + "</h1>");
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

}
