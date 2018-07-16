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
import negocio.Texto;

/**
 *
 * @author aluno
 */
@WebServlet(name = "ConroleContaCaracteres", urlPatterns = {"/ConroleContaCaracteres"})
public class ConroleContaCaracteres extends HttpServlet {

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
           
            Texto texto = new Texto(request.getParameter("texto"));
            String resposta;
            String bt=request.getParameter("bt");
            if(bt.equalsIgnoreCase("Vogais")){
                resposta=texto.getVogais();
            }else if(bt.equalsIgnoreCase("Outros")){
                resposta=texto.getOutros();
            }else{
                resposta=texto.getConsoantes();
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Conta Caracteres!!!</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + resposta + "</h1>");
            out.println(" <form action=\"ConroleContaCaracteres\" method=\"POST\">\n" +
"            <table align=\"center\" border=\"0\">\n" +
"                <tr>\n" +
"                    <td>Frase:</td>\n" +
"                    <td><input type=\"text\" name=\"texto\"/></td>\n" +
"                    <td>&nbsp;</td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td><input type=\"submit\" name=\"bt\" value=\"Vogais\"/></td>\n" +
"                    <td align=\"center\"><input type=\"submit\" name=\"bt\" value=\"Consoantes\"/></td>\n" +
"                    <td><input type=\"submit\" name=\"bt\" value=\"Outros\"/></td>\n" +
"                </tr>\n" +
"            </table>\n" +
"        </form></body>");
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
