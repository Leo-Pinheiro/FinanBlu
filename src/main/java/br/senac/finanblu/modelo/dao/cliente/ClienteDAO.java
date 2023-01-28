package br.senac.finanblu.modelo.dao.cliente;

import java.util.List;

import br.senac.finanblu.modelo.entidade.cliente.Cliente;
import br.senac.finanblu.modelo.entidade.contato.Contato;
import br.senac.finanblu.modelo.entidade.endereco.Endereco;

public interface ClienteDAO {

    void InserirCliente(Cliente cliente);

    void DeletarCliente(Cliente cliente);

    void atualizarCliente(Cliente cliente);
    
    List<Cliente> recuperarClientes();

}