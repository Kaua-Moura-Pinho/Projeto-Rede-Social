package br.com.projeto.controller;

import br.com.projeto.dao.GenericDAO;
import br.com.projeto.dao.UsuarioDAOImpl;
import br.com.projeto.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "LoginUsuario", urlPatterns = {"/LoginUsuario"})
public class LoginUsuario extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
            String emailUsuario = request.getParameter("emailusuario");
            String senhaUsuario = request.getParameter("senhausuario");

            String mensagem = "";
            String saudacao = null;

            try{
            if (!emailUsuario.isEmpty() && !senhaUsuario.isEmpty()
                    && emailUsuario != null && senhaUsuario != null) {

                UsuarioDAOImpl dao = new UsuarioDAOImpl();
                Usuario usuario = (Usuario) dao.logarUsuario(emailUsuario, senhaUsuario);
                if (usuario != null) {
                    HttpSession sessao = request.getSession(true);
                    sessao.setAttribute("usuario", usuario);
                    sessao.setAttribute("idusuario", usuario.getIdUsuario());
                    sessao.setAttribute("saudacao", saudacao);
                    request.getRequestDispatcher("home.jsp").forward(request, response);
                } else {
                    mensagem = "Email ou Senha inválidos!";
                    request.setAttribute("mensagem", mensagem);
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }

            } else {
                mensagem = "É necessário digitar Email e Senha";
                request.setAttribute("mensagem", mensagem);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }

        } catch (Exception ex) {
            System.out.println("Problema na servlet ao logar!"
                    + " \nErro:" + ex.getMessage());
            ex.printStackTrace();
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
