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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistema_padaria.Classes.Categoria;
import sistema_padaria.Classes.Perfil;

/**
 *
 * @author Pedro
 */
public class PerfilDAOImpl implements PerfilDAO {

    private Connection conexao;

    public PerfilDAOImpl() {
        conexao = Conexao.getConnection();

    }

    @Override
    public List<Perfil> getAllPerfis() {
        List<Perfil> lstPerfis = new ArrayList<Perfil>();
        try {
            PreparedStatement pStatementGetPerfil = conexao.prepareStatement("Select IDPerfil, Descricao from TB_Perfil ");
            ResultSet rs = pStatementGetPerfil.executeQuery();

            int id = -1;
            String descricao = "";
            while (rs.next()) {

                id = rs.getInt("IDPerfil");
                descricao = rs.getString("Descricao");

                Perfil perf = new Perfil();
                perf.setIDPerfil(id);
                perf.setDescricao(descricao);

                lstPerfis.add(perf);

            }
        } catch (SQLException sqlEx) {
            System.out.println("Erro de BD = " + sqlEx.getErrorCode() + " - " + sqlEx.getMessage());
        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }

        return lstPerfis;
    }

    @Override
    public Perfil getPerfilByID(int id) {
        // TODO Auto-generated method stub
        Perfil perf = new Perfil();

        try {
            
            PreparedStatement pStatementGetPerfil = conexao.prepareStatement("Select IDPerfil, Descricao from TB_Perfil  WHERE IDPerfil = ?");
            pStatementGetPerfil.setInt(1, id);
            ResultSet rs = pStatementGetPerfil.executeQuery();
            
            String descricao = "";
            while (rs.next()) {

                id = rs.getInt("IDPerfil");
                descricao = rs.getString("Descricao");
                perf.setIDPerfil(id);
                perf.setDescricao(descricao);

            }
        } catch (SQLException sqlEx) {
            System.out.println("Erro de BD = " + sqlEx.getErrorCode() + " - " + sqlEx.getMessage());
        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }

        return perf;

    }

    @Override
    public Perfil getPerfilByDesc(String descricao) {
        Perfil perf = new Perfil();
        perf.setIDPerfil(-1);

        try {
            PreparedStatement pStatementGetPerfil = conexao.prepareStatement("Select IDPerfil, Descricao from TB_Perfil  WHERE Descricao = ?");
            pStatementGetPerfil.setString(1, descricao);
            ResultSet rs = pStatementGetPerfil.executeQuery();

            int id = -1;

            while (rs.next()) {

                id = rs.getInt("IDPerfil");
                descricao = rs.getString("Descricao");
                perf.setIDPerfil(id);
                perf.setDescricao(descricao);

            }
        } catch (SQLException sqlEx) {
            System.out.println("Erro de BD = " + sqlEx.getErrorCode() + " - " + sqlEx.getMessage());
        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }

        return perf;

    }

    @Override
    public void updatePerfil(Perfil perfil, String Descricao) {
        Perfil perfilBusca = getPerfilByDesc(Descricao);
        if (perfilBusca.getIDPerfil() > 0) {
            try {
                int idGerado = -1;
                System.out.println(perfil.getDescricao());
                System.out.println(perfil.getIDPerfil());
                PreparedStatement pStatementUpdatePerfil = conexao.prepareStatement("UPDATE TB_Perfil SET Descricao = ? WHERE IDPerfil = (?)");
                pStatementUpdatePerfil.setString(1, perfil.getDescricao());
                pStatementUpdatePerfil.setInt(2, perfilBusca.getIDPerfil());
                int resultado = pStatementUpdatePerfil.executeUpdate();

                if (resultado > 0){
                    System.out.println("Perfil de id " + perfilBusca.getIDPerfil() + " atualizado com sucesso!");
                } else {
                    System.out.println("Ops! Deu ruim X_X. Não foi possível atualizar o perfil");
                }

            } catch (SQLException ex) {
                System.out.println("Erro de BD = " + ex.getErrorCode() + " - " + ex.getMessage());
            }

        } else {
            System.out.println("Perfil não encontrado");
        }

    }

    @Override
    public int insertPerfil(Perfil perfil) {
        int idGerado = -1;
        try {

            PreparedStatement pStatementInsertPerfil = conexao.prepareStatement("Insert into TB_Perfil (descricao) values (?) ", PreparedStatement.RETURN_GENERATED_KEYS);
            pStatementInsertPerfil.setString(1, perfil.getDescricao());

            int resultado = pStatementInsertPerfil.executeUpdate();
            ResultSet rs = pStatementInsertPerfil.getGeneratedKeys();
            if (rs.first()) {
                idGerado = rs.getInt(1);
            }

            if (idGerado > 0) {
                System.out.println("Perfil " + idGerado + " inserida com suceso");
            } else {
                System.out.println("Não foi possivel inserir a Categoria");
            }

        } catch (SQLException sqlEx) {
            System.out.println("Erro de BD = " + sqlEx.getErrorCode() + " - " + sqlEx.getMessage());
        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }
        return idGerado;

    }

    @Override
    public void deletePerfil(int id) {
        try {
            // TODO Auto-generated method stub

            PreparedStatement pStatementeDeletePerfil = conexao.prepareStatement("DELETE FROM TB_Perfil WHERE IDPerfil = ? ");
            pStatementeDeletePerfil.setInt(1, id);
            int resultado = pStatementeDeletePerfil.executeUpdate();

            if (resultado > 0) {
                System.out.println("Perfil deletado com sucesso");
            } else {
                System.out.println("Não foi possível deletar o perfil");
            }

        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
        }

    }

}
