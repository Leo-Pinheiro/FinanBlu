package br.senac.finanblu.modelo.entidade.empresa;

import br.senac.finanblu.modelo.entidade.contato.Contato;
import br.senac.finanblu.modelo.entidade.pessoaJuridica.PessoaJuridica;

public class Empresa {
	private long id;
	private Contato contato;
	private String senha;
	private PessoaJuridica pessoaJuridica;

	public Empresa(long id, PessoaJuridica pessoaJuridica, Contato contato, String senha) {
		this.setId(id);
		this.setPessoaJuridica(pessoaJuridica);
		this.setContato(contato);
		this.setSenha(senha);
	}

	public Empresa(PessoaJuridica pessoaJuridica, Contato contato, String senha) {
		this.setPessoaJuridica(pessoaJuridica);
		this.setContato(contato);
		this.setSenha(senha);

	}

	public Empresa() {

	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}

	public boolean equals(Object objeto) {

		if (this == objeto)
			return true;

		if (objeto == null)
			return false;

		if (getClass() != objeto.getClass())
			return false;

		Empresa empresa = (Empresa) objeto;

		return getId() == empresa.getId() && getContato().equals(empresa.getContato())
				&& getPessoaJuridica().equals(empresa.getPessoaJuridica()) && getSenha().equals(empresa.getSenha());
	}
}