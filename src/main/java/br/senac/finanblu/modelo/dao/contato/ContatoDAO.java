package br.senac.finanblu.modelo.dao.contato;

import java.util.List;

import br.senac.finanblu.modelo.entidade.contato.Contato;

public interface ContatoDAO {
	
	Contato inserirContato (Contato contato);
	
	void deletarContato (Contato contato);
	
	void atualizarContato(Contato contato);
	
	List<Contato> recuperarContatos();

}