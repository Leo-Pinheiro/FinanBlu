package br.senac.finanblu.modelo.dao.empresa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.senac.finanblu.modelo.dao.contato.ContatoDAOImpl;
import br.senac.finanblu.modelo.dao.pessoaJuridica.PessoaJuridicaDAOImpl;
import br.senac.finanblu.modelo.entidade.contato.Contato;
import br.senac.finanblu.modelo.entidade.empresa.Empresa;
import br.senac.finanblu.modelo.entidade.pessoaJuridica.PessoaJuridica;

public class EmpresaDAOImpl implements EmpresaDAO {

	public void inserirEmpresa(Empresa empresa) {
		Connection conexao = null;
		PreparedStatement insert = null;

		try {
			conexao = conectarBanco();
			insert = conexao.prepareStatement(
					"INSERT INTO empresa(id_pessoa_juridica, id_contato, senha_empresa) VALUES (?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);

			insert.setLong(1, empresa.getPessoaJuridica().getId());

			Contato contato = empresa.getContato();
			insert.setLong(2, contato.getId());

			insert.setString(3, empresa.getSenha());

			insert.execute();

			ResultSet chavePrimaria = insert.getGeneratedKeys();

			if (chavePrimaria.next())
				empresa.setId(chavePrimaria.getLong(1));

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
	}

	public void deletarEmpresa(Empresa empresa) {
		Connection conexao = null;
		PreparedStatement delete = null;

		try {
			conexao = conectarBanco();
			delete = conexao.prepareStatement("DELETE FROM empresa WHERE id_empresa = ?");

			delete.setLong(1, empresa.getId());
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

	public void atualizarEmpresa(Empresa empresa) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {
			conexao = conectarBanco();
			update = conexao.prepareStatement(
					"Update empresa set id_contato = ?, id_pessoa_juridica = ?, senha_empresa = ? where id_empresa = ?");
			update.setLong(1, empresa.getContato().getId());
			update.setLong(2, empresa.getPessoaJuridica().getId());
			update.setString(3, empresa.getSenha());
			update.setLong(4, empresa.getId());
			update.execute();
			System.out.println("Empresa atualizada com sucesso!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Empresa> recuperarEmpresas() {
		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Empresa> empresas = new ArrayList<Empresa>();

		try {
			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta
					.executeQuery("select id_empresa, id_contato, id_pessoa_juridica, senha_empresa from empresa");

			while (resultado.next()) {
				long idEmpresa = resultado.getLong("id_empresa");
				long idPessoaJuridica = resultado.getLong("id_pessoa_juridica");
				PessoaJuridica pessoaJuridica = new PessoaJuridicaDAOImpl()
						.recuperarPessoaJuridicaPorId(idPessoaJuridica);
				long idContato = resultado.getLong("id_contato");
				Contato contato = new ContatoDAOImpl().recuperarContatoPorId(idContato);
				String senha = resultado.getString("senha_empresa");

				empresas.add(new Empresa(idEmpresa, pessoaJuridica, contato, senha));

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

		return empresas;
	}

	private Connection conectarBanco() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/finanblu?user=root&password=root");
	}
}
