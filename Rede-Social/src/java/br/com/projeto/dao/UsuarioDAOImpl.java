package br.com.projeto.dao;

import br.com.projeto.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import br.com.projeto.model.Usuario;
import java.sql.SQLException;

public class UsuarioDAOImpl implements GenericDAO{

    private Connection conn;

    public UsuarioDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com Sucesso");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
    
    @Override
    public boolean cadastrar(Object object) {
        Usuario usuario = (Usuario) object;

        PreparedStatement stmt = null;

        String sql = "insert into usuario(primeironomeusuario, sobrenomeusuario, telefoneusuario, "
                + "generousuario, emailusuario, senhausuario) values(?,?,?,?,?,?);";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getPrimeiroNomeUsuario());
            stmt.setString(2, usuario.getSobrenomeUsuario());
            stmt.setString(3, usuario.getTelefoneUsuario());
            stmt.setString(4, usuario.getGeneroUsuario());
            stmt.setString(5, usuario.getEmailUsuario());
            stmt.setString(6, usuario.getSenhaUsuario());
            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problema ao cadastrar Usuario! \n"
                    + "Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problema ao fechar conexão! \n"
                        + "Erro: " + ex.getMessage());
            }
        }
        return false;
    }

    @Override
    public List<Object> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean excluir(int idObject) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object carregar(int idObject) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean alterar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Object logarUsuario(String email, String senha) {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;
        String sql = "select * from usuario where emailusuario = ? and senhausuario = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            while (rs.next()) {
                usuario = new Usuario();
                usuario.setEmailUsuario(rs.getString("emailusuario"));
                usuario.setSenhaUsuario(rs.getString("senhausuario"));
                usuario.setPrimeiroNomeUsuario(rs.getString("primeironomeusuario"));
                usuario.setSobrenomeUsuario(rs.getString("sobrenomeusuario"));
                usuario.setTelefoneUsuario(rs.getString("telefoneusuario"));
                usuario.setGeneroUsuario(rs.getString("generousuario"));
                usuario.setIdUsuario((rs.getInt("idusuario")));

            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao encontrar usuario. ERRO : " + ex.getMessage());
            ex.printStackTrace();

        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! ERRO: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return usuario;
    }
    
}
