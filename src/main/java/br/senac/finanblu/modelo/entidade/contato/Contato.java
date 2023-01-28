package br.senac.finanblu.modelo.entidade.contato;

public class Contato {

	private long id;
	private String telefone;
	private String email;

	public Contato(long id, String telefone, String email) {
		this.setId(id);
		this.setTelefone(telefone);
		this.setEmail(email);
	}

	public Contato(String telefone, String email) {
		this.setId(id);
		this.setTelefone(telefone);
		this.setEmail(email);
	}

	public Contato(long id) {
		this.setId(id);
	}

	public Contato() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean equals(Object objeto) {
		if (this == objeto)
			return true;

		if (objeto == null)
			return false;

		if (getClass() != objeto.getClass())
			return false;

		Contato contato = (Contato) objeto;

		return getId() == contato.getId() && getTelefone().equals(contato.getTelefone())
				&& getEmail().equals(contato.getEmail());
	}
}
