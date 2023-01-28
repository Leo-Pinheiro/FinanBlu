package br.senac.finanblu.modelo.dao.pessoaJuridica;

import java.util.List;

import br.senac.finanblu.modelo.entidade.pessoaJuridica.PessoaJuridica;

public interface PessoaJuridicaDAO {
	PessoaJuridica inserirPessoaJuridica(PessoaJuridica pessoaJuridica);

	void deletarPessoaJuridica(PessoaJuridica pessoaJuridica);

	void atualizarPessoaJuridica(PessoaJuridica pessoaJuridica);

	List<PessoaJuridica> recuperarPessoasJuridicas();
}
