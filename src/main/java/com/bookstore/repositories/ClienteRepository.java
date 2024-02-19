package com.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.models.ClienteModel;
import java.util.List;


@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
	public List<ClienteModel> findByOrderById();
}
