package com.tef.api.connection;

import java.sql.Connection;
import java.sql.DriverManager;

/*Responsavel por fazer a Conexão com Banco de dados*/
public class SingleConnection {

	
	  private static String banco =
	  "jdbc:postgresql://localhost:5432/neomind?autoReconnect=true"; private static
	  String password = "admin"; private static String user = "postgres";
	 

	/* Heroku */

	/*
	 * private static String banco =
	 * "jdbc:postgresql://ec2-107-21-209-1.compute-1.amazonaws.com:5432/dbsp7cicdfhgbf?sslmode=require";
	 * private static String password =
	 * "edb6abd39756fb24a5875b15f6da7530eebe2c0118d2e798a682a3616907b3b2"; private
	 * static String user = "btcucseidvygag";
	 */

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
				/*System.out.println("Conexão com Sucesso");*/
			}

		} catch (Exception e) {
			throw new RuntimeException("Erro ao conectar com o Banco de Dados");

		}

	}

	public static Connection getConnection() {

		return connection;
	}
}
