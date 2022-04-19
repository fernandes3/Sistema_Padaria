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
import java.util.logging.Level;
import java.util.logging.Logger;
import sistema_padaria.Classes.Categoria;
import sistema_padaria.Classes.Perfil;

/**
 *
 * @author Pedro
 */
public class CategoriaDAOImpl implements CategoriaDAO {
    private Connection conexao;

    public CategoriaDAOImpl(){
        conexao = Conexao.getConnection();
       	
     }

    @Override
    public List<Categoria> getAllCategorias() {
       List<Categoria> lstCategorias = new ArrayList<Categoria>();
       try {
                PreparedStatement pStatementGetCategoria = conexao.prepareStatement("Select IDCategoria, Descricao from TB_Categoria ");
                ResultSet rs = pStatementGetCategoria.executeQuery();
        
                int id = -1;
                String descricao = "";
                while(rs.next()) {
                    
                    id = rs.getInt("IDCategoria");
                    descricao = rs.getString("Descricao");
        
                    Categoria cat = new Categoria ();
                    cat.setIDCategoria(id);
                    cat.setDescricao(descricao);
                    
                    lstCategorias.add(cat);
        
                }
            } 
            catch(SQLException sqlEx) {
                System.out.println("Erro de BD = " + sqlEx.getErrorCode()  + " - " +  sqlEx.getMessage());
            }
            catch (Exception ex) {
                System.out.println("Erro = " +    ex.getMessage());
            } 

    return lstCategorias;
    }

    @Override
    public Categoria getCategoria(int id) {
        Categoria cat = new Categoria();
       

        try {
            PreparedStatement pStatementGetCategoria = conexao.prepareStatement("Select IDCategoria, Descricao from TB_Categoria  WHERE IDCategoria = ?");
            pStatementGetCategoria.setInt(1, id);
            ResultSet rs = pStatementGetCategoria.executeQuery();

            int idCategoria = -1;
            String descricao = "";
            while (rs.next()) {

                idCategoria = rs.getInt("IDCategoria");
                descricao = rs.getString("Descricao");
                cat.setIDCategoria(idCategoria);
                cat.setDescricao(descricao);

            }
        } catch (SQLException sqlEx) {
            System.out.println("Erro de BD = " + sqlEx.getErrorCode() + " - " + sqlEx.getMessage());
        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }

        return cat;

    }

    @Override
    public Categoria getCategoria(String descricao) {
     Categoria cat = new Categoria();
       

        try {
            PreparedStatement pStatementGetCategoria = conexao.prepareStatement("Select IDCategoria, Descricao from TB_Categoria  WHERE Descricao = ?");
            pStatementGetCategoria.setString(1, descricao);
            ResultSet rs = pStatementGetCategoria.executeQuery();

            int idCategoria = -1;
            String descricaoCategoria = "";
            while (rs.next()) {

                idCategoria = rs.getInt("IDCategoria");
                descricaoCategoria = rs.getString("Descricao");
                cat.setIDCategoria(idCategoria);
                cat.setDescricao(descricao);

            }
        } catch (SQLException sqlEx) {
            System.out.println("Erro de BD = " + sqlEx.getErrorCode() + " - " + sqlEx.getMessage());
        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }

        return cat;

    }

    @Override
    public void updateCategoria(Categoria categoria) {
         try {
            int idGerado = -1;
            
                    
            PreparedStatement pStatementUpdateCategoria = conexao.prepareStatement("UPDATE TB_Categoria SET Descricao = ?  WHERE IDCategoria = ?");
            pStatementUpdateCategoria.setString(1, categoria.getDescricao());
            pStatementUpdateCategoria.setInt(2, categoria.getIDCategoria());
    
            int resultado = pStatementUpdateCategoria.executeUpdate();
            
            if (resultado > 0) {
                
                System.out.println("Categoria de id " + categoria.getIDCategoria() + " atualizada com sucesso!");
            } else {
                System.out.println("Ops! Deu ruim X_X. Não foi possível atualizar a categoria");
            }

        } catch (SQLException ex) {
            System.out.println("Erro de BD = " + ex.getErrorCode() + " - " + ex.getMessage());
        }

        
    }

    @Override
    public int insertCategoria(Categoria categoria) {
        int idGerado = -1;
       try {
        
        PreparedStatement pStatementInsertCategoria = conexao.prepareStatement("Insert into TB_Categoria (descricao) values (?) ", PreparedStatement.RETURN_GENERATED_KEYS);
        pStatementInsertCategoria.setString(1, categoria.getDescricao());
        int resultado = pStatementInsertCategoria.executeUpdate();
        ResultSet rs = pStatementInsertCategoria.getGeneratedKeys();
        if(rs.first()) {
            idGerado = rs.getInt(1);
        }

        if(idGerado >0)
        {
            System.out.println("Categoria " + idGerado +  " inserida com suceso");
        }
        else
        {
            System.out.println("Não foi possivel inserir a Categoria");
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
    public void deleteCategoria(int id) {
        try {
            // TODO Auto-generated method stub

            PreparedStatement pStatementeDeleteCategoria = conexao.prepareStatement("DELETE FROM TB_Categoria WHERE IDCategoria = ? ");
             pStatementeDeleteCategoria.setInt(1, id);
             int resultado = pStatementeDeleteCategoria.executeUpdate();
             
             if(resultado > 0){
                 System.out.println("Categoria deletada com sucesso");
             }else{
                 System.out.println("Não foi possível deletar a categoria");
             }
            
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
        }
        
        
    }
}
