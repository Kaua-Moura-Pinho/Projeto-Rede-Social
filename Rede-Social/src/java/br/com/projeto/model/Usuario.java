package br.com.projeto.model;

public class Usuario {

    private int idUsuario;
    private String primeiroNomeUsuario;
    private String sobrenomeUsuario;
    private String telefoneUsuario;
    private String generoUsuario;
    private String emailUsuario;
    private String senhaUsuario;

    public Usuario() {
    }

    public Usuario(int idUsuario, String primeiroNomeUsuario, String sobrenomeUsuario, String telefoneUsuario, String generoUsuario, String emailUsuario, String senhaUsuario) {
        this.idUsuario = idUsuario;
        this.primeiroNomeUsuario = primeiroNomeUsuario;
        this.sobrenomeUsuario = sobrenomeUsuario;
        this.telefoneUsuario = telefoneUsuario;
        this.generoUsuario = generoUsuario;
        this.emailUsuario = emailUsuario;
        this.senhaUsuario = senhaUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getPrimeiroNomeUsuario() {
        return primeiroNomeUsuario;
    }

    public void setPrimeiroNomeUsuario(String primeiroNomeUsuario) {
        this.primeiroNomeUsuario = primeiroNomeUsuario;
    }

    public String getSobrenomeUsuario() {
        return sobrenomeUsuario;
    }

    public void setSobrenomeUsuario(String sobrenomeUsuario) {
        this.sobrenomeUsuario = sobrenomeUsuario;
    }

    public String getTelefoneUsuario() {
        return telefoneUsuario;
    }

    public void setTelefoneUsuario(String telefoneUsuario) {
        this.telefoneUsuario = telefoneUsuario;
    }

    public String getGeneroUsuario() {
        return generoUsuario;
    }

    public void setGeneroUsuario(String generoUsuario) {
        this.generoUsuario = generoUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }
    
    
    
}
