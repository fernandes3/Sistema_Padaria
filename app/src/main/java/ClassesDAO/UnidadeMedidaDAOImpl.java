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
import sistema_padaria.Classes.Perfil;
import sistema_padaria.Classes.UnidadeMedida;
import sistema_padaria.Classes.Usuario;

/**
 *
 * @author Pedro
 */
public class UnidadeMedidaDAOImpl implements UnidadeMedidaDAO {

    private Connection conexao;

    public UnidadeMedidaDAOImpl() {
        conexao = Conexao.getConnection();
    }

    @Override
    public List<UnidadeMedida> getAllUnidadesMedida() {
        List<UnidadeMedida> lstUnidadesMedida = new ArrayList<UnidadeMedida>();

        try {
            PreparedStatement pStatementGetUsuario = conexao.prepareStatement("SELECT IDUnidadeMedida, Descricao FROM TB_UnidadeMedida");

            ResultSet rs = pStatementGetUsuario.executeQuery();

            int id = -1;
            String descricao = "";

            while (rs.next()) {
                id = rs.getInt("IDUnidadeMedida");
                descricao = rs.getString("Descricao");
                //IDUsuario, Perfil perfil, String NomeUsuario, String Senha, String Status
                UnidadeMedida unidade = new UnidadeMedida(id, descricao);
                lstUnidadesMedida.add(unidade);

            }
        } catch (SQLException ex) {
            System.out.println("Erro de BD = " + ex.getErrorCode() + " - " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }

        return lstUnidadesMedida;
    }

    @Override
    public UnidadeMedida getUnidadeMedidaByID(int id) {

        UnidadeMedida unidade = null;

        try {
            PreparedStatement pStatementGetUnidadeMedida = conexao.prepareStatement("SELECT IDUnidadeMedida, Descricao FROM TB_UnidadeMedida  WHERE IDUnidadeMedida = ?");
            pStatementGetUnidadeMedida.setInt(1, id);
            ResultSet rs = pStatementGetUnidadeMedida.executeQuery();
            String descricao = "";

            while (rs.next()) {
                id = rs.getInt("IDUnidadeMedida");
                descricao = rs.getString("Descricao");
                unidade = new UnidadeMedida(id, descricao);
                System.out.println(unidade.getDescricao());
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return unidade;
    }

    @Override
    public UnidadeMedida getUnidadeMedidaByDesc(String unidadeMedida) {
        UnidadeMedida unidade = null;
        // user.setIDUsuario(-1);

        try {
            PreparedStatement pStatementGetUnidadeMedida = conexao.prepareStatement("SELECT IDUnidadeMedida, Descricao  FROM TB_UnidadeMedida WHERE Descricao = ?");
            pStatementGetUnidadeMedida.setString(1, unidadeMedida);
            ResultSet rs = pStatementGetUnidadeMedida.executeQuery();

            int id = -1;
            String descricao = "";

            while (rs.next()) {

                id = rs.getInt("IDUnidadeMedida");

                descricao = rs.getString("Descricao");

                unidade = new UnidadeMedida(id, descricao);

            }
        } catch (SQLException sqlEx) {
            System.out.println("Erro de BD = " + sqlEx.getErrorCode() + " - " + sqlEx.getMessage());
        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }

        return unidade;
    }

    @Override
    public void updateUnidadeMedida(UnidadeMedida unidadeMedida) {
        try {
            int idGerado = -1;

            PreparedStatement pStatementUpdateUnidadeMedida = conexao.prepareStatement("UPDATE TB_UnidadeMedida SET Descricao = ? WHERE IDUnidadeMedida = ?");
            pStatementUpdateUnidadeMedida.setString(1, unidadeMedida.getDescricao());
            pStatementUpdateUnidadeMedida.setInt(2, unidadeMedida.getIDUnidadeMedida());
            int resultado = pStatementUpdateUnidadeMedida.executeUpdate();

            if (resultado > 0) {
                System.out.println("Unidade de medida de id " + unidadeMedida.getIDUnidadeMedida() + " atualizada com sucesso!");
            } else {
                System.out.println("Ops! Deu ruim X_X. Não foi possível atualizar a Unidade de Medida");
            }

        } catch (SQLException ex) {
            System.out.println("Erro de BD = " + ex.getErrorCode() + " - " + ex.getMessage());
        }
    }

    @Override
    public int insertUnidadeMedida(UnidadeMedida unidadeMedida) {
        int idGerado = -1;
        try {

            PreparedStatement pStatementInsertUnidadeMedida = conexao.prepareStatement("Insert into TB_UnidadeMedida(Descricao) values (?) ", PreparedStatement.RETURN_GENERATED_KEYS);
            pStatementInsertUnidadeMedida.setString(1, unidadeMedida.getDescricao());

            int resultado = pStatementInsertUnidadeMedida.executeUpdate();
            ResultSet rs = pStatementInsertUnidadeMedida.getGeneratedKeys();
            if (rs.first()) {
                idGerado = rs.getInt(1);
            }

            if (idGerado > 0) {
                System.out.println("Unidade de Medida " + idGerado + " inserida com suceso");
            } else {
                System.out.println("Não foi possivel inserir a  Unidade de Medida");
            }

        } catch (SQLException sqlEx) {
            System.out.println("Erro de BD = " + sqlEx.getErrorCode() + " - " + sqlEx.getMessage());
        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }
        return idGerado;
    }

    @Override
    public void deleteUnidadeMedida(int id) {
        try {
            PreparedStatement pStatementeDeleteUnidadeMedida = conexao.prepareStatement("DELETE FROM TB_UnidadeMedida WHERE IDUnidadeMedida = ? ");
            pStatementeDeleteUnidadeMedida.setInt(1, id);
            int resultado = pStatementeDeleteUnidadeMedida.executeUpdate();

            if (resultado > 0) {
                System.out.println("UnidadeMedida deletada com sucesso");
            } else {
                System.out.println("Não foi possível deletar a Unidade de Medida");
            }

        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
        }
    }

}
