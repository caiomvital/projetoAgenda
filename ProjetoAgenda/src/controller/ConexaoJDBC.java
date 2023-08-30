package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoJDBC {

	public static String url;
	public static String user;
	public static String pass;

	public static Connection obterConexao() throws SQLException {
		return DriverManager.getConnection(url, user, pass);
	}

	public static void fecharConexao(Connection conexao) {
		if (conexao != null) {
			try {
				conexao.close();
			} catch(SQLException e) {

			}
		}
	}
}
