package br.senac.finanblu.modelo.entidade.titulo;

import java.time.LocalDate;

import br.senac.finanblu.modelo.entidade.cliente.Cliente;
import br.senac.finanblu.modelo.entidade.venda.Venda;
import br.senac.finanblu.modelo.enumeracao.Situacao;

public class Titulo {

	private long id;
	private Venda venda;
	private String instituicaoFinanceira;
	private LocalDate dataVencimento;
	private Situacao situacao;
	private LocalDate dataPagamento;

	public Titulo(long id, Venda venda, String instituicaoFinanceira, LocalDate dataVencimento, Situacao situacao,
			LocalDate dataPagamento) {
		this.setId(id);
		this.setVenda(venda);
		this.setInstituicaoFinanceira(instituicaoFinanceira);
		this.setDataVencimento(dataVencimento);
		this.setSituacao(situacao);
		this.setDataPagamento(dataPagamento);

	}

	public Titulo(Venda venda, String instituicaoFinanceira, LocalDate dataVencimento, Situacao situacao,
			LocalDate dataPagamento) {
		this.setId(id);
		this.setVenda(venda);
		this.setInstituicaoFinanceira(instituicaoFinanceira);
		this.setDataVencimento(dataVencimento);
		this.setSituacao(situacao);
		this.setDataPagamento(dataPagamento);

	}

	public Titulo() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public String getInstituicaoFinanceira() {
		return instituicaoFinanceira;
	}
	
	public void setInstituicaoFinanceira(String instituicaoFinanceira) {
		this.instituicaoFinanceira = instituicaoFinanceira;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

}