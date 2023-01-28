package br.senac.finanblu.modelo.entidade.cliente;

import br.senac.finanblu.modelo.entidade.contato.Contato;
import br.senac.finanblu.modelo.entidade.endereco.Endereco;
import br.senac.finanblu.modelo.entidade.pessoaJuridica.PessoaJuridica;

public class Cliente {

	private long id;
	private Endereco endereco;
	private Contato contato;
	private PessoaJuridica pessoaJuridica;

	public Cliente(long id, PessoaJuridica pessoaJuridica, Contato contato, Endereco endereco) {
		this.setId(id);
		this.setPessoaJuridica(pessoaJuridica);
		this.setContato(contato);
		this.setEndereco(endereco);
	}

	public Cliente(PessoaJuridica pessoaJuridica, Contato contato, Endereco endereco) {
		this.setPessoaJuridica(pessoaJuridica);
		this.setContato(contato);
		this.setEndereco(endereco);
	}

	public Cliente(long id) {
		this.setId(id);
	}

	public Cliente() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}

}