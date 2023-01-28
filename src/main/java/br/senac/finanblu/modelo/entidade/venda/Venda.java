package br.senac.finanblu.modelo.entidade.venda;

import java.time.LocalDate;

import br.senac.finanblu.modelo.entidade.cliente.Cliente;
import br.senac.finanblu.modelo.enumeracao.FormaPagamento;

public class Venda {

	private long id;
	private Cliente cliente;
	private float valorVenda;
	private LocalDate dataVenda;
	private FormaPagamento formaPagamento;
	private short parcela;

	public Venda(long id, Cliente cliente, float valorVenda, LocalDate dataVenda, FormaPagamento formaPagamento,
			short parcela) {
		this.setId(id);
		this.setCliente(cliente);
		this.setValorVenda(valorVenda);
		this.setDataVenda(dataVenda);
		this.setFormaPagamento(formaPagamento);
		this.setParcela(parcela);

	}
	public Venda(long id, float valorVenda, LocalDate dataVenda, FormaPagamento formaPagamento, short parcela) {
		this.setId(id);
		this.setValorVenda(valorVenda);
		this.setDataVenda(dataVenda);
		this.setFormaPagamento(formaPagamento);
		this.setParcela(parcela);
	}

	public Venda(Cliente cliente, float valorVenda, LocalDate dataVenda, FormaPagamento formaPagamento, short parcela) {
		this.setCliente(cliente);
		this.setValorVenda(valorVenda);
		this.setDataVenda(dataVenda);
		this.setFormaPagamento(formaPagamento);
		this.setParcela(parcela);

	}
	public Venda(long id) {
		this.setId(id);
	}

	public Venda() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public float getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(float valorVenda) {
		this.valorVenda = valorVenda;
	}

	public LocalDate getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDate dataVenda) {
		this.dataVenda = dataVenda;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public short getParcela() {
		return parcela;
	}

	public void setParcela(short parcela) {
		this.parcela = parcela;
	}

}
