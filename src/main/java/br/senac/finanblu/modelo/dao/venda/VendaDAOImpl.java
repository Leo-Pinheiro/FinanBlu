package br.senac.finanblu.modelo.dao.venda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.senac.finanblu.modelo.dao.cliente.ClienteDAOImpl;
import br.senac.finanblu.modelo.dao.contato.ContatoDAOImpl;
import br.senac.finanblu.modelo.dao.endereco.EnderecoDAOImpl;
import br.senac.finanblu.modelo.dao.pessoaJuridica.PessoaJuridicaDAOImpl;
import br.senac.finanblu.modelo.entidade.cliente.Cliente;
import br.senac.finanblu.modelo.entidade.contato.Contato;
import br.senac.finanblu.modelo.entidade.endereco.Endereco;
import br.senac.finanblu.modelo.entidade.pessoaJuridica.PessoaJuridica;
import br.senac.finanblu.modelo.entidade.venda.Venda;
import br.senac.finanblu.modelo.enumeracao.FormaPagamento;

public class VendaDAOImpl implements VendaDAO {

	public void inserirVenda(Venda venda) {
		Connection conexao = null;
		PreparedStatement insert = null;
		try {
			conexao = conectarBanco();
			insert = conexao.prepareStatement(
					"INSERT INTO venda (valor_venda, data_venda, forma_pagamento_venda, parcela_venda, id_cliente) VALUES (?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			insert.setFloat(1, venda.getValorVenda());
			insert.setString(2, venda.getDataVenda().toString());
			insert.setString(3, venda.getFormaPagamento().toString());
			insert.setShort(4, venda.getParcela());
			insert.setLong(5, venda.getCliente().getId());
			insert.execute();

			ResultSet chavePrimaria = insert.getGeneratedKeys();

			if (chavePrimaria.next())
				venda.setId(chavePrimaria.getLong(1));
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

	public void deletarVenda(Venda venda) {
		Connection conexao = null;
		PreparedStatement delete = null;

		try {

			conexao = conectarBanco();
			delete = conexao.prepareStatement("DELETE FROM venda WHERE id_venda = ?");

			delete.setLong(1, venda.getId());

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

	public void atualizarRazaoSocialCliente(Venda venda, String novaRazaoSocial) {
		Connection conexao = null;
		PreparedStatement update = null;
		try {
			conexao = conectarBanco();
			update = conexao.prepareStatement(
					"UPDATE pessoa_juridica SET razao_social_pessoa_juridica = ? WHERE id_pessoa_juridica = ?");

			update.setString(1, novaRazaoSocial);
			update.setLong(2, venda.getCliente().getPessoaJuridica().getId());

			update.execute();
		} catch (SQLException erro) {
			erro.printStackTrace();
		} finally {
			try {
				if (update != null)
					update.close();

				if (conexao != null)
					conexao.close();
			} catch (SQLException erro) {
				erro.printStackTrace();
			}
		}
	}

	public void atualizarNomeFantasiaCliente(Venda venda, String novoNomeFantasia) {
		Connection conexao = null;
		PreparedStatement update = null;
		try {
			conexao = conectarBanco();
			update = conexao.prepareStatement(
					"UPDATE pessoa_juridica SET nome_fantasia_pessoa_juridica = ? WHERE id_pessoa_juridica = ?");

			update.setString(1, novoNomeFantasia);
			update.setLong(2, venda.getCliente().getPessoaJuridica().getId());

			update.execute();
		} catch (SQLException erro) {
			erro.printStackTrace();
		} finally {
			try {
				if (update != null)
					update.close();

				if (conexao != null)
					conexao.close();
			} catch (SQLException erro) {
				erro.printStackTrace();
			}
		}

	}

	public void atualizarCnpjCliente(Venda venda, String novoCnpj) {
		Connection conexao = null;
		PreparedStatement update = null;
		try {
			conexao = conectarBanco();
			update = conexao.prepareStatement(
					"UPDATE pessoa_juridica SET cnpj_pessoa_juridica = ? WHERE id_pessoa_juridica = ?");

			update.setString(1, novoCnpj);
			update.setLong(2, venda.getCliente().getPessoaJuridica().getId());
			update.execute();
		} catch (SQLException erro) {
			erro.printStackTrace();
		} finally {
			try {
				if (update != null)
					update.close();

				if (conexao != null)
					conexao.close();
			} catch (SQLException erro) {
				erro.printStackTrace();
			}
		}
	}

	public void atualizarValorVenda(Venda venda, float novoValorVenda) {
		Connection conexao = null;
		PreparedStatement update = null;
		try {
			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE venda SET valor_venda = ? WHERE id_venda = ?");

			update.setFloat(1, novoValorVenda);
			update.setLong(2, venda.getId());

			update.execute();
		} catch (SQLException erro) {
			erro.printStackTrace();
		} finally {
			try {
				if (update != null)
					update.close();

				if (conexao != null)
					conexao.close();
			} catch (SQLException erro) {
				erro.printStackTrace();
			}
		}

	}

	public void atualizarDataVenda(Venda venda, LocalDate novaDataVenda) {
		Connection conexao = null;
		PreparedStatement update = null;
		try {
			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE venda SET data_venda = ? WHERE id_venda = ?");

			update.setString(1, novaDataVenda.toString());
			update.setLong(2, venda.getId());

			update.execute();
		} catch (SQLException erro) {
			erro.printStackTrace();
		} finally {
			try {
				if (update != null)
					update.close();

				if (conexao != null)
					conexao.close();
			} catch (SQLException erro) {
				erro.printStackTrace();
			}
		}
	}

	public void atualizarFormaPagamento(Venda venda, FormaPagamento novaFormaPagamento) {
		Connection conexao = null;
		PreparedStatement update = null;
		try {
			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE venda SET forma_pagamento_venda = ? WHERE id_venda = ?");

			update.setString(1, novaFormaPagamento.toString());
			update.setLong(2, venda.getId());

			update.execute();
		} catch (SQLException erro) {
			erro.printStackTrace();
		} finally {
			try {
				if (update != null)
					update.close();

				if (conexao != null)
					conexao.close();
			} catch (SQLException erro) {
				erro.printStackTrace();
			}
		}
	}

	public void atualizarParcela(Venda venda, short novaParcela) {
		Connection conexao = null;
		PreparedStatement update = null;
		try {
			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE venda SET parcela_venda = ? WHERE id_venda = ?");

			update.setShort(1, novaParcela);
			update.setLong(2, venda.getId());

			update.execute();
		} catch (SQLException erro) {
			erro.printStackTrace();
		} finally {
			try {
				if (update != null)
					update.close();

				if (conexao != null)
					conexao.close();
			} catch (SQLException erro) {
				erro.printStackTrace();
			}
		}
	}

	public List<Venda> recuperarVendas() {
		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Venda> vendas = new ArrayList<Venda>();

		try {
			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("select * from venda");

			while (resultado.next()) {
				long idVenda = resultado.getLong("id_venda");
				long idCliente = resultado.getLong("id_cliente");
				Cliente cliente = new ClienteDAOImpl().recuperarClientePorId(idCliente);
				float valorVenda = resultado.getFloat("valor_venda");
				LocalDate dataVenda = LocalDate.parse(resultado.getString("data_venda"));
				FormaPagamento formaPagamento = FormaPagamento.valueOf(resultado.getString("forma_pagamento_venda"));
				short parcela = resultado.getShort("parcela_venda");
				vendas.add(new Venda(idVenda, cliente, valorVenda, dataVenda, formaPagamento, parcela));

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

		return vendas;
	}

	public List<Venda> recuperarVendasPorOrdemDataAscendente() {
		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Venda> vendas = new ArrayList<Venda>();

		try {
			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM venda ORDER BY year(data_venda) ASC");

			while (resultado.next()) {
				long idVenda = resultado.getLong("id_venda");
				long idCliente = resultado.getLong("id_cliente");
				Cliente cliente = new ClienteDAOImpl().recuperarClientePorId(idCliente);
				float valorVenda = resultado.getFloat("valor_venda");
				LocalDate dataVenda = LocalDate.parse(resultado.getString("data_venda"));
				FormaPagamento formaPagamento = FormaPagamento.valueOf(resultado.getString("forma_pagamento_venda"));
				short parcela = resultado.getShort("parcela_venda");
				vendas.add(new Venda(idVenda, cliente, valorVenda, dataVenda, formaPagamento, parcela));

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

		return vendas;
	}

	public List<Venda> recuperarVendasPorOrdemDataDescendente() {
		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Venda> vendas = new ArrayList<Venda>();

		try {
			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("select * from venda ORDER BY year(data_venda) DESC");

			while (resultado.next()) {
				long idVenda = resultado.getLong("id_venda");
				long idCliente = resultado.getLong("id_cliente");
				Cliente cliente = new ClienteDAOImpl().recuperarClientePorId(idCliente);
				float valorVenda = resultado.getFloat("valor_venda");
				LocalDate dataVenda = LocalDate.parse(resultado.getString("data_venda"));
				FormaPagamento formaPagamento = FormaPagamento.valueOf(resultado.getString("forma_pagamento_venda"));
				short parcela = resultado.getShort("parcela_venda");
				vendas.add(new Venda(idVenda, cliente, valorVenda, dataVenda, formaPagamento, parcela));

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

		return vendas;
	}

	public List<Venda> recuperarVendasPorOrdemClienteAscendente() {
		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Venda> vendas = new ArrayList<Venda>();

		try {
			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("select * from venda ORDER BY id_cliente asc");

			while (resultado.next()) {
				long idVenda = resultado.getLong("id_venda");
				long idCliente = resultado.getLong("id_cliente");
				Cliente cliente = new ClienteDAOImpl().recuperarClientePorId(idCliente);
				float valorVenda = resultado.getFloat("valor_venda");
				LocalDate dataVenda = LocalDate.parse(resultado.getString("data_venda"));
				FormaPagamento formaPagamento = FormaPagamento.valueOf(resultado.getString("forma_pagamento_venda"));
				short parcela = resultado.getShort("parcela_venda");
				vendas.add(new Venda(idVenda, cliente, valorVenda, dataVenda, formaPagamento, parcela));

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

		return vendas;
	}

	public List<Venda> recuperarVendasPorOrdemClienteDescendente() {
		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Venda> vendas = new ArrayList<Venda>();

		try {
			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("select * from venda order by id_cliente desc");

			while (resultado.next()) {
				long idVenda = resultado.getLong("id_venda");
				long idCliente = resultado.getLong("id_cliente");
				Cliente cliente = new ClienteDAOImpl().recuperarClientePorId(idCliente);
				float valorVenda = resultado.getFloat("valor_venda");
				LocalDate dataVenda = LocalDate.parse(resultado.getString("data_venda"));
				FormaPagamento formaPagamento = FormaPagamento.valueOf(resultado.getString("forma_pagamento_venda"));
				short parcela = resultado.getShort("parcela_venda");
				vendas.add(new Venda(idVenda, cliente, valorVenda, dataVenda, formaPagamento, parcela));

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

		return vendas;
	}

	public Venda recuperarVendasPorId(long id) {

		Connection conexao = null;
		PreparedStatement consulta = null;
		ResultSet resultado = null;
		Venda venda = null;
		try {

			conexao = conectarBanco();

			consulta = conexao.prepareStatement("SELECT * FROM venda WHERE id_venda = ?");
			consulta.setLong(1, id);
			consulta.execute();
			resultado = consulta.getResultSet();
			while (resultado.next()) {
				long idVenda = resultado.getLong("id_venda");
				long idCliente = resultado.getLong("id_cliente");
				Cliente cliente = new ClienteDAOImpl().recuperarClientePorId(idCliente);
				float valorVenda = resultado.getFloat("valor_venda");
				LocalDate dataVenda = LocalDate.parse(resultado.getString("data_venda"));
				FormaPagamento formaPagamento = FormaPagamento.valueOf(resultado.getString("forma_pagamento_venda"));
				short parcela = resultado.getShort("parcela_venda");
				venda = new Venda(idVenda, cliente, valorVenda, dataVenda, formaPagamento, parcela);
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

		return venda;
	}

	private Connection conectarBanco() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/finanblu?user=root&password=root");
	}

}
