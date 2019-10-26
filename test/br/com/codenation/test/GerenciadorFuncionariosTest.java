package br.com.codenation.test;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

import br.com.codenatiom.FuncionarioDAO;
import br.com.codenatiom.exception.CpfInvalidoException;
import br.com.codenatiom.exception.DataDeAdmissaoInvalidaException;
import br.com.codenatiom.exception.DepartamentoInvalidoException;
import br.com.codenatiom.exception.QuantidadeFuncionariosInvalidoException;
import br.com.codenatiom.model.Coordenador;

public class GerenciadorFuncionariosTest {

	@Test
	public void testaInclusaoCoordenadorComDataValida()
			throws DataDeAdmissaoInvalidaException, CpfInvalidoException, QuantidadeFuncionariosInvalidoException {
		Coordenador coordenador = new Coordenador(LocalDate.of(2015, 1, 2), "12345678912", 1, "Vendas");
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		funcionarioDAO.adicionarCoordenador(coordenador);
		Assert.assertTrue(funcionarioDAO.getFuncionarios().contains(coordenador));
	}

	@Test(expected = DataDeAdmissaoInvalidaException.class)
	public void testaInclusaoCoordenadorComDataInvalida()
			throws DataDeAdmissaoInvalidaException, CpfInvalidoException, QuantidadeFuncionariosInvalidoException {

		Coordenador coordenador = new Coordenador(LocalDate.of(2014, 1, 2), "12345678912", 1, "Vendas");
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		funcionarioDAO.adicionarCoordenador(coordenador);
	}

	@Test(expected = CpfInvalidoException.class)
	public void testaInclusaoCoordenadorComCpfNulo()
			throws DataDeAdmissaoInvalidaException, CpfInvalidoException, QuantidadeFuncionariosInvalidoException {
		String cpf = null;
		Coordenador coordenador = new Coordenador(LocalDate.of(2015, 1, 2), cpf, 1, "Vendas");
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		funcionarioDAO.adicionarCoordenador(coordenador);
	}

	@Test(expected = CpfInvalidoException.class)
	public void testaInclusaoCoordenadorComCpfMenor()
			throws DataDeAdmissaoInvalidaException, CpfInvalidoException, QuantidadeFuncionariosInvalidoException {
		String cpf = "025";
		Coordenador coordenador = new Coordenador(LocalDate.of(2015, 1, 2), cpf, 1, "Vendas");
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		funcionarioDAO.adicionarCoordenador(coordenador);
	}

	@Test(expected = CpfInvalidoException.class)
	public void testaInclusaoCoordenadorComCpfMaior()
			throws DataDeAdmissaoInvalidaException, CpfInvalidoException, QuantidadeFuncionariosInvalidoException {
		String cpf = "025123456889999";
		Coordenador coordenador = new Coordenador(LocalDate.of(2015, 1, 2), cpf, 1, "Vendas");
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		funcionarioDAO.adicionarCoordenador(coordenador);
	}

	@Test(expected = QuantidadeFuncionariosInvalidoException.class)
	public void testaInclusaoCoordenadorComNumeroFuncionariosInvalido()
			throws DataDeAdmissaoInvalidaException, CpfInvalidoException, QuantidadeFuncionariosInvalidoException {
		Integer numeroFuncionarios = 0;
		Coordenador coordenador = new Coordenador(LocalDate.of(2015, 1, 2), "12345678901", numeroFuncionarios,
				"Vendas");
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		funcionarioDAO.adicionarCoordenador(coordenador);
	}

	@Test(expected = DepartamentoInvalidoException.class)
	public void testaInclusaoCoordenadorComDepartamentoInvalido()
			throws DataDeAdmissaoInvalidaException, CpfInvalidoException, QuantidadeFuncionariosInvalidoException {
		String departamento = "Vendas";
		Coordenador coordenador = new Coordenador(LocalDate.of(2015, 1, 2), "12345678901", 1, departamento);
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		funcionarioDAO.adicionarCoordenador(coordenador);
	}

}
