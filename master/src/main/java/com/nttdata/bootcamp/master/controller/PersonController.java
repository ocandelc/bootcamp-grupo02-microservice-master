package com.nttdata.bootcamp.master.controller;

import com.nttdata.bootcamp.master.model.document.Person;
import com.nttdata.bootcamp.master.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public Mono<Person> create(@RequestBody Person person){
        return this.personService.insert(person);
    }

    @PutMapping
    public Mono<Person> update(@RequestBody Person person){
        return this.personService.update(person);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id){
        return this.personService.delete(id);
    }

    @GetMapping("/{id}")
    public Mono<Person> find(@PathVariable String id){
        return this.personService.find(id);
    }

    @GetMapping("/findByCode/{code}")
    public Mono<Person> findByCode(@PathVariable String code){
        return this.personService.findByCode(code);
    }

    @GetMapping
    public Flux<Person> findAll(){
        return this.personService.findAll();
    }

}
