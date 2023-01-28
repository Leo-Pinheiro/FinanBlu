package br.senac.finanblu.modelo.entidade.endereco;

public class Endereco {
	private long id;
	private String cep;
	private String logradouro;
	private short numero;
	private String bairro;
	private String cidade;
	private String uf;
	private String complemento;

	public Endereco(long id, String cep, String logradouro, short numero, String bairro, String cidade, String uf,
			String complemento) {
		this.setId(id);
		this.setCep(cep);
		this.setLogradouro(logradouro);
		this.setNumero(numero);
		this.setBairro(bairro);
		this.setCidade(cidade);
		this.setUf(uf);
		this.setComplemento(complemento);

	}

	public Endereco(String cep, String logradouro, short numero, String bairro, String cidade, String uf,
			String complemento) {
		this.setCep(cep);
		this.setLogradouro(logradouro);
		this.setNumero(numero);
		this.setBairro(bairro);
		this.setCidade(cidade);
		this.setUf(uf);
		this.setComplemento(complemento);

	}
	public Endereco(long id) {
		this.setId(id);
	}

	public Endereco() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public short getNumero() {
		return numero;
	}

	public void setNumero(short numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public boolean equals(Object objeto) {
		if (this == objeto)
			return true;

		if (objeto == null)
			return false;

		if (getClass() != objeto.getClass())
			return false;

		Endereco endereco = (Endereco) objeto;

		return getId() == endereco.getId() && getCep().equals(endereco.getCep())
				&& getLogradouro().equals(endereco.getLogradouro()) && getNumero() == endereco.getNumero()
				&& getBairro().equals(endereco.getBairro()) && getCidade().equals(endereco.getCidade())
				&& getUf().equals(endereco.getUf());

	}

}