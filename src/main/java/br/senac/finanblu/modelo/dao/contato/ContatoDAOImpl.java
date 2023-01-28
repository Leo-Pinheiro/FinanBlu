package br.senac.finanblu.modelo.dao.contato;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.senac.finanblu.modelo.entidade.contato.Contato;

public class ContatoDAOImpl implements ContatoDAO {

	public Contato inserirContato(Contato contato) {

		Connection conexao = null;
		PreparedStatement insert = null;

		try {
			conexao = conectarBanco();
			insert = conexao.prepareStatement("INSERT INTO contato (telefone_contato, email_contato) VALUES (?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);

			insert.setString(1, contato.getTelefone());
			insert.setString(2, contato.getEmail());

			insert.execute();
			ResultSet chavePrimaria = insert.getGeneratedKeys();

			if (chavePrimaria.next())
				contato.setId(chavePrimaria.getLong(1));

		} catch (SQLException erro) {
			erro.printStackTrace();
		} finally {
			try {
				if (insert != null)
					insert.close();

				if (conexao != null)
					conexao.close();

			} catch (SQLException erro) {
				erro.printStackTrace();
			}
		}
		return contato;

	}

	public void deletarContato(Contato contato) {

		Connection conexao = null;
		PreparedStatement delete = null;

		try {

			conexao = conectarBanco();
			delete = conexao.prepareStatement("DELETE FROM contato WHERE id_contato = ?");

			delete.setLong(1, contato.getId());

			delete.execute();

		} catch (SQLException erro) {
			erro.printStackTrace();
		}

		finally {

			try {

				if (delete != null)
					delete.close();

				if (conexao != null)
					conexao.close();

			} catch (SQLException erro) {

				erro.printStackTrace();
			}
		}
	}

	public void atualizarContato(Contato contato) {
		Connection conexao = null;
		PreparedStatement update = null;

		try {
			conexao = conectarBanco();
			update = conexao.prepareStatement(
					"Update contato set telefone_contato = ?, email_contato = ? where id_contato = ?");
			update.setString(1,  contato.getTelefone());
			update.setString(2, contato.getEmail());
			update.setLong(3, contato.getId());
			update.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Contato> recuperarContatos() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Contato> contatos = new ArrayList<Contato>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM contato");

			while (resultado.next()) {

				long id = resultado.getInt("id_contato");
				String telefone = resultado.getString("telefone_contato");
				String email = resultado.getString("email_contato");

				contatos.add(new Contato(id, telefone, email));
			}

		} catch (SQLException erro) {
			erro.printStackTrace();
		}

		finally {

			try {

				if (resultado != null)
					resultado.close();

				if (consulta != null)
					consulta.close();

				if (conexao != null)
					conexao.close();

			} catch (SQLException erro) {

				erro.printStackTrace();
			}
		}

		return contatos;
	}
	public Contato recuperarContatoPorId(long id) {

		Connection conexao = null;
		PreparedStatement consulta = null;
		ResultSet resultado = null;
		Contato contato = null;
		try {

			conexao = conectarBanco();
			
			consulta = conexao.prepareStatement("SELECT * FROM contato WHERE id_contato = ?");
			consulta.setLong(1, id);
			consulta.execute();
			resultado = consulta.getResultSet();
			while (resultado.next()) {
			  
				String telefone = resultado.getString("telefone_contato");
				String email = resultado.getString("email_contato");

				contato = new Contato(id, telefone, email);
			}

		} catch (SQLException erro) {
			erro.printStackTrace();
		}

		finally {

			try {

				if (resultado != null)
					resultado.close();

				if (consulta != null)
					consulta.close();

				if (conexao != null)
					conexao.close();

			} catch (SQLException erro) {

				erro.printStackTrace();
			}
		}

		return contato;
	}

	private Connection conectarBanco() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/finanblu?user=root&password=root");
	}

	
}
