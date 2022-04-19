/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassesDAO;

import Database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sistema_padaria.Classes.Categoria;
import sistema_padaria.Classes.Perfil;
import sistema_padaria.Classes.Produtos;
import sistema_padaria.Classes.UnidadeMedida;
import sistema_padaria.Classes.Usuario;

/**
 *
 * @author Pedro
 */
public class ProdutosDAOImpl implements ProdutosDAO {

    private Connection conexao;

    public ProdutosDAOImpl() {
        conexao = Conexao.getConnection();
    }

    @Override
    public List<Produtos> getAllProducts() {

        List<Produtos> lstProducts = new ArrayList<Produtos>();

        try {
            PreparedStatement pStatementGetProducts = conexao.prepareStatement("SELECT p.IDProduto, p.Descricao, m.Descricao, c.Descricao, p.CodigoDeBarras, p.Quantidade, p.QuantidadeMinima, p.ValorUnitario FROM TB_Produtos p INNER JOIN TB_UnidadeMedida m ON p.IDUnidadeMedida = m.IDUnidadeMedida INNER JOIN TB_Categoria c ON p.IDCategoria = c.IDCategoria");

            ResultSet rs = pStatementGetProducts.executeQuery();

            int idProduto = -1;
            String descricaoProduto = "";
            String descricaoUnidadeMedida = "";
            String descricaoCategoria = "";
            String codigoDeBarras = "";
            Double quantidade = -1.0;
            Double quantidadeMinima = -1.0;
            Double valorUnitario = -1.0;

            while (rs.next()) {
                idProduto = rs.getInt("p.IDProduto");
                descricaoProduto = rs.getString("p.Descricao");
                descricaoUnidadeMedida = rs.getString("m.Descricao");
                descricaoCategoria = rs.getString("c.Descricao");
                codigoDeBarras = rs.getString("p.CodigoDeBarras");
                quantidade = rs.getDouble("p.Quantidade");
                quantidadeMinima = rs.getDouble("p.QuantidadeMinima");
                valorUnitario = rs.getDouble("p.ValorUnitario");
                //Pega descrição do Perfil do usuário;
                Categoria cat = new Categoria();
                cat.setDescricao(descricaoCategoria);
                UnidadeMedida unidade = new UnidadeMedida();
                unidade.setDescricao(descricaoUnidadeMedida);
                //IDUsuario, Perfil perfil, String NomeUsuario, String Senha, String Status
                Produtos produto = new Produtos(idProduto, cat, unidade, descricaoProduto,
                         codigoDeBarras, quantidade, quantidadeMinima, valorUnitario);
                lstProducts.add(produto);

            }
        } catch (SQLException ex) {
            System.out.println("Erro de BD = " + ex.getErrorCode() + " - " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }

        return lstProducts;

    }

    @Override
    public Produtos getProdutoByID(int id) {
        Produtos produto = null;

        try {
            PreparedStatement pStatementGetProducts = conexao.prepareStatement("SELECT p.IDProduto, p.Descricao, m.Descricao, c.Descricao, p.CodigoDeBarras, p.Quantidade, p.QuantidadeMinima, p.ValorUnitario FROM TB_Produtos p INNER JOIN TB_UnidadeMedida m ON p.IDUnidadeMedida = m.IDUnidadeMedida INNER JOIN TB_Categoria c ON p.IDCategoria = c.IDCategoria WHERE IDProduto = ?");
            pStatementGetProducts.setInt(1, id);
            ResultSet rs = pStatementGetProducts.executeQuery();

            int idProduto = -1;
            String descricaoProduto = "";
            String descricaoUnidadeMedida = "";
            String descricaoCategoria = "";
            String codigoDeBarras = "";
            Double quantidade = -1.0;
            Double quantidadeMinima = -1.0;
            Double valorUnitario = -1.0;

            while (rs.next()) {
                idProduto = rs.getInt("p.IDProduto");
                descricaoProduto = rs.getString("p.Descricao");
                descricaoUnidadeMedida = rs.getString("m.Descricao");
                descricaoCategoria = rs.getString("c.Descricao");
                codigoDeBarras = rs.getString("p.CodigoDeBarras");
                quantidade = rs.getDouble("p.Quantidade");
                quantidadeMinima = rs.getDouble("p.QuantidadeMinima");
                valorUnitario = rs.getDouble("p.ValorUnitario");
                //Pega descrição do Perfil do usuário;
                Categoria cat = new Categoria();
                cat.setDescricao(descricaoCategoria);
                UnidadeMedida unidade = new UnidadeMedida();
                unidade.setDescricao(descricaoUnidadeMedida);
                //IDUsuario, Perfil perfil, String NomeUsuario, String Senha, String Status
                 produto = new Produtos(idProduto, cat, unidade, descricaoProduto,
                         codigoDeBarras, quantidade, quantidadeMinima, valorUnitario);

            }
        } catch (SQLException ex) {
            System.out.println("Erro de BD = " + ex.getErrorCode() + " - " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }

        return produto;
    }

    @Override
    public Produtos getProdutoByDesc(String nomeProduto) {
         Produtos produto = null;

        try {
            PreparedStatement pStatementGetProducts = conexao.prepareStatement("SELECT p.IDProduto, p.Descricao,p.IDUnidadeMedida, m.Descricao,p.IDCategoria, c.Descricao, p.CodigoDeBarras, p.Quantidade, p.QuantidadeMinima, p.ValorUnitario FROM TB_Produtos p INNER JOIN TB_UnidadeMedida m ON p.IDUnidadeMedida = m.IDUnidadeMedida INNER JOIN TB_Categoria c ON p.IDCategoria = c.IDCategoria WHERE p.Descricao = ?");
            pStatementGetProducts.setString(1, nomeProduto);
            ResultSet rs = pStatementGetProducts.executeQuery();

            int idProduto = -1;
            String descricaoProduto = "";
            String descricaoUnidadeMedida = "";
            String descricaoCategoria = "";
            String codigoDeBarras = "";
            Double quantidade = -1.0;
            Double quantidadeMinima = -1.0;
            Double valorUnitario = -1.0;
            int IDUnidadeMedida = -1;
            int IDCategoria = -1;

            while (rs.next()) {
                idProduto = rs.getInt("p.IDProduto");
                descricaoProduto = rs.getString("p.Descricao");
                descricaoUnidadeMedida = rs.getString("m.Descricao");
                descricaoCategoria = rs.getString("c.Descricao");
                codigoDeBarras = rs.getString("p.CodigoDeBarras");
                IDUnidadeMedida = rs.getInt("p.IDUnidadeMedida");
                IDCategoria = rs.getInt("p.IDCategoria");
                quantidade = rs.getDouble("p.Quantidade");
                quantidadeMinima = rs.getDouble("p.QuantidadeMinima");
                valorUnitario = rs.getDouble("p.ValorUnitario");
                //Pega descrição do Perfil do usuário;
                Categoria cat = new Categoria();
                cat.setIDCategoria(IDCategoria);
                cat.setDescricao(descricaoCategoria);
                UnidadeMedida unidade = new UnidadeMedida();
                unidade.setIDUnidadeMedida(IDUnidadeMedida);
                unidade.setDescricao(descricaoUnidadeMedida);
                //IDUsuario, Perfil perfil, String NomeUsuario, String Senha, String Status
                 produto = new Produtos(idProduto, cat, unidade, descricaoProduto,
                         codigoDeBarras, quantidade, quantidadeMinima, valorUnitario);

            }
        } catch (SQLException ex) {
            System.out.println("Erro de BD = " + ex.getErrorCode() + " - " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }

        return produto;
    }

    @Override
    public void updateProduto(Produtos produto) {
        try {
            int idGerado = -1;

            PreparedStatement pStatementUpdateUsuario = conexao.prepareStatement("UPDATE TB_Produtos SET Descricao = ?, IDUnidadeMedida = ? , IDCategoria = ?, CodigoDeBarras = ?, Quantidade = ?, QuantidadeMinima = ?, ValorUnitario = ? WHERE IDProduto = ?");
            pStatementUpdateUsuario.setString(1, produto.getDescricao());
            pStatementUpdateUsuario.setInt(2, produto.getUnidadeMedida().getIDUnidadeMedida());
            pStatementUpdateUsuario.setInt(3, produto.getCategoria().getIDCategoria());
            pStatementUpdateUsuario.setString(4, produto.getCodigoDeBarras());
            pStatementUpdateUsuario.setDouble(5, produto.getQuantidade());
            pStatementUpdateUsuario.setDouble(6, produto.getQuantidadeMinima());
            pStatementUpdateUsuario.setDouble(7, produto.getValorUnitario());
            pStatementUpdateUsuario.setInt(8, produto.getIDProduto());
            int resultado = pStatementUpdateUsuario.executeUpdate();

            if (resultado > 0) {
                System.out.println("Produto de id " + produto.getIDProduto() + " atualizado com sucesso!");
            } else {
                System.out.println("Ops! Deu ruim X_X. Não foi possível atualizar o Produto");
            }

        } catch (SQLException ex) {
            System.out.println("Erro de BD = " + ex.getErrorCode() + " - " + ex.getMessage());
        }
    }

    @Override
    public int insertProduto(Produtos produto) {
     int idGerado = -1;
       try {
        
        PreparedStatement pStatementInsertProducts = conexao.prepareStatement("Insert into TB_Produtos(Descricao, IDUnidadeMedida, IDCategoria, CodigoDeBarras, Quantidade, QuantidadeMinima, ValorUnitario) values (?, ?, ?, ?, ?, ?, ?) ", PreparedStatement.RETURN_GENERATED_KEYS);
        pStatementInsertProducts.setString(1, produto.getDescricao());
        pStatementInsertProducts.setInt(2,produto.getUnidadeMedida().getIDUnidadeMedida());
        pStatementInsertProducts.setInt(3,produto.getCategoria().getIDCategoria());
        pStatementInsertProducts.setString(4,produto.getCodigoDeBarras());
        pStatementInsertProducts.setDouble(5,produto.getQuantidade());
        pStatementInsertProducts.setDouble(6,produto.getQuantidadeMinima());
        pStatementInsertProducts.setDouble(7,produto.getValorUnitario());
        
        
        
        int resultado = pStatementInsertProducts.executeUpdate();
        ResultSet rs = pStatementInsertProducts.getGeneratedKeys();
        if(rs.first()) {
            idGerado = rs.getInt(1);
        }

        if(idGerado >0)
        {
            System.out.println("Produto " + idGerado +  " inserido com suceso");
        }
        else
        {
            System.out.println("Não foi possivel inserir o Usuário");
        }

       }
       catch(SQLException sqlEx) {
        System.out.println("Erro de BD = " + sqlEx.getErrorCode()  + " - " +  sqlEx.getMessage());
        }
        catch (Exception ex) {
            System.out.println("Erro = " +    ex.getMessage());
        } 
        return idGerado;
    }

    @Override
    public void deleteProduto(int id) {
      try {
            PreparedStatement pStatementeDeleteComanda = conexao.prepareStatement("DELETE FROM TB_Produtos WHERE IDProduto = ? ");
             pStatementeDeleteComanda.setInt(1, id);
             int resultado = pStatementeDeleteComanda.executeUpdate();
             
             if(resultado > 0){
                 System.out.println("Produto deletado com sucesso");
             }else{
                 System.out.println("Não foi possível deletar  o Produto");
             }
            
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
        }
    }

}
