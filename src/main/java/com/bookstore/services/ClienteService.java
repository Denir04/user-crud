package com.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.bookstore.dtos.ClienteRecord;
import com.bookstore.models.ClienteModel;
import com.bookstore.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	private ClienteRepository clienteRepository;
	
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	public List<ClienteModel> findAllClientes() {
		return clienteRepository.findByOrderById();
	}
	
	public ClienteModel createCliente(ClienteRecord clienteDto) {
		var newCliente = new ClienteModel();
		BeanUtils.copyProperties(clienteDto, newCliente);
		return clienteRepository.save(newCliente);
	}
	
	public Optional<ClienteModel> findById(Long clienteId) {
		return clienteRepository.findById(clienteId);
	}
	
	public ClienteModel update(ClienteModel clienteModel) {
		return clienteRepository.save(clienteModel);
	}
	
	public void delete(Long clienteId) {
		clienteRepository.deleteById(clienteId);
		return;
	}
}
