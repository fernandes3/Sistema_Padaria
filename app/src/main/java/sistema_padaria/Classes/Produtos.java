/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_padaria.Classes;

/**
 *
 * @author Pedro
 */
public class Produtos {
    
    
    private int IDProduto;
    private Categoria Categoria;
    private UnidadeMedida UnidadeMedida;
    private String Descricao;
    private String CodigoDeBarras;
    private Double Quantidade;
    private Double QuantidadeMinima;
    private Double ValorUnitario;

    public Produtos(int IDProduto, Categoria Categoria, UnidadeMedida UnidadeMedida, String Descricao, String CodigoDeBarras, Double Quantidade, Double QuantidadeMinima, Double ValorUnitario) {
        this.IDProduto = IDProduto;
        this.Categoria = Categoria;
        this.UnidadeMedida = UnidadeMedida;
        this.Descricao = Descricao;
        this.CodigoDeBarras = CodigoDeBarras;
        this.Quantidade = Quantidade;
        this.QuantidadeMinima = QuantidadeMinima;
        this.ValorUnitario = ValorUnitario;
    }
    
    public Produtos(){}

    public int getIDProduto() {
        return IDProduto;
    }

    public void setIDProduto(int IDProduto) {
        this.IDProduto = IDProduto;
    }

    public Categoria getCategoria() {
        return Categoria;
    }

    public void setCategoria(Categoria Categoria) {
        this.Categoria = Categoria;
    }

    public UnidadeMedida getUnidadeMedida() {
        return UnidadeMedida;
    }

    public void setUnidadeMedida(UnidadeMedida UnidadeMedida) {
        this.UnidadeMedida = UnidadeMedida;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public String getCodigoDeBarras() {
        return CodigoDeBarras;
    }

    public void setCodigoDeBarras(String CodigoDeBarras) {
        this.CodigoDeBarras = CodigoDeBarras;
    }

    public Double getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(Double Quantidade) {
        this.Quantidade = Quantidade;
    }

    public Double getQuantidadeMinima() {
        return QuantidadeMinima;
    }

    public void setQuantidadeMinima(Double QuantidadeMinima) {
        this.QuantidadeMinima = QuantidadeMinima;
    }

    public Double getValorUnitario() {
        return ValorUnitario;
    }

    public void setValorUnitario(Double ValorUnitario) {
        this.ValorUnitario = ValorUnitario;
    }
    
    
    
    
    
    
    
    
}
