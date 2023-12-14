package br.com.projeto.controller;

import br.com.projeto.dao.GenericDAO;
import br.com.projeto.dao.UsuarioDAOImpl;
import br.com.projeto.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CadastrarUsuario", urlPatterns = {"/CadastrarUsuario"})
public class CadastrarUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String primeiroNomeUsuario = request.getParameter("primeironomeusuario");
        String sobrenomeUsuario = request.getParameter("sobrenomeusuario");
        String telefoneUsuario = request.getParameter("telefoneusuario");
        String generoUsuario = request.getParameter("generousuario");
        String emailUsuario = request.getParameter("emailusuario");
        String senhaUsuario = request.getParameter("senhausuario");

        String mensagem = "";

        Usuario usuario = new Usuario();
        usuario.setPrimeiroNomeUsuario(primeiroNomeUsuario);
        usuario.setSobrenomeUsuario(sobrenomeUsuario);
        usuario.setTelefoneUsuario(telefoneUsuario);
        usuario.setGeneroUsuario(generoUsuario);
        usuario.setEmailUsuario(emailUsuario);
        usuario.setSenhaUsuario(senhaUsuario);

        try {
            GenericDAO dao = new UsuarioDAOImpl();

            if (dao.cadastrar(usuario)) {
                mensagem = "Usuário cadastrado com sucesso!";
            } else {
                mensagem = "Problema ao cadastrar usuário!";
            }
            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("cadastrarusuario.jsp").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problema na servlet ao cadastrar usuário!"
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
