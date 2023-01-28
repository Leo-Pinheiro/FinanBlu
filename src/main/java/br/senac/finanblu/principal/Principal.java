package br.senac.finanblu.principal;

import java.util.List;

import br.senac.finanblu.modelo.dao.cliente.ClienteDAO;
import br.senac.finanblu.modelo.dao.cliente.ClienteDAOImpl;
import br.senac.finanblu.modelo.entidade.cliente.Cliente;
import br.senac.finanblu.modelo.entidade.contato.Contato;
import br.senac.finanblu.modelo.entidade.endereco.Endereco;
import br.senac.finanblu.modelo.entidade.pessoaJuridica.PessoaJuridica;

public class Principal {

	/*
	 * public static void main(String[] args) {
	 * 
	 * PessoaJuridicaDAO dao = new PessoaJuridicaDAOImpl(); List<PessoaJuridica>
	 * pessoasJuridicas = null;
	 * 
	 * System.out.println("Sejam Bem-Vindos.\n");
	 * 
	 * System.out.println("As Opções Disponíveis São:\n");
	 * 
	 * System.out.println("1 - Inserir Pessoa Juridica");
	 * System.out.println("2 - Listar Pessoas Juridicas");
	 * System.out.println("3 - Editar Pessoa Juridica");
	 * System.out.println("4 - Deletar Pessoa Juridica");
	 * 
	 * System.out.print("Selecione Uma das Opções Apresentadas: ");
	 * 
	 * Scanner leitor = new Scanner(System.in); Menu menu =
	 * Menu.values()[Integer.parseInt(leitor.next()) - 1];
	 * 
	 * switch (menu) { case INSERIR: dao.inserirPessoaJuridica(new
	 * PessoaJuridica("bjbasjfkafn", "gsgrgrgsgrgsg", "123456789-12345678"));
	 * System.out.println("Pessoa Salva Com Sucesso.\n"); break;
	 * 
	 * case LISTAR: System.out.println("\n");
	 * System.out.println("As Pessoas Juridicas cadastradas são:"); pessoasJuridicas
	 * = dao.recuperarPessoasJuridicas(); listarPessoasJuridicas(pessoasJuridicas);
	 * 
	 * break; case EDITAR: System.out.println("\n");
	 * System.out.println("As Pessoas Juridicas Cadastradas são:"); pessoasJuridicas
	 * = dao.recuperarPessoasJuridicas(); listarPessoasJuridicas(pessoasJuridicas);
	 * 
	 * System.out.print("Selecione Uma Das Pessoas Juridicas Para Editar: ");
	 * PessoaJuridica pessoaJuridica =
	 * pessoasJuridicas.get(Integer.valueOf(leitor.next()) - 1);
	 * 
	 * System.out.println("\n");
	 * 
	 * System.out.println("Os Opções Disponíveis são: ");
	 * System.out.println("1 - Editar A Razao Social Da Pessoa Juridica.");
	 * System.out.println("2 - Editar O Nome Fantasia Da Pessoa Juridica.");
	 * System.out.println("3 - Editar O CNPJ Da Pessoa Juridica.");
	 * 
	 * System.out.print("Selecione Uma Das Opções Apresentadas: ");
	 * 
	 * AtributoPessoaJuridica atributoPessoaJuridica = AtributoPessoaJuridica
	 * .values()[Integer.parseInt(leitor.next()) - 1];
	 * 
	 * switch (atributoPessoaJuridica) {
	 * 
	 * case RAZAOSOCIAL:
	 * 
	 * System.out.print("\n");
	 * System.out.print("Informe A Nova Razao Social Da Pessoa Juridica: ");
	 * 
	 * dao.atualizarRazaoSocial(pessoaJuridica, leitor.next());
	 * 
	 * break;
	 * 
	 * case NOMEFANTASIA:
	 * 
	 * System.out.print("\n");
	 * System.out.print("Informe O Novo Nome Fantasia Da Pessoa Juridica:");
	 * 
	 * dao.atualizarNomeFantasia(pessoaJuridica, leitor.next());
	 * 
	 * break;
	 * 
	 * case CNPJ:
	 * 
	 * System.out.print("\n");
	 * System.out.print("Informe o Novo CNPJ Da Pessoa Juridica:");
	 * 
	 * dao.atualizarCnpj(pessoaJuridica, leitor.next());
	 * 
	 * break;
	 * 
	 * }
	 * 
	 * System.out.println("\nO Endereço Foi Editado Com Sucesso.\n");
	 * 
	 * break;
	 * 
	 * case DELETAR:
	 * 
	 * System.out.print("\n");
	 * System.out.println("s Pessoas Juridicas Cadastrados São:\n");
	 * pessoasJuridicas = dao.recuperarPessoasJuridicas();
	 * listarPessoasJuridicasNumeradas(pessoasJuridicas);
	 * System.out.print("Selecione Uma Das Pessoas Juridicas Para deletar: ");
	 * pessoaJuridica = pessoasJuridicas.get(Integer.valueOf(leitor.next()) - 1);
	 * 
	 * dao.deletarPessoaJuridica(pessoaJuridica);
	 * System.out.println("A Pessoa Juridica Foi Deletada Com Sucesso.\n");
	 * 
	 * default: break;
	 * 
	 * }
	 * 
	 * }
	 * 
	 * private static void listarPessoasJuridicas(List<PessoaJuridica>
	 * pessoasJuridicas) { for (int i = 0; i < pessoasJuridicas.size(); i++) {
	 * 
	 * PessoaJuridica pessoaJuridica = pessoasJuridicas.get(i);
	 * 
	 * System.out.println("Razao Social: " + pessoaJuridica.getRazaoSocial());
	 * System.out.println("Nome Fantasia " + pessoaJuridica.getNomeFantasia());
	 * System.out.println("Cnpj: " + pessoaJuridica.getCnpj());
	 * System.out.print("\n"); } }
	 * 
	 * private static void listarPessoasJuridicasNumeradas(List<PessoaJuridica>
	 * pessoasJuridicas) { for (int i = 0; i < pessoasJuridicas.size(); i++) {
	 * PessoaJuridica pessoaJuridica = pessoasJuridicas.get(i);
	 * System.out.println("Endereço do Número " + (i + 1));
	 * System.out.println("Razao Social " + pessoaJuridica.getRazaoSocial());
	 * System.out.println("Nome Fantasia " + pessoaJuridica.getNomeFantasia());
	 * System.out.println("Cnph: " + pessoaJuridica.getCnpj());
	 * System.out.println("\n"); } }
	 * 
	 * }
	 * 
	 * public static void main(String[] args) {
	 * 
	 * EmpresaDAO dao = new EmpresaDAOImpl(); List<Empresa> empresas = null;
	 * 
	 * System.out.println("Sejam Bem-Vindos.\n");
	 * 
	 * System.out.println("As Opções Disponíveis São:\n");
	 * 
	 * System.out.println("1 - Inserir Empresa");
	 * System.out.println("2 - Listar Empresa");
	 * System.out.println("3 - Editar Empresa");
	 * System.out.println("4 - Deletar Empresa ");
	 * 
	 * System.out.print("Selecione Uma das Opções Apresentadas: ");
	 * 
	 * Scanner leitor = new Scanner(System.in); Menu menu =
	 * Menu.values()[Integer.parseInt(leitor.next()) - 1];
	 * 
	 * switch (menu) { case INSERIR: dao.inserirEmpresa(null);
	 * System.out.println("Pessoa Salva Com Sucesso.\n"); break;
	 * 
	 * case LISTAR: System.out.println("\n");
	 * System.out.println("As Empresas cadastradas são:"); empresas =
	 * dao.recuperarEmpresas(); listarEmpresas(empresas);
	 * 
	 * break;
	 * 
	 * case EDITAR:
	 * 
	 * System.out.println("\n"); System.out.println("As Empresas Cadastradas são:");
	 * empresas = dao.recuperarEmpresas(); listarEmpresas(empresas);
	 * System.out.print("Selecione Uma Das Empresas Para Editar: "); Empresa empresa
	 * = empresas.get(Integer.valueOf(leitor.next()) - 1);
	 * 
	 * System.out.println("\n");
	 * 
	 * System.out.println("Os Opções Disponíveis são: ");
	 * System.out.println("1 - Editar A Razao Social Da Empresa.");
	 * System.out.println("2 - Editar O Nome Fantasia Da Empresa.");
	 * System.out.println("3 - Editar O CNPJ Da Empresa.");
	 * System.out.println("4 - Editar O Telefone Da Empresa.");
	 * System.out.println("5 - Editar O Email Da Empresa.");
	 * System.out.println("6 - Editar A Senha Da Empresa.");
	 * System.out.print("Selecione Uma Das Opções Apresentadas: ");
	 * 
	 * AtributoEmpresa atributoEmpresa =
	 * AtributoEmpresa.values()[Integer.parseInt(leitor.next()) - 1];
	 * 
	 * switch (atributoEmpresa) {
	 * 
	 * case RAZAOSOCIAL:
	 * 
	 * System.out.print("\n");
	 * System.out.print("Informe A Nova Razao Social Da Empresa: ");
	 * 
	 * dao.atualizarRazaoSocial(empresa, leitor.next());
	 * 
	 * break;
	 * 
	 * case NOMEFANTASIA:
	 * 
	 * System.out.print("\n");
	 * System.out.print("Informe O Novo Nome Fantasia Da Empresa:");
	 * 
	 * dao.atualizarNomeFantasia(empresa, leitor.next());
	 * 
	 * break;
	 * 
	 * case CNPJ:
	 * 
	 * System.out.print("\n"); System.out.print("Informe o Novo CNPJ Da Empresa:");
	 * 
	 * dao.atualizarCnpj(empresa, leitor.next());
	 * 
	 * break;
	 * 
	 * case TELEFONE: System.out.println("\n");
	 * System.out.println("Informe o Novo Telefone Da Empresa");
	 * 
	 * dao.atualizarTelefoneEmpresa(empresa, leitor.next()); break;
	 * 
	 * case EMAIL: System.out.println("\n");
	 * System.out.println("Informe o novo Email Da Empresa");
	 * dao.atualizarEmailEmpresa(empresa, leitor.next()); break;
	 * 
	 * case SENHA: System.out.println("\n");
	 * System.out.println("Informe a nova Senha da Empresa");
	 * dao.atualizarSenha(empresa, leitor.next()); }
	 * 
	 * System.out.println("\nA Empresa Foi Editado Com Sucesso.\n");
	 * 
	 * break;
	 * 
	 * case DELETAR: System.out.print("\n");
	 * System.out.println(" Empresas Cadastradas São:\n"); empresas =
	 * dao.recuperarEmpresas(); listarEmpresasNumeradas(empresas);
	 * System.out.print("Selecione Uma Das Empresas Para deletar: "); empresa =
	 * empresas.get(Integer.valueOf(leitor.next()) - 1);
	 * 
	 * dao.deletarEmpresa(empresa);
	 * 
	 * System.out.println("A Empresa Foi Deletada Com Sucesso.\n");
	 * 
	 * default: break;
	 * 
	 * }
	 * 
	 * }
	 * 
	 * private static void listarEmpresas(List<Empresa> empresas) { for (int i = 0;
	 * i < empresas.size(); i++) { Empresa empresa = empresas.get(i);
	 * System.out.println("Razao Social: " +
	 * empresa.getPessoaJuridica().getRazaoSocial());
	 * System.out.println("Nome Fantasia " +
	 * empresa.getPessoaJuridica().getNomeFantasia()); System.out.println("Cnpj: " +
	 * empresa.getPessoaJuridica().getCnpj()); System.out.println("Telefone: " +
	 * empresa.getContato().getTelefone()); System.out.println("Email: " +
	 * empresa.getContato().getEmail()); System.out.println("Senha: " +
	 * empresa.getSenha()); System.out.print("\n"); } } private static void
	 * listarEmpresasNumeradas(List<Empresa> empresas) { for (int i = 0; i <
	 * empresas.size(); i++) { Empresa empresa = empresas.get(i);
	 * System.out.println("Empresa do Número " + (i + 1));
	 * System.out.println("Razao Social " +
	 * empresa.getPessoaJuridica().getRazaoSocial());
	 * System.out.println("Nome Fantasia " +
	 * empresa.getPessoaJuridica().getNomeFantasia()); System.out.println("CNPJ: " +
	 * empresa.getPessoaJuridica().getCnpj()); System.out.println("Telefone:" +
	 * empresa.getContato().getTelefone()); System.out.println("Email: " +
	 * empresa.getContato().getEmail());
	 * 
	 * System.out.println("\n"); } }
	 * 
	 * public static void main(String[] args) { Endereco endereco = new Endereco();
	 * endereco.setCep("1023310"); endereco.setLogradouro("fsafgsvdsba");
	 * endereco.setNumero((short) 123); endereco.setBairro("Bairaffasfr");
	 * endereco.setCidade("Cidaofqf"); endereco.setUf("Rn");
	 * endereco.setComplemento("53");
	 * 
	 * EnderecoDAO dao = new EnderecoDAOImpl(); dao.inserirEndereco(endereco);
	 * 
	 * Contato contato = new Contato(); contato.setEmail("s2bur32o.com");
	 * contato.setTelefone("4231621693"); ContatoDAO contatodao = new
	 * ContatoDAOImpl(); contatodao.inserirContato(contato);
	 * 
	 * PessoaJuridica pessoaJuridica = new PessoaJuridica();
	 * pessoaJuridica.setCnpj("127756112-22745673");
	 * pessoaJuridica.setNomeFantasia("abag14ia");
	 * pessoaJuridica.setRazaoSocial("se3m01a"); PessoaJuridicaDAO pjdao = new
	 * PessoaJuridicaDAOImpl(); pjdao.inserirPessoaJuridica(pessoaJuridica);
	 * 
	 * Cliente cliente = new Cliente(); cliente.setPessoaJuridica(pessoaJuridica);
	 * cliente.setContato(contato); cliente.setEndereco(endereco);
	 * 
	 * ClienteDAO clientedao = new ClienteDAOImpl();
	 * clientedao.InserirCliente(cliente); }
	 * 
	 * 
	 * public static void main(String[] args) { ClienteDAO dao = new
	 * ClienteDAOImpl(); List<Cliente> clientes = null;
	 * 
	 * System.out.println("Sejam Bem-Vindos.\n");
	 * 
	 * System.out.println("As Opções Disponíveis São:\n");
	 * 
	 * System.out.println("1 - Listar Clientes.");
	 * System.out.println("2 - Editar Clientes.");
	 * System.out.println("3 - Deletar Clientes.");
	 * System.out.println("4 - Sair do Sistema.\n");
	 * 
	 * System.out.print("Selecione Uma das Opções Apresentadas: ");
	 * 
	 * Scanner leitor = new Scanner(System.in); Menu menu =
	 * Menu.values()[Integer.parseInt(leitor.next()) - 1];
	 * 
	 * while (menu != Menu.SAIR) {
	 * 
	 * switch (menu) {
	 * 
	 * case LISTAR:
	 * 
	 * clientes = dao.recuperarClientes(); listarClientes(clientes);
	 * 
	 * break;
	 * 
	 * case EDITAR:
	 * 
	 * System.out.print("\n"); System.out.println("Os Clientes Cadastrados São:\n");
	 * 
	 * clientes = dao.recuperarClientes(); listarClientes(clientes);
	 * 
	 * System.out.print("Selecione Um Dos Clientes Para Editar: "); Cliente cliente
	 * = clientes.get(Integer.parseInt(leitor.next()) - 1);
	 * 
	 * System.out.print("\n");
	 * 
	 * System.out.println("As Opções Disponíveis São:\n");
	 * 
	 * System.out.println("1 - Editar A Razao Social Do Cliente.");
	 * System.out.println("2 - Editar O Nome Fantasia Do Cliente.");
	 * System.out.println("3 - Editar O CNPJ Do Cliente.");
	 * System.out.println("4 - Editar O Telefone Do Cliente.");
	 * System.out.println("5 - Editar O Email Do Cliente.");
	 * System.out.println("6 - Editar O CEP Do Cliente.");
	 * System.out.println("7 - Editar O Logradouro Do Cliente.");
	 * System.out.println("8 - Editar O Numero Do Cliente.");
	 * System.out.println("9 - Editar O Bairro Do Cliente.");
	 * System.out.println("10 - Editar O Cidade Do Cliente.");
	 * System.out.println("11 - Editar O UF Do Cliente.");
	 * System.out.println("12 - Editar O Complemento Do Cliente.");
	 * System.out.print("Selecione Uma Das Opções Apresentadas: "); AtributoCliente
	 * atributoCliente = AtributoCliente.values()[Integer.parseInt(leitor.next()) -
	 * 1];
	 * 
	 * switch (atributoCliente) {
	 * 
	 * case RAZAOSOCIAL:
	 * 
	 * System.out.print("\n");
	 * System.out.print("Informe A Nova Razao Social Do Cliente: ");
	 * 
	 * dao.AtualizarRazaoSocial(cliente, leitor.next());
	 * 
	 * break;
	 * 
	 * case NOMEFANTASIA:
	 * 
	 * System.out.print("\n");
	 * System.out.print("Informe O Novo Nome Fantasia Do Cliente:");
	 * 
	 * dao.AtualizarNomeFantasia(cliente, leitor.next());
	 * 
	 * break;
	 * 
	 * case CNPJ:
	 * 
	 * System.out.print("\n"); System.out.print("Informe o Novo CNPJ Do Cliente:");
	 * 
	 * dao.AtualizarCnpj(cliente, leitor.next());
	 * 
	 * break;
	 * 
	 * case TELEFONE: System.out.println("\n");
	 * System.out.println("Informe o Novo Telefone Do Cliente");
	 * 
	 * dao.AtualizarTelefoneCliente(cliente, leitor.next()); break;
	 * 
	 * case EMAIL: System.out.println("\n");
	 * System.out.println("Informe o novo Email Da Empresa");
	 * dao.AtualizarEmailCliente(cliente, leitor.next()); break;
	 * 
	 * case CEP: System.out.println("\n");
	 * System.out.println("Informe a novo CEP Do Cliente");
	 * dao.atualizarCepEndereco(cliente, leitor.next());
	 * 
	 * break; case LOGRADOURO: System.out.println("\n");
	 * System.out.println("Informe a novo Logradouro Do Cliente");
	 * dao.atualizarLogradouroEndereco(cliente, leitor.next());
	 * 
	 * break; case NUMERO: System.out.println("\n");
	 * System.out.println("Informe a novo Numero Do Cliente");
	 * dao.atualizarNumeroEndereco(cliente, leitor.nextShort());
	 * 
	 * break; case BAIRRO: System.out.println("\n");
	 * System.out.println("Informe a novo Bairro Do Cliente");
	 * dao.atualizarBairroEndereco(cliente, leitor.next());
	 * 
	 * break; case CIDADE: System.out.println("\n");
	 * System.out.println("Informe a novo Cidade Do Cliente");
	 * dao.atualizarCidadeEndereco(cliente, leitor.next());
	 * 
	 * break;
	 * 
	 * case UF: System.out.println("\n");
	 * System.out.println("Informe a nova UF Do Cliente");
	 * dao.atualizarUfEndereco(cliente, leitor.next()); break;
	 * 
	 * case COMPLEMENTO: System.out.println("\n");
	 * System.out.println("Informe a novo Complemento Do Cliente");
	 * dao.atualizarComplementoEndereco(cliente, leitor.next());
	 * 
	 * break;
	 * 
	 * }
	 * 
	 * System.out.println("\nA Empresa Foi Editado Com Sucesso.\n");
	 * 
	 * break;
	 * 
	 * case DELETAR:
	 * 
	 * System.out.print("\n"); System.out.println("Os Clientes Cadastrados São:\n");
	 * 
	 * clientes = dao.recuperarClientes(); listarClientes(clientes);
	 * 
	 * System.out.print("Selecione Um Dos Clientes Para deletar: "); cliente =
	 * clientes.get(Integer.parseInt(leitor.next()) - 1);
	 * 
	 * dao.DeletarCliente(cliente);
	 * System.out.println("O Cliente Foi Deletado Com Sucesso.\n");
	 * 
	 * break;
	 * 
	 * }
	 * 
	 * System.out.println("As Opções Disponíveis São:\n");
	 * 
	 * System.out.println("1 - Listar Clientes.");
	 * System.out.println("2 - Editar Clientes.");
	 * System.out.println("3 - Deletar Clientes.");
	 * System.out.println("4 - Sair do Sistema.\n");
	 * 
	 * System.out.print("Selecione Uma das Opções Apresentadas: ");
	 * 
	 * menu = Menu.values()[Integer.parseInt(leitor.next()) - 1]; }
	 * 
	 * leitor.close();
	 * 
	 * System.out.println("Saindo Do Sistema...");
	 * System.out.println("Muito Obrigado E Volte Sempre.");
	 * 
	 * }
	 * 
	 * private static void listarClientes(List<Cliente> clientes) {
	 * 
	 * for (int i = 0; i < clientes.size(); i++) {
	 * 
	 * Cliente cliente = clientes.get(i);
	 * 
	 * System.out.println("Razão Social: " +
	 * cliente.getPessoaJuridica().getRazaoSocial());
	 * System.out.println("Nome Fantasia: " +
	 * cliente.getPessoaJuridica().getNomeFantasia()); System.out.println("Cnpj: " +
	 * cliente.getPessoaJuridica().getCnpj()); System.out.println("Telefone: " +
	 * cliente.getContato().getTelefone()); System.out.println("Email: " +
	 * cliente.getContato().getEmail()); System.out.println("CEP: " +
	 * cliente.getEndereco().getCep()); System.out.println("Logradouro: " +
	 * cliente.getEndereco().getLogradouro()); System.out.println("Numero: " +
	 * cliente.getEndereco().getNumero()); System.out.println("Bairro: " +
	 * cliente.getEndereco().getBairro()); System.out.println("Cidade: " +
	 * cliente.getEndereco().getCidade()); System.out.println("UF: " +
	 * cliente.getEndereco().getUf()); System.out.println("Complemento: " +
	 * cliente.getEndereco().getComplemento());
	 * 
	 * System.out.print("\n"); } }
	 * 
	 * public static void main(String[] args) {
	 * 
	 * float valorVenda = 5000; LocalDate dataVenda = LocalDate.now();
	 * FormaPagamento formaPagamento = FormaPagamento.CARTAO_CREDITO; short parcela
	 * = (short) 5; Cliente cliente = new Cliente(11L); Venda venda = new
	 * Venda(cliente, valorVenda, dataVenda, formaPagamento, parcela); VendaDAO dao
	 * = new VendaDAOImpl(); dao.inserirVenda(venda); }
	 * 
	 * 
	 * VendaDAO dao = new VendaDAOImpl(); List<Venda> vendas = null;
	 * 
	 * System.out.println("Sejam Bem-Vindos.\n");
	 * 
	 * System.out.println("As Opções Disponíveis São:\n");
	 * 
	 * System.out.println("1 - Listar Clientes.");
	 * System.out.println("2 - Editar Clientes.");
	 * System.out.println("3 - Deletar Clientes.");
	 * System.out.println("4 - Sair do Sistema.\n");
	 * 
	 * System.out.print("Selecione Uma das Opções Apresentadas: ");
	 * 
	 * Scanner leitor = new Scanner(System.in); Menu menu =
	 * Menu.values()[Integer.parseInt(leitor.next()) - 1]; // while (menu !=
	 * Menu.SAIR) { switch (menu) {
	 * 
	 * case LISTAR: vendas = dao.recuperarVendas(); listarVendas(vendas);
	 * System.out.print("\n");
	 * 
	 * System.out.println("As Opções Disponíveis São:\n");
	 * 
	 * System.out.println("1 - Listar Vendas pela Data.");
	 * System.out.println("2 - Listar Vendas pelo Cliente.");
	 * 
	 * System.out.print("Selecione Uma Das Opções Apresentadas: ");
	 * 
	 * AtributoVenda atributoVenda =
	 * AtributoVenda.values()[Integer.parseInt(leitor.next()) - 1]; Ordem ordem =
	 * null;
	 * 
	 * System.out.println("\nAs Opções Disponíveis São:\n");
	 * 
	 * System.out.println("1 - Listar Em Ordem Ascendente.");
	 * System.out.println("2 - Listar Em Ordem Descendente.\n");
	 * 
	 * System.out.print("Selecione Uma Das Opções Apresentadas: ");
	 * 
	 * 
	 * ordem = Ordem.values()[Integer.parseInt(leitor.next()) - 1];
	 * 
	 * switch (atributoVenda) {
	 * 
	 * case DATAVENDA:
	 * 
	 * switch (ordem) {
	 * 
	 * case ASCENDENTE: vendas = dao.recuperarVendasPorOrdemDataAscendente();
	 * listarVendas(vendas); break;
	 * 
	 * case DESCENDENTE: vendas = dao.recuperarVendasPorOrdemDataDescendente();
	 * break; } break;
	 * 
	 * case CLIENTE:
	 * 
	 * switch (ordem) {
	 * 
	 * case ASCENDENTE: vendas = dao.recuperarVendasPorOrdemClienteAscendente();
	 * break;
	 * 
	 * case DESCENDENTE: vendas = dao.recuperarVendasPorOrdemClienteDescendente();
	 * break; } break;
	 * 
	 * } listarVendas(vendas); break;
	 * 
	 * }
	 * 
	 * /* case EDITAR:
	 * 
	 * System.out.print("\n"); System.out.println("Os Clientes Cadastrados São:\n");
	 * 
	 * vendas = dao.recuperarVendas(); listarVendas(vendas);
	 * 
	 * System.out.print("Selecione Um Dos Clientes Para Editar: "); Venda venda =
	 * vendas.get(Integer.parseInt(leitor.next()) - 1);
	 * 
	 * System.out.print("\n");
	 * 
	 * System.out.println("As Opções Disponíveis São:\n");
	 * 
	 * System.out.println("1 - Editar A Razao Social Do Cliente.");
	 * System.out.println("2 - Editar O Nome Fantasia Do Cliente.");
	 * System.out.println("3 - Editar O CNPJ Do Cliente.");
	 * System.out.println("4 - Editar O Valor Da Venda.");
	 * System.out.println("5 - Editar O Data da Venda.");
	 * System.out.println("6 - Editar O Forma De Pagamento.");
	 * System.out.print("Selecione Uma Das Opções Apresentadas: "); atributoVenda =
	 * AtributoVenda.values()[Integer.parseInt(leitor.next()) - 1];
	 * 
	 * 
	 * switch (atributoVenda) {
	 * 
	 * // RAZAOSOCIAL:
	 * 
	 * System.out.print("\n");
	 * System.out.print("Informe A Nova Razao Social Do Cliente: ");
	 * 
	 * dao.atualizarRazaoSocialCliente(venda, leitor.next());
	 * 
	 * break;
	 * 
	 * // case NOMEFANTASIA:
	 * 
	 * System.out.print("\n");
	 * System.out.print("Informe O Novo Nome Fantasia Do Cliente:");
	 * 
	 * dao.atualizarNomeFantasiaCliente(venda, leitor.next());
	 * 
	 * break;
	 * 
	 * case CNPJ:
	 * 
	 * System.out.print("\n"); System.out.print("Informe o Novo CNPJ Do Cliente:");
	 * 
	 * dao.atualizarCnpjCliente(venda, leitor.next());
	 * 
	 * break;
	 * 
	 * case DATAVENDA: System.out.println("\n");
	 * System.out.println("Informe a Data da Venda:");
	 * 
	 * dao.atualizarDataVenda(venda, LocalDate.parse(leitor.next()));
	 * 
	 * break;
	 * 
	 * case FORMAPAGAMENTO: System.out.println("\n");
	 * System.out.println("Informe a Forma de Pagamento");
	 * dao.atualizarFormaPagamento(venda, FormaPagamento.valueOf(leitor.next()));
	 * break;
	 * 
	 * case VALORVENDA: System.out.println("\n");
	 * System.out.println("Informe o Valor da Venda");
	 * 
	 * dao.atualizarValorVenda(venda, leitor.nextFloat()); break;
	 * 
	 * case PARCELA: System.out.println("\n");
	 * System.out.println("Informe a nova Parcela"); dao.atualizarParcela(venda,
	 * leitor.nextShort()); break; }
	 * 
	 * System.out.println("\nA Empresa Foi Editado Com Sucesso.\n"); break; case
	 * DELETAR: System.out.print("\n");
	 * System.out.println("Os Clientes Cadastrados São:\n");
	 * 
	 * vendas = dao.recuperarVendas(); listarVendas(vendas);
	 * 
	 * System.out.print("Selecione Um Dos Clientes Para deletar: "); venda =
	 * vendas.get(Integer.parseInt(leitor.next()) - 1);
	 * 
	 * dao.deletarVenda(venda);
	 * System.out.println("O Cliente Foi Deletado Com Sucesso.\n");
	 * 
	 * break; } System.out.println("As Opções Disponíveis São:\n");
	 * 
	 * System.out.println("1 - Listar Clientes.");
	 * System.out.println("2 - Editar Clientes.");
	 * System.out.println("3 - Deletar Clientes.");
	 * System.out.println("4 - Sair do Sistema.\n");
	 * 
	 * System.out.print("Selecione Uma das Opções Apresentadas: ");
	 * 
	 * menu = Menu.values()[Integer.parseInt(leitor.next()) - 1]; }
	 * 
	 * leitor.close();
	 * 
	 * System.out.println("Saindo Do Sistema...");
	 * System.out.println("Muito Obrigado E Volte Sempre.");
	 * 
	 * }
	 * 
	 * private static void listarVendas(List<Venda> vendas) {
	 * 
	 * for (int i = 0; i < vendas.size(); i++) {
	 * 
	 * Venda venda = vendas.get(i); System.out.println("ID venda: " +
	 * venda.getId()); System.out.println("ID Cliente: " +
	 * venda.getCliente().getId()); System.out.println("Razão Social: " +
	 * venda.getCliente().getPessoaJuridica().getRazaoSocial());
	 * System.out.println("Nome Fantasia: " +
	 * venda.getCliente().getPessoaJuridica().getNomeFantasia());
	 * System.out.println("Cnpj: " +
	 * venda.getCliente().getPessoaJuridica().getCnpj());
	 * System.out.println("Valor da Venda: " + venda.getValorVenda());
	 * System.out.println("Data da Venda: " + venda.getDataVenda());
	 * System.out.println("Forma de Pagamento " + venda.getFormaPagamento());
	 * System.out.println("Parcela " + venda.getParcela());
	 * 
	 * System.out.print("\n"); } }
	 */
	public static void main(String[] args) {
		/*
		 * String instituicaoFinanceira = "Bradesco"; Venda venda = new Venda(12L);
		 * LocalDate dataVencimento = LocalDate.now(); Situacao situacao =
		 * Situacao.ABERTO; LocalDate dataPagamento = LocalDate.now();
		 * 
		 * Titulo titulo = new Titulo(venda, instituicaoFinanceira, dataVencimento,
		 * situacao, dataPagamento);
		 * 
		 * TituloDAO dao = new TituloDAOImpl();
		 * 
		 * dao.inserirTitulo(titulo);
		 * 
		 * TituloDAO dao = new TituloDAOImpl(); List<Titulo> titulos = null;
		 * 
		 * System.out.println("Sejam Bem-Vindos.\n");
		 * 
		 * System.out.println("As Opções Disponíveis São:\n");
		 * 
		 * System.out.println("1 - Listar Titulos.");
		 * System.out.println("2 - Editar Titulos.");
		 * System.out.println("3 - Deletar Titulos.");
		 * System.out.println("4 - Sair do Sistema.\n");
		 * 
		 * System.out.print("Selecione Uma das Opções Apresentadas: ");
		 * 
		 * Scanner leitor = new Scanner(System.in); Menu menu =
		 * Menu.values()[Integer.parseInt(leitor.next()) - 1]; while (menu != Menu.SAIR)
		 * { switch (menu) {
		 * 
		 * case LISTAR:
		 * 
		 * titulos = dao.recuperarTitulos(); listarTitulos(titulos);
		 * System.out.print("\n");
		 * 
		 * System.out.println("As Opções Disponíveis São:\n");
		 * 
		 * System.out.println("1 - Listar Titulos Pagos.");
		 * System.out.println("2 - Listar Titulos Pagos Por Data.");
		 * System.out.println("3 - Listar Títulos Pagos Por Cliente.\n");
		 * 
		 * System.out.println("4 - Listar Títulos Abertos.");
		 * System.out.println("5 - Listar Títulos Abertos Por Data.");
		 * System.out.println("6 - Listar Títulos Abertos Por Cliente.\n");
		 * 
		 * System.out.println("7 - Listar Títulos À Vencer.");
		 * System.out.println("8 - Listar Títulos À Vencer Por Data.");
		 * System.out.println("9 - Listar Títulos À Vencer Por Cliente.\n");
		 * 
		 * System.out.println("10 - Listar Títulos Vencidos.");
		 * System.out.println("11 - Listar Títulos Vencidos Por Data.");
		 * System.out.println("12 - Listar Títulos Vencidos Por Cliente.\n");
		 * 
		 * System.out.print("Selecione Uma Das Opções Apresentadas: ");
		 * 
		 * Atrib atrib = Atrib.values()[Integer.parseInt(leitor.next()) - 1]; Ordem
		 * ordem = null;
		 * 
		 * 
		 * switch (atrib) {
		 * 
		 * case PAGO: titulos = dao.recuperarTitulosPagos(); break;
		 * 
		 * case PAGO_POR_DATA: switch(ordem) {
		 * 
		 * } }
		 * 
		 * System.out.println("\n");
		 * System.out.println("Os Títulos Cadastrados São:\n");
		 * 
		 * listarTitulos(titulos);
		 * 
		 * break; case EDITAR: System.out.print("\n");
		 * System.out.println("Os Títulos Cadastrados São:\n");
		 * 
		 * titulos = dao.recuperarTitulos(); listarTitulos(titulos);
		 * 
		 * System.out.print("Selecione Um Dos Titulos Para Editar: "); Titulo titulo =
		 * titulos.get(Integer.parseInt(leitor.next()) - 1);
		 * 
		 * System.out.print("\n");
		 * 
		 * System.out.println("As Opções Disponíveis São:\n");
		 * 
		 * System.out.println("1 - Editar A Razão Social.");
		 * System.out.println("2 - Editar Nome Fantasia.");
		 * System.out.println("3 - Editar A CNPJ.");
		 * System.out.println("4 - Editar O Valor Da Venda.");
		 * System.out.println("5 - Editar A Data Da Venda.");
		 * System.out.println("6 - Editar A Forma De Pagamento.");
		 * System.out.println("7 - Editar A Parcela Da Venda.");
		 * System.out.println("8 - Editar A Institução Financeira Do Titulo.");
		 * System.out.println("9 - Editar A Data De Vencimento Do Título");
		 * System.out.println("10 - Editar A Data De Pagamento Do Titulo.");
		 * System.out.println("11 - Editar A Situação Do Titulo");
		 * 
		 * System.out.print("Selecione Uma Das Opções Apresentadas: ");
		 * 
		 * AtributoTitulo atributoTitulo =
		 * AtributoTitulo.values()[Integer.parseInt(leitor.next()) - 1];
		 * 
		 * switch (atributoTitulo) { case RAZAO_SOCIAL:
		 * 
		 * System.out.print("\n");
		 * System.out.print("Informe A Nova Razão Social Do Cliente: ");
		 * 
		 * dao.atualizarRazaoSocialCliente(titulo, leitor.next());
		 * 
		 * break;
		 * 
		 * case NOME_FANTASIA:
		 * 
		 * System.out.print("\n");
		 * System.out.print("Informe O Novo Nome Fantasia Do Cliente:");
		 * 
		 * dao.atualizarNomeFantasiaCliente(titulo, leitor.next());
		 * 
		 * break;
		 * 
		 * case CNPJ:
		 * 
		 * System.out.print("\n"); System.out.print("Informe A Novo CNPJ Do Cliente:");
		 * 
		 * dao.atualizarCnpjCliente(titulo, leitor.next());
		 * 
		 * break;
		 * 
		 * case VALOR_VENDA:
		 * 
		 * System.out.print("\n"); System.out.print("Informe A Novo Valor Da Venda:");
		 * 
		 * dao.atualizarValorVenda(titulo, leitor.nextFloat());
		 * 
		 * break; case DATA_VENDA:
		 * 
		 * System.out.print("\n"); System.out.print("Informe A Nova Data Da Venda:");
		 * 
		 * dao.atualizarDataVenda(titulo, LocalDate.parse(leitor.next()));
		 * 
		 * break; case FORMA_PAGAMENTO:
		 * 
		 * System.out.print("\n");
		 * System.out.print("Informe A Nova Forma de Pagamento Da Venda:");
		 * 
		 * dao.atualizarFormaPagamentoVenda(titulo,
		 * FormaPagamento.valueOf(leitor.next()));
		 * 
		 * break; case PARCELA:
		 * 
		 * System.out.print("\n"); System.out.print("Informe A Nova Parcela Da Venda:");
		 * 
		 * dao.atualizarParcelaVenda(titulo, leitor.nextShort());
		 * 
		 * break; case INSTITUICAO_FINANCEIRA:
		 * 
		 * System.out.print("\n");
		 * System.out.print("Informe A Nova Instituição Financeira Do Titulo:");
		 * 
		 * dao.atualizarInstitucaoFinanceira(titulo, leitor.next());
		 * 
		 * break; case DATA_VENCIMENTO:
		 * 
		 * System.out.print("\n");
		 * System.out.print("Informe A Nova Data De Vencimento Do Titulo:");
		 * 
		 * dao.atualizarDataVencimento(titulo, LocalDate.parse(leitor.next()));
		 * 
		 * break; case DATA_PAGAMENTO:
		 * 
		 * System.out.print("\n");
		 * System.out.print("Informe A Nova Data de Pagamento Do Titulo:");
		 * 
		 * dao.atualizarDataPagamento(titulo, LocalDate.parse(leitor.next()));
		 * 
		 * break;
		 * 
		 * case SITUACAO:
		 * 
		 * System.out.print("\n");
		 * System.out.print("Informe A Nova Situação Do Titulo:");
		 * 
		 * dao.atualizarSituacao(titulo, Situacao.valueOf(leitor.next()));
		 * 
		 * break; }
		 * 
		 * System.out.println("\nO Cliente Foi Editado Com Sucesso.\n");
		 * 
		 * break;
		 * 
		 * case DELETAR:
		 * 
		 * System.out.print("\n"); System.out.println("Os Titulos Cadastrados São:\n");
		 * 
		 * titulos = dao.recuperarTitulos(); listarTitulos(titulos);
		 * 
		 * System.out.print("Selecione Um Dos Titulos Para deletar: "); titulo =
		 * titulos.get(Integer.parseInt(leitor.next()) - 1);
		 * 
		 * dao.deletarTitulo(titulo);
		 * System.out.println("O Titulo Foi Deletado Com Sucesso.\n");
		 * 
		 * break; } System.out.println("As Opções Disponíveis São:\n");
		 * 
		 * System.out.println("1- Listar Titulos.");
		 * System.out.println("2 - Editar Titulos.");
		 * System.out.println("3 - Deletar Titulos.");
		 * System.out.println("4 - Sair do Sistema.\n");
		 * 
		 * System.out.print("Selecione Uma das Opções Apresentadas: ");
		 * 
		 * menu = Menu.values()[Integer.parseInt(leitor.next()) - 1]; }
		 * 
		 * leitor.close();
		 * 
		 * System.out.println("Saindo Do Sistema...");
		 * System.out.println("Muito Obrigado E Volte Sempre."); }
		 * 
		 * private static void listarTitulos(List<Titulo> titulos) {
		 * 
		 * for (int i = 0; i < titulos.size(); i++) {
		 * 
		 * Titulo titulo = titulos.get(i); System.out.println("ID Titulo: " +
		 * titulo.getId()); System.out.println("ID Cliente: " +
		 * titulo.getVenda().getCliente().getId()); System.out.println("ID venda: " +
		 * titulo.getVenda().getId()); System.out.println("Razão Social: " +
		 * titulo.getVenda().getCliente().getPessoaJuridica().getRazaoSocial());
		 * System.out.println("Nome Fantasia: " +
		 * titulo.getVenda().getCliente().getPessoaJuridica().getNomeFantasia());
		 * System.out.println("Cnpj: " +
		 * titulo.getVenda().getCliente().getPessoaJuridica().getCnpj());
		 * System.out.println("Valor da Venda: " + titulo.getVenda().getValorVenda());
		 * System.out.println("Data da Venda: " + titulo.getVenda().getDataVenda());
		 * System.out.println("Forma de Pagamento: " +
		 * titulo.getVenda().getFormaPagamento()); System.out.println("Parcela: " +
		 * titulo.getVenda().getParcela());
		 * System.out.println("Instituição Financeira: " +
		 * titulo.getInstituicaoFinanceira()); System.out.println("Data Vencimento: " +
		 * titulo.getDataVencimento()); System.out.println("Data Pagamento: " +
		 * titulo.getDataPagamento()); System.out.println("Situação: " +
		 * titulo.getSituacao()); System.out.print("\n"); }
		 * 
		 */
		
		
		List<Cliente> clientes = null;
		System.out.print("\n");
		
		PessoaJuridica pessoaJuridica = new PessoaJuridica((22L));
		Contato contato = new Contato((13L));
		Endereco endereco = new Endereco((10L));
		Cliente cliente = new Cliente((13L), pessoaJuridica, contato, endereco);

		ClienteDAO dao = new ClienteDAOImpl();

		dao.atualizarCliente(cliente);
	
		clientes = dao.recuperarClientes();
		listarEmpresas(clientes);


		
	}

	private static void listarEmpresas(List<Cliente> clientes) {

		for (int i = 0; i < clientes.size(); i++) {

			Cliente cliente = clientes.get(i);

			System.out.println("ID Cliente : " + cliente.getId());
			System.out.println("razao Social: " + cliente.getPessoaJuridica().getRazaoSocial());
			System.out.println("email: " + cliente.getContato().getEmail());
			System.out.println("Cep: " + cliente.getEndereco().getCep());
			System.out.print("\n");

		}
	}
}