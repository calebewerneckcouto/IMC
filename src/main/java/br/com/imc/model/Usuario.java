package br.com.imc.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import io.swagger.annotations.ApiModelProperty;

@Entity
@SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario", allocationSize = 1, initialValue = 1)
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "Código do usuário",dataType = "Long")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
	private Long id;
    @ApiModelProperty(value = "Nome do usuário",dataType = "String")
	private String nome;
    @ApiModelProperty(value = "Idade do usuário",dataType = "Int")
	private int idade;
    @ApiModelProperty(value = "Altura do usuário",dataType = "String")
	private String altura;
    @ApiModelProperty(value = "Peso do usuário",dataType = "String")
	private String peso;
    @ApiModelProperty(value = "Resultado do IMC do usuário",dataType = "String")
	private String resultadoIMC;
    @ApiModelProperty(value = "Descricao do Resultado  do usuário",dataType = "String")
	private String descricao;

	

	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getResultadoIMC() {
		return resultadoIMC;
	}

	public void setResultadoIMC(String resultadoIMC) {
		this.resultadoIMC = resultadoIMC;
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

}