package com.br.teste.dao;

import com.br.teste.model.Boleto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BoletoDAO extends MongoRepository<Boleto, String> {
}
