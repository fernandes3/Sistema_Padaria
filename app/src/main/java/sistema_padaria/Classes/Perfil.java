/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_padaria.Classes;

/**
 *
 * @author Pedro
 */
public class Perfil {
    
    private int IDPerfil;
    private String Descricao;

    public Perfil(int IDPerfil, String Descricao) {
        this.IDPerfil = IDPerfil;
        this.Descricao = Descricao;
    }
    
    public Perfil(){}

    public int getIDPerfil() {
        return IDPerfil;
    }

    public void setIDPerfil(int IDPerfil) {
        this.IDPerfil = IDPerfil;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }
    
    
    
    
    
    
    
    
   
    
    
    
}
