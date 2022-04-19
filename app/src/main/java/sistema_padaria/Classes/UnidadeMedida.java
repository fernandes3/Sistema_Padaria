/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_padaria.Classes;

/**
 *
 * @author Pedro
 */
public class UnidadeMedida {
    private int IDUnidadeMedida;
    private String Descricao;

    public UnidadeMedida(int IDUnidadeMedida, String Descricao) {
        this.IDUnidadeMedida = IDUnidadeMedida;
        this.Descricao = Descricao;
    }
    
    public UnidadeMedida(){}

    public int getIDUnidadeMedida() {
        return IDUnidadeMedida;
    }

    public void setIDUnidadeMedida(int IDUnidadeMedida) {
        this.IDUnidadeMedida = IDUnidadeMedida;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }
    
    
    

            
    
    
}
