package com.bookstore.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_cliente")
public class ClienteModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cli_id")
	private Long id;
	@Column(name = "cli_nome")
	private String nome;
	@Column(name = "cli_data_nascimento")
	private LocalDate dataNascimento;
	@Column(name = "cli_cpf")
	private String cpf;
	@Column(name = "cli_telefone")
	private String telefone;
	@Column(name = "cli_email")
	private String email;
	@Column(name = "cli_senha")
	private String senha;
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
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
