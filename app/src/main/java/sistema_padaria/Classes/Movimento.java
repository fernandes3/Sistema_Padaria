/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_padaria.Classes;

import java.util.Date;

/**
 *
 * @author Pedro
 */
public class Movimento {
    
    private int IDMovimento;
    private Usuario usuario;
    private Date DataMovimento;
    private String Tipo;
    private String Descricao;
    private Double Valor;

    public Movimento(int IDMovimento, Usuario usuario, Date DataMovimento, String Tipo, String Descricao, Double Valor) {
        this.IDMovimento = IDMovimento;
        this.usuario = usuario;
        this.DataMovimento = DataMovimento;
        this.Tipo = Tipo;
        this.Descricao = Descricao;
        this.Valor = Valor;
    }
    
    
    
    public Movimento(){}

    public int getIDMovimento() {
        return IDMovimento;
    }

    public void setIDMovimento(int IDMovimento) {
        this.IDMovimento = IDMovimento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getDataMovimento() {
        return DataMovimento;
    }

    public void setDataMovimento(Date DataMovimento) {
        this.DataMovimento = DataMovimento;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public Double getValor() {
        return Valor;
    }

    public void setValor(Double Valor) {
        this.Valor = Valor;
    }
    
    
    
    
    
    
}
