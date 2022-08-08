package com.nttdata.bootcamp.master.model.dao;

import com.nttdata.bootcamp.master.model.document.DocumentType;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface DocumentTypeDao extends ReactiveMongoRepository<DocumentType, String> {

    Mono<DocumentType> findByCode(String code);

}
