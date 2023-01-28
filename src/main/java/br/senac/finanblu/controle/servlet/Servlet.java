package br.senac.finanblu.controle.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senac.finanblu.modelo.dao.cliente.ClienteDAO;
import br.senac.finanblu.modelo.dao.cliente.ClienteDAOImpl;
import br.senac.finanblu.modelo.dao.contato.ContatoDAO;
import br.senac.finanblu.modelo.dao.contato.ContatoDAOImpl;
import br.senac.finanblu.modelo.dao.empresa.EmpresaDAO;
import br.senac.finanblu.modelo.dao.empresa.EmpresaDAOImpl;
import br.senac.finanblu.modelo.dao.endereco.EnderecoDAO;
import br.senac.finanblu.modelo.dao.endereco.EnderecoDAOImpl;
import br.senac.finanblu.modelo.dao.pessoaJuridica.PessoaJuridicaDAO;
import br.senac.finanblu.modelo.dao.pessoaJuridica.PessoaJuridicaDAOImpl;
import br.senac.finanblu.modelo.entidade.contato.Contato;
import br.senac.finanblu.modelo.entidade.empresa.Empresa;
import br.senac.finanblu.modelo.entidade.pessoaJuridica.PessoaJuridica;

@WebServlet("/")
public class Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ContatoDAO daoContato;
	private PessoaJuridicaDAO daoPessoaJuridica;
	private ClienteDAO daoCliente;
	private EnderecoDAO daoEndereco;
	private EmpresaDAO daoEmpresa;

	public void init() {
		daoContato = new ContatoDAOImpl();
		daoCliente = new ClienteDAOImpl();
		daoEndereco = new EnderecoDAOImpl();
		daoEmpresa = new EmpresaDAOImpl();
		daoPessoaJuridica = new PessoaJuridicaDAOImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		try {

			switch (action) {

			case "/nova-empresa":
				mostrarFormularioNovaEmpresa(request, response);
				break;

			case "/inserir-empresa":
				inserirEmpresa(request, response);
				break;

			case "/deletar-empresa":
				deletarEmpresa(request, response);
				break;

			case "/editar-empresa":
				mostrarFormularioEditarEmpresa(request, response);
				break;

			case "/atualizar-empresa":
				atualizarEmpresa(request, response);
				break;

			default:
				listarEmpresas(request, response);

			}

		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void mostrarFormularioNovaEmpresa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("form-empresa.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarFormularioEditarEmpresa(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("form-empresa.jsp");
		dispatcher.forward(request, response);
	}

	private void inserirEmpresa(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		String razaoSocial = request.getParameter("razao_social_pessoa_juridica");
		String nomeFantasia = request.getParameter("nome_fantasia_pessoa_juridica");
		String cnpj = request.getParameter("cnpj_pessoa_juridica");
		PessoaJuridica pessoaJuridica = daoPessoaJuridica.inserirPessoaJuridica(new PessoaJuridica(razaoSocial, nomeFantasia, cnpj));

		String telefone = request.getParameter("telefone_contato");
		String email = request.getParameter("email_contato");
		Contato contato = daoContato.inserirContato(new Contato(telefone, email));
		
		String senha = request.getParameter("senha_empresa");
		

		daoEmpresa.inserirEmpresa(new Empresa(pessoaJuridica, contato, senha));
		response.sendRedirect("listar");
	}

	private void atualizarEmpresa(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		long id = Long.parseLong(request.getParameter("id"));
		String razaoSocial = request.getParameter("razao_social_pessoa_juridica");
		String nomeFantasia = request.getParameter("nome_fantasia_pessoa_juridica");
		String cnpj = request.getParameter("cnpj_pessoa_juridica");

		PessoaJuridica pessoaJuridica = new PessoaJuridica(razaoSocial, nomeFantasia, cnpj);

		String telefone = request.getParameter("telefone_contato");
		String email = request.getParameter("email_contato");
		Contato contato = new Contato(telefone, email);

		String senha = request.getParameter("senha_empresa");

		daoEmpresa.atualizarEmpresa(new Empresa(id, pessoaJuridica, contato, senha));
		response.sendRedirect("listar");
	}

	private void deletarEmpresa(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		long id = Long.parseLong(request.getParameter("id"));
		// Empresa empresa = daoEmpresa.recuperarEmpresas(new Cliente(id));
		// daoEmpresa.deletarEmpresa(empresa);
		response.sendRedirect("listar");
	}

	private void listarEmpresas(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<Empresa> empresas = daoEmpresa.recuperarEmpresas();
		request.setAttribute("empresas", empresas);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listar-empresa.jsp");
		dispatcher.forward(request, response);
	}

	/*
	 * private void mostrarFormularioNovoCliente(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletException, IOException {
	 * 
	 * RequestDispatcher dispatcher =
	 * request.getRequestDispatcher("form-empresa.jsp"); dispatcher.forward(request,
	 * response); }
	 * 
	 * private void mostrarFormularioEditarCliente(HttpServletRequest request,
	 * HttpServletResponse response) throws SQLException, ServletException,
	 * IOException {
	 * 
	 * long id = Long.parseLong(request.getParameter("id")); Cliente cliente =
	 * daoCliente.recuperarClientes(new Cliente(id));
	 * request.setAttribute("cliente", cliente); RequestDispatcher dispatcher =
	 * request.getRequestDispatcher("form-contato.jsp"); dispatcher.forward(request,
	 * response); }
	 * 
	 * private void inserirCliente(HttpServletRequest request, HttpServletResponse
	 * response) throws SQLException, IOException {
	 * 
	 * String telefone = request.getParameter("telefone_contato"); String email =
	 * request.getParameter("email_contato"); String razaoSocial =
	 * request.getParameter("razao_social_pessoa_juridica"); String nomeFantasia =
	 * request.getParameter("nome_fantasia_pessoa_juridica"); String cnpj =
	 * request.getParameter("cnpj_pessoa_juridica"); String cep =
	 * request.getParameter("cep_endereco"); String logradouro =
	 * request.getParameter("logradouro_endereco"); short numero =
	 * Short.parseShort(request.getParameter("numero_endereco")); String bairro =
	 * request.getParameter("bairro_endereco"); String cidade =
	 * request.getParameter("cidade_endereco"); String uf =
	 * request.getParameter("uf_endereco"); String complemento =
	 * request.getParameter("complemento_endereco");
	 * 
	 * daoCliente.InserirCliente(new Cliente()); response.sendRedirect("listar"); }
	 * 
	 * private void atualizarCliente(HttpServletRequest request, HttpServletResponse
	 * response) throws SQLException, IOException {
	 * 
	 * long id = Long.parseLong(request.getParameter("id")); String telefone =
	 * request.getParameter("telefone_contato"); String email =
	 * request.getParameter("email_contato"); String razaoSocial =
	 * request.getParameter("razao_social_pessoa_juridica"); String nomeFantasia =
	 * request.getParameter("nome_fantasia_pessoa_juridica"); String cnpj =
	 * request.getParameter("cnpj_pessoa_juridica"); String cep =
	 * request.getParameter("cep_endereco"); String logradouro =
	 * request.getParameter("logradouro_endereco"); short numero =
	 * Short.parseShort(request.getParameter("numero_endereco")); String bairro =
	 * request.getParameter("bairro_endereco"); String cidade =
	 * request.getParameter("cidade_endereco"); String uf =
	 * request.getParameter("uf_endereco"); String complemento =
	 * request.getParameter("complemento_endereco"); daoCliente.atualizarCliente(new
	 * Cliente(id,telefone, email, razaoSocial, nomeFantasia, cnpj, cep, logradouro,
	 * numero, bairro, cidade, uf, complemento)); response.sendRedirect("listar"); }
	 * 
	 * private void deletarCliente(HttpServletRequest request, HttpServletResponse
	 * response) throws SQLException, IOException {
	 * 
	 * long id = Long.parseLong(request.getParameter("id")); Cliente cliente =
	 * daoCliente.recuperarClientes(new Cliente(id));
	 * daoCliente.DeletarCliente(cliente); response.sendRedirect("listar"); }
	 * private void listarClientes(HttpServletRequest request, HttpServletResponse
	 * response) throws SQLException, IOException, ServletException {
	 * 
	 * List<Empresa> empresas = daoEmpresa.recuperarEmpresas();
	 * request.setAttribute("empresas", empresas); RequestDispatcher dispatcher =
	 * request.getRequestDispatcher("listar-empresa.jsp");
	 * dispatcher.forward(request, response);
	 */// }
}