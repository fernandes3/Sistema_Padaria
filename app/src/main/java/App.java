import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import sistema_padaria.Classes.Perfil;


public class App {
    public static void main(String[] args) throws SQLException {

      
        //Try With Resources
        try (Connection cnn = conecta()){

            Perfil p = new Perfil();
            p.setDescricao("Teste");
            p.setIDPerfil(1);
          
            if(cnn.isValid(5)){
                //Inserção
                PreparedStatement pStatementInsereAluno = cnn.prepareStatement("Insert into TB_Perfil (Descricao) values (?) ", Statement.RETURN_GENERATED_KEYS);
                pStatementInsereAluno.setString(1, p.getDescricao());
           

                int resultado = pStatementInsereAluno.executeUpdate();
                if(resultado >0)
                {
                    System.out.println("Aluno inserido com suceso");
                }
                else
                {
                    System.out.println("Não foi possivel inserir o aluno");
                }

                //pStatementInsereAluno.close();

                //Consulta
                PreparedStatement pStatementConsultaAlunos = cnn.prepareStatement("Select IDPerfil, Descricao from TB_Perfil");
                ResultSet rs = pStatementConsultaAlunos.executeQuery();

                int tmpIDPerfil = 0;
                String tmpDescricao = "";
                while(rs.next()) {
                    
                    tmpIDPerfil = rs.getInt("IDPerfil");
                    tmpDescricao = rs.getString("Descricao");

                    System.out.println("IDPerfil = " + tmpIDPerfil + " | Descricao = " + tmpDescricao  );

                }
               // rs.close();
               // pStatementConsultaAlunos.close();
              // desconecta(cnn);

            }
        }

        catch(SQLException sqlEx) {
            System.out.println("Erro de BD = " + sqlEx.getErrorCode()  + " - " +  sqlEx.getMessage());
        }
        catch (Exception ex) {
            System.out.println("Erro = " +    ex.getMessage());
        } 
       
       

    }

    public static Connection conecta () throws Exception {
        //jdbc:mysql -> Indica que o driver para MySql será usado
        /* Exemplos:

           "jdbc:mysql://localhost:3306/exemplojdbc202201"
           "jdbc:postgresql://localhost/exemplojdbc202201"
           "jdbc:oracle:thin:@192.168.2.145:5321:exemplojdbc202201"
        */
        String url = "jdbc:mysql://mysql746.umbler.com:41890/padaria_poo";
        String usuario = "pooii2022";
        String senha = "2022pooii";
        Connection c = DriverManager.getConnection(url, usuario, senha);
        boolean conexaoValida = c.isValid(5);

        if(conexaoValida) {
            System.out.println("Conexao válida");
        }
        else {
            System.err.println("Conexao invalida");
        }

        return c;

    }

    public static void desconecta (Connection cnn) throws Exception {
        if(cnn.isValid(5)) {
            cnn.close();
        }
    }
}
