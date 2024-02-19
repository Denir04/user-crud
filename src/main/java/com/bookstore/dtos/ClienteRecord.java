package com.bookstore.dtos;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import com.bookstore.annotations.ContactNumberConstraint;

import jakarta.validation.constraints.NotBlank;

public record ClienteRecord(
	@NotBlank(message = "Nome é obrigatório")
	String nome,
	LocalDate dataNascimento,
	@CPF(message = "CPF inválido")
	String cpf,
	@ContactNumberConstraint(message = "Número de telefone inválido")
	@NotBlank(message = "Número de telefone é obrigatório")
	String telefone,
	String email,
	String senha
) {}
