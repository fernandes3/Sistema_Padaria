/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassesDAO;

import java.util.List;
import sistema_padaria.Classes.Produtos;
import sistema_padaria.Classes.Usuario;

/**
 *
 * @author Pedro
 */
public interface ProdutosDAO {

    public List<Produtos> getAllProducts();

    public Produtos getProdutoByID(int id);

    public Produtos getProdutoByDesc(String nomeProduto);

    public void updateProduto(Produtos produto);

    public int insertProduto(Produtos produto);

    public void deleteProduto(int id);

}
