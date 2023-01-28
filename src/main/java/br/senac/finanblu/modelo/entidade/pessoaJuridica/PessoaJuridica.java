package br.senac.finanblu.modelo.entidade.pessoaJuridica;

public class PessoaJuridica {
	private long id;
	private String razaoSocial;
	private String nomeFantasia;
	private String cnpj;

	public PessoaJuridica(long id, String razaoSocial, String nomeFantasia, String cnpj) {
		this.setId(id);
		this.setRazaoSocial(razaoSocial);
		this.setNomeFantasia(nomeFantasia);
		this.setCnpj(cnpj);

	}

	public PessoaJuridica(String razaoSocial, String nomeFantasia, String cnpj) {
		this.setRazaoSocial(razaoSocial);
		this.setNomeFantasia(nomeFantasia);
		this.setCnpj(cnpj);

	}

	public PessoaJuridica(long id) {
		this.setId(id);
	}

	public PessoaJuridica() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public boolean equals(Object objeto) {
		if (this == objeto)
			return true;

		if (objeto == null)
			return false;

		if (getClass() != objeto.getClass())
			return false;

		PessoaJuridica pessoaJuridica = (PessoaJuridica) objeto;

		return getId() == pessoaJuridica.getId() && getRazaoSocial().equals(pessoaJuridica.getRazaoSocial())
				&& getNomeFantasia().equals(pessoaJuridica.getNomeFantasia())
				&& getCnpj().equals(pessoaJuridica.getCnpj());

	}
}