/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_padaria.Classes;

/**
 *
 * @author Pedro
 */
public class Usuario {
    private int IDUsuario;
    private Perfil perfil;
    private String NomeUsuario;
    private String Senha;
    private String Status;

    public Usuario(int IDUsuario, Perfil perfil, String NomeUsuario, String Senha, String Status) {
        this.IDUsuario = IDUsuario;
        this.perfil = perfil;
        this.NomeUsuario = NomeUsuario;
        this.Senha = Senha;
        this.Status = Status;
    }
    
    public Usuario(){}

    public int getIDUsuario() {
        return IDUsuario;
    }

    public void setIDUsuario(int IDUsuario) {
        this.IDUsuario = IDUsuario;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public String getNomeUsuario() {
        return NomeUsuario;
    }

    public void setNomeUsuario(String NomeUsuario) {
        this.NomeUsuario = NomeUsuario;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
    
    
    
    
    
    
    
}
