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
import negocio.Jogo;

/**
 *
 * @author ManoelNeto
 */
@WebServlet(name = "ZeroCemController", urlPatterns = {"/ZeroCemController"})
public class ZeroCemController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private Jogo jogo;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            HttpSession ses=request.getSession();
            jogo =(Jogo)ses.getAttribute("jogo");
            if (jogo==null){
                jogo=new Jogo();
                ses.setAttribute("jogo", jogo);
            }
            
            int numeroDigitado= Integer.parseInt(request.getParameter("numero"));
            
          
            jogo.setNumeroDigitado(numeroDigitado);
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Zero Cem Game</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h1>" + jogo.getResultado() + "</h1>");
            
            out.println("<h1>O numero sorteado é: " + jogo.getNumeroSorteado() + "</h1>");
            
            out.println("<form action=\"ZeroCemController\" method=\"GET\">\n" +
"            Digite um Número entre 0 e 100: <input type=\"text\" name=\"numero\"/>\n" +
"            <input type=\"submit\" name=\"bt\" value=\"OK\"/>\n" +
"        </form>");
            
           
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
