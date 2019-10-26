package br.com.codenatiom.model;

import java.time.LocalDate;

public class Coordenador extends Funcionario {

	private Integer numeroFuncionarios;
	private String departamentoCoordenacao;

	public Coordenador(LocalDate dataAdmissao, String cpf, Integer numeroFuncionarios, String departamentoCoordenacao) {
		super.setDataAdmissao(dataAdmissao);
		super.setCpf(cpf);
		this.numeroFuncionarios = numeroFuncionarios;
		this.departamentoCoordenacao = departamentoCoordenacao;
	}

	public Integer getNumeroFuncionarios() {
		return numeroFuncionarios;
	}

	public void setNumeroFuncionarios(Integer numeroFuncionarios) {
		this.numeroFuncionarios = numeroFuncionarios;
	}

	public String getDepartamentoCoordenacao() {
		return departamentoCoordenacao;
	}

	public void setDepartamentoCoordenacao(String departamentoCoordenacao) {
		this.departamentoCoordenacao = departamentoCoordenacao;
	}

}
