/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_padaria.Classes;

/**
 *
 * @author Pedro
 */
public class Categoria {
    
    
    private int IDCategoria;
    private String Descricao;

    public Categoria(int IDCategoria, String Descricao) {
        this.IDCategoria = IDCategoria;
        this.Descricao = Descricao;
    }
    
    public Categoria(){}

    public int getIDCategoria() {
        return IDCategoria;
    }

    public void setIDCategoria(int IDCategoria) {
        this.IDCategoria = IDCategoria;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }
    
    
    
    
    
    
    
}
