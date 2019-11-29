package connection;

import java.sql.Connection;
import java.sql.DriverManager;

/*Responsavel por fazer a Conexão com Banco de dados*/
public class SingleConnection {

	private static String banco = "jdbc:postgresql://localhost:5432/curso-jsp?autoReconnect=true";
	private static String password = "admin";
	private static String user = "postgres";
	private static Connection connection = null;

	/* Estanciar a classe executa a conexão */
	static {
		conectar();
	}

	public SingleConnection() {
		conectar();
	}

	private static void conectar() {

		try {

			if (connection == null) {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(banco, user, password);
				connection.setAutoCommit(false);
				/* System.out.println("Conexão com Sucesso"); */
			}

		} catch (Exception e) {
			throw new RuntimeException("Erro ao conectar com o Banco de Dados");

		}

	}

	public static Connection getConnection() {

		return connection;
	}
}
