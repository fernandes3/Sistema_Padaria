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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sistema_padaria.Classes.Categoria;
import sistema_padaria.Classes.Comanda;
import sistema_padaria.Classes.ItemComanda;
import sistema_padaria.Classes.Produtos;
import sistema_padaria.Classes.UnidadeMedida;

/**
 *
 * @author Pedro
 */
public class ComandaDAOImpl implements ComandaDAO {

    private Connection conexao;

    public ComandaDAOImpl() {
        conexao = Conexao.getConnection();
    }

    @Override
    public List<Comanda> getAllComandas() {

        List<Comanda> lstComandas = new ArrayList<Comanda>();

        try {
            PreparedStatement pStatementGetComandas = conexao.prepareStatement("SELECT IDComanda, DataComanda FROM TB_Comanda");

            ResultSet rs = pStatementGetComandas.executeQuery();

            int idComanda = -1;
            Date DataComanda;

            while (rs.next()) {
                idComanda = rs.getInt("IDComanda");
                DataComanda = rs.getDate("DataComanda");
                //IDUsuario, Perfil perfil, String NomeUsuario, String Senha, String Status
                Comanda c = new Comanda(idComanda, DataComanda);
                lstComandas.add(c);

            }
        } catch (SQLException ex) {
            System.out.println("Erro de BD = " + ex.getErrorCode() + " - " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }

        return lstComandas;

    }

    @Override
    public Comanda getComandaByID(int id) {
        Comanda c = null;

        try {
            PreparedStatement pStatementGetComanda = conexao.prepareStatement("SELECT IDComanda, DataComanda  FROM TB_Comanda WHERE IDComanda = ?");
            pStatementGetComanda.setInt(1, id);
            ResultSet rs = pStatementGetComanda.executeQuery();

            int idComanda = -1;
            Date dataComanda = null;
                

            while (rs.next()) {
                idComanda = rs.getInt("IDComanda");
                dataComanda = rs.getDate("DataComanda");
              
                //IDUsuario, Perfil perfil, String NomeUsuario, String Senha, String Status
                 c = new Comanda(idComanda, dataComanda);

            }
        } catch (SQLException ex) {
            System.out.println("Erro de BD = " + ex.getErrorCode() + " - " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }

        return c;
    }

    @Override
    public void updateComanda(Comanda comanda) {
         try {
            int idGerado = -1;

            PreparedStatement pStatementUpdateComanda = conexao.prepareStatement("UPDATE TB_Comanda SET DataComanda = ? WHERE IDComanda = ?");
            Date a = comanda.getDataComanda();
            
            pStatementUpdateComanda.setDate(1, (java.sql.Date) a);
            pStatementUpdateComanda.setInt(2, comanda.getIDComanda());
                        int resultado = pStatementUpdateComanda.executeUpdate();

            if (resultado > 0) {
                System.out.println("Comanda de id " + comanda.getIDComanda()+ " atualizada com sucesso!");
            } else {
                System.out.println("Ops! Deu ruim X_X. Não foi possível atualizar o Produto");
            }

        } catch (SQLException ex) {
            System.out.println("Erro de BD = " + ex.getErrorCode() + " - " + ex.getMessage());
        }
    }

    @Override
    public int insertComanda(Comanda comanda) {
         int idGerado = -1;
       try {
        
        PreparedStatement pStatementInsertComanda = conexao.prepareStatement("Insert into TB_Comanda(DataComanda) values (?) ", PreparedStatement.RETURN_GENERATED_KEYS);
        SimpleDateFormat sd =  new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        pStatementInsertComanda.setString(1, sd.format(comanda.getDataComanda()));
        
        
       
        ItemComandaDAO itemDAO = new ItemComandaDAOImpl();
        
        
        
        int resultado = pStatementInsertComanda.executeUpdate();
        ResultSet rs = pStatementInsertComanda.getGeneratedKeys();
        if(rs.first()) {
            idGerado = rs.getInt(1);
        }
        
         for(ItemComanda i : comanda.getItensComanda()){
            itemDAO.insertItemComanda(i, idGerado);
        }

        if(idGerado >0)
        {
            System.out.println("Comanda " + idGerado +  " inserida com suceso");
        }
        else
        {
            System.out.println("Não foi possivel inserir a Comanda");
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
    public void deleteComanda(int id) {
        try {
            ItemComandaDAO itemDao = new ItemComandaDAOImpl();
            itemDao.deleteItemComandaByIDComanda(id);
            PreparedStatement pStatementeDeleteComada = conexao.prepareStatement("DELETE FROM TB_Comanda WHERE IDComanda = ? ");
             pStatementeDeleteComada.setInt(1, id);
             int resultado = pStatementeDeleteComada.executeUpdate();
             
             if(resultado > 0){
                 System.out.println("Comanda deletada com sucesso");
             }else{
                 System.out.println("Não foi possível deletar  a comanda");
             }
            
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
        }
    }

}
