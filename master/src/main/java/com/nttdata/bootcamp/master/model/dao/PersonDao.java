package com.nttdata.bootcamp.master.model.dao;

import com.nttdata.bootcamp.master.model.document.Person;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface PersonDao extends ReactiveMongoRepository<Person, String> {

    Mono<Person> findByCode(String code);

}
