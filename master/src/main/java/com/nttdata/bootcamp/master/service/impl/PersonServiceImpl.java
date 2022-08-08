package com.nttdata.bootcamp.master.service.impl;

import com.nttdata.bootcamp.master.model.dao.PersonDao;
import com.nttdata.bootcamp.master.model.document.Person;
import com.nttdata.bootcamp.master.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonServiceImpl implements PersonService {

    private static final Logger log = LoggerFactory.getLogger(PersonServiceImpl.class);
    @Autowired
    private PersonDao personDao;

    @Override
    public Mono<Person> insert(Person person) {
        return personDao.save(person)
                .doFirst(() -> log.info("Begin Insert Person"))
                .doOnNext(p -> log.info(p.toString()))
                .doAfterTerminate(() -> log.info("Finish Insert Person"));
    }

    @Override
    public Mono<Person> update(Person person) {
        return personDao.findById(person.getId())
                .doFirst(() -> log.info("Begin Update Person"))
                .map(p -> person)
                .flatMap(this.personDao::save)
                .doOnNext(p -> log.info(p.toString()))
                .doAfterTerminate(() -> log.info("Finish Update Person"));
    }

    @Override
    public Mono<Void> delete(String id) {
        return personDao.deleteById(id)
                .doFirst(() -> log.info("Begin Delete Person"))
                .doOnNext(p -> log.info(p.toString()))
                .doAfterTerminate(() -> log.info("Finish Delete Person"));
    }

    @Override
    public Mono<Person> find(String id) {
        return personDao.findById(id)
                .doFirst(() -> log.info("Begin Find Person"))
                .doOnNext(p -> log.info(p.toString()))
                .doAfterTerminate(() -> log.info("Finish Find Person"));
    }

    @Override
    public Mono<Person> findByCode(String code) {
        return personDao.findByCode(code)
                .doFirst(() -> log.info("Begin FindByCode Person"))
                .doOnNext(p -> log.info(p.toString()))
                .doAfterTerminate(() -> log.info("Finish FindByCode Person"));
    }

    @Override
    public Flux<Person> findAll() {
        return personDao.findAll()
                .doFirst(() -> log.info("Begin FindAll Person"))
                .doOnNext(p -> log.info(p.toString()))
                .doAfterTerminate(() -> log.info("Finish FindAll Person"));
    }

}
