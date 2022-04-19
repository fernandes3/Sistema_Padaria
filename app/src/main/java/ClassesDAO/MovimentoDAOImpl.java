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
import sistema_padaria.Classes.Movimento;
import sistema_padaria.Classes.Perfil;
import sistema_padaria.Classes.Produtos;
import sistema_padaria.Classes.UnidadeMedida;
import sistema_padaria.Classes.Usuario;

/**
 *
 * @author Pedro
 */
public class MovimentoDAOImpl implements MovimentoDAO {

    private Connection conexao;

    public MovimentoDAOImpl() {
        conexao = Conexao.getConnection();
    }

    @Override
    public List<Movimento> getAllMovimentos() {

        List<Movimento> lstMovimentos = new ArrayList<Movimento>();

        try {
            PreparedStatement pStatementGetMovimentos = conexao.prepareStatement("SELECT m.IDMovimento, m.Descricao, m.Tipo, m.DataMovimento, m.Valor,m.IDUsuario, u.Nome FROM TB_Movimento m INNER JOIN TB_Usuario u ON m.IDUsuario = u.IDUsuario");

            ResultSet rs = pStatementGetMovimentos.executeQuery();

            int idMovimento = -1;
            String descricaoMovimento = "";
            String tipoMovimento = "";
            Date dataMovimento = null;
            Double valorMovimento = -1.0;
            int idUsuario = -1;
            String nomeUsuario = "";

            while (rs.next()) {
                idMovimento = rs.getInt("m.IDMovimento");
                descricaoMovimento = rs.getString("m.Descricao");
                tipoMovimento = rs.getString("m.Tipo");
                dataMovimento = rs.getDate("m.DataMovimento");
                valorMovimento = rs.getDouble("m.Valor");
                idUsuario = rs.getInt("m.IDUsuario");
                nomeUsuario = rs.getString("u.Nome");

                Usuario us = new Usuario();
                us.setIDUsuario(idUsuario);
                us.setNomeUsuario(nomeUsuario);

                Movimento mv = new Movimento(idMovimento, us, dataMovimento, tipoMovimento, descricaoMovimento, valorMovimento);
                //IDUsuario, Perfil perfil, String NomeUsuario, String Senha, String Status

                lstMovimentos.add(mv);

            }
        } catch (SQLException ex) {
            System.out.println("Erro de BD = " + ex.getErrorCode() + " - " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }

        return lstMovimentos;

    }

    @Override
    public Movimento getMovimentoByID(int id) {
        Movimento mov = new Movimento();

        try {

            PreparedStatement pStatementGetMovimento = conexao.prepareStatement("Select m.IDMovimento, m.Descricao, m.Tipo, m.DataMovimento, m.Valor, m.IDUsuario, u.Nome from TB_Movimento m INNER JOIN TB_Usuario u ON m.IDUsuario = u.IDUsuario  WHERE m.IDMovimento = ?");
            pStatementGetMovimento.setInt(1, id);
            ResultSet rs = pStatementGetMovimento.executeQuery();

            int idMovimento = -1;
            String descricaoMovimento = "";
            String tipoMovimento = "";
            Date dataMovimento = null;
            Double valorMovimento = -1.0;
            int idUsuario = -1;
            String nomeUsuario = "";

            while (rs.next()) {

                idMovimento = rs.getInt("m.IDMovimento");
                descricaoMovimento = rs.getString("m.Descricao");
                tipoMovimento = rs.getString("m.Tipo");
                dataMovimento = rs.getDate("m.DataMovimento");
                valorMovimento = rs.getDouble("m.Valor");
                idUsuario = rs.getInt("m.IDUsuario");
                nomeUsuario = rs.getString("u.Nome");

                Usuario us = new Usuario();
                us.setIDUsuario(idUsuario);
                us.setNomeUsuario(nomeUsuario);

                mov = new Movimento(idMovimento, us, dataMovimento, tipoMovimento, descricaoMovimento, valorMovimento);
                //IDUsuario, Perfil perfil, String NomeUsuario, String Senha, String Status

            }
        } catch (SQLException sqlEx) {
            System.out.println("Erro de BD = " + sqlEx.getErrorCode() + " - " + sqlEx.getMessage());
        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }

        return mov;
    }

    @Override
    public Movimento getMovimentoByDesc(String descricaoMovimentox) {
        Movimento mov = new Movimento();

        try {
            PreparedStatement pStatementGetPerfil = conexao.prepareStatement("Select m.IDMovimento, m.Descricao, m.Tipo, m.DataMovimento, m.Valor, m.IDUsuario, u.Nome from TB_Movimento m INNER JOIN TB_Usuario u ON m.IDUsuario = u.IDUsuario  WHERE m.Descricao = ?");
            pStatementGetPerfil.setString(1, descricaoMovimentox);
            ResultSet rs = pStatementGetPerfil.executeQuery();

            int idMovimento = -1;
            String descricaoMovimento = "";
            String tipoMovimento = "";
            Date dataMovimento = null;
            Double valorMovimento = -1.0;
            int idUsuario = -1;
            String nomeUsuario = "";

            while (rs.next()) {

                idMovimento = rs.getInt("m.IDMovimento");
                descricaoMovimento = rs.getString("m.Descricao");
                tipoMovimento = rs.getString("m.Tipo");
                dataMovimento = rs.getDate("m.DataMovimento");
                valorMovimento = rs.getDouble("m.Valor");
                idUsuario = rs.getInt("m.IDUsuario");
                nomeUsuario = rs.getString("u.Nome");

                Usuario us = new Usuario();
                us.setIDUsuario(idUsuario);
                us.setNomeUsuario(nomeUsuario);

                mov = new Movimento(idMovimento, us, dataMovimento, tipoMovimento, descricaoMovimento, valorMovimento);

            }
        } catch (SQLException sqlEx) {
            System.out.println("Erro de BD = " + sqlEx.getErrorCode() + " - " + sqlEx.getMessage());
        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }
        return mov;
    }

    @Override
    public void updateMovimento(Movimento movimento) {
        try {
            int idGerado = -1;

            PreparedStatement pStatementUpdateUsuario = conexao.prepareStatement("UPDATE TB_Movimento SET Descricao = ?, Tipo = ? , Valor = ?, IDUsuario = ? WHERE IDMovimento = ?");
            pStatementUpdateUsuario.setString(1, movimento.getDescricao());
            pStatementUpdateUsuario.setString(2, movimento.getTipo());
            pStatementUpdateUsuario.setDouble(3, movimento.getValor());
            pStatementUpdateUsuario.setInt(4, movimento.getUsuario().getIDUsuario());
            pStatementUpdateUsuario.setInt(5, movimento.getIDMovimento());

            int resultado = pStatementUpdateUsuario.executeUpdate();

            if (resultado > 0) {
                System.out.println("Movimento de id " + movimento.getIDMovimento() + " atualizado com sucesso!");
            } else {
                System.out.println("Ops! Deu ruim X_X. Não foi possível atualizar o Movimento");
            }

        } catch (SQLException ex) {
            System.out.println("Erro de BD = " + ex.getErrorCode() + " - " + ex.getMessage());
        }
    }

    @Override
    public int insertMovimento(Movimento movimento) {
        int idGerado = -1;
        try {

            PreparedStatement pStatementInsertMovimento = conexao.prepareStatement("Insert into TB_Movimento(Descricao, Tipo,DataMovimento, Valor, IDUsuario) values (?, ?,?, ?, ?) ", PreparedStatement.RETURN_GENERATED_KEYS);
            pStatementInsertMovimento.setString(1, movimento.getDescricao());
            pStatementInsertMovimento.setString(2, movimento.getTipo());
            SimpleDateFormat sd =  new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            pStatementInsertMovimento.setString(3,sd.format(movimento.getDataMovimento()));
            pStatementInsertMovimento.setDouble(4, movimento.getValor());
            pStatementInsertMovimento.setInt(5, movimento.getUsuario().getIDUsuario());

            int resultado = pStatementInsertMovimento.executeUpdate();
            ResultSet rs = pStatementInsertMovimento.getGeneratedKeys();
            if (rs.first()) {
                idGerado = rs.getInt(1);
            }

            if (idGerado > 0) {
                System.out.println("Movimento " + idGerado + " inserido com suceso");
            } else {
                System.out.println("Não foi possivel inserir o Usuário");
            }

        } catch (SQLException sqlEx) {
            System.out.println("Erro de BD = " + sqlEx.getErrorCode() + " - " + sqlEx.getMessage());
        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }
        return idGerado;
    }

    @Override
    public void deleteMovimento(int id) {
        try {
            // TODO Auto-generated method stub

            PreparedStatement pStatementeDeleteMovimento = conexao.prepareStatement("DELETE FROM TB_Movimento WHERE IDMovimento = ? ");
            pStatementeDeleteMovimento.setInt(1, id);
            int resultado = pStatementeDeleteMovimento.executeUpdate();

            if (resultado > 0) {
                System.out.println("Movimento deletado com sucesso");
            } else {
                System.out.println("Não foi possível deletar o Movimento");
            }

        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
        }

    }
}
