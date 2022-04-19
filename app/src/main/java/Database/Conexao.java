/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

/**
 *
 * @author Pedro
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static Connection connection = null;

    private static String url = "jdbc:mysql://mysql746.umbler.com:41890/padaria_poo";
    private static String usuario = "pooii2022";
    private static String senha = "2022pooii";

    private Conexao()
	{
		try
		{
			connection = DriverManager.getConnection(url, usuario, senha); 
			System.out.println("Conexão ok");

		} catch (SQLException e)
		{
			System.err.println("Erro de conexao");
			System.exit(0);
		} 
	}

	
	public static Connection  getConnection()
	{
		if (connection == null)
		{
			new Conexao();
		}

		return connection;
	}
    
}
