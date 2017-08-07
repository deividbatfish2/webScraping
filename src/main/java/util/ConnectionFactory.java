package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {

	private String host = "havana.autoglass.com.br";
	private String user = "QUALIDADE.TI";
	private String pass = "teste";

	public Connection c;

	/**
	 * Construtor da classe
	 *
	 * @param host
	 *            Host em que se deseja conectar
	 * @param user
	 *            Nome do usuário
	 * @param pass
	 *            Senha do usuário
	 */

	/**
	 * Método que estabelece a conexão com o banco de dados
	 *
	 * @return True se conseguir conectar, falso em caso contrário.
	 */
	public Connection getConnection() {

		String serverName = this.host;
		String portNumber = "1521";
		String servico = "HAVANA";
		String userName = this.user;
		String passName = this.pass;
		String url = "jdbc:oracle:thin:@" + serverName + ":" + portNumber + ":" + servico;

		try {
			this.c = DriverManager.getConnection(url, userName, passName);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return this.c;
	}

	/**
	 * Esse método executa a query dada, e retorna um ResultSet Talvez fosse
	 * melhor idéia fazer esse método lançar uma exception a faze-lo retornar
	 * null como eu fiz, porém isso é apenas um exemplo para demonstrar a
	 * funcionalidade do comando execute
	 *
	 * @param query
	 *            String contendo a query que se deseja executar
	 * @return ResultSet em caso de estar tudo Ok, null em caso de erro.
	 */
	public ResultSet executar(String query) {
		Statement st;
		ResultSet rs;

		try {
			st = this.c.createStatement();
			rs = st.executeQuery(query);
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Executa uma query como update, delete ou insert. Retorna o número de
	 * registros afetados quando falamos de um update ou delete ou retorna 1
	 * quando o insert é bem sucedido. Em outros casos retorna -1
	 *
	 * @param query
	 *            A query que se deseja executar
	 * @return 0 para um insert bem sucedido. -1 para erro
	 */
	public int inserir(String query) {
		Statement st;
		int result = -1;

		try {
			st = this.c.createStatement();
			result = st.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * Método que estabelece a desconexão com o banco de dados
	 */

	public void close() {
		try {
			c.close();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
