package br.com.codenatiom;

import java.util.LinkedList;
import java.util.List;

import br.com.codenatiom.exception.CpfInvalidoException;
import br.com.codenatiom.exception.DataDeAdmissaoInvalidaException;
import br.com.codenatiom.exception.QuantidadeFuncionariosInvalidoException;
import br.com.codenatiom.model.Coordenador;
import br.com.codenatiom.model.Funcionario;

public class FuncionarioDAO {
	private List<Funcionario> funcionarios;

	public FuncionarioDAO() {
		this.funcionarios = new LinkedList<Funcionario>();
	}

	public void adicionarCoordenador(Coordenador coordenador)
			throws DataDeAdmissaoInvalidaException, CpfInvalidoException, QuantidadeFuncionariosInvalidoException {
		if (coordenador.getDataAdmissao().getYear() < 2015) {
			throw new DataDeAdmissaoInvalidaException();
		}

		if (coordenador.getCpf() == null || coordenador.getCpf().length() != 11) {
			throw new CpfInvalidoException();
		}

		if (coordenador.getNumeroFuncionarios() <= 0) {
			throw new QuantidadeFuncionariosInvalidoException();
		}

		funcionarios.add(coordenador);
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

}
