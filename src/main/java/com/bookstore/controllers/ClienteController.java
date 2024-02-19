package com.bookstore.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.dtos.ClienteRecord;
import com.bookstore.dtos.TextResponse;
import com.bookstore.models.ClienteModel;
import com.bookstore.services.ClienteService;
import com.bookstore.utils.BookStoreUtils;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<List<ClienteModel>> findAllClientes() {
		return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAllClientes());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable("id") String clienteId){
		Optional<ClienteModel> clienteOp = clienteService.findById(Long.parseLong(clienteId));
		if(clienteOp.isEmpty()) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(new TextResponse("Cliente não encontrado"));
		}
		return ResponseEntity.status(HttpStatus.OK).body(clienteOp.get());
	}
	
	@PostMapping
	public ResponseEntity<ClienteModel> createCliente(@Valid @RequestBody ClienteRecord clienteDto){
		ClienteModel newCliente = clienteService.createCliente(clienteDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(newCliente);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateCliente(
		@PathVariable("id") String clienteId ,
		@RequestBody ClienteRecord clienteDto
	){
		Optional<ClienteModel> clienteOp = clienteService.findById(Long.parseLong(clienteId));
		if(clienteOp.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		var clienteModel = clienteOp.get();
		BookStoreUtils.copyPropertiesNotNull(clienteDto, clienteModel);
		clienteService.update(clienteModel);
		return ResponseEntity.status(HttpStatus.OK).body(clienteModel);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCliente(@PathVariable ("id") String clienteId){
		Optional<ClienteModel> clienteOp = clienteService.findById(Long.parseLong(clienteId));
		if(clienteOp.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Cliente não encontrado");
		}
		clienteService.delete(Long.parseLong(clienteId));
		return ResponseEntity.status(HttpStatus.OK).body("Cliente "+clienteId+" excluído com sucesso");
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return errors;
	}

}
