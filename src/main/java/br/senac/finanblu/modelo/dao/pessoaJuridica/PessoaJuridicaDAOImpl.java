package br.senac.finanblu.modelo.dao.pessoaJuridica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.senac.finanblu.modelo.entidade.pessoaJuridica.PessoaJuridica;

public class PessoaJuridicaDAOImpl implements PessoaJuridicaDAO {

	public PessoaJuridica inserirPessoaJuridica(PessoaJuridica pessoaJuridica) {
		Connection conexao = null;
		PreparedStatement insert = null;

		try {
			conexao = conectarBanco();
			insert = conexao.prepareStatement(
					"INSERT INTO pessoa_juridica(cnpj_pessoa_juridica, razao_social_pessoa_juridica, nome_fantasia_pessoa_juridica) VALUES (?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			insert.setString(1, pessoaJuridica.getCnpj());
			insert.setString(2, pessoaJuridica.getRazaoSocial());
			insert.setString(3, pessoaJuridica.getNomeFantasia());

			insert.execute();
			ResultSet chavePrimaria = insert.getGeneratedKeys();

			if (chavePrimaria.next())
				pessoaJuridica.setId(chavePrimaria.getLong(1));

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
		return pessoaJuridica;
	}

	public void deletarPessoaJuridica(PessoaJuridica pessoaJuridica) {
		Connection conexao = null;
		PreparedStatement delete = null;

		try {
			conexao = conectarBanco();
			delete = conexao.prepareStatement("DELETE FROM pessoa_juridica WHERE id_pessoa_juridica = ?");

			delete.setLong(1, pessoaJuridica.getId());
			delete.execute();
		} catch (SQLException erro) {
			erro.printStackTrace();
		} finally {
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

	public void atualizarPessoaJuridica(PessoaJuridica pessoaJuridica) {
		Connection conexao = null;
		PreparedStatement update = null;

		try {
			conexao = conectarBanco();
			update = conexao.prepareStatement(
					"Update pessoa_juridica set razao_social_pessoa_juridica = ?, nome_fantasia_pessoa_juridica = ?, cnpj_pessoa_juridica = ? where id_pessoa_juridica = ?");
			update.setString(1, pessoaJuridica.getRazaoSocial());
			update.setString(2, pessoaJuridica.getNomeFantasia());
			update.setString(3, pessoaJuridica.getCnpj());
			update.setLong(4, pessoaJuridica.getId());
			update.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<PessoaJuridica> recuperarPessoasJuridicas() {
		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<PessoaJuridica> pessoasJuridicas = new ArrayList<PessoaJuridica>();

		try {
			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM pessoa_juridica");

			while (resultado.next()) {
				long id = resultado.getLong("id_pessoa_juridica");
				String razaoSocial = resultado.getString("razao_social_pessoa_juridica");
				String nomeFantasia = resultado.getString("nome_fantasia_pessoa_juridica");
				String cnpj = resultado.getString("cnpj_pessoa_juridica");

				pessoasJuridicas.add(new PessoaJuridica(id, razaoSocial, nomeFantasia, cnpj));

			}

		} catch (SQLException erro) {
			erro.printStackTrace();
		} finally {
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

		return pessoasJuridicas;
	}

	public PessoaJuridica recuperarPessoaJuridicaPorId(long id) {

		Connection conexao = null;
		PreparedStatement consulta = null;
		ResultSet resultado = null;
		PessoaJuridica pessoaJuridica = null;
		try {

			conexao = conectarBanco();

			consulta = conexao.prepareStatement("SELECT * FROM pessoa_juridica WHERE id_pessoa_juridica = ?");
			consulta.setLong(1, id);
			consulta.execute();
			resultado = consulta.getResultSet();
			while (resultado.next()) {

				String razaoSocial = resultado.getString("razao_social_pessoa_juridica");
				String nomeFantasia = resultado.getString("nome_fantasia_pessoa_juridica");
				String cnpj = resultado.getString("cnpj_pessoa_juridica");

				pessoaJuridica = new PessoaJuridica(id, razaoSocial, nomeFantasia, cnpj);
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

		return pessoaJuridica;
	}

	private Connection conectarBanco() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/finanblu?user=root&password=root");
	}



}