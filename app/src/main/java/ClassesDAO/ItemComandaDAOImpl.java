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
import java.util.Date;
import java.util.List;
import sistema_padaria.Classes.Comanda;
import sistema_padaria.Classes.ItemComanda;
import sistema_padaria.Classes.Produtos;

/**
 *
 * @author Pedro
 */
public class ItemComandaDAOImpl implements ItemComandaDAO {

    private Connection conexao;

    public ItemComandaDAOImpl() {
        conexao = Conexao.getConnection();
    }

    @Override
    public List<ItemComanda> getAllItensComanda() {
        List<ItemComanda> lstItensComanda = new ArrayList<ItemComanda>();

        try {
            PreparedStatement pStatementGetComandas = conexao.prepareStatement("SELECT c.IDItemComanda, c.Quantidade, c.ValorUnitario, c.IDProduto, p.Descricao FROM TB_Item_Comanda c INNER JOIN TB_Produtos p  ON c.IDProduto=  p.IDProduto");

            ResultSet rs = pStatementGetComandas.executeQuery();

            int idItemComanda = -1;
            Double quantidade = -1.0;
            Double valorUnitario = -1.0;

            int idProduto = -1;
            String descricaoProduto = "";

            while (rs.next()) {
                idItemComanda = rs.getInt("c.IDItemComanda");
                quantidade = rs.getDouble("c.Quantidade");
                valorUnitario = rs.getDouble("c.ValorUnitario");
                idProduto = rs.getInt("c.IDProduto");
                descricaoProduto = rs.getString("p.Descricao");
                Comanda c = new Comanda();

                Produtos p = new Produtos();
                p.setIDProduto(idProduto);
                p.setDescricao(descricaoProduto);
                ItemComanda i = new ItemComanda(idItemComanda, p, quantidade, valorUnitario);
                //IDUsuario, Perfil perfil, String NomeUsuario, String Senha, String Status

                lstItensComanda.add(i);

            }
        } catch (SQLException ex) {
            System.out.println("Erro de BD = " + ex.getErrorCode() + " - " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }

        return lstItensComanda;

    }

    @Override
    public ItemComanda getItemComandaByID(int id) {
        ItemComanda item = null;

        try {
            PreparedStatement pStatementGetItemComanda = conexao.prepareStatement("SELECT c.IDItemComanda, c.Quantidade, c.ValorUnitario, c.IDProduto, p.Descricao FROM TB_Item_Comanda c INNER JOIN TB_Produtos p  ON c.IDProduto=  p.IDProduto WHERE IDItemComanda = ?");
            pStatementGetItemComanda.setInt(1, id);
            ResultSet rs = pStatementGetItemComanda.executeQuery();

            int idItemComanda = -1;
            Double quantidade = -1.0;
            Double valorUnitario = -1.0;

            int idProduto = -1;
            String descricaoProduto = "";

            while (rs.next()) {
                idItemComanda = rs.getInt("c.IDItemComanda");
                quantidade = rs.getDouble("c.Quantidade");
                valorUnitario = rs.getDouble("c.ValorUnitario");
                idProduto = rs.getInt("c.IDProduto");
                descricaoProduto = rs.getString("p.Descricao");
                Comanda c = new Comanda();

                Produtos p = new Produtos();
                p.setIDProduto(idProduto);
                p.setDescricao(descricaoProduto);
                item = new ItemComanda(idItemComanda, p, quantidade, valorUnitario);
                //IDUsuario, Perfil perfil, String NomeUsuario, String Senha, String Status

            }
        } catch (SQLException ex) {
            System.out.println("Erro de BD = " + ex.getErrorCode() + " - " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }

        return item;
    }

    @Override
    public ItemComanda getItemComandaByIDComanda(int id) {
        ItemComanda item = null;

        try {
            PreparedStatement pStatementGetItemComanda = conexao.prepareStatement("SELECT c.IDItemComanda, c.Quantidade, c.ValorUnitario, c.IDProduto, p.Descricao FROM TB_Item_Comanda c INNER JOIN TB_Produtos p  ON c.IDProduto=  p.IDProduto WHERE IDComanda = ?");
            pStatementGetItemComanda.setInt(1, id);
            ResultSet rs = pStatementGetItemComanda.executeQuery();

            int idItemComanda = -1;
            Double quantidade = -1.0;
            Double valorUnitario = -1.0;

            int idProduto = -1;
            String descricaoProduto = "";

            while (rs.next()) {
                idItemComanda = rs.getInt("c.IDItemComanda");
                quantidade = rs.getDouble("c.Quantidade");
                valorUnitario = rs.getDouble("c.ValorUnitario");
                idProduto = rs.getInt("c.IDProduto");
                descricaoProduto = rs.getString("p.Descricao");
                Comanda c = new Comanda();

                Produtos p = new Produtos();
                p.setIDProduto(idProduto);
                p.setDescricao(descricaoProduto);
                item = new ItemComanda(idItemComanda, p, quantidade, valorUnitario);
                //IDUsuario, Perfil perfil, String NomeUsuario, String Senha, String Status

            }
        } catch (SQLException ex) {
            System.out.println("Erro de BD = " + ex.getErrorCode() + " - " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }

        return item;
    }

    @Override
    public void updateItemComanda(ItemComanda itemComanda) {
        try {
            int idGerado = -1;

            PreparedStatement pStatementUpdateItemComanda = conexao.prepareStatement("UPDATE TB_Item_Comanda SET Quantidade = ?, ValorUnitario = ?, IDProduto = ? WHERE IDItemComanda = ?");
  
            pStatementUpdateItemComanda.setDouble(1,itemComanda.getQuantidade());
            pStatementUpdateItemComanda.setDouble(2, itemComanda.getValorUnitario());
            pStatementUpdateItemComanda.setInt(3, itemComanda.getProduto().getIDProduto());
             pStatementUpdateItemComanda.setInt(4, itemComanda.getIDItemComanda());
            int resultado = pStatementUpdateItemComanda.executeUpdate();

            if (resultado > 0) {
                System.out.println("Item Comanda de id " + itemComanda.getIDItemComanda() + " atualizada com sucesso!");
            } else {
                System.out.println("Ops! Deu ruim X_X. Não foi possível atualizar o Produto");
            }

        } catch (SQLException ex) {
            System.out.println("Erro de BD = " + ex.getErrorCode() + " - " + ex.getMessage());
        }

    }

    @Override
    public int insertItemComanda(ItemComanda itemComanda, int idComanda) {
         int idGerado = -1;
       try {
        
        PreparedStatement pStatementInsertItemComanda = conexao.prepareStatement("Insert into TB_Item_Comanda(Quantidade, ValorUnitario, IDComanda, IDProduto) values (?, ?, ?, ?) ", PreparedStatement.RETURN_GENERATED_KEYS);
        pStatementInsertItemComanda.setDouble(1, itemComanda.getQuantidade());
        pStatementInsertItemComanda.setDouble(2,itemComanda.getValorUnitario());
        pStatementInsertItemComanda.setInt(3,idComanda);
        pStatementInsertItemComanda.setInt(4,itemComanda.getProduto().getIDProduto());
        
        
        int resultado = pStatementInsertItemComanda.executeUpdate();
        ResultSet rs = pStatementInsertItemComanda.getGeneratedKeys();
        if(rs.first()) {
            idGerado = rs.getInt(1);
        }

        if(idGerado >0)
        {
            System.out.println("ItemComanda " + idGerado +  " inserido com suceso");
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
    public void deleteItemComanda(int id) {
      try {
            PreparedStatement pStatementeDeleteItemComanda = conexao.prepareStatement("DELETE FROM TB_Item_Comanda WHERE IDItemComanda = ? ");
             pStatementeDeleteItemComanda.setInt(1, id);
             int resultado = pStatementeDeleteItemComanda.executeUpdate();
             
             if(resultado > 0){
                 System.out.println("ItemComanda deletado com sucesso");
             }else{
                 System.out.println("Não foi possível deletar  o ItemComanda");
             }
            
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
        }
    }

    @Override
    public void deleteItemComandaByIDComanda(int idComanda) {
         try {
            PreparedStatement pStatementeDeleteItemComanda = conexao.prepareStatement("DELETE FROM TB_Item_Comanda WHERE IDComanda = ? ");
             pStatementeDeleteItemComanda.setInt(1, idComanda);
             int resultado = pStatementeDeleteItemComanda.executeUpdate();
             
             if(resultado > 0){
                 System.out.println("ItemComanda deletado com sucesso");
             }else{
                 System.out.println("Não foi possível deletar  o ItemComanda");
             }
            
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
        }
    }
}
