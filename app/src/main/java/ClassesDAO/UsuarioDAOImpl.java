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
import sistema_padaria.Classes.Perfil;
import sistema_padaria.Classes.Usuario;

/**
 *
 * @author Pedro
 */
public class UsuarioDAOImpl implements UsuarioDAO {

    private Connection conexao;

    public UsuarioDAOImpl() {
        conexao = Conexao.getConnection();
    }

    @Override
    public List<Usuario> getAllUsers() {
        List<Usuario> lstUsers = new ArrayList<Usuario>();

        try {
            PreparedStatement pStatementGetUsuario = conexao.prepareStatement("SELECT u.IDUsuario, u.Nome, u.Senha, u.Status, p.Descricao  "
                    + "FROM TB_Usuario u "
                    + "INNER JOIN TB_Perfil p  ON u.IDPerfil = p.IDPerfil");

            ResultSet rs = pStatementGetUsuario.executeQuery();

            int id = -1;
            String nome = "";
            String senha = "";
            String status = "";
            String descricaoPerfil = "";

            while (rs.next()) {
                id = rs.getInt("u.IDUsuario");
                nome = rs.getString("u.Nome");
                senha = rs.getString("u.Senha");
                status = rs.getString("u.Status");
                //Pega descrição do Perfil do usuário;
                Perfil perf = new Perfil();
                perf.setDescricao(rs.getString("p.Descricao"));
                //IDUsuario, Perfil perfil, String NomeUsuario, String Senha, String Status
                Usuario user = new Usuario(id, perf, nome, senha, status);
                lstUsers.add(user);

            }
        } catch (SQLException ex) {
            System.out.println("Erro de BD = " + ex.getErrorCode() + " - " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }

        return lstUsers;

    }

    @Override
    public Usuario getUserById(int id) {

        Usuario user = null;

        try {
            PreparedStatement pStatementGetUsuario = conexao.prepareStatement("Select u.IDUsuario, u.Nome,"
                    + "u.Senha, u.Status, p.Descricao FROM TB_Usuario u"
                    + " INNER JOIN TB_Perfil p ON u.IDPerfil = p.IDPerfil  WHERE u.IDUsuario = ?");
            pStatementGetUsuario.setInt(1, id);
            ResultSet rs = pStatementGetUsuario.executeQuery();
            String descricao = "";
            String nome = "";
            String senha = "";
            String status = "";
            while (rs.next()) {
                id = rs.getInt("u.IDUsuario");
                nome = rs.getString("u.Nome");
                senha = rs.getString("u.Senha");
                status = rs.getString("u.Status");
                descricao = rs.getString("p.Descricao");

                Perfil perf = new Perfil();
                perf.setDescricao(descricao);
                user = new Usuario(id, perf, nome, senha, status);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return user;
    }

    @Override
    public Usuario getUserByDesc(String nomeUsuario) {
        Usuario user = null;
        // user.setIDUsuario(-1);

        try {
            PreparedStatement pStatementGetUsuario = conexao.prepareStatement("Select u.IDUsuario, u.Nome, u.Senha, u.Status,p.IDPerfil, p.Descricao"
                    + "  FROM TB_Usuario u INNER JOIN TB_Perfil p  WHERE u.Nome = ?");
            pStatementGetUsuario.setString(1, nomeUsuario);
            ResultSet rs = pStatementGetUsuario.executeQuery();

            int id = -1;
            String nome = "";
            String senha = "";
            String status = "";
            String descricaoPerfil = "";
            int IDPerfil = -1;

            while (rs.next()) {

                id = rs.getInt("u.IDUsuario");
                nome = rs.getString("u.Nome");
                senha = rs.getString("u.Senha");
                status = rs.getString("u.Status");
                descricaoPerfil = rs.getString("p.Descricao");
                IDPerfil = rs.getInt("p.IDPerfil");
                Perfil perf = new Perfil();
                perf.setIDPerfil(IDPerfil);
                perf.setDescricao(descricaoPerfil);
                user = new Usuario(id, perf, nome, senha, status);

            }
        } catch (SQLException sqlEx) {
            System.out.println("Erro de BD = " + sqlEx.getErrorCode() + " - " + sqlEx.getMessage());
        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }

        return user;

    }

    @Override
    public void updateUser(Usuario user) { // Usuario u =  new Usuario ("Pedro", usuarioBusca.get
        try {
            int idGerado = -1;

            PreparedStatement pStatementUpdateUsuario = conexao.prepareStatement("UPDATE TB_Usuario SET Nome = ?, Senha = ? , Status = ?, IDPerfil = ? WHERE IDUsuario = ?");
            pStatementUpdateUsuario.setString(1, user.getNomeUsuario());
            pStatementUpdateUsuario.setString(2, user.getSenha());
            pStatementUpdateUsuario.setString(3, user.getStatus());
            pStatementUpdateUsuario.setInt(4, user.getPerfil().getIDPerfil());
            pStatementUpdateUsuario.setInt(5, user.getIDUsuario());
            int resultado = pStatementUpdateUsuario.executeUpdate();

            if (resultado > 0) {
                System.out.println("Usuário de id " + user.getIDUsuario() + " atualizado com sucesso!");
            } else {
                System.out.println("Ops! Deu ruim X_X. Não foi possível atualizar o perfil");
            }

        } catch (SQLException ex) {
            System.out.println("Erro de BD = " + ex.getErrorCode() + " - " + ex.getMessage());
        }

    }

    @Override
    public int insertUser(Usuario user) {
          int idGerado = -1;
       try {
        
        PreparedStatement pStatementInsertUsuario = conexao.prepareStatement("Insert into TB_Usuario(Nome, Senha, Status, IDPerfil) values (?, ?, ?, ?) ", PreparedStatement.RETURN_GENERATED_KEYS);
        pStatementInsertUsuario.setString(1, user.getNomeUsuario());
        pStatementInsertUsuario.setString(2,user.getSenha());
        pStatementInsertUsuario.setString(3,user.getStatus());
        pStatementInsertUsuario.setInt(4,user.getPerfil().getIDPerfil());
        
        
        int resultado = pStatementInsertUsuario.executeUpdate();
        ResultSet rs = pStatementInsertUsuario.getGeneratedKeys();
        if(rs.first()) {
            idGerado = rs.getInt(1);
        }

        if(idGerado >0)
        {
            System.out.println("Usuario " + idGerado +  " inserido com suceso");
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
    public void deleteUser(int id) {
      try {
            PreparedStatement pStatementeDeleteUsuario = conexao.prepareStatement("DELETE FROM TB_Usuario WHERE IDUsuario = ? ");
             pStatementeDeleteUsuario.setInt(1, id);
             int resultado = pStatementeDeleteUsuario.executeUpdate();
             
             if(resultado > 0){
                 System.out.println("Usuário deletado com sucesso");
             }else{
                 System.out.println("Não foi possível deletar  o usuário");
             }
            
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
        }
    }

}
