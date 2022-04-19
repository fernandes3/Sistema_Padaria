/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_padaria.Classes;

/**
 *
 * @author Pedro
 */
public class ItemComanda {
    
    private int IDItemComanda;
    private Produtos produto;
    private Double Quantidade;
    private Double ValorUnitario;

    public ItemComanda(int IDItemComanda, Produtos produto, Double Quantidade, Double ValorUnitario) {
        this.IDItemComanda = IDItemComanda;
        this.produto = produto;
        this.Quantidade = Quantidade;
        this.ValorUnitario = ValorUnitario;
    }
    
    
    public ItemComanda(){};

    public int getIDItemComanda() {
        return IDItemComanda;
    }

    public void setIDItemComanda(int IDItemComanda) {
        this.IDItemComanda = IDItemComanda;
    }

    public Produtos getProduto() {
        return produto;
    }

    public void setProduto(Produtos produto) {
        this.produto = produto;
    }

    public Double getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(Double Quantidade) {
        this.Quantidade = Quantidade;
    }

    public Double getValorUnitario() {
        return ValorUnitario;
    }

    public void setValorUnitario(Double ValorUnitario) {
        this.ValorUnitario = ValorUnitario;
    }
    
    
    
    
    
}
