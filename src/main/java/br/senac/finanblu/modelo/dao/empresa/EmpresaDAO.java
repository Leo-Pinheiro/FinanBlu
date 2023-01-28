package br.senac.finanblu.modelo.dao.empresa;

import java.util.List;

import br.senac.finanblu.modelo.entidade.contato.Contato;
import br.senac.finanblu.modelo.entidade.empresa.Empresa;

public interface EmpresaDAO {

	void inserirEmpresa(Empresa empresa);

	void deletarEmpresa(Empresa empresa);

	void atualizarEmpresa(Empresa empresa);
	
	List<Empresa> recuperarEmpresas();

}
