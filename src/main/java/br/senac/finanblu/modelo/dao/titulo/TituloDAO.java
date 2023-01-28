package br.senac.finanblu.modelo.dao.titulo;

import java.time.LocalDate;
import java.util.List;

import br.senac.finanblu.modelo.entidade.titulo.Titulo;
import br.senac.finanblu.modelo.enumeracao.FormaPagamento;
import br.senac.finanblu.modelo.enumeracao.Situacao;

public interface TituloDAO {
	void inserirTitulo(Titulo titulo);
	
	void deletarTitulo(Titulo titulo);

	void atualizarRazaoSocialCliente(Titulo titulo, String novaRazaoSocial);

	void atualizarNomeFantasiaCliente(Titulo titulo, String novoNomeFantasia);

	void atualizarCnpjCliente(Titulo titulo, String novoCnpj);

	void atualizarValorVenda(Titulo titulo, float novoValorVenda);

	void atualizarDataVenda(Titulo titulo, LocalDate novaDataVenda);

	void atualizarFormaPagamentoVenda(Titulo titulo, FormaPagamento novaFormaPagamento);

	void atualizarParcelaVenda(Titulo titulo, short novaParcela);

	void atualizarInstitucaoFinanceira(Titulo titulo, String novaInstuicaoFinanceira);
	
	void atualizarDataVencimento(Titulo titulo, LocalDate novaDataVencimento);
	
	void atualizarSituacao(Titulo titulo, Situacao novaSituacao);
	
	void atualizarDataPagamento(Titulo titulo, LocalDate novaDataPagamento);
	
	List<Titulo> recuperarTitulos();
	
	List<Titulo> recuperarTitulosPagos();
	
	List<Titulo> recuperarTitulosPagosPorData();
	
	List<Titulo> recuperarTitulosPagosPorCliente();
	
	List<Titulo> recuperarTitulosAbertos();
	
	List<Titulo> recuperarTitulosAbertosPorData(Titulo titulo, LocalDate dataVenda);
	
	List<Titulo> recuperarTitulosAbertosPorCliente();
	
	List<Titulo> recuperarTitulosVencer();
	
	List<Titulo> recuperarTitulosVencerPorData();
	
	List<Titulo> recuperarTitulosVencerPorCliente();
	
	List<Titulo> recuperarTitulosVencidos();
	
	List<Titulo> recuperarTitulosVencidosPorData();
	
	List<Titulo> recuperarTitulosVencidosPorCliente();
	
	
}
